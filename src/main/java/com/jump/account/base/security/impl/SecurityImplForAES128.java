package com.jump.account.base.security.impl;

import com.jump.account.base.security.ISecurity;
import com.jump.account.base.util.ConvertUtil;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.security.Security;
import java.util.Arrays;

/**
 * Created by zhangp on 2017/6/23.
 * Java本身限制密钥的长度最多128位，而AES256需要的密钥长度是256位，因此需要到Java官网上下载一个
 * java Cryptography Extension (JCE) Unlimited Strength Jurisdiction Policy Files。
 * 在Java SE的下载页面下面的Additional Resources那里会有下载链接。下载后打开压缩包，里面有两个jar文件。
 * 把这两个jar文件解压到JRE目录下的lib/security文件夹，覆盖原来的文件。这样Java就不再限制密钥的长度了。
 */
@Component("iSecurity")
public class SecurityImplForAES128 implements ISecurity {

    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityImplForAES128.class);
    private static final String algorithm = "AES";
    //算法/模式/补码方式
    private static final String DEFAULT_CIPHER_ALGORITHM = "AES/CBC/PKCS7Padding";
    private byte[] iv = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    @Value("${sharedSecretKey}")
    private String sharedSecretKey;
    @Autowired
    private ConvertUtil convertUtil;

    /**
     * 对原始数据进行加密
     * @param src 需要加密的原始数据
     * @return 加密数据
     */
    @Override
    public byte[] encrypt(byte[] src) {
        LOGGER.info("before encrypt, src :{}", convertUtil.bytesToHexString(src));
        if (src == null || src.length <= 0) {
            LOGGER.error("需要加密的数据为空或长度为 0 ! {}", src);
            return null;
        }

        byte[] encryptResult;
        try {
            SecretKeySpec key = getKey();
            Cipher enCipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
            enCipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(iv));
            encryptResult = enCipher.doFinal(src);
        } catch (Exception e) {
            LOGGER.error("encrypt error: {}", e);
            return null;
        }
        LOGGER.info("after encrypt, data: {}", convertUtil.bytesToHexString(encryptResult));
        return encryptResult;
    }

    /**
     * 对加密数据进行解密
     *
     * @param encryptData 加密的数据
     * @return 解密后的数据 字节数组
     */
    @Override
    public byte[] decrypt(byte[] encryptData) {
        LOGGER.info("before decrypt: {}", convertUtil.bytesToHexString(encryptData));
        byte[] decryptBytes;
        try {
            //加密秘钥
            SecretKeySpec key = getKey();
            Cipher deCipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
            deCipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(iv));
            decryptBytes = deCipher.doFinal(encryptData);
        } catch (Exception e) {
            LOGGER.error("decrypt error: {}", e);
            return null;
        }
        LOGGER.info("after decrypt: {}", convertUtil.bytesToHexString(decryptBytes));
        return decryptBytes;
    }

    /**
     * 将加密秘钥字符串转为字节数组
     * @return 返回共享的加密秘钥
     */
    private SecretKeySpec getKey() {
        //
        Security.addProvider(new BouncyCastleProvider());
        try {
            byte[] key = sharedSecretKey.getBytes();
            if (key.length % 16 != 0) {
                int count = key.length / 16 + 1;
                byte[] bytes = new byte[count * 16];
                System.arraycopy(key, 0, bytes, 0, key.length);
                key = bytes;
            }
            KeyGenerator kgen = KeyGenerator.getInstance(algorithm);
            kgen.init(128, new SecureRandom(key));
            return new SecretKeySpec(kgen.generateKey().getEncoded(), algorithm);
        } catch (Exception e) {
            LOGGER.error("get secretKeySpec error: {}", e);
            return null;
        }
    }
}
