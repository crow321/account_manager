package com.jump.account.base.thrift.client;

import com.google.protobuf.ByteString;
import com.jump.account.base.protobuf.AccountOuterClass;
import com.jump.account.base.security.ISecurity;
import com.jump.account.base.thrift.AccountService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.nio.ByteBuffer;

/**
 * Created by zhangp on 2017/7/5.
 */
@Component
public class Client {
    private static final Logger LOGGER = LoggerFactory.getLogger(Client.class);

    private static final int server_transport = 8990;
    private static ISecurity security;

    public static void main(String[] args) {
        start();
    }


    private static void start() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        security = (ISecurity) context.getBean("iSecurity");

//        TTransport transport = new TFramedTransport(new TSocket("192.168.56.102", server_transport));
        TTransport transport = new TFramedTransport(new TSocket("127.0.0.1", server_transport));
        TProtocol tProtocol = new TBinaryProtocol(transport);
        AccountService.Client Client = new AccountService.Client(tProtocol);

//        sendSaveAccount(Client, transport);
        sendGetAccountByKeyword(Client, transport);
    }

    private static void sendSaveAccount(AccountService.Client client, TTransport tTransport) {
        AccountOuterClass.AccountMessage.Builder builder = AccountOuterClass.AccountMessage.newBuilder();
        builder.setName("test");
        builder.setUrl("1");
        builder.setMessage("message");
        builder.setUserName("root");
        builder.setPassword(ByteString.copyFrom("password".getBytes()));

        ByteBuffer byteBuffer = ByteBuffer.wrap(builder.build().toByteArray());

        try {
            tTransport.open();

            client.saveAccount(byteBuffer);

        } catch (TException e) {
            LOGGER.error("sendSaveAccount error, e{}", e);
        } finally {
            tTransport.close();
        }
    }

    private static void sendGetAccountByKeyword(AccountService.Client client, TTransport tTransport) {
        String keyword = "mysql";
        try {
            tTransport.open();
            client.getAccountByKeyword(keyword);
        } catch (TTransportException e) {

            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        } finally {
            tTransport.close();
        }
    }
}
