package test.dao;

import com.jump.account.base.security.impl.SecurityImplByAES128;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by zhangp on 2017/6/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class Junit4BaseTest {

    @Autowired
    private SecurityImplByAES128 securityImplByAES128;

    @Test
    public void bytesToHex() {
        byte[] bytes = "hello".getBytes();
        System.out.println("bytes: " + Arrays.toString(bytes));

        for (int i = 0; i < bytes.length; i++) {
            int v = bytes[i] & 0xFF;
            System.out.println("v: " + v);
            System.out.println("bytes[" + i + "]: " + bytes[i]);
            String binary = Integer.toBinaryString(bytes[i]);
            System.out.println("binary: " + binary);
            String hex = Integer.toHexString(bytes[i]);
            System.out.println("hex: " + hex);
        }

        if (bytes.length < 16) {
            byte[] bytes16 = new byte[16];
            System.arraycopy(bytes, 0, bytes16, 0, bytes.length);
            System.out.println("bytes16: " + Arrays.toString(bytes16));
        }
    }

    @Test
    public void testAES() {
        String s = "12fdasf";
//        System.out.println(securityImplByAES128.encrypt(s.getBytes()));
    }

    @Test
    public void testTime() {

        long targetTime = 1498030207991L;
        long currentTime = System.currentTimeMillis();


        long time = currentTime - targetTime;
        int second = (int) (time / 1000);
        int minute = second / 60;
        int hour = second / 3600;

        int day = (int) (time / (1000 * 60 * 60 * 24));


        System.out.println("currentTime(ms): " + currentTime);
        System.out.println("当前时间: " + new Date());
        System.out.println("时间相差: " + hour + " h " + minute + " min " + second + " s");

    }
}
