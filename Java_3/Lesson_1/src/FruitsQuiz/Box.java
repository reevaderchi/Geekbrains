package FruitsQuiz;

import java.util.ArrayList;

public class Box<T extends Fruit> {

    ArrayList<Fruit> frs = new ArrayList(); // для хранения фруктов (для операция с ArrayList)

    private T[] fruits;

    public Box(T[] fruits) {
        this.fruits = fruits;
        for (T o: fruits) // делаем дубль в ArrayList
            frs.add(o);
    }

    // получить обищй вес ящика
    public float getWeight() {

        float weight = 0;

        for (Fruit o: frs)
            weight += o.getWeight();

        return weight;

    }

    // добавить фрукт в ящик
    // апельсины к яблокам добавить нельзя, как и наоборот
    public void addFruit (T fruit) {
        this.frs.add(fruit);
    }

    // сравнение веса коробоа
    // можно сравнить вес коробки с яблоками и вес коробки с апельсинами
    public void compareBoxes (Box<?> boxToCompare) {
        if (this.getWeight() == boxToCompare.getWeight()) {
            System.out.println("Boxes have the same weight = " + this.getWeight());
        } else {
            System.out.println("Boxes are different! Weight_1 = " + this.getWeight()
                    + " Weight_2 = " + boxToCompare.getWeight());
        }
    }

    // метод пересыпки из одного ящика в другой
    // нельзя пересыпать яблоки к апельсинам и наоборот
    public void emptyTo (Box<T> boxToAddFruits) {
        boxToAddFruits.frs.addAll(this.frs);
        this.frs.clear();
    }

}
