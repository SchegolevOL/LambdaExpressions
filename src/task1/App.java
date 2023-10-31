package task1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

interface LeapYear {
    boolean isLeapYear(int year);
}

interface DaysBetweenTwoDates {
    int numberDaysBetweenTwoDates(String date1, String date2);
}

interface FullWeeksBetweenTwoDates {
    int numberFullWeeksBetweenTwoDates(String date1, String date2);
}

interface DayWeek {
    String dayWeekByReceivedDate(String date);
}

public class App {
    public static void main(String[] args) {

        //-------Checking whether the year is a leap year;-------
        LeapYear isLeap = (int year) -> (year % 4 == 0 && year % 100 != 0) || year % 400 == 0 ? true : false;
        System.out.println(isLeap.isLeapYear(1981));

        //-------Counting the number of days between 2 dates;----
        DaysBetweenTwoDates dates = (String date1, String date2) -> {
            Date dateBegin = getDate(date1);
            Date dateEnd = getDate(date2);
            long difference = dateBegin.getTime() - dateEnd.getTime();
            int days = Math.abs((int) (difference / (24 * 60 * 60 * 1000)));
            return days;
        };
        System.out.println(dates.numberDaysBetweenTwoDates("10.01.2023", "12.01.2023"));
        //---Counting the day of the week by the received date, for example, July 20, 1969 - Sunday;---
        DayWeek dayWeek = (String d) -> {
            Date date = getDate(d);
            DateFormat formatWeek = new SimpleDateFormat("EEEE", Locale.US);
            return formatWeek.format(date);
        };
        System.out.println(dayWeek.dayWeekByReceivedDate("30.10.2023"));
        //------Counting the number of full weeks between 2 dates;-------
        FullWeeksBetweenTwoDates weeksBetweenTwoDates = (String d1, String d2) -> {
            Date date1 = getDate(d1);
            Date date2 = getDate(d2);
            long difference = date1.getTime() - date2.getTime();
            int days = Math.abs((int) (difference / (24 * 60 * 60 * 1000)));
            String weekDey = dayWeek.dayWeekByReceivedDate(d1);
            return weekDey.equals("Monday")?days/7:days/7-1;
        };
        System.out.println(weeksBetweenTwoDates.numberFullWeeksBetweenTwoDates("09.10.2023", "23.10.2023"));
    }

    private static Date getDate(String d) {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        Date date = null;
        try {
            date = format.parse(d);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }



}


