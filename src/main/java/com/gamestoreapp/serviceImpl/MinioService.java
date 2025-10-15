//package com.gamestoreapp.serviceImpl;
//
//import io.minio.*;
//import io.minio.http.Method;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//import java.io.InputStream;
//import java.util.UUID;
//
//@Service
//public class MinioService {
//
//    @Autowired
//    private MinioClient minioClient;
//
//    private final String bucketName = "games";
//
//    public String uploadFile(MultipartFile file) throws Exception {
//        if (!minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build())) {
//            minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
//        }
//
//        String fileName = UUID.randomUUID() + "-" + file.getOriginalFilename();
//
//        try (InputStream is = file.getInputStream()) {
//            minioClient.putObject(
//                    PutObjectArgs.builder()
//                            .bucket(bucketName)
//                            .object(fileName)
//                            .stream(is, file.getSize(), -1)
//                            .contentType(file.getContentType())
//                            .build()
//            );
//        }
//
//        return fileName;
//    }
//
//    public String getFileUrl(String fileName) throws Exception {
//        return minioClient.getPresignedObjectUrl(
//                GetPresignedObjectUrlArgs.builder()
//                        .bucket(bucketName)
//                        .object(fileName)
//                        .method(Method.GET)
//                        .build()
//        );
//    }
//}
