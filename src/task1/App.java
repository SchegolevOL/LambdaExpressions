package task1;

import java.text.SimpleDateFormat;
import java.util.Date;

interface LeapYear {
    boolean isLeapYear(int year);
}
interface DaysBetweenTwoDates{
    int numberDaysBetweenTwoDates(String date1, String date2);
}
interface FullWeeksBetweenDates{
    int numberFullWeeksBetweenDates(String date1, String date2);
}
public class App {
    public static void main(String[] args) {

        LeapYear isLeap = (int year) -> (year % 4 == 0 && year % 100 != 0) || year % 400 == 0 ? true : false;
        System.out.println(isLeap.isLeapYear(1981));
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
    }



    public static boolean isLeapYear(int year){
        if((year%4==0&&year%100!=0)||year%400==0)return true;
        return false;
    }


}


