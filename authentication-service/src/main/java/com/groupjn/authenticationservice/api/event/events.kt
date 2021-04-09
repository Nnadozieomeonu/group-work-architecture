package com.groupjn.authenticationservice.api.event

data class UserAddedEvent (
        val username: String,
        val password: String,
        val email: String,
        val enabled: Boolean,
        val accountNonExpired: Boolean,
        val credentialsNonExpired: Boolean,
        val accountNonLocked: Boolean,
        val roles: Int
)
