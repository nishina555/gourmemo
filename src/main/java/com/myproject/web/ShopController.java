package com.myproject.web;

import com.myproject.domain.Shop;
import com.myproject.service.LoginUserDetails;
import com.myproject.service.ShopService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by nishina on 2016/07/02.
 */
@Controller
@RequestMapping("shops")
public class ShopController {
    @Autowired
    ShopService shopService;

    @ModelAttribute
    ShopForm setUpForm() {
        return new ShopForm();
    }

    //create メソッド

    @RequestMapping(value = "edit", params = "form", method = RequestMethod.GET)
    String editForm(@RequestParam Integer id, ShopForm form) {
        Shop shop = shopService.findOne(id);
        BeanUtils.copyProperties(shop, form);
        return "shops/edit";
    }

    @RequestMapping(value = "delete")
    String delete() {
        return "shops/delete";
    }

    //編集をPOSTして更新するメソッド
    @RequestMapping(value = "edit", method = RequestMethod.POST)
    String edit(@RequestParam Integer id, @Validated ShopForm form, BindingResult result, @AuthenticationPrincipal LoginUserDetails userDetails) {
        if (result.hasErrors()) {
            return editForm(id, form);
        }
        Shop shop = new Shop();
        BeanUtils.copyProperties(form, shop);

        shop.setId(id);
        shopService.update(shop, userDetails.getUser());

        return "redirect:/users";
    }

    //トップページに戻るメソッド
    @RequestMapping(value = "edit", params = "goToTop")
    String goToTop() {
        return "redirect:/users";
    }

}
