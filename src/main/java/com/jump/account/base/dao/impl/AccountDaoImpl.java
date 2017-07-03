package com.jump.account.base.dao.impl;

import com.jump.account.base.dao.IAccountDao;
import com.jump.account.base.entity.Account;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by zhangp on 2017/6/22.
 */
@Repository
public class AccountDaoImpl extends BaseDaoImpl<Account> implements IAccountDao<Account> {

    @Override
    public boolean deleteByKeyword(String keyword) {
        String hql = "delete Account  where name like :keyword" +
                " or url like :keyword" +
                " or message like :keyword";
        Query query = getCurrentSession().createQuery(hql);
        query.setParameter("keyword", "%" + keyword + "%");
        return query.executeUpdate() > 0;
    }
}
