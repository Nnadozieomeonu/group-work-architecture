package com.groupjn.authenticationservice.api.command

import com.sun.org.apache.xpath.internal.operations.Bool
import org.axonframework.commandhandling.TargetAggregateIdentifier

data class AddUserCommand (
        @TargetAggregateIdentifier
        val username: String,
        val password: String,
        val email: String,
        val enabled: Boolean,
        val accountNonExpired: Boolean,
        val credentialsNonExpired: Boolean,
        val accountNonLocked: Boolean,
        val roles: Int

)
