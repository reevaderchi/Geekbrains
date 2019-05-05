import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class Review {

    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class ch = URLClassLoader.newInstance(new URL[]{new File("D:/Geekbrains/Java_3/HWforReview/out/production/HWforReview")
                .toURI().toURL()}).loadClass("Main");

        Constructor constructor = ch.getConstructor();

        System.out.println(constructor);

        Object hw = constructor.newInstance();

        Method mCalculateInt = ch.getDeclaredMethod("calculate", int.class, int.class, int.class, int.class);
        mCalculateInt.setAccessible(true);
        int task1 =(int) mCalculateInt.invoke(hw, 1, 2, 4, 2);
        System.out.println(task1);

        Method mCalculateFloat = ch.getDeclaredMethod("calculate", float.class, float.class, float.class, float.class);
        mCalculateFloat.setAccessible(true);
        float task2 =(float) mCalculateFloat.invoke(hw, 1.0f, 2.0f, 4.0f, 2.0f);
        System.out.println(task2);

        Method mCheckTwoNumbers = ch.getDeclaredMethod("checkTwoNumbers", int.class, int.class);
        mCheckTwoNumbers.setAccessible(true);
        boolean task3 = (boolean) mCheckTwoNumbers.invoke(hw, 7, 8);
        System.out.println(task3);

        Method mPrintIsPositive = ch.getDeclaredMethod("printIsPositive", int.class);
        mPrintIsPositive.setAccessible(true);
        String task4 = (String) mPrintIsPositive.invoke(hw, 4);

        Method mIsNegative = ch.getDeclaredMethod("isNegative", int.class);
        mIsNegative.setAccessible(true);
        boolean task5 = (boolean) mIsNegative.invoke(hw, -2);
        System.out.println(task5);

        Method mPrintWelcome = ch.getDeclaredMethod("printWelocome", String.class);
        mPrintWelcome.setAccessible(true);
        String task6 = (String)mPrintWelcome.invoke(hw, "John");

        Method mIsLeapYear = ch.getDeclaredMethod("isLeapYear", int.class);
        mIsLeapYear.setAccessible(true);
        boolean task7 = (boolean)mIsLeapYear.invoke(hw, 2012);

        System.out.println(" ");

        if (task1 == 4)
            System.out.println("Задание 1 верно!");
        else System.out.println("Задание 1 неверно!");

        if (task2 == 4.0f)
            System.out.println("Задание 2 верно!");
        else System.out.println("Задание 2 неверно!");

        if (task3 == true)
            System.out.println("Задание 3 верно!");
        else System.out.println("Задание 3 неверно!");

        if (task4 == "Your number is positive!")
            System.out.println("Задание 4 верно!");
        else System.out.println("Задание 4 неверно!");

        if (task5 == true)
            System.out.println("Задание 5 верно!");
        else System.out.println("Задание 5 неверно!");

        if (task6 =="Привет, John!")
            System.out.println("Задание 6 верно!");
        else System.out.println("Задание 6 неверно!");

        if (task7 == true)
            System.out.println("Задание 7 верно!");
        else System.out.println("Задание 7 неверно!");

    }

}
