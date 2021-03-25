package ru.gb.bocharov.lesson31;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        //Задача 1
        String[] arr = {"ab", "ac", "ad", "ae"};
        System.out.println(Arrays.toString(arr));
        swap(arr, 2, 3);
        System.out.println(Arrays.toString(arr));

        //Задача 2

        List<String> list = convertToList(arr);
        System.out.println(list.getClass()+ ": " + list);


        //Задача с фруктами
        
        Orange orange = new Orange();
        Apple apple = new Apple();
        Box<Orange> orangeBox1 = new Box();
        Box<Orange> orangeBox2 = new Box();
        Box<Apple> appleBox = new Box();
        orangeBox1.add(new Orange());
        orangeBox1.add(new Orange());
        orangeBox1.add(new Orange());
        for (int i = 0; i < 4; i++) {
            orangeBox2.add(new Orange());
        }
        for (int i = 0; i < 6; i++) {
            appleBox.add(new Apple());
        }
        orangeBox1.info();
        orangeBox2.info();
        appleBox.info();

        Float orange1Weight = orangeBox1.getWeight();
        Float orange2Weight = orangeBox2.getWeight();
        Float appleWeight = appleBox.getWeight();
        System.out.println("Вес первой коробки с апельсинами: " + orange1Weight);
        System.out.println("Вес второй коробки с апельсинами: " + orange2Weight);
        System.out.println("Вес коробки с яблоками: " + appleWeight);
        System.out.println("Сравнить вес первой коробки с апельсинами с коробкой с яблоками: " + orangeBox1.compare(appleBox));
        System.out.println("Сравнить вес второй коробки с апельсинами с коробкой с яблоками: " + orangeBox2.compare(appleBox));

        orangeBox1.moveAt(orangeBox2);

        orangeBox1.info();
        orangeBox2.info();
        appleBox.info();

    }
    private static <T> void swap(T[] array, int index1, int index2){
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
    private static <E> List<E> convertToList(E[] array) {
        return Arrays.asList(array);
    }
}
