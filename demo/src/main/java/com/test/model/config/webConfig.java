package com.test.model.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class webConfig {


    @Bean
    WebClient publicDataClient(@Value("${openapi.base-url}")String baseUrl) {
        return WebClient.builder().baseUrl(baseUrl).build();
    }

    @Bean
    WebClient fastapiClient(@Value("${fastapi.base-url}") String baseUrl) {
        return WebClient.builder().baseUrl(baseUrl).build();
    }

}
