package com.myproject.web;

import com.myproject.domain.Shop;
import com.myproject.domain.User;
import com.myproject.service.LoginUserDetails;
import com.myproject.service.ShopService;
import com.myproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by nishina on 2016/05/08.
 */
@Controller
@RequestMapping("users")
public class UserController {
    @Autowired
    ShopService shopService;
    UserService userService;


    @RequestMapping(method = RequestMethod.GET)
    String list(Model model, @AuthenticationPrincipal LoginUserDetails userDetails) {
        User user = userDetails.getUser();
        List<Shop> shops = shopService.findByUser(user);
        model.addAttribute("shops", shops);
        System.out.println("debugdebugdebug");
/*        shopService.findAll().forEach(System.out::println);*/
        return "users/shoplist";
    }

    //検索
    @RequestMapping(value = "search", method = RequestMethod.GET)
    String search(Model model, @RequestParam String tag, String free_word, @AuthenticationPrincipal LoginUserDetails userDetails) {
        User user = userDetails.getUser();
        List<Shop> shops = shopService.findByNoteLikeAndUser(free_word, user);
        System.out.println(shops);
        model.addAttribute("shops", shops);

        return "users/shoplist";
    }

    @RequestMapping(value = "delete")
    String delete() {
        return "users/delete";
    }

}
