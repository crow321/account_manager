package com.jump.account.base.dao.impl;

import com.jump.account.base.dao.IAccountDao;
import com.jump.account.base.entity.Account;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zhangp on 2017/6/22.
 */
@Repository
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class AccountDaoImpl extends BaseDaoImpl<Account> implements IAccountDao<Account> {

}
