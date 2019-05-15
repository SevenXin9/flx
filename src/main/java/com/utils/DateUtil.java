package com.utils;


import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {


    //日期转字符串
    public static String dateToString(Date date, String dateFormat) throws Exception {
        if (date==null) return "";
        SimpleDateFormat format = new SimpleDateFormat(dateFormat);
        return format.format(date);
    }

    //字符串转换日期
    public static Date strToDate(String str, String dateFormat) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat(dateFormat);
        return format.parse(str);
    }
}
