package com.niceapp.utils;

public class ByteToIntUtil {

    public static int byteArrayToInt(byte[] b) {
        return b[3] & 0xFF |
                (b[2] & 0xFF) << 8 |
                (b[1] & 0xFF) << 16 |
                (b[0] & 0xFF) << 24;
    }

    public static byte[] intToByteArray(int a) {
        return new byte[]{
                (byte) ((a >> 24) & 0xFF),
                (byte) ((a >> 16) & 0xFF),
                (byte) ((a >> 8) & 0xFF),
                (byte) (a & 0xFF)
        };
    }

    /**
     * 用一个长度为4的数组表示一个整数
     * 因为java中一个int类型占4个字节即八位，而一个byte类型占1个字节
     * 所以如果用byte表示一个整数的话，需要一个长度为4的byte数组。
     * 注意这里要用无符号右移
     *
     * @param bytes
     * @param temp
     */
    public static void putInt(byte[] bytes, int temp) {
        bytes[0] = (byte) (temp >>> 24);//bytes[0]表示一个int值的最高8位
        bytes[1] = (byte) (temp >>> 16);//bytes[1]表示一个int值的接下来的8位
        bytes[2] = (byte) (temp >>> 8);//bytes[2]表示一个int值的再接下来的8位
        bytes[3] = (byte) (temp);      //bytes[3]表示一个int值的最低8位
    }

    /**
     * 把一个长度为4的byte数组还原为整数
     * 注意这里一定要明确的区分开来一个int值的四个字节。
     * 每个字节之间一定要用括号()括起来
     *
     * @param bytes
     * @return
     */
    public static int getInt(byte[] bytes) {
        return (bytes[0] << 24) | //还原int值最高8位
                ((bytes[1] & 0xff) << 16) | //还原int值接下来的8位
                ((bytes[2] & 0xff) << 8) |//还原int值再接下来的8位
                (bytes[3] & 0xff);         //还原int值的最低8位
    }

}
