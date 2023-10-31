package task1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

interface LeapYear {
    boolean isLeapYear(int year);
}
interface DaysBetweenTwoDates{
    int numberDaysBetweenTwoDates(String date1, String date2);
}
interface FullWeeksBetweenTwoDates{
    int numberFullWeeksBetweenTwoDates(String date1, String date2);
}
interface DayWeek{
    String dayWeekByReceivedDate(String date);
}
public class App {
    public static void main(String[] args) {

        //-------Checking whether the year is a leap year;-------
        LeapYear isLeap = (int year) -> (year % 4 == 0 && year % 100 != 0) || year % 400 == 0 ? true : false;
        System.out.println(isLeap.isLeapYear(1981));

        //-------Counting the number of days between 2 dates;----
        DaysBetweenTwoDates dates = (String date1, String date2)->{
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
            Date dateBegin = null;
            Date dateEnd = null;
            try {
                dateBegin = format.parse(date1);
                dateEnd = format.parse(date2);
            } catch (Exception e) {
                e.printStackTrace();
            }
            long difference = dateBegin.getTime() - dateEnd.getTime();
            int days =  Math.abs((int)(difference / (24 * 60 * 60 * 1000)));
            return days;
        };
        System.out.println(dates.numberDaysBetweenTwoDates("10.01.2023", "12.01.2023"));
        //---Counting the day of the week by the received date, for example, July 20, 1969 - Sunday;---
        DayWeek dayWeek = (String d)->{
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
            Date date = null;
            try {
                date = format.parse(d);
            } catch (Exception e) {
                e.printStackTrace();
            }
            DateFormat formatWeek = new SimpleDateFormat("EEEE", Locale.US);
            return formatWeek.format(date);
        };
        System.out.println(dayWeek.dayWeekByReceivedDate("31.10.2023"));
        //------Counting the number of full weeks between 2 dates;-------


    }



    public static boolean isLeapYear(int year){
        if((year%4==0&&year%100!=0)||year%400==0)return true;
        return false;
    }


}


