package com.niceapp.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5 {

    public static final int BIT_32 = 32;
    public static final int BIT_16 = 16;

    public static String getMD5(String val, int bit) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(val.getBytes());
        byte[] m = md5.digest();//加密
        return getString(m, bit);
    }

    private static String getString(byte[] b, int bit) {
        StringBuilder buf = new StringBuilder();
        for (byte aB : b) {
            int a = aB;
            if (a < 0)
                a += 256;
            if (a < 16)
                buf.append("0");
            buf.append(Integer.toHexString(a));

        }
        if (bit == BIT_32) {
            return buf.toString();  //32位
        } else {
            return buf.toString().substring(8, 24);   //16位
        }
    }
}
