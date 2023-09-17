package automatingOperationsOnVariousElements;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CompareDates {

    static String requiredDay = "22";
    static String requiredMonth = "february";
    static String requiredYear = "2022";

    public static String currentDateAndTime() {

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMMM-yyyy");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }

    public static void main(String[] str) throws InterruptedException, ParseException {

        String currentDate = currentDateAndTime();
        System.out.println(currentDate);
        String expectedDate = requiredDay + "-" + requiredMonth + "-" + requiredYear;

        Date expectedDates = new SimpleDateFormat("dd-MMMM-yyyy" , Locale.ENGLISH)
                .parse(expectedDate);
        Date currentDates = new SimpleDateFormat("dd-MMMM-yyyy" , Locale.ENGLISH)
                .parse(currentDate);

        if (expectedDates.compareTo(currentDates) == 0) {

            System.out.println("Expected Date and Current Date are same : ");
        } else if (expectedDates.compareTo(currentDates) > 0) {

            System.out.println("Expected Date is after Current Date : ");
        } else if (expectedDates.compareTo(currentDates) < 0) {

            System.out.println("Expected Date is before Current Date : ");
        }
    }
}
