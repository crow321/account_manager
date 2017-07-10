package com.jump.account.web.controller;

import com.jump.account.base.entity.Account;
import com.jump.account.base.service.impl.AccountServiceImpl;
import com.jump.account.base.vo.Page;
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
   /* @Autowired
    private ProtoBufUtil protoBufUtil;*/

    @RequestMapping(value = {"home", ""}, method = RequestMethod.GET)
    public String showHome(Model model) {

        model.addAttribute("time", new Date());
        model.addAttribute("name", "HomeController.showHome");
        return "home";
    }
}
