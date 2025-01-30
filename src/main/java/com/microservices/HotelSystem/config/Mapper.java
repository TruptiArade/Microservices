package com.microservices.HotelSystem.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Mapper
{
    @Bean
    public ModelMapper getModelMapper()
    {
        return new ModelMapper();
    }
}
