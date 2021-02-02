package ru.gb.bocharov.lesson7;

public class Plate {
    private int food;
    public Plate(int food) {
        this.food = food;
    }
    boolean decreaseFood(int n) {
        int remainder = food - n;
        if (remainder < 0) {
            System.out.println("Коту не хватило еды");
            return false;}
        food -= n;
        return true;
    }
    public void info() {
        System.out.println("plate: " + food);
    }
    public void addFood(int food){
        this.food += food;
    }

}
