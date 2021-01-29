package ru.gb.bocharov.lesson6;

public class Cat extends Animal {

    public Cat(String name) {
        this.name = name;
    }
    public void swim(int swim){
        System.out.println("Кошки не умеют плавать");
    }

    public void run(int run){
        if (run >= 200 || run <= 0) {
            System.out.println("Кошки не могут столько пробежать");
        } else System.out.println(name + " пробежал " + run + " м");
    }


}
