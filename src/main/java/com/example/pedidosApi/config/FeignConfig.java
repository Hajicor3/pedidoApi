package com.example.pedidosApi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.pedidosApi.services.exceptions.feignexceptions.FeignErrorDecoder;

@Configuration
public class FeignConfig {

	@Bean
    FeignErrorDecoder feignErrorDecoder() {
        return new FeignErrorDecoder();
    }
}
