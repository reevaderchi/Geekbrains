import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Task_2 {

    public static void main(String[] args) {

        ArrayList<InputStream> al = new ArrayList<>();

        try {
            al.add(new FileInputStream("text/text1.txt"));
            al.add(new FileInputStream("text/text2.txt"));
            al.add(new FileInputStream("text/text3.txt"));
            al.add(new FileInputStream("text/text4.txt"));
            al.add(new FileInputStream("text/text5.txt"));

            SequenceInputStream sin = new SequenceInputStream(Collections.enumeration(al));

            byte [] arr = new byte [10000];

            int x;

            while ( (x = sin.read(arr)) != -1) {
                System.out.println(new String(arr, 0 , x, "UTF-8"));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
