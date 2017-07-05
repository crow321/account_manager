package com.jump.account.base.thrift.impl;

import com.google.protobuf.ByteString;
import com.jump.account.base.dao.impl.AccountDaoImpl;
import com.jump.account.base.entity.Account;
import com.jump.account.base.protobuf.AccountOuterClass;
import com.jump.account.base.security.ISecurity;
import com.jump.account.base.thrift.AccountService;
import com.jump.account.base.util.ProtoBufUtil;
import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.ByteBuffer;
import java.util.Date;
import java.util.List;

/**
 * Created by zhangp on 2017/7/5.
 */
@Service
public class AccountServiceImpl implements AccountService.Iface {
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Autowired
    private AccountDaoImpl accountDao;
    @Autowired
    private ProtoBufUtil protoBufUtil;
    @Autowired
    private ISecurity security;

    @Override
    public boolean saveAccount(ByteBuffer request) throws TException {
        AccountOuterClass.AccountMessage re = protoBufUtil.parseByteBufferToAccountMessage(request);
        if (re != null) {
            LOGGER.info("receive save request,{}", re);

            byte[] originPassword = re.getPassword().toByteArray();
            if (originPassword.equals(new byte[0])) {
                LOGGER.error("password should not be null!");
                return false;
            }

            byte[] encryptPassword = security.encrypt(originPassword);
            Account account = new Account();
            account.setUserName(re.getUserName());
            account.setPassword(encryptPassword);
            account.setUrl(re.getUrl());
            account.setName(re.getName());
            account.setTime(new Date());

            return accountDao.insert(account);
        }
        return false;
    }

    @Override
    public ByteBuffer getAccountByKeyword(String keyword) throws TException {
        LOGGER.info("receive get Account By Keyword,{}", keyword);

        List<Account> accounts = accountDao.queryByKeyword(keyword);
        if (accounts != null && accounts.size() > 0) {
            if (accounts.size() > 1) {
                LOGGER.warn("匹配到多个结果，仅返回一个结果！");
            }
            Account account = accounts.get(0);
            byte[] encryptPassword = account.getPassword();
            byte[] decryptPassword = security.decrypt(encryptPassword);

            AccountOuterClass.AccountMessage.Builder accBuilder = AccountOuterClass.AccountMessage.newBuilder();
            accBuilder.setName(account.getName());
            accBuilder.setUserName(account.getUserName());
            accBuilder.setMessage(account.getMessage());
            accBuilder.setUrl(account.getUrl());
            accBuilder.setPassword(ByteString.copyFrom(decryptPassword));

            LOGGER.info("response result, {}", accBuilder.build());
            return ByteBuffer.wrap(accBuilder.build().toByteArray());
        }
        return null;
    }

    @Override
    public void update(ByteBuffer request) throws TException {
        //todo
    }

    @Override
    public boolean removeAccountByKeyword(String keyword) throws TException {
        LOGGER.info("receive remove account by keyword, {}", keyword);
        return accountDao.deleteByKeyword(keyword);
    }

    @Override
    public ByteBuffer getPasswordAndUserNameByKeyword(String keyword) throws TException {
        //todo
        return null;
    }
}
