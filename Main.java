package ru.gb.bocharov.lesson7;

public class Main {
    public static void main(String[] args) {
        Cat[] cats = {new Cat("Sema", 6 ),
                new Cat("Demon", 5),
                new Cat("George", 4),
                new Cat("Righik", 3),
                new Cat("Chak", 2)};

        Plate plate = new Plate(10);
        for (Cat cat : cats) {
            cat.eat(plate);
            plate.addFood(1);
            cat.info();
        }

    }
}

