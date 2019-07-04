package com.zking.springbootrs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.zking.springbootrs.dao")
@EnableScheduling
public class SpringbootrsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootrsApplication.class, args);
    }

}
