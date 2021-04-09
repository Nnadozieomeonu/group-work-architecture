package com.groupjn.authenticationservice.model;

import com.groupjn.authenticationservice.api.command.AddUserCommand;
import com.groupjn.authenticationservice.api.event.UserAddedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;

import javax.persistence.Column;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

@Aggregate
public class User {

        @AggregateIdentifier
        private int id;
    private String username;
    private String password;
    private String email;
    private boolean enabled;
    private boolean accountNonExpired;
    private boolean credentialsNonExpired;
    private boolean accountNonLocked;
    private int roles;

        public User() {
        }

        @CommandHandler
        public User(AddUserCommand cmd){
            apply( new UserAddedEvent(
                            cmd.getUsername(),
                            cmd.getEmail(),
                            cmd.getPassword(),
                            cmd.getEnabled(),
                    cmd.getCredentialsNonExpired(),
                    cmd.getAccountNonExpired(),
                    cmd.getAccountNonLocked(),
                    cmd.getRoles()
                    )
            );
        }

        @EventSourcingHandler
        public void on(UserAddedEvent evt){
            username = evt.getUsername();
            password = evt.getPassword();
            email = evt.getEmail();
            enabled = evt.getEnabled();
            accountNonExpired = evt.getAccountNonExpired();
            credentialsNonExpired = evt.getCredentialsNonExpired();
            accountNonLocked = evt.getAccountNonLocked();
            roles = evt.getRoles();
        }


}
