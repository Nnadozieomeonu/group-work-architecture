package com.groupjn.orderservice.configuration;

import com.groupjn.orderservice.interceptor.GeneralPurposeInterceptor;
import com.groupjn.orderservice.interceptor.SinglePurposeInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(final InterceptorRegistry registry) {
        registry.addInterceptor(new GeneralPurposeInterceptor()).order(1);
        registry.addInterceptor(new SinglePurposeInterceptor()).addPathPatterns("/order/**").order(2);
    }
}
