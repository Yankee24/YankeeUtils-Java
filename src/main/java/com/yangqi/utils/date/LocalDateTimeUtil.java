package com.yangqi.utils.date;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * The type Local date time util.
 *
 * @author Yankee
 * @date 2020 /3/13 19:11
 */
public class LocalDateTimeUtil {
    /**
     * Days between early and late.
     *
     * @param early the early
     * @param late  the late
     * @return the days
     */
    public static long daysBetween(LocalDate early, LocalDate late) {
        return late.toEpochDay() - early.toEpochDay();
    }

    /**
     * Days between early and late.
     *
     * @param early             the early
     * @param late              the late
     * @param dateTimeFormatter the date time formatter
     * @return the days
     */
    public static long daysBetween(String early, String late, DateTimeFormatter dateTimeFormatter) {
        LocalDate earlyDate = LocalDateTimeFormatUtil.parseToLocalDate(early, dateTimeFormatter);
        LocalDate lateDate = LocalDateTimeFormatUtil.parseToLocalDate(late, dateTimeFormatter);
        // 断言测试
        assert earlyDate != null;
        assert lateDate != null;
        return daysBetween(earlyDate, lateDate);
    }

    /**
     * Month between early and late.
     *
     * @param early the early
     * @param late  the late
     * @return the month
     */
    public static long monthBetween(LocalDateTime early, LocalDateTime late) {
        Duration betweenMonths = Duration.between(early, late);
        return betweenMonths.toHours();
    }

    /**
     * Month between early and late.
     *
     * @param early             the early
     * @param late              the late
     * @param dateTimeFormatter the date time formatter
     * @return the month
     */
    public static long monthBetween(String early, String late, DateTimeFormatter dateTimeFormatter) {
        LocalDateTime earlyDate = LocalDateTimeFormatUtil.parseToLocalDateTime(early, dateTimeFormatter);
        LocalDateTime lateDate = LocalDateTimeFormatUtil.parseToLocalDateTime(late, dateTimeFormatter);
        return monthBetween(earlyDate, lateDate);
    }

    /**
     * Minutes between early and late.
     *
     * @param eayly the eayly
     * @param late  the late
     * @return the minutes
     */
    public static long minutesBetween(LocalDateTime eayly, LocalDateTime late) {
        Duration betweenMinutes = Duration.between(eayly, late);
        return betweenMinutes.toMinutes();
    }

    /**
     * Minutes between early and late.
     *
     * @param early             the early
     * @param late              the late
     * @param dateTimeFormatter the date time formatter
     * @return the minutes
     */
    public static long minutesBetween(String early, String late, DateTimeFormatter dateTimeFormatter) {
        LocalDateTime earlyDate = LocalDateTimeFormatUtil.parseToLocalDateTime(early, dateTimeFormatter);
        LocalDateTime lateDate = LocalDateTimeFormatUtil.parseToLocalDateTime(late, dateTimeFormatter);
        return minutesBetween(earlyDate, lateDate);
    }

    /**
     * Millis seconds between early and late.
     *
     * @param eayly the eayly
     * @param late  the late
     * @return the millisSeconds
     */
    public static long millisSecondsBetween(LocalDateTime eayly, LocalDateTime late) {
        Duration betweenMinutes = Duration.between(eayly, late);
        return betweenMinutes.toMillis();
    }

    /**
     * Millis seconds between early and late.
     *
     * @param early             the early
     * @param late              the late
     * @param dateTimeFormatter the date time formatter
     * @return the millisSeconds
     */
    public static long millisSecondsBetween(String early, String late, DateTimeFormatter dateTimeFormatter) {
        LocalDateTime earlyDate = LocalDateTimeFormatUtil.parseToLocalDateTime(early, dateTimeFormatter);
        LocalDateTime lateDate = LocalDateTimeFormatUtil.parseToLocalDateTime(late, dateTimeFormatter);
        return millisSecondsBetween(earlyDate, lateDate);
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        LocalDateTime early = LocalDateTime.of(2017, 9, 1, 0, 0, 0);
        LocalDateTime late = LocalDateTime.of(2017, 10, 2, 0, 0, 0);
        System.out.println(millisSecondsBetween(early, late));
    }
}
