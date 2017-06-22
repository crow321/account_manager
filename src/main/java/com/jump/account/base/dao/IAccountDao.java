package com.jump.account.base.dao;

import com.jump.account.base.entity.Account;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

/**
 * Created by zhangp on 2017/6/22.
 */
@Repository
public interface IAccountDao<Account> extends IBaseDao<Account> {

}
