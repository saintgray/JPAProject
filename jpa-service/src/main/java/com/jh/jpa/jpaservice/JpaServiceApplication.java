package com.jh.jpa.jpaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EntityScan(basePackages = "com.jh.jpa.jpaservice.*")
public class JpaServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaServiceApplication.class, args);
    }

}
