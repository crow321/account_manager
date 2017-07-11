package com.jump.account.base.entity;

import javax.persistence.*;

/**
 * Created by zhangp on 2017/7/11.
 */
@Entity
@Table(name = "a_address")
public class Address {
    @Id
    @Column(name = "ADDR_ID", nullable = false)
    private int Id;
    @Column(name = "NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name = "ACCOUNT_ID")
    private Account account;

    public int getId() {
        return Id;
    }

    public void setAddrId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
