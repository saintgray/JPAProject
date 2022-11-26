package com.jh.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication(
        exclude = {JacksonAutoConfiguration.class},
        scanBasePackages = {"com.jh.member"})
@EntityScan("com.jh.member.jpo")
@RestController
public class MemberServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MemberServiceApplication.class, args);
    }
}
