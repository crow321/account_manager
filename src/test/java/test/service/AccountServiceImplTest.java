package test.service;

import com.jump.account.base.entity.Account;
import com.jump.account.base.security.ISecurity;
import com.jump.account.base.service.impl.AccountServiceImpl;
import com.jump.account.base.util.ConvertUtil;
import com.jump.account.base.vo.Page;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import test.Junit4BaseTest;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by zhangp on 2017/6/23.
 */
public class AccountServiceImplTest extends Junit4BaseTest {
    @Autowired
    private AccountServiceImpl accountService;
    @Autowired
    private ISecurity security;
    @Autowired
    private ConvertUtil convertUtil;

    @Test
    public void saveAccount() throws Exception {

        Account account = new Account();
        account.setName("mysql数据库 centos7");
        account.setTime(new Date());
        account.setMessage("本地数据库，虚拟机");
        account.setUrl("192.168.56.102:3306");
        account.setUserName("root");
        account.setPassword("123456".getBytes());
        boolean res = accountService.saveAccount(account);
        System.out.println("save: " + res);
    }

    @Test
    public void deleteByKeyword() {
        String keyword = "mysql数据库";
        boolean res = accountService.deleteByKeyword(keyword);
        System.out.println("del:" + res);
    }
    @Test
    public void getAccountByName() throws Exception {
        Account account = accountService.getAccountByName("mysql数据库 key_store");
        System.out.println("**************************************************");
        System.out.println("account查询结果:\n" + account);
//        System.out.println("password.size: " + account.getPassword().length);
        System.out.println("password: " + new String(account.getPassword()));
        System.out.println("**************************************************");

    }

    @Test
    public void getAccountByUserName() throws Exception {
    }

    @Test
    public void te() throws UnsupportedEncodingException {
        byte[] bytes = "Qtec_KSM*".getBytes();
        byte[] enc = security.encrypt(bytes);
        System.out.println("bytes:" + Arrays.toString(bytes));
        System.out.println("enc:" + Arrays.toString(enc));
//        System.out.println("encHex: " + convertUtil.bytesToHexString(enc));
        byte[] dec = security.decrypt(enc);
        System.out.println("dec: " + Arrays.toString(dec));
//        System.out.println("decHex: " + convertUtil.bytesToHexString(dec));

    }
}