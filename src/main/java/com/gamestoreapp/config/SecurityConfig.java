//package com.gamestoreapp.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class SecurityConfig {
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//            .csrf(csrf -> csrf.disable())
//            
//            .authorizeHttpRequests(auth -> auth
//                .requestMatchers(
//                    "/swagger-ui/**",
//                    "/swagger-ui.html",
//                    "/v3/api-docs/**",
//                    "/swagger-resources/**",
//                    "/webjars/**",
//                    "/h2-console/**",
//                    "/auth/**",
//                    "/auth/cart/remove/**",
//                    "/auth/api/games/uploadImage/**",
//                    "/auth/api/games/add", "/auth/api/games/getAll", "/auth/api/games/get/**"
//                ).permitAll()
//                .anyRequest().authenticated()
//            )
//            
//            .headers(headers -> headers.frameOptions(frame -> frame.disable()))
//            
//            .httpBasic(httpBasic -> httpBasic.disable())
//            .formLogin(form -> form.disable());
//
//        return http.build();
//    }
//}













package com.gamestoreapp.config;

import com.gamestoreapp.security.JwtRequestFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    private final JwtRequestFilter jwtFilter;

    public SecurityConfig(JwtRequestFilter jwtFilter) {
        this.jwtFilter = jwtFilter;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())

            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                    "/swagger-ui/**",
                    "/swagger-ui.html",
                    "/v3/api-docs/**",
                    "/swagger-resources/**",
                    "/webjars/**",
                    "/h2-console/**",
                    "/auth/login",
                    "/auth/signup",
                    "/auth/api/games/getAll",
                    "/auth/api/games/getByGenre/**",
                    "/auth/api/games/get/**"
                ).permitAll()

                .requestMatchers(
                    "/auth/cart/**"
                    
                ).hasRole("USER")

                .requestMatchers(
                    "/auth/api/games/add",
                    "/auth/api/games/update/**",
                    "/auth/api/games/delete/**",
                    "/auth/user/**"
                ).hasRole("ADMIN")

                .anyRequest().authenticated()
            )

            .headers(headers -> headers.frameOptions(frame -> frame.disable()))

            .httpBasic(httpBasic -> httpBasic.disable())
            .formLogin(form -> form.disable())

            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
