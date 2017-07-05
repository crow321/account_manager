package com.jump.account;

import com.jump.account.base.thrift.server.AccountServerImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zhangp on 2017/7/5.
 */
public class BootStrap {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountServerImpl accountServer = (AccountServerImpl) context.getBean("accountServer");
        accountServer.run();
    }
}
