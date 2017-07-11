package com.jump.account.base.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.Set;

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

    //使用mappedBy 方式指定集合中的对象Address是通过 Address 中的 account 属性关联到 Account对象的
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private Set<Address> addressSet;

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
                '}';
    }

    public Set<Address> getAddressSet() {
        return addressSet;
    }

    public void setAddressSet(Set<Address> addressSet) {
        this.addressSet = addressSet;
    }
}
