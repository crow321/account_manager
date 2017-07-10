package test.dao;

import com.jump.account.base.dao.impl.AccountDaoImpl;
import com.jump.account.base.entity.Account;
import com.jump.account.base.vo.Page;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import test.Junit4BaseTest;

import java.util.Date;
import java.util.List;

/**
 * Created by zhangp on 2017/6/22.
 */
public class AccountDaoImplTest extends Junit4BaseTest {
    @Autowired
    private AccountDaoImpl accountDao;

    @Test
    public void insert() throws Exception {

        Account account = new Account();
        account.setName("本地PC机静态IP");
        account.setTime(new Date());
        account.setMessage("DNS: 192.168.90.253/8.8.8.8");
        account.setUrl("192.168.90.90/24 GW:192.168.90.1");
        account.setUserName("");
        account.setPassword("1".getBytes());
        boolean result = accountDao.insert(account);
        System.out.println("insert: " + result);

       /* Account account = new Account();
        boolean res = accountDao.insert(account);
        System.out.println("account-->" + account);
        System.out.println("res-->" + res);*/
    }

    @Test
    public void getOneByName() throws Exception {
    }

    @Test
    public void update() throws Exception {
    }

    @Test
    public void deleteByKeyword() throws Exception {
        boolean res = accountDao.deleteByKeyword("url");
        System.out.println("del：" + res);
    }

    @Test
    public void queryForPage() {
        Page page = accountDao.queryForPage(3, 2);

        System.out.println("*************************************************************************************");
        System.out.println("当前页数             : 第 " + page.getCurrentPageIndex() + " 页.");
        System.out.println("总页数为             : 共 " + page.getTotalPageNumber() + " 页.");
        System.out.println("每页记录数           :    " + page.getperPageSize() + " 条.");
        System.out.println("当前页的首条记录索引从: 第 " + page.getBeginPageIndex() + " 条开始.");
        System.out.println("*************************************************************************************");
    }

    @Test
    public void queryByKeyword() {
        String keyword = "192.168.56.102";
        List list = accountDao.queryByKeyword(keyword);
        System.out.println("keyword:\n" + list);
    }

}