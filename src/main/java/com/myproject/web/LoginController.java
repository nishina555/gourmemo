package com.myproject.web;

import com.myproject.domain.User;
import com.myproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by nishina on 2016/07/09.
 */
@Controller
public class LoginController {
    @Autowired
    UserService userService;
    @RequestMapping("loginForm")
    String loginForm() {
        User user = new User();
        user.setId(1);
        user.setName("user1");
        user.setEncodedPassword("$2a$10$1gJJgBlL75OIjkSgkYPXI.mV7ihEPjxIiCkXKBEc7/r9xUIjZyc9i");
        userService.create(user);
        return "loginForm";
    }
}
