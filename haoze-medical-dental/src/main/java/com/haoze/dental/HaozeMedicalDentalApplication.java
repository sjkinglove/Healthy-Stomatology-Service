package com.haoze.dental;



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
/*能使用缓存*/
@EnableCaching
/*能使用定时任务*/
@EnableScheduling
/*复合注解,包括@ComponentScan，和@SpringBootConfiguration，@EnableAutoConfiguration*/
@SpringBootApplication(scanBasePackages = {"com.haoze.dental", "com.haoze.common"})
/*启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />*/
@EnableTransactionManagement(proxyTargetClass = true)
@MapperScan(basePackages = "com.haoze.dental.dao")
public class HaozeMedicalDentalApplication {

    public static void main(String[] args) {
        SpringApplication.run(HaozeMedicalDentalApplication.class, args);
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
