package com.myproject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by nishina on 2016/05/07.
 */
@RestController
public class SampleController {

    @RequestMapping("/")
    public String index() {
        return "Spring Boot Sample!";
    }

}