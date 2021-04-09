package com.groupjn.authenticationservice.controller;

import com.groupjn.authenticationservice.api.command.AddUserCommand;
import com.groupjn.authenticationservice.entity.UserSummary;

import java.util.UUID;


public class AdminUser implements UserFactory {
    @Override
    public String createUser(UserSummary summary) {
        AddUserCommand cmd = new AddUserCommand(
                summary.getUsername(),
                summary.getPassword(),
                summary.getEmail(),
                summary.getEnabled(),
                summary.getAccountNonExpired(),
                summary.getAccountNonLocked(),
                summary.getCredentialsNonExpired(),
                2
        );
        String result = "Created Admin User User.";
        return result;
    }
}
