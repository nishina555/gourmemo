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


    @RequestMapping(value = "edit", params = "form", method = RequestMethod.GET)
    String editForm(@RequestParam Integer id, ShopForm form) {
        Shop shop = shopService.findOne(id);
        BeanUtils.copyProperties(shop, form);
        return "shops/edit";
    }

    @RequestMapping(value = "delete")
    String delete(@RequestParam Integer id) {
        shopService.delete(id);
        //confirm欲しい

        return "redirect:/users";
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

    @RequestMapping(value="create", method=RequestMethod.GET)
    String create() {
        return "/shops/create";
    }

    //編集をPOSTして新規作成するメソッド
    @RequestMapping(value = "save", method = RequestMethod.POST)
    String save(@Validated ShopForm form, BindingResult result, @AuthenticationPrincipal LoginUserDetails userDetails) {
        if (result.hasErrors()) {
            return "shops/create";
        }
        Shop shop = new Shop();
        BeanUtils.copyProperties(form, shop);
        shopService.create(shop, userDetails.getUser());
        return "redirect:/users";
    }

    //トップページに戻るメソッド
    @RequestMapping(value = "edit", params = "goToTop")
    String goToTop() {
        return "redirect:/users";
    }

}
