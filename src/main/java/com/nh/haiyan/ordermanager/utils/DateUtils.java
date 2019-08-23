package com.nh.haiyan.ordermanager.utils;

import org.springframework.util.unit.DataUnit;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.CancellationException;

/**
 * @Classname DateUtils
 * @Description TODO
 * @Date 2019/8/1 4:56 PM
 * @Created by nihui
 */
public class DateUtils {
    public static String DATE_FORMAT="yyyy-MM-dd";
    public static String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static String getCurrentDate(){
        String datestr = null;
        SimpleDateFormat df = new SimpleDateFormat(DateUtils.DATE_FORMAT);
        datestr = df.format(df);
        return datestr;
    }


    public static String getCurrentDateTime(String Dateformat){
        String datestr = null;
        SimpleDateFormat df = new SimpleDateFormat(Dateformat);
        datestr = df.format(new Date());
        return datestr;
    }

    public static String dateToDateTime(Date date){
        String datestr = null;
        SimpleDateFormat df = new SimpleDateFormat(DateUtils.DATE_TIME_FORMAT);
        datestr = df.format(date);
        return datestr;
    }

    public static Date stringToDate(String datestr){
        if (datestr==null|| datestr.equals("")){
            return null;
        }
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat(DateUtils.DATE_FORMAT);
        try{
            date = df.parse(datestr);
        } catch (ParseException e) {
            date = DateUtils.stringToDate(datestr,"yyyyMMdd");
        }
        return date;
    }

    public static Date stringToDate(String datestr,String dateformat){
        Date date =new Date();
        SimpleDateFormat df = new SimpleDateFormat(dateformat);
        try{
            date = df.parse(datestr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String dateToString(Date date){
        String datestr = null;
        SimpleDateFormat df = new SimpleDateFormat(DateUtils.DATE_FORMAT);
        datestr = df.format(date);
        return datestr;
    }

    public static String dateToString(Date date,String dateformat){
        String datestr = null;
        SimpleDateFormat df = new SimpleDateFormat(dateformat);
        datestr = df.format(date);
        return datestr;
    }

    public static int getDayOfDate(Date date){
        int d = 0;
        Calendar cd = Calendar.getInstance();
        cd.setTime(date);
        d = cd.get(Calendar.DAY_OF_MONTH);
        return d;
    }


    public static int getMonthOfDate(Date date){
        int m = 0;
        Calendar cd = Calendar.getInstance();
        cd.setTime(date);
        m = cd.get(Calendar.MONTH)+1;
        return m;
    }


    public static int getYearOfDate(Date date){
        int y = 0;
        Calendar cd = Calendar.getInstance();
        cd.setTime(date);
        y = cd.get(Calendar.YEAR);
        return y;
    }

    public static int getWeekOfDate(Date date){
        int wd = 0;
        Calendar cd = Calendar.getInstance();
        cd.setTime(date);
        wd = cd.get(Calendar.DAY_OF_WEEK)-1;
        return wd;
    }

    public static Date getFristDayOfMonth(Date date){
        Calendar cd = Calendar.getInstance();
        cd.setTime(date);
        cd.set(Calendar.DAY_OF_MONTH,1);
        return cd.getTime();
    }

    public static Date getLastDayOfMonth(Date date){
        return DateUtils.addDay(DateUtils.getFristDayOfMonth(DateUtils.addMonth(date,1)),-1);
    }

    public static boolean isLeapYEAR(Date date){
        Calendar cd = Calendar.getInstance();
        cd.setTime(date);
        int year = cd.get(Calendar.YEAR);
        if (year % 4 == 0&&year%100!=0||year%400==0){
            return true;
        }else {
            return false;
        }
    }

    public static Date getDateByYMD(int year,int month,int day){
        Calendar cd = Calendar.getInstance();
        cd.set(year,month-1,day);
        return cd.getTime();
    }

    public static Date getYearCycleOfDate(Date date,int iyear){
        Calendar cd = Calendar.getInstance();
        cd.setTime(date);
        cd.add(Calendar.YEAR,iyear);
        return cd.getTime();
    }

    public static Date getMonthCycleOfDate(Date date,int i){
        Calendar cd = Calendar.getInstance();
        cd.setTime(date);
        cd.add(Calendar.MONTH,i);
        return cd.getTime();
    }

    public static int getYearByMinusDate(Date fromDate,Date toDate){
        Calendar df = Calendar.getInstance();
        df.setTime(fromDate);
        Calendar dt = Calendar.getInstance();
        dt.setTime(toDate);
        return dt.get(Calendar.YEAR)-df.get(Calendar.YEAR);
    }

    public static int getMonthByMinusDate(Date fromDate,Date toDate){
        Calendar df = Calendar.getInstance();
        df.setTime(fromDate);
        Calendar dt = Calendar.getInstance();
        dt.setTime(toDate);
        return dt.get(Calendar.YEAR)*12+dt.get(Calendar.MONTH)-(df.get(Calendar.YEAR)*12+df.get(Calendar.MONTH));
    }

    public static long getDayByMinusDate(Object fromDate,Object toDate){
        Date f = DateUtils.chgObject(fromDate);
        Date t = DateUtils.chgObject(toDate);

        long fd = f.getTime();
        long td = t.getTime();

        return (td-fd)/(24L*60L*60L*1000L);
    }

    public static int calcAge(Date birthday,Date calcDate){
        int cYear = DateUtils.getYearOfDate(calcDate);
        int cMonth = DateUtils.getMonthOfDate(calcDate);
        int cDay = DateUtils.getDayOfDate(calcDate);
        int bYear = DateUtils.getYearOfDate(birthday);
        int bMonth = DateUtils.getMonthOfDate(birthday);
        int bDay = DateUtils.getDayOfDate(birthday);

        if (cMonth>bMonth||(cMonth==bMonth&&cDay>bDay)){
            return cYear-bYear;
        }else {
            return cYear-1-bYear;
        }
    }

    public static String getBirthDayFromIDCard(String idno){
        Calendar cd = Calendar.getInstance();
        if (idno.length()==15){
            cd.set(Calendar.YEAR,Integer.valueOf("19"+idno.substring(6,8)).intValue());
            cd.set(Calendar.MONTH,Integer.valueOf(idno.substring(8,10)).intValue()-1);
            cd.set(Calendar.DAY_OF_MONTH,Integer.valueOf(idno.substring(10,12)).intValue());
        }else if (idno.length()==18){
            cd.set(Calendar.YEAR,Integer.valueOf(idno.substring(6,10)).intValue());
            cd.set(Calendar.MONTH,Integer.valueOf(idno.substring(10,12)).intValue()-1);
            cd.set(Calendar.DAY_OF_MONTH,Integer.valueOf(idno.substring(12,14)).intValue());
        }
        return DateUtils.dateToDateTime(cd.getTime());
    }

    public static Date addDay(Date date,int iday){
        Calendar cd = Calendar.getInstance();
        cd.setTime(date);
        cd.add(Calendar.DAY_OF_MONTH,iday);
        return cd.getTime();
    }

    public static Date addMonth(Date date,int imonth){
        Calendar cd = Calendar.getInstance();
        cd.setTime(date);
        cd.add(Calendar.MONTH,imonth);
        return cd.getTime();
    }

    public static Date addYear(Date date,int iyear){
        Calendar cd = Calendar.getInstance();
        cd.setTime(date);
        cd.add(Calendar.YEAR,iyear);
        return cd.getTime();
    }

    public static Date chgObject(Object date){
        if (date!=null&&date instanceof Date){
            return (Date) date;
        }
        if (date!=null&& date instanceof String){
            return DateUtils.stringToDate((String)date);
        }
        return null;
    }

    public static long getAgeByBirthday(String date){
        Date birthday = stringToDate(date,"yyyy-MM-dd");
        long sce = new Date().getTime()-birthday.getTime();
        long age = sce/(1000*60*60*24)/365;
        return age;
    }

    public static Date getCurrentTime(){
        return new Date(System.currentTimeMillis());
    }
}

