package ru.gb.bocharov.lesson7;

public class Cat {
    private String name;
    private int appetite;
    private boolean hungry;


    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.hungry = true;
    }
    public void eat(Plate p) {
        if (p.decreaseFood(appetite)) {
            hungry = false;
        }

        }
        public void info (){
            String isHungry = !hungry ? "сыт" : "голоден";
            System.out.println(name + ": " + isHungry);
        }

    }




