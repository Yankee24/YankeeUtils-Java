package com.yangqi.utils.date;

import com.yangqi.utils.isnull.NullUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * The type Date util.
 *
 * @author Yankee
 * @date 2020 /3/13 17:26
 */
public class LocalDateTimeFormatUtil {
    // 时间格式为 yyyyMMddHHmmss
    private static DateTimeFormatter ymdhmsFormat1;

    // 时间格式为 yyyyMMdd HH:mm:ss
    private static DateTimeFormatter ymdhmsFormat2;

    // 时间格式为 yyyy-MM-dd HH:mm:ss
    private static DateTimeFormatter ymdhmsFormat3;

    // 时间格式为 yyyy年MM月dd日 HH时mm分ss秒
    private static DateTimeFormatter ymdhmsFormat4;

    // 时间格式为 yyyyMMdd
    private static DateTimeFormatter ymdFormat1;

    // 时间格式为 yyyy-MM-dd
    private static DateTimeFormatter ymdFormat2;

    // 时间格式为 yyyy年MM月dd日
    private static DateTimeFormatter ymdFormat3;

    // 时间格式为 HHmmss
    private static DateTimeFormatter hmsFormat1;

    // 时间格式为 HH:mm:ss
    private static DateTimeFormatter hmsFormat2;

    // 时间格式为 HH时mm分ss秒
    private static DateTimeFormatter hmsFormat3;

    static {
        ymdhmsFormat1 = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        ymdhmsFormat2 = DateTimeFormatter.ofPattern("yyyyyMMdd HH:mm:ss");
        ymdhmsFormat3 = DateTimeFormatter.ofPattern("yyyyy-MM-dd HH:mm:ss");
        ymdhmsFormat4 = DateTimeFormatter.ofPattern("yyyyy年MM月dd日 HH时mm分ss秒");
        ymdFormat1 = DateTimeFormatter.ofPattern("yyyyMMdd");
        ymdFormat2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        ymdFormat3 = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
        hmsFormat1 = DateTimeFormatter.ofPattern("HHmmss");
        hmsFormat2 = DateTimeFormatter.ofPattern("HH:mm:ss");
        hmsFormat3 = DateTimeFormatter.ofPattern("HH时mm分ss秒");
    }

    /**
     * LocalDateTime parse to your format string.
     *
     * @param localDateTime     the local date time
     * @param dateTimeFormatter the date time formatter
     * @return the string
     */
    public static String parseToyyyyMMddHHmmss(LocalDateTime localDateTime, DateTimeFormatter dateTimeFormatter) {
        if (NullUtil.isNull(localDateTime)) {
            return null;
        }
        return localDateTime.format(dateTimeFormatter);
    }

    /**
     * String parse to your format local date time.
     *
     * @param localDateTime     the local date time
     * @param dateTimeFormatter the date time formatter
     * @return the local date time
     */
    public static LocalDateTime parseToLocalDateTime(String localDateTime, DateTimeFormatter dateTimeFormatter) {
        if (NullUtil.isNull(localDateTime)) {
            return null;
        }
        return LocalDateTime.parse(localDateTime, dateTimeFormatter);
    }

    /**
     * LocalDateTime parse to yyyyMMddHHmmss string.
     *
     * @param localDateTime the local date time
     * @return the string
     */
    public static String parseToyyyyMMddHHmmss1(LocalDateTime localDateTime) {
        if (NullUtil.isNull(localDateTime)) {
            return null;
        }
        return localDateTime.format(ymdhmsFormat1);
    }

    /**
     * String parse to yyyyMMddHHmmss local date time.
     *
     * @param localDateTime the string
     * @return the local date time
     */
    public static LocalDateTime parseToLocalDateTime1(String localDateTime) {
        if (NullUtil.isNull(localDateTime)) {
            return null;
        }
        return LocalDateTime.parse(localDateTime, ymdhmsFormat1);
    }

    /**
     * LocalDateTime parse to yyyyMMdd HH:mm:ss string.
     *
     * @param localDateTime the local date time
     * @return the string
     */
    public static String parseToyyyyMMddHHmmss2(LocalDateTime localDateTime) {
        if (NullUtil.isNull(localDateTime)) {
            return null;
        }
        return localDateTime.format(ymdhmsFormat2);
    }

    /**
     * String parse to yyyyMMdd HH:mm:ss local date time.
     *
     * @param localDateTime the string
     * @return the local date time
     */
    public static LocalDateTime parseToLocalDateTime2(String localDateTime) {
        if (NullUtil.isNull(localDateTime)) {
            return null;
        }
        return LocalDateTime.parse(localDateTime, ymdhmsFormat2);
    }

    /**
     * LocalDateTime parse to yyyyy-MM-dd HH:mm:ss string.
     *
     * @param localDateTime the local date time
     * @return the string
     */
    public static String parseToyyyyMMddHHmmss3(LocalDateTime localDateTime) {
        if (NullUtil.isNull(localDateTime)) {
            return null;
        }
        return localDateTime.format(ymdhmsFormat3);
    }

    /**
     * String parse to yyyyy-MM-dd HH:mm:ss local date time.
     *
     * @param localDateTime the string
     * @return the local date time
     */
    public static LocalDateTime parseToLocalDateTime3(String localDateTime) {
        if (NullUtil.isNull(localDateTime)) {
            return null;
        }
        return LocalDateTime.parse(localDateTime, ymdhmsFormat3);
    }

    /**
     * LocalDateTime parse to yyyyy年MM月dd日 HH时mm分ss秒 string.
     *
     * @param localDateTime the local date time
     * @return the string
     */
    public static String parseToyyyyMMddHHmmss4(LocalDateTime localDateTime) {
        if (NullUtil.isNull(localDateTime)) {
            return null;
        }
        return localDateTime.format(ymdhmsFormat4);
    }

    /**
     * String parse to yyyyy年MM月dd日 HH时mm分ss秒 local date time.
     *
     * @param localDateTime the string
     * @return the local date time
     */
    public static LocalDateTime parseToLocalDateTime4(String localDateTime) {
        if (NullUtil.isNull(localDateTime)) {
            return null;
        }
        return LocalDateTime.parse(localDateTime, ymdhmsFormat4);
    }

    /**
     * LocalDate parse to your format string.
     *
     * @param localDate         the local date
     * @param dateTimeFormatter the date time formatter
     * @return the string
     */
    public static String parseToyyyyMMdd(LocalDate localDate, DateTimeFormatter dateTimeFormatter) {
        if (NullUtil.isNull(localDate)) {
            return null;
        }
        return localDate.format(dateTimeFormatter);
    }

    /**
     * String parse to your format local date.
     *
     * @param localDate         the local date time
     * @param dateTimeFormatter the date time formatter
     * @return the local date time
     */
    public static LocalDate parseToLocalDate(String localDate, DateTimeFormatter dateTimeFormatter) {
        if (NullUtil.isNull(localDate)) {
            return null;
        }
        return LocalDate.parse(localDate, dateTimeFormatter);
    }

    /**
     * LocalDate parse to yyyyMMdd string.
     *
     * @param localDate the local date
     * @return the string
     */
    public static String parseToyyyyMMdd1(LocalDate localDate) {
        if (NullUtil.isNull(localDate)) {
            return null;
        }
        return localDate.format(ymdFormat1);
    }

    /**
     * String parse to yyyyMMdd local date.
     *
     * @param localDate the string
     * @return the local date
     */
    public static LocalDate parseToLocalDate1(String localDate) {
        if (NullUtil.isNull(localDate)) {
            return null;
        }
        return LocalDate.parse(localDate, ymdFormat1);
    }

    /**
     * LocalDate parse to yyyy-MM-dd string.
     *
     * @param localDate the local date
     * @return the string
     */
    public static String parseToyyyyMMdd2(LocalDate localDate) {
        if (NullUtil.isNull(localDate)) {
            return null;
        }
        return localDate.format(ymdFormat2);
    }

    /**
     * String parse to yyyy-MM-dd local date.
     *
     * @param localDate the string
     * @return the local date
     */
    public static LocalDate parseToLocalDate2(String localDate) {
        if (NullUtil.isNull(localDate)) {
            return null;
        }
        return LocalDate.parse(localDate, ymdFormat2);
    }

    /**
     * LocalDate parse to yyyy年MM月dd日 string.
     *
     * @param localDate the local date
     * @return the string
     */
    public static String parseToyyyyMMdd3(LocalDateTime localDate) {
        if (NullUtil.isNull(localDate)) {
            return null;
        }
        return localDate.format(ymdFormat3);
    }

    /**
     * String parse to yyyy年MM月dd日 local date.
     *
     * @param localDate the string
     * @return the local date
     */
    public static LocalDate parseToLocalDate3(String localDate) {
        if (NullUtil.isNull(localDate)) {
            return null;
        }
        return LocalDate.parse(localDate, ymdFormat3);
    }

    /**
     * LocalTime parse to your format string.
     *
     * @param localTime         the local time
     * @param dateTimeFormatter the date time formatter
     * @return the string
     */
    public static String parseToHHmmss(LocalDateTime localTime, DateTimeFormatter dateTimeFormatter) {
        if (NullUtil.isNull(localTime)) {
            return null;
        }
        return localTime.format(dateTimeFormatter);
    }

    /**
     * String parse to your format local time.
     *
     * @param localTime         the local date time
     * @param dateTimeFormatter the date time formatter
     * @return the local date time
     */
    public static LocalTime parseToLocalTime(String localTime, DateTimeFormatter dateTimeFormatter) {
        if (NullUtil.isNull(localTime)) {
            return null;
        }
        return LocalTime.parse(localTime, dateTimeFormatter);
    }

    /**
     * LocalDate parse to HHmmss string.
     *
     * @param localTime the local time
     * @return the string
     */
    public static String parseToHHmmss1(LocalTime localTime) {
        if (NullUtil.isNull(localTime)) {
            return null;
        }
        return localTime.format(hmsFormat1);
    }

    /**
     * String parse to yyyyMMddHHmmss local time.
     *
     * @param localTime the string
     * @return the localtime
     */
    public static LocalTime parseToLocalTime1(String localTime) {
        if (NullUtil.isNull(localTime)) {
            return null;
        }
        return LocalTime.parse(localTime, hmsFormat1);
    }

    /**
     * LocalTime parse to HH:mm:ss string.
     *
     * @param localTime the local time
     * @return the string
     */
    public static String parseToHHmmss2(LocalTime localTime) {
        if (NullUtil.isNull(localTime)) {
            return null;
        }
        return localTime.format(hmsFormat2);
    }

    /**
     * String parse to HH:mm:ss local time.
     *
     * @param localTime the string
     * @return the local time
     */
    public static LocalTime parseToLocalTime2(String localTime) {
        if (NullUtil.isNull(localTime)) {
            return null;
        }
        return LocalTime.parse(localTime, hmsFormat2);
    }

    /**
     * LocalTime parse to HH时mm分ss秒 string.
     *
     * @param localTime the local time
     * @return the string
     */
    public static String parseToHHmmss3(LocalTime localTime) {
        if (NullUtil.isNull(localTime)) {
            return null;
        }
        return localTime.format(hmsFormat3);
    }

    /**
     * String parse to HH时mm分ss秒 local time.
     *
     * @param localTime the string
     * @return the local time
     */
    public static LocalTime parseToLocalTime3(String localTime) {
        if (NullUtil.isNull(localTime)) {
            return null;
        }
        return LocalTime.parse(localTime, hmsFormat3);
    }
}
