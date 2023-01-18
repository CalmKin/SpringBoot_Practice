package com.calmkin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.calmkin.mapper")       //TODO 将dao层扫描进去，也可以在每个dao接口上面加上mapper注解
public class SpringBootPracticeApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootPracticeApplication.class, args);
    }

}
