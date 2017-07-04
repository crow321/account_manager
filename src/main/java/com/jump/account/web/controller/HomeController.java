package com.jump.account.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by zhangp on 2017/7/4.
 */
@Controller
@RequestMapping(value = "/", method = RequestMethod.GET)
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showHome() {
        return "home";
    }
}
