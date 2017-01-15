/*
 * Test.java
 *
 * Created on March 3, 2005, 7:48 PM
 */

/**
 *
 * @author Family
 */
import java.io.*;
import java.text.DecimalFormat;

class Time
{

  private static int CurrentHrs, CurrentMin;
  private int Hrs, Min;
  static DecimalFormat timeStat = new DecimalFormat("00");

  public Time (int hours, int minutes)
  {
    if (hours > 24)
      for (; hours > 24; hours -= 24)
    if (hours == 24)
      hours = 0;
    
    Hrs = hours;

    if (minutes > 60)
      for (; minutes > 60; minutes -= 60)
        Hrs++;

    Min = minutes;
  }

  public void show (boolean format)
  {
    if (format)
      outputAmPm(Hrs, Min);
    else
      outputMilitary(Hrs, Min);
  }

  public static void setCurTime (int hours, int minutes)
  {
    if (hours > 24)
      for (; hours > 24; hours -= 24)
    if (hours == 24)
      hours = 0;
    
    CurrentHrs = hours;

    if (minutes > 60)
      for (; minutes > 60; minutes -= 60)
      CurrentHrs++;

    CurrentMin = minutes;
  }

  public static void showCurTime (boolean format)
  {
    if (format)
      outputAmPm (CurrentHrs, CurrentMin);
    else
      outputMilitary (CurrentHrs, CurrentMin);
  }

  private static void outputAmPm (int hours, int minutes)
  {
    
    if (hours < 12)
      System.out.print (hours + ":" + timeStat.format(minutes) + "AM");
    if (hours == 12)
      System.out.print (hours + ":" + timeStat.format(minutes) + "PM");
    if (hours > 12)
    {
      hours -= 12;
      System.out.print (hours + ":" + timeStat.format(minutes) + "PM");
    } 
  }

  private static void outputMilitary (int hours, int minutes)
  {
    System.out.print (hours + ":" + timeStat.format(minutes));
  }

  public static void addToCurTime (int minutes)
  {
    CurrentMin += minutes;

    for (; CurrentMin >= 60; CurrentMin -= 60)
      CurrentHrs++;
  }

  public boolean isLaterToday ()
  {
    if ( Hrs < CurrentHrs)
      return false;
    if ( Hrs == CurrentHrs && Min < CurrentMin)
      return false;

    return true;
  }
}
