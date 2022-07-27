package com.example.demoanalytic;



        import java.text.ParseException;
        import java.text.SimpleDateFormat;
        import java.util.Calendar;
        import java.util.Date;
        import java.util.TimeZone;

/**
 * @author caibou
 */
public class DateUtil {

    public static final String FULL = "yyyy-MM-dd HH:mm:ss";
    public static final String SIMPLE = "MM-dd HH:mm";
    public static final String MONTH_DAY = "MM.dd";
    public static final String DATE = "MM-dd";
    public static final String TIME = "HH:mm";
    public static final String TIME3 = "HH:mm";
    public static final String TIME2 = "HH小时mm分钟";
    public static final String TIME4 = "HH:mm:ss";
    public static final String TIME5 = "HH小时mm分钟ss秒";
    public static final String TIME6 = "HH";
    public static final String TIME7 = "mm:ss";
    public static final String LIMIT_DATE = "yyyy-MM-dd";
    public static final String FULL_DATE_HOUR = "MM-dd HH:mm";
    public static final String YEAR_MONTH = "yyyy年MM月";
    public static final String YEAR_MONTH_DAY = "yyyy年MM月dd日";
    public static final String TIME_SS = "mm:ss";
    public static final String LIMIT_TIME = "yyyy-MM-dd HH:mm";
    public static final String TIME_DOT = "HH.mm";
    private final static SimpleDateFormat SDF = new SimpleDateFormat();
    public static final String FULL2 = "yy-MM-dd HH:mm:ss";
    private final static Date D = new Date();

    static {
        SDF.setTimeZone(TimeZone.getTimeZone("GMT+08"));
    }


    public static String covert(String src, String srcFormat, String dstFormat) {
        try {
            SDF.applyPattern(srcFormat);
            Date date = SDF.parse(src);
            SDF.applyPattern(dstFormat);
            return SDF.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return src;
    }

    public static String covertFullTime(String src, String dstFormat) {
        return covert(src, FULL, dstFormat);
    }

    public static String covertToSimple(String src) {
        return covert(src, FULL, SIMPLE);
    }

    public static String covertToDATE(String src) {
        return covert(src, FULL, DATE);
    }

    public static String covertToTIME(String src) {
        return covert(src, FULL, TIME);
    }

    /*转换成ms*/
    public static long covertToMill(String src, String srcFormat) {
        try {
            SDF.applyPattern(srcFormat);
            Date date = SDF.parse(src);
            return date.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 时间戳转换成具体时间格式
     *
     * @param time
     * @param srcFormat
     */
    public static String covert(long time, String srcFormat) {
        SDF.applyPattern(srcFormat);
        D.setTime(time);
        return SDF.format(D);
    }

    /**
     * 将Unix时间戳转成指定的时间格式字符串
     *
     * @param mill      unix时间戳
     * @param dstFormat 指定输出格式
     * @return 转换后的时间字符串
     */
    public static String covertUnix(long mill, String dstFormat) {
        SDF.applyPattern(dstFormat);
        D.setTime(mill * 1000);
        return SDF.format(D);
    }

    /**
     * 获取前n天日期、后n天日期
     *
     * @param distanceDay 前几天 如获取前7天日期则传-7即可；如果后7天则传7
     * @return
     */
    public static String getDistanceDate(int distanceDay) {
        SimpleDateFormat dft = new SimpleDateFormat(FULL);
        Date beginDate = new Date();
        Calendar date = Calendar.getInstance();
        date.setTime(beginDate);
        date.set(Calendar.DATE, date.get(Calendar.DATE) + distanceDay);
        Date endDate = null;
        try {
            endDate = dft.parse(dft.format(date.getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dft.format(endDate);
    }


    /*
     * 毫秒转化时分秒毫秒
     */
    public static String formatTime(Long ms) {
        Integer ss = 1000;
        Integer mi = ss * 60;
        Integer hh = mi * 60;
        Integer dd = hh * 24;

        Long day = ms / dd;
        Long hour = (ms - day * dd) / hh;
        Long minute = (ms - day * dd - hour * hh) / mi;
        Long second = (ms - day * dd - hour * hh - minute * mi) / ss;
        Long milliSecond = ms - day * dd - hour * hh - minute * mi - second * ss;

        StringBuffer sb = new StringBuffer();
        if (day > 0) {
            sb.append(day + ":");
        }
        if (hour > 0) {
            sb.append(String.format("%02d", hour) + ":");
        }else{
            sb.append(String.format("%02d", hour) + ":");
        }
        if (minute >= 0) {
            sb.append(String.format("%02d", minute) + ":");
        }
        if (second >= 0) {
            sb.append(String.format("%02d", second));
        }
        return sb.toString();
    }

    public static String sec2StringTime(long mss) {
        if (mss <= 0) {
            return "--:--";
        }
        long hours = (mss % (60 * 60 * 24)) / (60 * 60);
        long minutes = (mss % (60 * 60)) / 60;
        long seconds = mss % 60;
        if (hours > 0) {
            return hours + "小时" + minutes + "分钟";
        } else if (minutes > 0) {
            return minutes + "分钟" + seconds + "秒";
        } else {
            return 0 + "分钟" + seconds + "秒";
        }
    }


    /*
     * 毫秒转化时分秒毫秒
     */
    public static String getHomeTime(Long ms) {
        Integer ss = 1000;
        Integer mi = ss * 60;
        Integer hh = mi * 60;
        Integer dd = hh * 24;

        Long day = ms / dd;
        Long hour = (ms - day * dd) / hh;
        Long minute = (ms - day * dd - hour * hh) / mi;
        Long second = (ms - day * dd - hour * hh - minute * mi) / ss;


        StringBuffer sb = new StringBuffer();

        if (day > 0) {
            sb.append(String.format("%s天", day));
        }

        if (hour >= 0) {
            sb.append(String.format("%02d", hour) + ":");
        }
        if (minute >= 0) {
            sb.append(String.format("%02d", minute) + ":");
        }
        if (second >= 0) {
            sb.append(String.format("%02d", second));
        }
        return sb.toString();
    }

    /**
     * 根据年月日返回星期几
     *
     * @param date //年份 2019-04-16 12:00:21
     * @return String //返回值直接返回星期几
     */
    public static String weekByDate(String date) {
        String str = "";
        int weekDay = 0;
        SimpleDateFormat fmt = new SimpleDateFormat(LIMIT_TIME);
        try {
            Date d = null;
            d = fmt.parse(date);
            Calendar cal = Calendar.getInstance();
            cal.setTime(d);
            weekDay = cal.get(Calendar.DAY_OF_WEEK);
            switch (weekDay) {
                case 1:
                    str = "周天";
                    break;
                case 2:
                    str = "周一";
                    break;
                case 3:
                    str = "周二";
                    break;
                case 4:
                    str = "周三";
                    break;
                case 5:
                    str = "周四";
                    break;
                case 6:
                    str = "周五";
                    break;
                case 7:
                    str = "周六";
                    break;
                default:
                    break;
            }
        } catch (ParseException e) {
            return "";
        }


        return str;
    }

    /**
     * 根据年月日返回星期几
     *
     * @param date //年份 2019-04-16 12:00:21
     * @return String //返回值直接返回星期几
     */
    public static String weekByDate2(String date) {
        String str = "";
        int weekDay = 0;
        SimpleDateFormat fmt = new SimpleDateFormat(FULL2);
        try {
            Date d = null;
            d = fmt.parse(date);
            Calendar cal = Calendar.getInstance();
            cal.setTime(d);
            weekDay = cal.get(Calendar.DAY_OF_WEEK);
            switch (weekDay) {
                case 1:
                    str = "周天";
                    break;
                case 2:
                    str = "周一";
                    break;
                case 3:
                    str = "周二";
                    break;
                case 4:
                    str = "周三";
                    break;
                case 5:
                    str = "周四";
                    break;
                case 6:
                    str = "周五";
                    break;
                case 7:
                    str = "周六";
                    break;
                default:
                    break;
            }
        } catch (ParseException e) {
            return "";
        }


        return str;
    }

    /**
     * 通过时间秒毫秒数判断两个时间的间隔
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int differentDaysByMillisecond(Date date1, Date date2) {
        int days = (int) ((date2.getTime() - date1.getTime()) / (1000 * 3600 * 24));
        return days;
    }


    public static String getHourMin(int min) {
        int hours = (int) Math.floor(min / 60);
        int minute = min % 60;
        return hours + "小时" + minute + "分钟";
    }

    public static long getHHmmMs(String countDownTime) {
        String[] times = countDownTime.split(":");
        int hour = Integer.parseInt(times[0]);
        int min = Integer.parseInt(times[1]);
        return hour * 60 * 60 * 1000 + min * 60 * 1000;
    }
}
