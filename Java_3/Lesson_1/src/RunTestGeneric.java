public class RunTestGeneric {

    public static void main(String[] args) {

        //1. Написать метод, который меняет два элемента массива местами
        // (массив может быть любого ссылочного типа);

        String[] stringArray = {"1", "2", "3", "4", "5"};
        Integer[] integerArray = {1,2,3,4,5};

        TestGeneric<String> stringTestGeneric = new TestGeneric<>(stringArray);
        TestGeneric<Integer> integerTestGeneric = new TestGeneric<>(integerArray);

        stringTestGeneric.swipePosition(0,1);
        integerTestGeneric.swipePosition(1,2);

        // 2. Написать метод, который преобразует массив в ArrayList;

        stringTestGeneric.convertToArrayList();
        System.out.println("stringTestGeneric ArrayList size = " + stringTestGeneric.convertToArrayList().size());
        integerTestGeneric.convertToArrayList();
        System.out.println("integerTestGeneric ArrayList size = " + stringTestGeneric.convertToArrayList().size());

    }

}
