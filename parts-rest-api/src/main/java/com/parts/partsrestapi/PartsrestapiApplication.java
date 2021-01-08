package com.parts.partsrestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PartsrestapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(PartsrestapiApplication.class, args);
    }

}
