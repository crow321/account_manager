package com.jump.account.base.service;

import com.jump.account.base.entity.Account;
import org.springframework.stereotype.Service;

/**
 * Created by zhangp on 2017/6/23.
 */
@Service
public interface IAccountService {

    /**
     * 保存账号信息
     *
     * @param account
     * @return
     */
    boolean saveAccount(Account account);

    Account getAccountByName(String name);

    String getPasswordByUserName(String userName);

    boolean deleteByKeyword(String keyword);

}
