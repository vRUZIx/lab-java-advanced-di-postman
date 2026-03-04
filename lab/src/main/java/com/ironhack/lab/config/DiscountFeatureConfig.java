package com.ironhack.lab.config;

import com.ironhack.lab.service.EarlyBirdDiscountService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DiscountFeatureConfig {

    @ConditionalOnProperty(name="feature.earlybird.enabled", havingValue = "true")
    @Bean
    public EarlyBirdDiscountService earlyBirdDiscountService(){
        return new EarlyBirdDiscountService();
    }
}
