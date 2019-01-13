package com.niceapp.utils;

import android.text.TextUtils;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;

import java.lang.reflect.Field;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mateng on 2018/10/31 12:01
 */
public class SignUtils {

    private final static String SECRET = "80a63ab31bdee024";

    /**
     * 生成签名
     *
     * @param object
     * @return
     */
    public static String sign(Object object) {
        String params = getAscOrderStringByJson(new Gson().toJson(object));
        params += SECRET;
        try {
            String sign = Md5.getMD5(params, Md5.BIT_32);
            return sign;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }


//    /**
//     *
//     * */
//    public static String sign(Object object) {
//        String params = getAscOrderString(object);
//        params += SECRET;
//        try {
//            String sign = Md5.getMD5(params, Md5.BIT_32);
//            return sign;
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }


    /**
     * 反射拼接类的属性值
     *
     * @param object
     * @return
     */
    public static String getAscOrderString(Object object) {
        String rawString = "";
        Map<String, Object> map = new HashMap<>();
        Field[] fs = object.getClass().getDeclaredFields();
        Field[] parent = object.getClass().getSuperclass().getDeclaredFields();

        for (int i = 0; i < fs.length + parent.length; i++) {
            Field field = null;
            if (i < fs.length) {
                field = fs[i];
            } else {
                field = parent[i - fs.length];
            }
            field.setAccessible(true);
            String valString;
            try {
                if (field.get(object) == null) {
                    valString = "";
                } else {
                    valString = field.get(object).toString();
                }
                if (!field.getName().equals("shadow$_monitor_") && !field.getName().equals("shadow$_klass_")) {
                    map.put(field.getName(), valString);
                }
            } catch (IllegalArgumentException | IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        Collection<String> keyset = map.keySet();
        List<String> list = new ArrayList<>(keyset);
        Collections.sort(list);
        rawString = appendMap(rawString, map, list);
        return rawString;
    }


    /**
     * 反射拼接类的属性值
     *
     * @param json
     * @return
     */
    public static String getAscOrderStringByJson(String json) {
        String rawString = "";
        JSONObject jsonObject = JSONObject.parseObject(json);
        Map<String, Object> map = new HashMap<>(jsonObject);
        Collection<String> keyset = map.keySet();
        List<String> list = new ArrayList<>(keyset);
        Collections.sort(list);
        rawString = appendMap(rawString, map, list);
        return rawString;

    }

    private static String appendMap(String rawString, Map<String, Object> map, List<String> list) {
        StringBuilder rawStringBuilder = new StringBuilder(rawString);
        for (int i = 0; i < list.size(); i++) {
            if (!TextUtils.isEmpty(map.get(list.get(i)).toString())) {
                rawStringBuilder.append(map.get(list.get(i)));
            }
//            if (i == (list.size() - 1)) {
//                if (!TextUtils.isEmpty(map.get(list.get(i)).toString())) {
//                    rawString += list.get(i) + map.get(list.get(i));
//                }
//            } else {
//                if (!TextUtils.isEmpty(map.get(list.get(i)).toString())) {
//                    rawString += list.get(i) + map.get(list.get(i));
//                }
//            }
        }
        rawString = rawStringBuilder.toString();
        return rawString;
    }

    /**
     * 字符串转换成十六进制字符串
     *
     * @return String 每个Byte之间空格分隔，如: [61 6C 6B]
     */
    public static String str2HexStr(String str) {

        char[] chars = "0123456789ABCDEF".toCharArray();
        StringBuilder sb = new StringBuilder("");
        byte[] bs = str.getBytes();
        int bit;

        for (byte b : bs) {
            bit = (b & 0x0f0) >> 4;
            sb.append(chars[bit]);
            bit = b & 0x0f;
            sb.append(chars[bit]);
        }
        return sb.toString().trim();
    }

    /**
     * 十六进制转换字符串
     *
     * @return String 对应的字符串
     */
    public static String hexStr2Str(String hexStr) {
        String str = "0123456789ABCDEF";
        char[] hexs = hexStr.toCharArray();
        byte[] bytes = new byte[hexStr.length() / 2];
        int n;

        for (int i = 0; i < bytes.length; i++) {
            n = str.indexOf(hexs[2 * i]) * 16;
            n += str.indexOf(hexs[2 * i + 1]);
            bytes[i] = (byte) (n & 0xff);
        }
        return new String(bytes);
    }

    /**
     * bytes转换成十六进制字符串
     *
     * @param b byte数组
     * @return String 每个Byte值之间空格分隔
     */
    public static String byte2HexStr(byte[] b) {
        String stmp = "";
        StringBuilder sb = new StringBuilder("");
        for (byte aB : b) {
            stmp = Integer.toHexString(aB & 0xFF);
            sb.append((stmp.length() == 1) ? "0" + stmp : stmp);
        }
        return sb.toString().toUpperCase().trim();
    }

    /**
     * bytes字符串转换为Byte值
     *
     * @param src Byte字符串，每个Byte之间没有分隔符
     * @return byte[]
     */
    public static byte[] hexStr2Bytes(String src) {
        int m = 0, n = 0;
        int l = src.length() / 2;
        System.out.println(l);
        byte[] ret = new byte[l];
        for (int i = 0; i < l; i++) {
            m = i * 2 + 1;
            n = m + 1;
            ret[i] = Byte.decode("0x" + src.substring(i * 2, m) + src.substring(m, n));
        }
        return ret;
    }

    /**
     * String的字符串转换成unicode的String
     *
     * @param strText 全角字符串
     * @return String 每个unicode之间无分隔符
     * @throws Exception
     */
    public static String strToUnicode(String strText)
            throws Exception {
        char c;
        StringBuilder str = new StringBuilder();
        int intAsc;
        String strHex;
        for (int i = 0; i < strText.length(); i++) {
            c = strText.charAt(i);
            intAsc = (int) c;
            strHex = Integer.toHexString(intAsc);
            if (intAsc > 128)
                str.append("\\u" + strHex);
            else // 低位在前面补00
                str.append("\\u00" + strHex);
        }
        return str.toString();
    }

    /**
     * unicode的String转换成String的字符串
     *
     * @param hex 16进制值字符串 （一个unicode为2byte）
     * @return String 全角字符串
     */
    public static String unicodeToString(String hex) {
        int t = hex.length() / 6;
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < t; i++) {
            String s = hex.substring(i * 6, (i + 1) * 6);
            // 高位需要补上00再转
            String s1 = s.substring(2, 4) + "00";
            // 低位直接转
            String s2 = s.substring(4);
            // 将16进制的string转为int
            int n = Integer.valueOf(s1, 16) + Integer.valueOf(s2, 16);
            // 将int转换为字符
            char[] chars = Character.toChars(n);
            str.append(new String(chars));
        }
        return str.toString();
    }

}
