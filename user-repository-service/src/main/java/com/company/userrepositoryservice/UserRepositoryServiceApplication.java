package com.company.userrepositoryservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@OpenAPIDefinition(info = @Info(title = "User-db-service"))
public class UserRepositoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserRepositoryServiceApplication.class, args);
    }

}
