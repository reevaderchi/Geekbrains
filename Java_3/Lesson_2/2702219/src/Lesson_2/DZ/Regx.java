package Lesson_2.DZ;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regx {

    public static void main(String[] args) {
       // System.out.println(testRegx("eqweqwe"));
String str = "eqweqwe";

        if(testRegx(str)) {
            System.out.println("Ок");
            if (testRegx1(str)) {
                System.out.println("Ок Ok");
            }
        }
    }

    private static boolean testRegx(String str) {
        Pattern p = Pattern.compile("^.{5,10}$");
        Matcher m = p.matcher(str);

        return m.matches();
    }

    private static boolean testRegx1(String str) {
        Pattern p = Pattern.compile("^.{5,10}$");
        Matcher m = p.matcher(str);

        return m.matches();
    }

}
