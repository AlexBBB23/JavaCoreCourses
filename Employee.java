package ru.gb.bocharov.lesson5;

public class Employee {
    private String fullName;
    private String position;
    private String email;
    private int salary;
    private int age;
    private String phoneNumber;

    public int getAge(){
        return age;
    }

    public Employee(String fullName, String position, String email, int salary, int age, String phoneNumber) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.salary = salary;
        this.age = age;
        this.phoneNumber = phoneNumber;

    }

public void printInfo() {
    System.out.printf("ФИО: %s Должность: %s Зарплата: %d\n", fullName, position, salary);
    System.out.printf("Возраст: %d Телефон: %s Email: %s\n", age, phoneNumber, email);
}

}
