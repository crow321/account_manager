package com.jump.account.base.util;

import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

/**
 * Created by zhangp on 2017/6/23.
 */
@Component
public class ConvertUtil {

    public String bytesToHexString(byte[] bytes) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (bytes == null || bytes.length <= 0) {
            return null;
        }

        for (int i = 0; i < bytes.length; i++) {
            int v = bytes[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() != 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString().toUpperCase();
    }

    /**
     * 十六进制字符串转换为字节数组
     *
     * @param hex 十六进制字符串
     * @return 字节数组
     */
    public byte[] HexStringToBytes(String hex) {
        if (hex == null || hex.equals("")) {
            return null;
        }
        hex = hex.toUpperCase();
        char[] hexChars = hex.toCharArray();
        byte[] bytes = new byte[hex.length()];
        for (int i = 0; i < hexChars.length; i++) {
            int pos = i * 2;
            bytes[i] = (byte) (charToByte(pos) << 4 | charToByte(pos + 1));
        }
        return bytes;
    }

    private byte charToByte(int index) {
        return (byte) "0123456789ABCDEF".indexOf(index);
    }

    public byte[] stringToBytes16(String data) {
        if (data == null || data.equals("")) {
            return null;
        }

        try {
            byte[] dataBytes = data.getBytes("utf-8");
            byte[] bytes = new byte[16];
            System.arraycopy(dataBytes, 0, bytes, 0, dataBytes.length);
            return bytes;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }


    }
}
