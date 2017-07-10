package com.jump.account.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by zhangp on 2017/7/7.
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String showAccount(Model model) {
        model.addAttribute("method", "AccountController.showAccount");
        return "account";
    }
}
