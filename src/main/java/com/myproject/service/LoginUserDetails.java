package com.myproject.service;

import com.myproject.domain.User;
import lombok.Data;
import org.springframework.security.core.authority.AuthorityUtils;

/**
 * Created by nishina on 2016/07/09.
 */
@Data
public class LoginUserDetails extends org.springframework.security.core.userdetails.User {
    private final User user;

    public LoginUserDetails(User user) {
        super(user.getName(), user.getEncodedPassword(), AuthorityUtils.createAuthorityList("ROLE_USERS"));
        this.user = user;

    }

}
