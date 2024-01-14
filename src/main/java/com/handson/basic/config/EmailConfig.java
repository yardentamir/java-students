package com.handson.basic.config;

import com.postmarkapp.postmark.Postmark;
import com.postmarkapp.postmark.client.ApiClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class EmailConfig {
    @Value("${postmark.api.key}")
    private String secretKey;
    @Bean
    public ApiClient apiClient(){
        return Postmark.getApiClient(secretKey);
    }
}
