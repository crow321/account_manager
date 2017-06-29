package com.jump.account.base.util;

import com.jump.account.base.vo.Page;

import java.util.List;

/**
 * Created by zhangp on 2017/6/28.
 */
public class PageUtil {
    private static final int PER_PAGE_SIZE = 10;

    /**
     * 创建分页
     *
     * @param totalRecordNumber 总记录数
     * @param perPageSize       每页记录最大值
     * @param startRecordIndex  返回页起始记录的索引
     * @param list              要返回的记录列表
     * @return Page 实例
     */
    public static Page createPage(int totalRecordNumber, int perPageSize, int startRecordIndex, List list) {
        int currentPageIndex = getCurrentPage(startRecordIndex, perPageSize);
        perPageSize = getPerPageSize(perPageSize);
        int totalPageNumber = getTotalPageNumber(totalRecordNumber, perPageSize);

        Page page = new Page();
        page.setTotalRecordNumber(totalRecordNumber);
        page.setperPageSize(perPageSize);
        page.setCurrentPageIndex(currentPageIndex);
        page.setList(list);
        page.setTotalPageNumber(totalPageNumber);
        page.setBeginPageIndex(getBeginPageIndex(startRecordIndex, perPageSize));
        page.setHasPrePage(getIsHasPrePage(currentPageIndex));
        page.setHasNextPage(getIsHasNextPage(currentPageIndex, totalPageNumber));

        return page;
    }

    /**
     * 获取显示总页数
     *
     * @param totalRecordNumber
     * @param perPageSize
     * @return
     */
    public static int getTotalPageNumber(int totalRecordNumber, int perPageSize) {
        if (perPageSize == 0) {
            perPageSize = PER_PAGE_SIZE;
        }
        int count = totalRecordNumber / perPageSize;
        return totalRecordNumber % perPageSize == 0 ? count : count + 1;
    }

    /**
     * 获取当前页
     *
     * @param startRecordIndex
     * @return
     */
    public static int getCurrentPage(int startRecordIndex, int perPageSize) {
        int currentPage = startRecordIndex / perPageSize;
        return startRecordIndex % perPageSize == 0 ? currentPage : currentPage + 1;
    }

    /**
     * 获取每页最大记录数
     *
     * @param perPageSize 每页最大记录数
     * @return 每页最大记录数
     */
    public static int getPerPageSize(int perPageSize) {
        return perPageSize == 0 ? PER_PAGE_SIZE : perPageSize;
    }

    /**
     * 判断是否有上一页
     *
     * @param currentPageIndex 当前页码
     * @return true or false
     */
    public static boolean getIsHasPrePage(int currentPageIndex) {
        return currentPageIndex == 1 ? false : true;
    }

    /**
     * 判断是否有下一页
     *
     * @param currentPageIndex 当前页码
     * @param totalPageNumber  总页数
     * @return true or false
     */
    public static boolean getIsHasNextPage(int currentPageIndex, int totalPageNumber) {
        return currentPageIndex < totalPageNumber ? true : false;
    }

    /**
     * 获取起始页码
     *
     * @param startRecordIndex 需要返回的起始记录索引
     * @param perPageSize      每页最大记录数
     * @return 默认 1
     */
    public static int getBeginPageIndex(int startRecordIndex, int perPageSize) {
        return startRecordIndex;
    }
}
