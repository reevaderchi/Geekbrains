import java.util.ArrayList;

public class TestGeneric<T> {

    private T[] array;

    public TestGeneric(T[] array) {
        this.array = array;
    }

    //1. Написать метод, который меняет два элемента массива местами
    // (массив может быть любого ссылочного типа);
    public void swipePosition (int i, int j) {

        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;

        for (T o: array)
            System.out.println(o);

        System.out.println();

    }

    // 2. Написать метод, который преобразует массив в ArrayList;
    public ArrayList<T> convertToArrayList() {
        ArrayList<T> convertedArray = new ArrayList<>();

        for (T o: array)
            convertedArray.add(o);

        return convertedArray;
    }

}
