package test.dao;

import com.jump.account.base.dao.impl.AccountDaoImpl;
import com.jump.account.base.dao.impl.BaseDaoImpl;
import com.jump.account.base.entity.Account;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by zhangp on 2017/6/22.
 */
public class BaseDaoImplTest extends Junit4BaseTest{
    @Autowired
    private AccountDaoImpl accountDao;

    @Test
    public void insert() throws Exception {

        Account account = new Account();
        account.setName("insert");
        account.setTime(new Date());
        account.setId(10);
        account.setMessage("message");
        account.setUrl("url");
        account.setUserName("root");
        account.setPassword("123456");
        boolean result = accountDao.insert(account);
        System.out.println("insert: " + result);
    }

    @Test
    public void getOneByName() throws Exception {
    }

    @Test
    public void update() throws Exception {
    }

    @Test
    public void deleteByName() throws Exception {
    }

}