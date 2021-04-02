package com.groupjn.orderservice.interceptor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

@Data
public class BearerTokenWrapper {

    @Autowired
    private Environment env;

    private String token;

    public BearerTokenWrapper(){
        System.out.println(env.getProperty("bearer-token"));
        token = env.getProperty("bearer-token");
    }

}
