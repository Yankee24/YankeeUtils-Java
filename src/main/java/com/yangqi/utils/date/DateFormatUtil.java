package com.yangqi.utils.date;

import com.yangqi.utils.isnull.NullUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The type Date util.
 *
 * @author Yankee
 * @date 2020 /3/13 18:16
 */
public class DateFormatUtil {
    // 时间格式为 yyyyMM
    private static SimpleDateFormat ymFormat1;

    // 时间格式为 yyyy-MM
    private static SimpleDateFormat ymFormat2;

    // 时间格式为 yyyy年MM月
    private static SimpleDateFormat ymFormat3;

    static {
        ymFormat1 = new SimpleDateFormat("yyyyMM");
        ymFormat2 = new SimpleDateFormat("yyyy-MM");
        ymFormat3 = new SimpleDateFormat("yyyy年MM月");
    }

    /**
     * Date parse to your format string.
     *
     * @param date             the date
     * @param simpleDateFormat the simple date format
     * @return the string
     */
    public static String parseToyyyyMM(Date date, SimpleDateFormat simpleDateFormat) {
        if (NullUtil.isNull(date)) {
            return null;
        }
        return simpleDateFormat.format(date);
    }

    /**
     * String parse to your format date.
     *
     * @param date             the date of string
     * @param simpleDateFormat the simple date format
     * @return the date
     */
    public static Date parseToDate(String date, SimpleDateFormat simpleDateFormat) {
        if (NullUtil.isNull(date)) {
            return null;
        }
        try {
            return simpleDateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Date parse to yyyyMM string.
     *
     * @param date the date
     * @return the string
     */
    public static String parseToyyyyMM1(Date date) {
        if (NullUtil.isNull(date)) {
            return null;
        }
        return ymFormat1.format(date);
    }

    /**
     * String parse to yyyyMM date.
     *
     * @param date the date of string
     * @return the date
     */
    public static Date parseToDate1(String date) {
        if (NullUtil.isNull(date)) {
            return null;
        }
        try {
            return ymFormat1.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Date parse to yyyy-MM string.
     *
     * @param date the date
     * @return the string
     */
    public static String parseToyyyyMM2(Date date) {
        if (NullUtil.isNull(date)) {
            return null;
        }
        return ymFormat2.format(date);
    }

    /**
     * String parse to yyyy-MM date.
     *
     * @param date the date of string
     * @return the date
     */
    public static Date parseToDate2(String date) {
        if (NullUtil.isNull(date)) {
            return null;
        }
        try {
            return ymFormat2.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Date parse to yyyy年MM月 string.
     *
     * @param date the date
     * @return the string
     */
    public static String parseToyyyyMM3(Date date) {
        if (NullUtil.isNull(date)) {
            return null;
        }
        return ymFormat3.format(date);
    }

    /**
     * String parse to yyyy年MM月 date.
     *
     * @param date the date of string
     * @return the date
     */
    public static Date parseToDate3(String date) {
        if (NullUtil.isNull(date)) {
            return null;
        }
        try {
            return ymFormat3.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
