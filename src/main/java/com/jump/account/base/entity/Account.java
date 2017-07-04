package com.jump.account.base.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by zhangp on 2017/6/22.
 */
@Entity
@Table(name = "account_manager")
public class Account implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    //备注
    private String message;
    private String url;
    @Column(name = "USER_NAME")
    private String userName;
    private byte[] password;
    private Date time;

    public Account() {
    }

    public Account(String userName, byte[] password) {
        this.userName = userName;
        this.password = password;
    }

    public Account(String url, String userName, byte[] password) {
        this(userName, password);
        this.url = url;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String owner) {
        this.message = owner;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public byte[] getPassword() {
        return password;
    }

    public void setPassword(byte[] password) {
        this.password = password;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Account: {" +
                "\n name='" + name + '\'' +
                ", \n message='" + message + '\'' +
                ", \n time=" + time +
                " }";
    }
}
