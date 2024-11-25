package com.example.admin_panel.restClient;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfiguration {

    @Bean
    public RestClient restClientProduct(){
        return RestClient.create("http://localhost:8081");
    }
}
