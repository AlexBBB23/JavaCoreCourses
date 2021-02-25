package ru.gb.bocharov.lesson23;

public class Task2 {
    public static void main(String[] args) {
        Phonebook book = new Phonebook();
        book.addContact("Semenov", "1234");
        book.addContact("Avdeev", "2345");
        book.addContact("Avdeev", "3456");
        book.addContact("Bazarov", "4567");
        book.addContact("Andropov", "5678");
        book.addContact("Makarov", "6789");
        book.addContact("Semenov", "7890");


        book.getContact("Semenov");
        book.getContact("Andropov");
        book.getContact("Avdeev");

    }

}
