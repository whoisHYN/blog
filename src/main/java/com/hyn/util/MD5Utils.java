package com.hyn.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author: HYN
 * @Description:  对前端传来的数据进行MD5后再存放在服务器数据库
 * @Date: 2020/2/8 10:04 上午
 * @Modified By:
 */
public class MD5Utils {

    public static String digest(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte[] byteDigest = md.digest();
            int i;
            StringBuffer sb = new StringBuffer();
            for (byte b : byteDigest) {
                i = b;
                if (i < 0) {
                    i += 256;
                }
                if (i < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i));
            }
            // 32位加密
            return sb.toString();
            // 16位加密
            // return sb.toString().substring(8, 24);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(digest("123456"));
    }
}
