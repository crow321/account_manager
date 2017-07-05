package com.jump.account.base.util;

import com.google.protobuf.InvalidProtocolBufferException;
import com.jump.account.base.protobuf.AccountOuterClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.nio.ByteBuffer;

/**
 * Created by zhangp on 2017/7/5.
 */
@Component
public class ProtoBufUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProtoBufUtil.class);

    public AccountOuterClass.AccountMessage parseByteBufferToAccountMessage(ByteBuffer byteBuffer) {
       /* byte[] tempBytes = new byte[byteBuffer.limit()];
        System.arraycopy(byteBuffer.array(), 0, tempBytes, 0, byteBuffer.limit());*/
        byte[] tempBytes = byteBuffer.array();
        try {
            AccountOuterClass.AccountMessage message = AccountOuterClass.AccountMessage.parseFrom(tempBytes);
            return message;
        } catch (InvalidProtocolBufferException e) {
            LOGGER.error("parse error, {}", e);
            return null;
        }
    }
}
