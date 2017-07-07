package com.jump.account.web.controller;

import com.jump.account.base.entity.Account;
import com.jump.account.base.thrift.AccountService;
import com.jump.account.base.thrift.impl.AccountServiceImpl;
import com.jump.account.base.util.ProtoBufUtil;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.nio.ByteBuffer;

/**
 * Created by zhangp on 2017/7/4.
 */
@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    private AccountServiceImpl accountService;
    @Autowired
    private ProtoBufUtil protoBufUtil;

    @RequestMapping(value = {"/home", "/"}, method = RequestMethod.GET)
    public String showHome(Model model) {
        Account account = new Account();
        account.setName("acc");
        account.setUrl("127.0.0.1");
        model.addAttribute(account);

        return "home";
    }
}
