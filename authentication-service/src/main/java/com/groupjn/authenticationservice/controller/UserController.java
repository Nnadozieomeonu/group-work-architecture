package com.groupjn.authenticationservice.controller;

import com.groupjn.authenticationservice.entity.UserSummary;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {
        private CommandGateway commandGateway;
        private QueryGateway queryGateway;

        public UserController(CommandGateway commandGateway, QueryGateway queryGateway) {
            this.commandGateway = commandGateway;
            this.queryGateway = queryGateway;
        }

    @PostMapping("/addUser")
    public void handle(@RequestBody UserSummary userSummary) {
        if(userSummary.usertype.equalsIgnoreCase("Admin")){
            new AdminUser();
        }
        else{
            new ClientUser();
        }

    }

//        @GetMapping("/users")
//        public CompletableFuture<List<UserSummary>> getProducts(){
//            return queryGateway.query(new GetUserQuery(), ResponseTypes.multipleInstancesOf(UserSummary.class));
//        }

}
