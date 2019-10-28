package lib.algo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateUtls {

    /**
     * 날짜의 요일 구하기
     * @param date      입력 날짜
     * @return
     */
    public static String getSimpleWeekDay(String date) {
        return getWeekDay(date, "yyyy-MM-dd");
    }

    /**
     * 날짜의 요일 구하기
     * @param date      입력 날짜
     * @param format   입력 format ex) yyyy-MM-dd hh:mm:ss
     * @return
     */
    public static String getWeekDay(String date, String format) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.KOREAN);
            Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Seoul"));
            cal.setTime(sdf.parse(date));
            int day = cal.get(Calendar.DAY_OF_WEEK);
            switch (day) {
                case 1: return "일";
                case 2: return "월";
                case 3: return "화";
                case 4: return "수";
                case 5: return "목";
                case 6: return "금";
                case 7: return "토";
                default : return "";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }


    /**
     * Calendar Class get
     * @param date
     * @return
     */
    public static Calendar getCalendar(String date) {
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Seoul"));
        String replace = replaceForamt(date);
        set(cal, replace);
        return cal;
    }

    /**
     * Date Class get
     * @param date
     * @return
     */
    public static Date getDate(String date) {
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Seoul"));
        String replace = replaceForamt(date);
        set(cal, replace);
        return cal.getTime();
    }

    /**
     * Date Time Millisecond get
     * @param date
     * @return
     */
    public static long getDateTimeMillis(String date) {
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Seoul"));
        String replace = replaceForamt(date);
        set(cal, replace);
        return cal.getTimeInMillis();
    }

    /**
     * Set Calendar Basic Format
     * @param c
     * @param date
     */
    public static void set(Calendar c, String date) {
        int year = Integer.parseInt(date.substring(0,4));
        int month = Integer.parseInt(date.substring(4,6)) - 1;
        int dat = Integer.parseInt(date.substring(6,8));
        c.set(year, month, dat);
        if(date.length() > 8) {
            int hour = Integer.parseInt(date.substring(9,11));
            int min = Integer.parseInt(date.substring(11,13));
            int second = Integer.parseInt(date.substring(13,15));
            c.set(year, month, dat, hour, min, second);
        }
    }

    /**
     * 중간중간의 기호 변경
     * @param param
     * @return
     */
    public static String replaceForamt(String param) {
        return param.replaceAll("-", "")
                .replaceAll(":", "")
                .replaceAll(".", "");
    }


}
