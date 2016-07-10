package com.myproject.web;

import com.myproject.domain.Shop;
import com.myproject.domain.User;
import com.myproject.service.LoginUserDetails;
import com.myproject.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by nishina on 2016/05/08.
 */
@Controller
@RequestMapping("users")
public class UserController {
    @Autowired
    ShopService shopService;

    @RequestMapping(method = RequestMethod.GET)
    String list(Model model, @AuthenticationPrincipal LoginUserDetails userDetails) {

        //joinのケース
        User user = userDetails.getUser();
        Shop shop = new Shop();
        shop.setId(1);
        shop.setName("たまい");
        shop.setNote("安い");
/*        shop.setUser(user);
        shopService.create_join(shop,user);*/
        shopService.create(shop);

        //独立しているケース
/*        shopService.create(new Shop(null, "たまい", "やすい"));
        shopService.create(new Shop(null, "美登利", "うまい"));*/

        List<Shop> shops = shopService.findAll();
        model.addAttribute("shops", shops);
        System.out.println(user.getId());
        System.out.println(user.getEncodedPassword());
        System.out.println(user.getName());
        return "users/shoplist";
    }

    @RequestMapping(value = "delete")
    String delete() {
        return "users/delete";
    }

}
