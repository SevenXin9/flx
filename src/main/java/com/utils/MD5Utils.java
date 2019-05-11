package com.utils;
import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * @create 2019/5/5
 */
public class MD5Utils {
    //MD5加密
    public static String MD5(String username, String pwd){
        Object result = new SimpleHash("MD5",pwd,username,1024);
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(MD5Utils.MD5("lin","123"));
    }
}
