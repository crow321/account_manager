package com.jump.account.base.dao;

/**
 * Created by zhangp on 2017/6/22.
 */
public interface IBaseDao<T> {
    boolean insert(T entity);

    T getOneByName(String name);

    boolean update(T entity);

    boolean deleteByName(String name);
}
