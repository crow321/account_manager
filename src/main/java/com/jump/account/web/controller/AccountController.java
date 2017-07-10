package com.jump.account.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

/**
 * Created by zhangp on 2017/7/7.
 */
@Controller
@RequestMapping({"/account", "/account/"})
public class AccountController {

    @RequestMapping(method = RequestMethod.GET)
    public String showAccount(Model model) {
        model.addAttribute("method", "AccountController.showAccount");
        model.addAttribute("time", new Date());
        return "account";
    }

    public String getAccount(Model model) {

        return "/get_account";
    }

}
