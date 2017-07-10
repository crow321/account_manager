package com.jump.account.base.service;

import com.jump.account.base.entity.Account;
import com.jump.account.base.vo.Page;
import org.springframework.stereotype.Service;

import java.util.List;

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

    /**
     * 通过username       进行模糊查询
     *
     * @param userName 关键字
     * @return 返回匹配到的结果
     */
    List<String> getPasswordByUserName(String userName);

    boolean deleteByKeyword(String keyword);

    void update(Account account);

    Page queryForPageByKeyword(String keyword);
}
