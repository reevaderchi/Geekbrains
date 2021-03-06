package Lesson_2.DZ;

import java.util.Arrays;

public class MainClassEnum
{
    public static void main(String[] args)
    {
        DayOfWeek d = DayOfWeek.SATURDAY;
        System.out.println(getWorkingHours(d));
    }

    public static String getWorkingHours(DayOfWeek d)
    {
        DayOfWeek[] mass = new DayOfWeek[2];

        int num = 5 - d.ordinal();
        return (num > 0) ? String.valueOf(num*8) + " hours" : "Weekend!!!";
    }
}

enum DayOfWeek
{MONDAY, TUESDAY, WENSDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY}