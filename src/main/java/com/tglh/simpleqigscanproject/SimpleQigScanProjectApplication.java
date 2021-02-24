package com.tglh.simpleqigscanproject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.tglh.simpleqigscanproject.*")
@MapperScan("com.tglh.simpleqigscanproject.mapper")
public class SimpleQigScanProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleQigScanProjectApplication.class, args);
    }

}
