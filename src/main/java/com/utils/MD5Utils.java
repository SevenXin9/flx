package com.utils;

import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * @create 2019/5/5
 */
public class MD5Utils {
    //MD5盐值加密
    public static String MD5(String username, String pwd){
        Object result = new SimpleHash("MD5",pwd,username,1024);
        System.out.println( result.toString());
        return result.toString();
    }

}
