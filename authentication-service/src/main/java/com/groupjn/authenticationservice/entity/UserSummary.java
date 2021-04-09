package com.groupjn.authenticationservice.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@Data
@NoArgsConstructor
public class UserSummary {
    @Id
    private String username;
    private String password;
    private String email;
    private Boolean enabled;
    private Boolean accountNonExpired;
    private Boolean credentialsNonExpired;
    private Boolean accountNonLocked;
    public String usertype;
    private Integer role;


    public UserSummary( String username, String password, String email, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, int role ) {
        this.username = username;
        this.password = password;
        this.email =  email;
        this.enabled = enabled;
        this.accountNonExpired = accountNonExpired;
        this.credentialsNonExpired = credentialsNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.role = role;
        //this.roles = user.getRoles();
    }

}
