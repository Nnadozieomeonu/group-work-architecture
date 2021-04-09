package com.groupjn.authenticationservice.query;

import com.groupjn.authenticationservice.api.event.UserAddedEvent;
import com.groupjn.authenticationservice.entity.UserSummary;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;

import java.util.List;

public class UserProjector {

        private final UserSummaryRepository repository;

        public UserProjector(UserSummaryRepository repository) {
            this.repository = repository;
        }

        @EventHandler
        public  void on(UserAddedEvent evt){
            //gotten from usersummary
            UserSummary summary = new UserSummary(evt.getUsername(), evt.getPassword(), evt.getEmail(), evt.getEnabled(), evt.getAccountNonExpired(), evt.getAccountNonLocked(), evt.getCredentialsNonExpired(), evt.getRoles());
            repository.save(summary);
        }

        @QueryHandler
        public List<UserSummary> handle(GetUserQuery query){
            return  repository.findAll();
        }


}
