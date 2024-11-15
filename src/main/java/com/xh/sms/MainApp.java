package com.xh.sms;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class MainApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext ioc = SpringApplication.run(MainApp.class, args);
        JdbcTemplate jdbcTemplate = ioc.getBean(JdbcTemplate.class);
        System.out.println("jdbcTemplate---------" + jdbcTemplate);

        System.out.println("吼吼吼吼吼吼吼吼吼吼吼吼吼吼吼吼");
    }
}
