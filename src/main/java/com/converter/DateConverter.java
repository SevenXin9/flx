package com.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Create 2019/4/22
 * 时间转换器
 */

@Component
public class DateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String s) {
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            date = sdf.parse(s);
        }catch (Exception e){
            e.printStackTrace();
        }

        return date;
    }
}
