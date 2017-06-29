package com.jump.account.base.service.impl;

import com.jump.account.base.dao.impl.AccountDaoImpl;
import com.jump.account.base.entity.Account;
import com.jump.account.base.security.impl.SecurityImplByAES128;
import com.jump.account.base.service.IAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhangp on 2017/6/23.
 */
@Service
public class AccountServiceImpl implements IAccountService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);
    @Autowired
    private AccountDaoImpl accountDao;
    @Autowired
    private SecurityImplByAES128 securityImplByAES128;

    @Override
    public boolean saveAccount(Account account) {
        byte[] password = securityImplByAES128.encrypt(account.getPassword());
        account.setPassword(password);
        accountDao.insert(account);
        return true;
    }

    @Override
    public Account getAccountByName(String name) {
        return accountDao.getOneByName(name);
    }

    @Override
    public String getPasswordByUserName(String userName) {
        Account account = accountDao.getOneByName(userName);

        return new String(account.getPassword());
    }

}
