package com.haoze.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

@EnableFeignClients(basePackages = {"com.haoze"})
@EnableCaching
@EnableScheduling
@SpringBootApplication(scanBasePackages = {"com.haoze.base", "com.haoze.common"})
@EnableTransactionManagement(proxyTargetClass = true)
//@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class})
@MapperScan(basePackages = "com.haoze.base.mapper.auth")
public class CloudBaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudBaseApplication.class, args);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}