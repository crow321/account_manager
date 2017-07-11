package com.jump.account.web.controller;

import com.jump.account.base.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;


/**
 * Created by zhangp on 2017/7/4.
 */
@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    private AccountServiceImpl accountService;

    @RequestMapping(value = {"home", ""}, method = RequestMethod.GET)
    public String showHome(Model model) {
        int count = accountService.countAccount("account");
        System.out.println("count: " + count);
        model.addAttribute("time", new Date());
        model.addAttribute("totalAccountCount", count);
        return "home";
    }
}
