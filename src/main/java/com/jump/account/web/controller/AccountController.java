package com.jump.account.web.controller;

import com.jump.account.base.entity.Account;
import com.jump.account.base.security.ISecurity;
import com.jump.account.base.service.impl.AccountServiceImpl;
import com.jump.account.base.util.ConvertUtil;
import com.jump.account.base.vo.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by zhangp on 2017/7/7.
 */
@Controller
@RequestMapping("/account")
public class AccountController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    private AccountServiceImpl accountService;
    @Autowired
    private ISecurity security;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String showAccount(Model model) {
        model.addAttribute("method", "AccountController.showAccount");
        model.addAttribute("time", new Date());
        return "account";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addAccount(HttpServletRequest req, Model model) {
        LOGGER.error("Receive getAccount, req.length:{}", req.getContentLength());
        String name = req.getParameter("name");
        if (name == null || name.equals("")) {
            LOGGER.error("输入字符串为空！");
            return "account_add";
        } else {
            Account account = new Account();
            account.setTime(new Date());
            account.setName(req.getParameter("name"));
            account.setUrl(req.getParameter("url"));
            account.setUserName(req.getParameter("userName"));
        /*String pwd = req.getParameter("password");
        if (pwd != null || !(pwd.equals(""))) {
            account.setPassword(req.getParameter("password").getBytes());
        }*/
            account.setPassword(req.getParameter("password").getBytes());
            account.setMessage(req.getParameter("message"));

            boolean isSave = accountService.saveAccount(account);
            LOGGER.error("saveAccount isSave:{}", isSave);

            model.addAttribute("isSave", isSave);
            model.addAttribute(account);
            return "account_add";
        }

    }

    //todo
    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String updateAccount(HttpServletRequest req, Model model) {
        LOGGER.error("Receive updateAccount, req.length:{}", req.getContentLength());
        String name = req.getParameter("name");
        if (name == null || name.equals("")) {
            LOGGER.error("输入字符串为空！");
            return "account_update";
        } else {
            Account account = accountService.getAccountByName(req.getParameter("name"));
            account.setTime(new Date());
            account.setUserName(req.getParameter("userName"));
            account.setPassword(req.getParameter("password").getBytes());
            accountService.update(account);

            return "account_update";
        }
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String getAccount(HttpServletRequest req, Model model) {

        LOGGER.error("Receive getAccount, keyword:{}", req.getContentLength());
        String keyword = req.getParameter("keyword");
        /*if (req.getContentLength() == -1 ) {
            LOGGER.error("***************");
        }*/
        if (keyword == null || keyword.equals("")) {
            LOGGER.error("输入字符串为空！");
            return "account_get";
        } else {
            System.out.println("web传入参数, name: " + req.getParameter("keyword"));
            Page page = accountService.queryForPageByKeyword(keyword);
//            System.out.println("Page.list:" + page.getList());
            List<Account> accountList = page.getList();
            List<String> passwordList = new ArrayList<String>();

            boolean isGetEmpty = false;
            if (accountList.size() == 0) {
                isGetEmpty = true;

            }
            model.addAttribute("isGetEmpty", isGetEmpty);
            model.addAttribute("accountList", accountList);

            return "account_get_result";
        }

    }

    @RequestMapping(value = "/del", method = RequestMethod.GET)
    public String delAccount(HttpServletRequest req, Model model) {

        String keyword = req.getParameter("keyword");
        LOGGER.error("delAccount ,length:{}", req.getContentLength());

        if (keyword == null) {
            LOGGER.error("delAccount null");
            return "account_delete";
        }
        boolean isDelete = accountService.deleteByKeyword(keyword);
        model.addAttribute(isDelete);
        return "account_delete";
    }
}


