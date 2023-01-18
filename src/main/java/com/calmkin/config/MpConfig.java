package com.calmkin.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//TODO 为了分页查询能够生效，需要配置分页器的拦截器
@Configuration
public class MpConfig {

    @Bean
    public MybatisPlusInterceptor pageInterceptor()
    {
        MybatisPlusInterceptor mpIntorceptor = new MybatisPlusInterceptor();
        mpIntorceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return mpIntorceptor;
    }

}
