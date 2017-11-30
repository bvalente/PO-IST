package exemplo;

import java.io.*;

public class Dates {
  /**
   * Computes the number of number of days of the given month. Does not take into account leap years.
   *
   * @param month the concerned month. This parameter is between 1 and 12, inclusive.
   *
   * @returns the number of days in the given month.
   **/
  public int daysInMonth(int month) {
    // September, April, June and November have 30 days
    if ((month == 9) || (month == 4) || (month == 6) || (month == 11)) {
      return 30;
    }
    else if (month == 2) // All the rest have 31, except for February .... 
      return 28;
    else return 31;
  }

  /**
   * This entry point method should be invoked with four arguements: first day, first month, last day and last month
   * and it should print the difference of days between the first date (first day and month) and the second date (last day and month).
   **/
  public static void main (String[] args) {
    int someMonth, someDay;
    int laterMonth, laterDay;
    
    int aMonth;
    someMonth = Integer.parseInt(args[0]);
    someDay = Integer.parseInt(args[1]);
    
    laterMonth = Integer.parseInt(args[2]);
    laterDay = Integer.parseInt(args[3]);
    
    /* Used to record what day in the year the first day  */
    /* of someMonth and laterMonth are. */
    int someDayInYear = 0;
    int laterDayInYear = 0;  
    Dates dates = new Dates();
    
    for (aMonth = 0; aMonth < someMonth; aMonth = aMonth + 1) {
      someDayInYear = someDayInYear + dates.daysInMonth(aMonth); 
    }
    
    for (aMonth = 1; aMonth < laterMonth; aMonth = aMonth + 1) {
      laterDayInYear = laterDayInYear + dates.daysInMonth(aMonth); 
    }
    
    /* The answer */
    int daysBetween = 0;
    System.out.println("The difference in days between " +
                       someMonth + "/" + someDay + " and " +
                       laterMonth + "/" + laterDay + " is: ");
    daysBetween = laterDayInYear - someDayInYear;
    daysBetween = daysBetween + laterDay - someDay;
    System.out.println(daysBetween);
  }
}
