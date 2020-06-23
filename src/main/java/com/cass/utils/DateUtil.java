package com.cass.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: Xin Wang
 * @Date 2020/6/22 17:07
 */
public class DateUtil {

    public static String getcurrentYMD(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(new Date());
    }

    public static void main(String[] args) {
        System.out.println(getcurrentYMD());
    }
}
