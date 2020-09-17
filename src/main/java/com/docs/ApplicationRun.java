package com.docs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@EnableFeignClients
@SpringBootApplication
@MapperScan(basePackages = "com.docs.mapper.**")
public class ApplicationRun {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(ApplicationRun.class);
        application.addListeners(new ApplicationPidFileWriter());
        application.run(args);
    }
}
