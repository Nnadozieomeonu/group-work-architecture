package com.groupjn.orderservice.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

public class RequestResponseHandlerInterceptor implements ClientHttpRequestInterceptor {

    @Autowired
    private Environment env;

    @Override
    public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] body, ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {
        httpRequest.getHeaders().add("Authorization", "Bearer "+env.getProperty("bearer-token"));
        return clientHttpRequestExecution.execute(httpRequest, body);
    }



    /*Autowired
    private Environment env;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        System.out.println(env.getProperty("bearer-token"));
        request.setAttribute("Authorization", "Bearer 292b8e65-61ec-452c-9e81-c8c4648b3c06");
        return true;
    }*/
}
