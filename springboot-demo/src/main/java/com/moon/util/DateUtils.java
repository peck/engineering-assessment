package com.moon.util;

import com.moon.constant.Constant;
import com.moon.constant.ExceptionEnum;
import org.springframework.util.Assert;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 描述信息：日期处理工具类
 *
 * @author  moon
 * @version 1.0
 * @date    2023/3/1 17:35
 */
public class DateUtils {

    public static String YYYY = "yyyy";

    public static String YYYY_MM = "yyyy-MM";

    public static String YYYY_MM_DD = "yyyy-MM-dd";

    public static String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    public static String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    private static String[] parsePatterns = {
            "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM",
            "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM",
            "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM"
    };


    /**
     * 获取当前LocalTime型 时间
     *
     * @return LocalTime 当前时间
     */
    public static LocalTime getNowTime() {
        return LocalTime.now();
    }


    /**
     * 获取当前LocalDate型日期
     *
     * yyyy-MM-dd
     * @return LocalDate 当前日期
     */
    public static LocalDate getNowDate() {
        return LocalDate.now();
    }


    /**
     * 获取当前LocalDateTime型日期时间
     *
     * @return LocalDateTime 当前日期时间
     */
    public static LocalDateTime getNowDateTime() {
        return LocalDateTime.now();
    }


    /**
     * 获取指定日期的毫秒/日期转换为long类型时间戳
     *
     * @param localDateTime 输入日期
     * @return 毫秒 13位时间戳
     */
    public static Long getMillis(LocalDateTime localDateTime) {
        return localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }


    /**
     * 获取指定日期的指定格式
     *
     * @param localDateTime 指定日期
     * @param pattern 格式
     * @return String型日期
     */
    public static String formatTime(LocalDateTime localDateTime,String pattern) {
        return localDateTime.format(DateTimeFormatter.ofPattern(pattern));
    }


    /**
     * 指定日期转换为String类型时间
     *
     * @param localDateTime 输入日期
     * @param pattern 输出日期的时间格式
     * @return String
     */
    public static String localDateTimeToString(LocalDateTime localDateTime, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return localDateTime.format(formatter);
    }


    /**
     * String类型时间转换为 LocalDateTime 日期
     *
     * @param stringTime 输入日期
     * @param pattern 输入日期的时间格式
     * @return String
     */
    public static LocalDateTime stringToLocalDateTime(String stringTime, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDateTime.parse(stringTime, formatter);
    }


    /**
     * String类型时间转换为 LocalDate 日期
     *
     * @param stringTime 输入日期
     * @param pattern 输入日期的时间格式
     * @return String
     */
    public static LocalDate stringToLocalDate(String stringTime, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDate.parse(stringTime, formatter);
    }


    /**
     * String类型时间转换为 LocalTime 日期
     *
     * @param stringTime 输入日期
     * @param pattern 输入日期的时间格式
     * @return String
     */
    public static LocalTime stringToLocalTime(String stringTime, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return LocalTime.parse(stringTime, formatter);
    }


    /**
     * Date转换为 LocalDateTime
     *
     * @param date 输入Date日期
     * @return LocalDateTime日期
     */
    public static LocalDateTime dateToLocalDateTime(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }


    /**
     * LocalDateTime 转换为 Date
     *
     * @param localDateTime 输入LocalDateTime日期
     * @return 输出Date日期
     */
    public static Date localDateTimeToDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }


    /**
     * 获取两个日期的差  field参数为ChronoUnit.
     *
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @param field  单位(年月日时分秒) ChronoUnit.HOURS  ChronoUnit.DAYS 枚举
     * @return
     */
    public static long betweenTwoTime(LocalDateTime startTime, LocalDateTime endTime, ChronoUnit field) {
        Period period = Period.between(LocalDate.from(startTime), LocalDate.from(endTime));

        if (field == ChronoUnit.YEARS) {
            return period.getYears();
        }
        if (field == ChronoUnit.MONTHS) {
            return period.getYears() * 12 + period.getMonths();
        }
        return field.between(startTime, endTime);
    }


    /**
     * 日 开始时间、结束时间
     *
     * @param localDateTime 输入日期
     * @return todayTime
     */
    public static Map dayTime(LocalDateTime localDateTime) {
        Map todayTime = new HashMap<String, LocalDateTime>();
        todayTime.put("beginTime", localDateTime.with(LocalTime.MIN));
        todayTime.put("endTime", localDateTime.with(LocalTime.MAX));
        return todayTime;
    }


    /**
     * 周 开始时间、结束时间
     *
     * @param localDateTime 输入日期
     * @return weekTime
     */
    public static Map weekTime(LocalDateTime localDateTime) {
        Map weekTime = new HashMap<String, LocalDateTime>();
        int dayOfWeek = localDateTime.getDayOfWeek().getValue();
        LocalDateTime weekStart = localDateTime.minusDays(dayOfWeek - 1).with(LocalTime.MIN);
        LocalDateTime weekEnd = localDateTime.plusDays(7 - dayOfWeek).with(LocalTime.MAX);
        weekTime.put("beginTime", weekStart);
        weekTime.put("endTime", weekEnd);
        return weekTime;
    }


    /**
     * 月 开始时间、结束时间
     *
     * @param localDateTime 输入日期
     * @return monthTime
     */
    public static Map monthTime(LocalDateTime localDateTime) {
        Map monthTime = new HashMap<String, LocalDateTime>();
        LocalDateTime monthStart = localDateTime.with(TemporalAdjusters.firstDayOfMonth()).with(LocalTime.MIN);
        LocalDateTime monthEnd = localDateTime.with(TemporalAdjusters.lastDayOfMonth()).with(LocalTime.MAX);
        monthTime.put("beginTime", monthStart);
        monthTime.put("endTime", monthEnd);
        return monthTime;
    }


    /**
     * 季 开始时间、结束时间
     *
     * @param localDateTime 输入日期
     * @return seasonTime
     */
    public static Map seasonTime(LocalDateTime localDateTime) {
        Map seasonTime = new HashMap<String, LocalDateTime>();
        LocalDate seasonStartDate = LocalDate.of(localDateTime.getYear(), localDateTime.getMonth().firstMonthOfQuarter(), 1);
        LocalDate seasonEndDate = LocalDate.of(localDateTime.getYear(), localDateTime.getMonth().firstMonthOfQuarter().plus(2), localDateTime.getMonth().firstMonthOfQuarter().plus(2).maxLength());
        LocalDateTime seasonStart = LocalDateTime.of(seasonStartDate, LocalTime.MIN);
        LocalDateTime seasonEnd = LocalDateTime.of(seasonEndDate, LocalTime.MAX);
        seasonTime.put("beginTime", seasonStart);
        seasonTime.put("endTime", seasonEnd);
        return seasonTime;
    }


    /**
     * 年 开始时间、结束时间
     *
     * @param localDateTime 输入日期
     * @return yearTime
     */
    public static Map yearTime(LocalDateTime localDateTime) {
        Map yearTime = new HashMap<String, LocalDateTime>();
        LocalDateTime yearStart = localDateTime.with(TemporalAdjusters.firstDayOfYear()).with(LocalTime.MIN);
        LocalDateTime yearEnd = localDateTime.with(TemporalAdjusters.lastDayOfYear()).with(LocalTime.MAX);
        yearTime.put("beginTime", yearStart);
        yearTime.put("endTime", yearEnd);
        return yearTime;
    }


    /**
     * 获取标准的时间格式
     *
     * 支持输入的字符串格式有：yyyyMMdd、yyyy-MM-dd、yyyy/MM/dd、yyyy-MM-dd HH:mm:ss、yyyy/MM/dd HH:mm:ss
     *
     * @param dateString
     */
    public static String getStandardDateFormat(String dateString) {

        if (dateString.length() == Constant.Digital.EIGHT) {  // 时间格式为： yyyyMMdd

            dateString = dateString + Constant.DatePattern.BLANK_START_TIME;  // 返回的时间格式：yyyyMMdd HH:mm:ss

        } else if (dateString.length() == Constant.Digital.TEN) {  // 时间格式为： yyyy-MM-dd 或 yyyy/MM/dd

            dateString = dateString + Constant.DatePattern.BLANK_START_TIME;  // 返回的时间格式：yyyy-MM-dd HH:mm:ss 或 yyyy/MM/dd HH:mm:ss

        } else if (dateString.length() == Constant.Digital.NINETEEN) {  // 时间格式为：yyyy-MM-dd HH:mm:ss 或 yyyy/MM/dd HH:mm:ss

            return dateString;

        } else {
            return dateString;  // 错误的时间格式
        }

        return dateString;  // 正确的时间格式
    }


    /**
     * 将字符串转换成正确的 LocalDateTime ，并返回 Map 集合.
     *
     * @param dateString
     * @return
     */
    public static Map<Boolean, LocalDateTime> exchangeDateStringFormat(String dateString) {

        Map<Boolean, LocalDateTime> map = new HashMap<>();
        map.put(Constant.BooleanFlag.FALSE, null);
        LocalDateTime dateTime = null;

        try {
            // 时间格式：yyyy-MM-dd HH:mm:ss
            dateTime = LocalDateTime.parse(dateString, DateTimeFormatter.ofPattern(Constant.DatePattern.NORM_DATETIME_PATTERN));
        } catch (Exception e2) {
            try {
                // 时间格式：yyyy/MM/dd HH:mm:ss
                dateTime = LocalDateTime.parse(dateString, DateTimeFormatter.ofPattern(Constant.DatePattern.SLASH_NORM_DATETIME_PATTERN));
            } catch (Exception e3) {
                try {
                    // 时间格式：yyyyMMdd HH:mm:ss
                    dateTime = LocalDateTime.parse(dateString, DateTimeFormatter.ofPattern(Constant.DatePattern.BLANK_PURE_DATETIME_PATTERN));
                } catch (Exception e4) {
                    // 格式转换失败
                    return map;
                }
            }
        }

        map.put(Constant.BooleanFlag.TRUE, dateTime);
        return map;
    }


    /**
     * 校验时间字符串格式，并返回结果信息.
     *
     * 支持的格式有：yyyyMMdd、yyyy-MM-dd、yyyy/MM/dd、yyyy-MM-dd HH:mm:ss、yyyy/MM/dd HH:mm:ss
     *
     * @param dateString
     * @param errorMsg
     */
    public static String checkDateFormat(String dateString, String errorMsg) {

        String result = "";
        Map<Boolean, LocalDateTime> map = new HashMap<>();

        // 获取标准的时间格式；
        dateString = getStandardDateFormat(dateString);

        // 将字符串转换成正确的 LocalDateTime ，并返回 Map 集合.
        map = exchangeDateStringFormat(dateString);

        if (map.containsKey(Constant.BooleanFlag.TRUE)) {
            return result;
        } else {
            return errorMsg;
        }
    }


    /**
     * 校验时间字符串格式
     *
     * 支持的格式有：yyyyMMdd、yyyy-MM-dd、yyyy/MM/dd、yyyy-MM-dd HH:mm:ss、yyyy/MM/dd HH:mm:ss
     *
     * @param dateString
     */
    public static void checkDateFormat(String dateString) {

        Map<Boolean, LocalDateTime> map = new HashMap<>();

        // 获取标准的时间格式；
        dateString = getStandardDateFormat(dateString);
        Assert.isTrue(dateString.length() != Constant.Digital.SEVENTEEN && dateString.length() != Constant.Digital.NINETEEN, ExceptionEnum.Exception_10000.getDesc());

        // 将字符串转换成正确的 LocalDateTime ，并返回 Map 集合.
        map = exchangeDateStringFormat(dateString);
        Assert.isTrue(!map.containsKey(Constant.BooleanFlag.TRUE), ExceptionEnum.Exception_10000.getDesc());
    }


    /**
     * 把时间字符串 转成 LocalDateTime .
     *
     * 支持的格式有：yyyyMMdd、yyyy-MM-dd、yyyy/MM/dd、yyyy-MM-dd HH:mm:ss、yyyy/MM/dd HH:mm:ss
     *
     * @param dateString
     */
    public static LocalDateTime getLocalDateTimeByString(String dateString) {

        Map<Boolean, LocalDateTime> map = new HashMap<>();

        // 获取标准的时间格式；
        dateString = getStandardDateFormat(dateString);
        Assert.isTrue(dateString.length() != Constant.Digital.SEVENTEEN && dateString.length() != Constant.Digital.NINETEEN, ExceptionEnum.Exception_10000.getDesc());

        // 将字符串转换成正确的 LocalDateTime ，并返回 Map 集合.
        map = exchangeDateStringFormat(dateString);
        Assert.isTrue(!map.containsKey(Constant.BooleanFlag.TRUE), ExceptionEnum.Exception_10000.getDesc());

        LocalDateTime date = map.get(Constant.BooleanFlag.TRUE);

        return date;
    }


}
