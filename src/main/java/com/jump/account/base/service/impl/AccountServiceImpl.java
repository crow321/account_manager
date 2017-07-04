package com.jump.account.base.service.impl;

import com.jump.account.base.dao.impl.AccountDaoImpl;
import com.jump.account.base.entity.Account;
import com.jump.account.base.security.impl.SecurityImplForAES128;
import com.jump.account.base.service.IAccountService;
import com.jump.account.base.util.ConvertUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangp on 2017/6/23.
 */
@Service
public class AccountServiceImpl implements IAccountService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);
    @Autowired
    private AccountDaoImpl accountDao;
    @Autowired
    private SecurityImplForAES128 security;
    @Autowired
    private ConvertUtil convertUtil;

    @Override
    public boolean saveAccount(Account account) {
        LOGGER.info("receive account,{}", account);
        try {
            byte[] password = security.encrypt(account.getPassword());
            account.setPassword(password);
            accountDao.insert(account);
        } catch (Exception e) {
            LOGGER.error("save account error.{}", e);
            return false;
        }
        return true;
    }

    @Override
    public Account getAccountByName(String name) {
        LOGGER.info("receive name: {}", name);
        Account account = accountDao.getOneByName(name);
        byte[] password = account.getPassword();
        byte[] decPassword = security.decrypt(password);
        account.setPassword(decPassword);
        return account;
    }

    @Override
    public List<String> getPasswordByUserName(String userName) {
        LOGGER.info("get password by userName:{}", userName);
        List<Account> accounts = accountDao.queryByKeyword(userName);
        List<String> passwordList = new ArrayList<String>();
        for (Account account : accounts) {
            byte[] password = account.getPassword();
            byte[] decPassword = security.decrypt(password);
            passwordList.add(new String(decPassword));
        }
        return passwordList;
    }

    @Override
    public boolean deleteByKeyword(String keyword) {
        return accountDao.deleteByKeyword(keyword);
    }

    @Override
    public void update(Account account) {
        LOGGER.info("receive update account,{}", account);
        if (account.getPassword() != null) {
            byte[] password = security.encrypt(account.getPassword());
            account.setPassword(password);
        }
        accountDao.update(account);
    }
}
