package test.dao;

import com.jump.account.base.dao.impl.AccountDaoImpl;
import com.jump.account.base.entity.Account;
import com.jump.account.base.vo.Page;
import org.junit.Assert;
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

        for (int i = 1; i < 10; i++) {
            Account account = new Account();
            account.setName("testwwww" + i);
            account.setTime(new Date());
            account.setId(i);
            account.setMessage("1");
            account.setUrl("1");
            account.setUserName("1");
            account.setPassword(("aa" + i).getBytes());
            //boolean result = accountDao.insert(account);
//            Assert.assertTrue(result);
            System.out.println("插入数量: " + i);
            long start = System.currentTimeMillis();
            Account res = accountDao.loadById((long) i);
            System.out.println("load(" + i + "),耗时：" + (System.currentTimeMillis() - start));
//            System.out.println("load:"+res.getName());
        }

       /* Account account = new Account();
        boolean res = accountDao.insert(account);
        System.out.println("account-->" + account);
        System.out.println("res-->" + res);*/
    }

    @Test
    public void getOneByName() throws Exception {
        for (int i = 0; i < 100; i++) {
            accountDao.getOneByName("testq" + i);
            System.out.println("get第 " + i + "个");
        }
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

    @Test
    public void loadById() {
        long count = 1022;
        while (true) {

            Account acc = accountDao.loadById(count);
            System.out.println("*******************\n" + acc.getName());
            count++;
            if (count > 1050) {
                break;
            }
        }

    }

}