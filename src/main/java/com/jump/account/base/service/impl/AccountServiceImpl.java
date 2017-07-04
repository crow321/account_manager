package com.jump.account.base.service.impl;

import com.jump.account.base.dao.impl.AccountDaoImpl;
import com.jump.account.base.entity.Account;
import com.jump.account.base.security.impl.SecurityImplForAES128;
import com.jump.account.base.service.IAccountService;
import com.jump.account.base.util.ConvertUtil;
import com.jump.account.base.vo.Page;
import org.jboss.logging.Cause;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.Log;

/**
 * Created by zhangp on 2017/6/23.
 */
@Service
public class AccountServiceImpl implements IAccountService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);
    @Autowired
    private AccountDaoImpl accountDao;
    @Autowired
    private SecurityImplForAES128 securityImplForAES128;
    @Autowired
    private ConvertUtil convertUtil;

    @Override
    public boolean saveAccount(Account account) {
        LOGGER.info("receive account,{}", account);
        try {
            byte[] password = securityImplForAES128.encrypt(account.getPassword());
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
        byte[] decPassword = securityImplForAES128.decrypt(password);
        account.setPassword(decPassword);
        return account;
    }

    @Override
    public String getPasswordByUserName(String userName) {
        Account account = accountDao.getOneByName(userName);

        return new String(account.getPassword());
    }

    @Override
    public boolean deleteByKeyword(String keyword) {
        return accountDao.deleteByKeyword(keyword);
    }
}
