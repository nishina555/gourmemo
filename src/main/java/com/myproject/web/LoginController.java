package com.myproject.web;

import com.myproject.service.ShopService;
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
    ShopService shopService;

    @RequestMapping("loginForm")
    String loginForm() {
/*        User created_user = userService.findOne(1);
        System.out.println(created_user);*/
        return "loginForm";
    }
}
