package SerializableTest;

import java.io.Serializable;

public class Students implements Serializable {

    String name;
    int age;


    public Students(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void info() {
        System.out.println(name + " " + age);
    }

}
