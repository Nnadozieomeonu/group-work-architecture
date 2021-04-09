package com.groupjn.authenticationservice.controller;

import com.groupjn.authenticationservice.entity.UserSummary;

public interface UserFactory {
    String createUser(UserSummary summary);
}
