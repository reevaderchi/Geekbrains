import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Task_1 {

    public static void main(String[] args) {

        try (FileInputStream in = new FileInputStream("text/text1.txt")) {

            byte [] arr = new byte[1024];

            int x;

            while ( (x = in.read(arr)) != -1) {
                System.out.println(new String (arr, 0, x, "UTF-8"));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
