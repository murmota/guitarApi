package com.example.guitarApi.Configs;

import com.example.guitarApi.dal.DataAccessLayer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataConfiguration {
    @Bean
    public DataAccessLayer dataAccessLayer(){
        return new DataAccessLayer();
    }
}

