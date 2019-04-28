import java.util.Arrays;

public class TestClass {


    public static void main(String[] args) {


        int[] bArray = {0, 1, 4, 6, 7};
        try {
            System.out.println(Arrays.toString(cutArray(bArray)));
        } catch (MyArrayException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println(checkArray(bArray));
    }


    public static int[] cutArray (int[] inputArray) throws MyArrayException{

        int[] outputArray = null;

        int elCount = 0;
        int numCount = 0;

            for (int n = inputArray.length - 1; n >= 0; n--) {

                elCount++;

                if (inputArray[n] == 4) {
                    numCount++;
                    outputArray = new int[elCount - 1];
                    System.arraycopy(inputArray, (n + 1), outputArray, 0, elCount - 1);
                    break;
                }

            }

            if (numCount == 0)
                throw new MyArrayException("Текущий массив не задержит элемент: 4");

            return outputArray;
    }

    public static boolean checkArray (int[] inputArray) {

        boolean result = false;

        for (int i : inputArray) {
            if (i == 1 || i == 4)
                result = true;
        }

        return result;

    }

}

class MyArrayException extends Exception{

    public MyArrayException(String message){
        super(message);
    }
}