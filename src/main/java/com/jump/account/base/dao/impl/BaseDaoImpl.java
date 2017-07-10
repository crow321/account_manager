package com.jump.account.base.dao.impl;

import com.jump.account.base.dao.IBaseDao;
import com.jump.account.base.entity.Account;
import com.jump.account.base.util.PageUtil;
import com.jump.account.base.vo.Page;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * 基类 Dao
 * Created by zhangp on 2017/6/22.
 */

public class BaseDaoImpl<T> implements IBaseDao<T> {

    private final static Logger LOGGER = LoggerFactory.getLogger(BaseDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    private Class<T> clazz;

    @SuppressWarnings("unchecked")
    public BaseDaoImpl() {
        Class c = getClass();
        ParameterizedType pt = (ParameterizedType) c.getGenericSuperclass();
        Type[] types= pt.getActualTypeArguments();
        clazz = (Class<T>) types[0];
        LOGGER.info("clazz: {}", clazz.getName());
    }

    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public boolean insert(T entity) {
        try {
            getCurrentSession().save(entity);
        } catch (Exception e) {
            LOGGER.error("insert error: {}", e);
            return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T getOneByName(String name) {
        String hql = "select a from " + clazz.getSimpleName() + " as a where a.name =:name";
        Query query = getCurrentSession().createQuery(hql);
        query.setParameter("name", name);
        return (T) query.uniqueResult();
    }

    @Override
    public void update(T entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public boolean deleteByKeyword(String keyword) {
        String hql = "delete " + clazz.getSimpleName() + " as a where a.name like :keyword";
        Query query = getCurrentSession().createQuery(hql);
        query.setParameter("keyword", "%" + keyword + "%");
        return query.executeUpdate() > 0;
    }
    @Override
    public Page queryForPage(int startRecordIndex, int perPageSize) {
        String hql = "from Account";
        return queryForPageByHql(hql, startRecordIndex, perPageSize);
    }

    @Override
    public Page queryForPageByHql(String hql, int startRecordIndex, int perPageSize) {
//        String hql = "from Account";
//        String countHql = "select count(*) from Account";
        Query query = getCurrentSession().createQuery(hql);
        query.setFirstResult(startRecordIndex).setMaxResults(perPageSize);
        List<Account> list = query.list();
        int totalRecordNumber = list.size();

        return PageUtil.createPage(totalRecordNumber, perPageSize, startRecordIndex, list);
    }

    @Override
    public int count(String hql) {
        return Integer.parseInt(getCurrentSession().createQuery(hql).uniqueResult().toString());
    }

    @Override
    public List<T> queryByKeyword(String keyword) {
        LOGGER.debug("receive keyword:{}", keyword);

        //方式一 使用变量 :keyword
        /*String hql = "from " + clazz.getSimpleName() + " as a where a.message like :keyword";
        Query query = getCurrentSession().createQuery(hql);
        query.setParameter("keyword", "%" + keyword + "%");*/

        //方式二 使用占位符
        String hql = "from Account where name like ?";
        Query query = getCurrentSession().createQuery(hql);
        query.setParameter(0, "%" + keyword + "%");
        return query.list();
    }
}
