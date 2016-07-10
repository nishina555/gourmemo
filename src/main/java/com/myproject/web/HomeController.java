package com.myproject.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by nishina on 2016/05/07.
 */
@Controller
public class HomeController {
    @RequestMapping("/")
    public String index() {
        return "top";
    }

}