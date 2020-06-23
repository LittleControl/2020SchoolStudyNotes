package exper6;

import java.io.*;
public class Customer5 implements Serializable {
    private String name;
    private int age;

    public Customer5(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return "name=" + name + " age=" + age;
    }
}
