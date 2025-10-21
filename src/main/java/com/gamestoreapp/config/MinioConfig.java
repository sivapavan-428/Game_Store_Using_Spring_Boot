
package com.gamestoreapp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import io.minio.*;

@Configuration
public class MinioConfig {

    @Value("${minio.url}")
    private String minioUrl;

    @Value("${minio.access-key}")
    private String accessKey;

    @Value("${minio.secret-key}")
    private String secretKey;

    @Value("${minio.bucket}")
    private String bucketName;

    @Bean
    public MinioClient minioClient() {
        return MinioClient.builder()
                .endpoint(minioUrl)
                .credentials(accessKey, secretKey)
                .build();
    }

    @Bean
    @DependsOn("minioClient")
    CommandLineRunner initMinio(MinioClient minioClient) {
        return args -> {
            try {
                if (!minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build())) {
                    minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
                    System.out.println("✅ MinIO bucket created: " + bucketName);
                } else {
                    System.out.println("✅ MinIO bucket already exists: " + bucketName);
                }

                String[] folders = {"game_covers/", "trailers/", "screenshots/"};
                for (String folder : folders) {
                    try {
                        minioClient.statObject(StatObjectArgs.builder().bucket(bucketName).object(folder).build());
                    } catch (Exception e) {
                        minioClient.putObject(PutObjectArgs.builder()
                                .bucket(bucketName)
                                .object(folder)
                                .stream(new java.io.ByteArrayInputStream(new byte[0]), 0, -1)
                                .contentType("application/octet-stream")
                                .build());
                        System.out.println("📁 Folder created: " + folder);
                    }
                }
            } catch (Exception e) {
                System.err.println("❌ MinIO initialization failed: " + e.getMessage());
                throw new RuntimeException(e);
            }
        };
    }
}
