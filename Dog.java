package ru.gb.bocharov.lesson6;

public class Dog extends Animal {

    public Dog(String name) {
        this.name = name;
    }

    public void swim(int swim){
        if (swim >= 10 || swim <= 0) {
            System.out.println("Собаки не могут столько проплыть");
        } else System.out.println(name + " проплыл " + swim + " м");
    }

    public void run(int run){
        if (run >= 500 || run <= 0) {
            System.out.println("Собаки не могут столько пробежать");
        } else System.out.println(name + " пробежал " + run + " м");
    }
}
