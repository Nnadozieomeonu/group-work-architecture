package com.groupjn.authenticationservice.controller;

import com.groupjn.authenticationservice.entity.UserSummary;

public class ClientUser implements UserFactory {
    @Override
    public String createUser(UserSummary summary) {
        String result = "Created Client User User.";
        return result;
    }
}
