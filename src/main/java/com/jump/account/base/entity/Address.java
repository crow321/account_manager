package com.jump.account.base.entity;

import org.hibernate.annotations.*;
import org.hibernate.annotations.Cache;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by zhangp on 2017/7/11.
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
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
