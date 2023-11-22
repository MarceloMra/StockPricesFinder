package com.example.StockPricesFinder.configuration;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
@Data
public class PricesAPIConfiguration {
    @Value("${api.brapi.token}")
    private String token;
    @Value("${api.brapi.baseurl}")
    private String baseUrl;
}
