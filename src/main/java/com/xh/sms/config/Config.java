package com.xh.sms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class Config {

    @Bean
    public JdbcTemplate jdbcTemplateBean(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
