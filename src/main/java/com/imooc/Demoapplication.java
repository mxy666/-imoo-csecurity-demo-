package com.imooc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * create by mxy on 2017/12/15
 */

@SpringBootApplication
@RestController
@EnableSwagger2
public class Demoapplication {


    public static void main(String[] args) {
        SpringApplication.run(Demoapplication.class, args);
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello spring security";
    }
}
