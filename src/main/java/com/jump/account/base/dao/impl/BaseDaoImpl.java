package com.jump.account.base.dao.impl;

import com.jump.account.base.dao.IBaseDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.Target;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 基类 Dao
 * Created by zhangp on 2017/6/22.
 */
public class BaseDaoImpl<T> implements IBaseDao<T> {

    private final static Logger LOGGER = LoggerFactory.getLogger(BaseDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;
    private Class<T> clazz;


    public BaseDaoImpl() {
        Class c = getClass();
        //LOGGER.info("getClass:{}", c);
        ParameterizedType pt = (ParameterizedType) c.getGenericSuperclass();
        //LOGGER.info("type: {}", type);
        Type[] types= pt.getActualTypeArguments();
        clazz = (Class<T>) types[0];

        LOGGER.info("clazz: {}",clazz.getName());
    }

    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public boolean insert(T entity) {
        try {
            getCurrentSession().save(entity);
        } catch (Exception e) {
            LOGGER.error("insert error!\n{}", e);
            return false;
        }
        return true;
    }

    @Override
    public T getOneByName(String name) {
        String hql = "select a from " + clazz.getSimpleName() + " as a where a.name =:name";
        Query query = getCurrentSession().createQuery(hql);
        query.setParameter("name", name);
        return (T) query.uniqueResult();
    }

    @Override
    public boolean update(T entity) {
        return false;
    }

    @Override
    public boolean deleteByName(String name) {
        String hql = "delete a from " + clazz.getSimpleName() + "as a where a.name =:name";
        Query query = getCurrentSession().createQuery(hql);
        return query.executeUpdate() > 0;
    }
}
