package com.jump.account.base.vo;

import java.util.List;

/**
 * 分页
 * Created by zhangp on 2017/6/28.
 */
public class Page {
    //总记录数
    private int totalRecordNumber;
    //每页容量
    private int perPageSize;
    //起始页
    private int beginPageIndex;
    //该页记录内容列表
    private List list;
    //总页数
    private int totalPageNumber;
    //当前页
    private int currentPageIndex;
    //是否有上一页
    private boolean isHasPrePage;
    //是否有下一页
    private boolean isHasNextPage;

    public Page() {
    }

    public Page(int totalRecordNumber, int perPageSize, int beginPageIndex,
                List list, int totalPageNumber, int currentPageIndex) {
        this.totalRecordNumber = totalRecordNumber;
        this.perPageSize = perPageSize;
        this.beginPageIndex = beginPageIndex;
        this.list = list;
        this.totalPageNumber = totalPageNumber;
        this.currentPageIndex = currentPageIndex;
        this.isHasPrePage = false;
        this.isHasNextPage = true;
    }

    /**
     * 构造函数
     *
     * @param totalRecordNumber 总记录数
     * @param perPageSize       每页记录的最大记录数
     * @param beginPageIndex    起始页码
     * @param list              该页包含的记录列表
     * @param totalPageNumber   总页数
     * @param currentPageIndex  当前页码
     * @param isHasPrePage      是否有上一页
     * @param isHasNextPage     是否有下一页
     */
    public Page(int totalRecordNumber, int perPageSize, int beginPageIndex,
                List list, int totalPageNumber, int currentPageIndex, boolean isHasPrePage, boolean isHasNextPage) {
        this(totalRecordNumber, perPageSize, beginPageIndex, list, totalPageNumber, currentPageIndex);
        this.isHasPrePage = isHasPrePage;
        this.isHasNextPage = isHasNextPage;
    }

    public int getTotalRecordNumber() {
        return totalRecordNumber;
    }

    public void setTotalRecordNumber(int totalRecordNumber) {
        this.totalRecordNumber = totalRecordNumber;
    }

    public int getperPageSize() {
        return perPageSize;
    }

    public void setperPageSize(int perPageSize) {
        this.perPageSize = perPageSize;
    }

    public int getBeginPageIndex() {
        return beginPageIndex;
    }

    public void setBeginPageIndex(int beginPageIndex) {
        this.beginPageIndex = beginPageIndex;
    }

    public int getTotalPageNumber() {
        return totalPageNumber;
    }

    public void setTotalPageNumber(int totalPageNumber) {
        this.totalPageNumber = totalPageNumber;
    }

    public int getCurrentPageIndex() {
        return currentPageIndex;
    }

    public void setCurrentPageIndex(int currentPageIndex) {
        this.currentPageIndex = currentPageIndex;
    }

    public boolean isHasPrePage() {
        return isHasPrePage;
    }

    public void setHasPrePage(boolean hasPrePage) {
        isHasPrePage = hasPrePage;
    }

    public boolean isHasNextPage() {
        return isHasNextPage;
    }

    public void setHasNextPage(boolean hasNextPage) {
        isHasNextPage = hasNextPage;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Page{" +
                "totalRecordNumber=" + totalRecordNumber +
                ", perPageSize=" + perPageSize +
                ", beginPageIndex=" + beginPageIndex +
                ", totalPageNumber=" + totalPageNumber +
                ", currentPageIndex=" + currentPageIndex +
                ", isHasPrePage=" + isHasPrePage +
                ", isHasNextPage=" + isHasNextPage +
                '}';
    }
}
