//package com.example.Gradjanin.Security;
//
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//
//
//@Configuration
//public class CorsConfiguration implements WebMvcConfigurer {
//
//    private static final Logger logger = LoggerFactory.getLogger(CorsConfiguration.class);
//
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        logger.info("Adding CORS mappings...");
//        registry.addMapping("/**")
//                .allowedOrigins("http://localhost:4200")
//                .allowedMethods("GET", "POST", "PUT", "DELETE")
//                .allowedHeaders("*");
//    }
//}
