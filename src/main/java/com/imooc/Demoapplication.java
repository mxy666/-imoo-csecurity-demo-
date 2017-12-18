package com.imooc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by mxy on 2017/12/15
 */

@SpringBootApplication
@RestController
public class Demoapplication {


    public static void main(String[] args) {
        SpringApplication.run(Demoapplication.class, args);
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello spring security";
    }
}
