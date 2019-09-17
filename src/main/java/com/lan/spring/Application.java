package com.lan.spring;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

@SpringBootApplication
@MapperScan("com.lan.spring.mapper")
//@ComponentScan("com.lan.spring.component")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
