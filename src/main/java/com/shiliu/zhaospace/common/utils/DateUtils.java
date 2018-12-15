package com.shiliu.zhaospace.common.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 日期时间公共类
 *
 * @author chenshiliu
 */
public class DateUtils {
    /**
     * 日期格式
     */
    private final static String COMPACT_DATE_FORMAT = "yyyyMMdd";
    private final static String SHORT_DATE_FORMAT = "yyyy-MM-dd";
    private final static String LONG_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    private final static Integer MONTH = 12;

    /**
     * 日期格式对象
     */
    private static SimpleDateFormat dfCompact = new SimpleDateFormat(COMPACT_DATE_FORMAT);
    private static SimpleDateFormat dfShort = new SimpleDateFormat(SHORT_DATE_FORMAT);
    private static SimpleDateFormat dfLong = new SimpleDateFormat(LONG_DATE_FORMAT);

    private static DateFormat sdfLong = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 获取当前时间
     *
     * @return 当前时间
     */
    public static String nowDate() {
        return dfLong.format(new Date());
    }

    /**
     * 获取当天日期文本，不含时间。 返回格式：yyyy-mm-dd
     *
     * @return 当前日期 yyyy-MM-dd
     */
    public static String getToday() {
        Calendar now = Calendar.getInstance();

        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH) + 1;
        int day = now.get(Calendar.DAY_OF_MONTH);

        return year + "-" + (month < 10 ? "0" + month : month) + "-" + (day < 10 ? "0" + day : day);
    }

    /**
     * 获取当前日期几天前日期
     *
     * @param
     * @return
     * @author chenshiliu
     * @method
     * @date 2018/4/12 11:34
     */
    public static String getDateBefore(Date d, int day) {
        Calendar now = Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.DATE, now.get(Calendar.DATE) - day);
        return dfShort.format(now.getTime());
    }

    /**
     * 获取当前日期几天后日期
     *
     * @param
     * @return
     * @author chenshiliu
     * @method
     * @date 2018/4/12 12:30
     */
    public static String getDateAfter(Date d, int day) {
        Calendar now = Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.DATE, now.get(Calendar.DATE) + day);
        return dfShort.format(now.getTime());
    }

    /**
     * 获取当天的开始时间
     *
     * @date 2018/4/24 14:00
     */
    public static Date getDayBegin() {
        Calendar cal = new GregorianCalendar();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 获取当天的结束时间
     *
     * @date 2018/4/24 14:00
     */
    public static Date getDayEnd() {
        Calendar cal = new GregorianCalendar();
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        return cal.getTime();
    }

    /**
     * 获取昨天的开始时间
     *
     * @date 2018/4/24 14:00
     */
    public static Date getBeginDayOfYesterday() {
        Calendar cal = new GregorianCalendar();
        cal.setTime(getDayBegin());
        cal.add(Calendar.DAY_OF_MONTH, -1);
        return cal.getTime();
    }

    /**
     * 获取昨天的结束时间
     *
     * @date 2018/4/24 14:00
     */
    public static Date getEndDayOfYesterDay() {
        Calendar cal = new GregorianCalendar();
        cal.setTime(getDayEnd());
        cal.add(Calendar.DAY_OF_MONTH, -1);
        return cal.getTime();
    }

    /**
     * 获取明天的开始时间
     *
     * @date 2018/4/24 14:00
     */
    public static Date getBeginDayOfTomorrow() {
        Calendar cal = new GregorianCalendar();
        cal.setTime(getDayBegin());
        cal.add(Calendar.DAY_OF_MONTH, 1);

        return cal.getTime();
    }

    /**
     * 获取明天的结束时间
     *
     * @date 2018/4/24 14:00
     */
    public static Date getEndDayOfTomorrow() {
        Calendar cal = new GregorianCalendar();
        cal.setTime(getDayEnd());
        cal.add(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }


    /**
     * 获取本周的开始时间。以周一为一周的开始
     *
     * @date 2018/4/24 14:00
     */
    public static Date getBeginDayOfWeek() {
        Date date = new Date();

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int dayofweek = cal.get(Calendar.DAY_OF_WEEK);
        if (dayofweek == 1) {
            dayofweek += 7;
        }
        cal.add(Calendar.DATE, 2 - dayofweek);
        return getDayStartTime(cal.getTime());
    }


    /**
     * 获取本周的结束时间。以周一为一周的开始
     *
     * @date 2018/4/24 14:00
     */
    public static Date getEndDayOfWeek() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getBeginDayOfWeek());
        cal.add(Calendar.DAY_OF_WEEK, 6);
        Date weekEndSta = cal.getTime();
        return getDayEndTime(weekEndSta);
    }


    /**
     * 获取指定日期当周的开始时间。以周日为一周的开始
     *
     * @date 2018/4/24 14:00
     */
    public static Date getBeginDayOfWeekWithSundayFirst(Date date) {
        if (date == null) {
            date = new Date();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int dayofweek = cal.get(Calendar.DAY_OF_WEEK);
        if (dayofweek == 0) {
            dayofweek += 7;
        }
        cal.add(Calendar.DATE, 1 - dayofweek);
        return DateUtils.getDayStartTime(cal.getTime());
    }


    /**
     * 获取指定日期当周的结束时间。以周日为一周的开始
     *
     * @date 2018/4/24 14:00
     */
    public static Date getEndDayOfWeekWithSundayFirst(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getBeginDayOfWeekWithSundayFirst(date));
        cal.add(Calendar.DAY_OF_WEEK, 6);
        Date weekEndSta = cal.getTime();
        return DateUtils.getDayEndTime(weekEndSta);
    }


    /**
     * 获取本月的开始时间
     *
     * @date 2018/4/24 14:00
     */
    public static Date getBeginDayOfMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(getNowYear(), getNowMonth() - 1, 1);
        return getDayStartTime(calendar.getTime());
    }


    /**
     * 获取本月的结束时间
     *
     * @date 2018/4/24 14:00
     */
    public static Date getEndDayOfMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(getNowYear(), getNowMonth() - 1, 1);
        int day = calendar.getActualMaximum(5);
        calendar.set(getNowYear(), getNowMonth() - 1, day);
        return getDayEndTime(calendar.getTime());
    }


    /**
     * 获取本年的开始时间
     *
     * @date 2018/4/24 14:00
     */
    public static Date getBeginDayOfYear() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, getNowYear());
        // cal.set
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DATE, 1);

        return getDayStartTime(cal.getTime());
    }


    /**
     * 获取本年的结束时间
     *
     * @date 2018/4/24 14:00
     */
    public static Date getEndDayOfYear() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, getNowYear());
        cal.set(Calendar.MONTH, Calendar.DECEMBER);
        cal.set(Calendar.DATE, 31);
        return getDayEndTime(cal.getTime());
    }


    /**
     * 获取某个日期的开始时间
     *
     * @date 2018/4/24 14:00
     */
    public static Timestamp getDayStartTime(Date d) {
        Calendar calendar = Calendar.getInstance();
        if (null != d) {
            calendar.setTime(d);
        }
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return new Timestamp(calendar.getTimeInMillis());
    }


    /**
     * 获取某个日期的结束时间
     *
     * @date 2018/4/24 14:00
     */
    public static Timestamp getDayEndTime(Date d) {
        Calendar calendar = Calendar.getInstance();
        if (null != d) {
            calendar.setTime(d);
        }
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 23, 59, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return new Timestamp(calendar.getTimeInMillis());
    }


    /**
     * 获取今年是哪一年
     *
     * @date 2018/4/24 14:00
     */
    public static Integer getNowYear() {
        Date date = new Date();
        GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
        gc.setTime(date);
        return Integer.valueOf(gc.get(1));
    }


    /**
     * 获取本月是哪一月
     *
     * @date 2018/4/24 14:00
     */
    public static int getNowMonth() {
        Date date = new Date();
        GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
        gc.setTime(date);
        return gc.get(2) + 1;
    }


    /**
     * 两个日期相减得到的天数
     *
     * @date 2018/4/24 14:00
     */
    public static int getDiffDays(Date beginDate, Date endDate) {

        if (beginDate == null || endDate == null) {
            throw new IllegalArgumentException("getDiffDays param is null!");
        }

        long diff = (endDate.getTime() - beginDate.getTime())
                / (1000 * 60 * 60 * 24);

        return new Long(diff).intValue();
    }


    /**
     * 两个日期相减得到的毫秒数
     *
     * @date 2018/4/24 14:00
     */
    public static long dateDiff(Date beginDate, Date endDate) {
        long date1ms = beginDate.getTime();
        long date2ms = endDate.getTime();
        return date2ms - date1ms;
    }


    /**
     * 获取两个日期中的最大日期
     *
     * @date 2018/4/24 14:00
     */
    public static Date max(Date beginDate, Date endDate) {
        if (beginDate == null) {
            return endDate;
        }
        if (endDate == null) {
            return beginDate;
        }
        if (beginDate.after(endDate)) {
            return beginDate;
        }
        return endDate;
    }


    /**
     * 获取两个日期中的最小日期
     *
     * @date 2018/4/24 14:00
     */
    public static Date min(Date beginDate, Date endDate) {
        if (beginDate == null) {
            return endDate;
        }
        if (endDate == null) {
            return beginDate;
        }
        if (beginDate.after(endDate)) {
            return endDate;
        }
        return beginDate;
    }


    /**
     * 返回某月该季度的第一个月
     *
     * @date 2018/4/24 14:00
     */
    public static Date getFirstSeasonDate(Date date) {
        final int[] SEASON = {1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4};
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int sean = SEASON[cal.get(Calendar.MONTH)];
        cal.set(Calendar.MONTH, sean * 3 - 3);
        return cal.getTime();
    }


    /**
     * 返回某个日期下几天的日期
     *
     * @date 2018/4/24 14:00
     */
    public static Date getNextDay(Date date, int i) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        cal.set(Calendar.DATE, cal.get(Calendar.DATE) + i);
        return cal.getTime();
    }


    /**
     * 返回某个日期前几天的日期
     *
     * @date 2018/4/24 14:00
     */
    public static Date getFrontDay(Date date, int i) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        cal.set(Calendar.DATE, cal.get(Calendar.DATE) - i);
        return cal.getTime();
    }


    /**
     * 获取某年某月到某年某月按天的切片日期集合（间隔天数的日期集合）
     *
     * @date 2018/4/24 14:00
     */
    public static List getTimeList(int beginYear, int beginMonth, int endYear,
                                   int endMonth, int k) {
        List list = new ArrayList();
        if (beginYear == endYear) {
            for (int j = beginMonth; j <= endMonth; j++) {
                list.add(getTimeList(beginYear, j, k));

            }
        } else {
            {
                for (int j = beginMonth; j < MONTH; j++) {
                    list.add(getTimeList(beginYear, j, k));
                }

                for (int i = beginYear + 1; i < endYear; i++) {
                    for (int j = 0; j < MONTH; j++) {
                        list.add(getTimeList(i, j, k));
                    }
                }
                for (int j = 0; j <= endMonth; j++) {
                    list.add(getTimeList(endYear, j, k));
                }
            }
        }
        return list;
    }

    /**
     *  获取某年某月按天切片日期集合（某个月间隔多少天的日期集合）
     *
     * @date  2018/4/24 14:00
     */
    public static List getTimeList(int beginYear, int beginMonth, int k) {
        List list = new ArrayList();
        Calendar begincal = new GregorianCalendar(beginYear, beginMonth, 1);
        int max = begincal.getActualMaximum(Calendar.DATE);
        for (int i = 1; i < max; i = i + k) {
            list.add(begincal.getTime());
            begincal.add(Calendar.DATE, k);
        }
        begincal = new GregorianCalendar(beginYear, beginMonth, max);
        list.add(begincal.getTime());
        return list;
    }

    /**
     * 字符串转换成长日期。若格式不合法，则返回当前日期
     *
     * @param cdate 文本时间
     * @return date 日期时间 "yyyy-MM-dd HH:mm:ss"
     */
    public static Date strToLongDate(String cdate) {
        return strToDate(dfLong, cdate);
    }

    /**
     * 将日期转换为长日期文本时间.格式: yyyy-MM-dd HH:mm:ss
     *
     * @param ddate 时间
     * @return 文本时间  yyyy-MM-dd HH:mm:ss
     */
    public static String dateToLongStr(Date ddate) {
        return dateToStr(dfLong, ddate);
    }


    public static String dateToStr(Timestamp ddate) {
        return dfLong.format(ddate.getTime());
    }

    /**
     * 字符串转换成短日期。若格式不合法，则返回当前日期
     *
     * @param cdate 文本时间
     * @return date 日期时间 ，格式为"yyyy-MM-dd"
     */
    public static Date strToShortDate(String cdate) {
        return strToDate(dfShort, cdate);
    }

    /**
     * 将日期转换为短日期文本时间
     *
     * @param ddate 时间
     * @return 文本时间  yyyy-MM-dd
     */
    public static String dateToShortStr(Date ddate) {
        return dateToStr(dfShort, ddate);
    }

    /**
     * 将日期转换为紧凑日期文本时间
     *
     * @param ddate 时间
     * @return 文本时间  yyyyMMdd
     */
    public static String dateToCompactStr(Date ddate) {
        return dateToStr(dfCompact, ddate);
    }

    /**
     * 字符串转换成日期。若格式不合法，则返回当前日期
     *
     * @param df    时间格式
     * @param cdate 文本时间
     * @return date 日期时间
     */
    private static Date strToDate(SimpleDateFormat df, String cdate) {
        Date date;
        try {
            date = df.parse(cdate);
        } catch (ParseException e) {
            date = df.equals(dfShort) ? getDayBegin() : new Date();
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 将日期转换为日期文本时间
     *
     * @param df    时间格式
     * @param ddate 时间
     * @return 文本时间
     */
    private static String dateToStr(SimpleDateFormat df, Date ddate) {
        if (ddate == null) {
            ddate = new Date();
        }
        return df.format(ddate);
    }

}