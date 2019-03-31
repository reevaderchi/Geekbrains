package FruitsQuiz;

public abstract class Fruit {

    private float weight;
    private String name;

    public float getWeight() {
        return weight;
    }

    public Fruit(String name) {
        this.name = name;
    }

}
