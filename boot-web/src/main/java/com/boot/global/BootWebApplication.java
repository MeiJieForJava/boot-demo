package com.boot.global;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan(basePackages = "com.boot")
@EnableSwagger2
public class BootWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(BootWebApplication.class, args);
    }
}
