/*
 * TimeTest.java
 *
 * Created on March 3, 2005, 7:50 PM
 */

/**
 *
 * @author Family
 */
import javax.swing.JOptionPane;

class TimeTest      // feel free to convert this program to an applet if you wish.
{
  public static void main(String args[])
  {
    String entry;
    int colonIdx, hour, min;
    Time breakfastTime, lunchTime, dinnerTime;

    entry = JOptionPane.showInputDialog( // Beware that this won't work on hills unless it's an applet
        "What time is it? (Please use 24-hour hh:mm format)");
    colonIdx = entry.indexOf(':');
    hour = Integer.parseInt(entry.substring(0, colonIdx));
    min = Integer.parseInt(entry.substring(colonIdx+1));
    Time.setCurTime(hour, min);

    breakfastTime = new Time(9, 0); // store 9:00 AM
    lunchTime = new Time(12, 0); // store 12:00 PM
    dinnerTime = new Time(18, 30); // store 6:30 PM

    System.out.print("It's now ");
    Time.showCurTime(false);     // display current time
    System.out.print("\nBreakfast is at ");
    breakfastTime.show(true);              // display with AM
    if(breakfastTime.isLaterToday())
      System.out.println("\nwhich is later today.");
    else
      System.out.println("\nwhich is not until tomorrow.");

    System.out.print("Lunch is at ");
    lunchTime.show(true);              // display with PM
    if(lunchTime.isLaterToday())
      System.out.println("\nwhich is later today.");
    else
      System.out.println("\nwhich is not until tomorrow.");

    System.out.print("Dinner is at ");
    dinnerTime.show(false);              // display without PM
    if(dinnerTime.isLaterToday())
      System.out.println("\nwhich is later today.");
    else
      System.out.println("\nwhich is not until tomorrow.");

    Time.addToCurTime(90);  // make current time 90 minutes later
    System.out.print("Imagine 90 minutes have passed and it is now ");
    Time.showCurTime(true);     // display current time
    if(lunchTime.isLaterToday())
      System.out.println("\nLunch is later today.");
    else
      System.out.println("\nLunch is not until tomorrow.");
    if(dinnerTime.isLaterToday())
      System.out.println("Dinner is later today.");
    else
      System.out.println("Dinner is not until tomorrow.");

    System.exit(0);
  }
}

