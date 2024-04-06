package com.kshrd.btb_restapi02_demo_class.configuration;


import com.kshrd.btb_restapi02_demo_class.mapper.UserMapper;
import com.kshrd.btb_restapi02_demo_class.mapper.UserMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserBeanConfig {
    @Bean
    public UserMapper userMapper(){
        return new UserMapperImpl();
    }
}
