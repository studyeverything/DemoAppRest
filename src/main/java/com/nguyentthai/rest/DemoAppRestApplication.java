package com.nguyentthai.rest;

import com.nguyentthai.rest.config.StorageProperties;
import com.nguyentthai.rest.service.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableAutoConfiguration
@EnableConfigurationProperties(StorageProperties.class)
public class DemoAppRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoAppRestApplication.class, args);
    }

    @Bean
    CommandLineRunner init(StorageService storageService) {
        return (args) -> {
            storageService.deleteAll();
            storageService.init();
        };
    }
}
