package com.jump.account.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by zhangp on 2017/7/7.
 */
@Controller
@RequestMapping({"/form", "/form/"})
public class FormController {

    @RequestMapping(method = RequestMethod.GET)
    public String formMain(Model model) {

        return "form";
    }
}
