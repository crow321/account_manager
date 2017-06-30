package com.jump.account.base.dao;

import com.jump.account.base.vo.Page;

import java.util.List;

/**
 * Created by zhangp on 2017/6/22.
 */
public interface IBaseDao<T> {
    boolean insert(T entity);

    T getOneByName(String name);

    /**
     * 更新对象
     *
     * @param entity
     */
    void update(T entity);

    /**
     * 根据名称删除对象
     *
     * @param name
     * @return
     */
    boolean deleteByName(String name);

    /**
     * 分页查询
     *
     * @param startRecordIndex 从该位置后开始记录
     * @param perPageSize      每页的容量
     * @return
     */
    Page queryForPage(int startRecordIndex, int perPageSize);

    /**
     * 根据 HQL 语句统计数量
     *
     * @param hql
     * @return
     */
    int count(String hql);

    /**
     * 根据关键字进行模糊查询
     *
     * @param keyword 关键字
     * @return 返回匹配到的所有对象
     */
    List<T> queryByKeyword(String keyword);
}
