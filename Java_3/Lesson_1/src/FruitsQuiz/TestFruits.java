package FruitsQuiz;

public class TestFruits {

    public static void main(String[] args) {
        Orange[] oranges = {new Orange("orange1"), new Orange("orange2"), new Orange("orange3")};
        Apple[] apples = {new Apple("apple1"), new Apple("apple2"), new Apple("apple3")};

        // создаем коробки
        Box <Orange> orangeBox = new Box<>(oranges);
        Box <Apple> appleBox = new Box<>(apples);
        Box <Apple> anotherAppleBox = new Box<>(apples);

        // выводим вес ящиков
        System.out.println("OrangeBox weight is: " + orangeBox.getWeight());
        System.out.println("AppleBox weight is: " + appleBox.getWeight());

        // добавляем яблоко в коробку с яблоками
        anotherAppleBox.addFruit(new Apple("apple4"));
        System.out.println("AnotherAppleBox weight is: " + anotherAppleBox.getWeight());

        // сравниваем коробки с яблоками
        appleBox.compareBoxes(anotherAppleBox);

        // пересыпаем яблоки из коробки appleBox в anotherAppleBox
        // выводим вес ящиков после пересыпки
        appleBox.emptyTo(anotherAppleBox);
        System.out.println("AppleBox weight is: " + appleBox.getWeight());
        System.out.println("AnotherAppleBox weight is: " + anotherAppleBox.getWeight());

    }

}
