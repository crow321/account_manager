package test.service;

import com.jump.account.base.entity.Account;
import com.jump.account.base.service.impl.AccountServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import test.Junit4BaseTest;

import java.util.Date;

/**
 * Created by zhangp on 2017/6/23.
 */
public class AccountServiceImplTest extends Junit4BaseTest {
    @Autowired
    private AccountServiceImpl accountService;

    @Test
    public void saveAccount() throws Exception {
        Account account = new Account();
        account.setName("QTEC");
        account.setTime(new Date());
        account.setMessage("员工宿舍");
        account.setUrl("url");
        account.setUserName("411");
        account.setPassword("房间号".getBytes("utf-8"));
        accountService.saveAccount(account);
        System.out.println("save: " + account);
    }

    @Test
    public void getAccountByName() throws Exception {
        Account account = accountService.getAccountByName("编译服务器");
        System.out.println("**************************************************");
        System.out.println("account查询结果:\n " + account);
        System.out.println("**************************************************");

    }

    @Test
    public void getAccountByUserName() throws Exception {
    }

}