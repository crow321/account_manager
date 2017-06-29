package com.jump.account.base.security;

/**
 * Created by zhangp on 2017/6/23.
 */
public interface ISecurity {
    public byte[] encrypt(byte[] src);

    public byte[] decrypt(byte[] encryptData);
}
