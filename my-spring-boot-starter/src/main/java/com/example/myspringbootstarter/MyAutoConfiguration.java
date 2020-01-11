package com.example.myspringbootstarter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(MyServiceProperties.class)
@ConditionalOnClass(MyService.class)
public class MyAutoConfiguration {

    @Autowired
    MyServiceProperties properties;

    @Bean
    @ConditionalOnMissingBean(MyService.class)
    public MyService myService() {
        MyService service = new MyService(properties.getPrefix(), properties.getSuffix());
        return service;
    }
}
