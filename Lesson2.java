package ru.bocharov.lesson2;


import java.util.Arrays;

public class Lesson2 {
    public static void main(String[] args) {
        System.out.println("Задание 1");
        int[] arr1 = {1, 0, 1, 1, 0, 0, 0};
        System.out.println(Arrays.toString(arr1));
        invertArray(arr1);
        System.out.println(Arrays.toString(arr1));
        System.out.println("Задание 2");
        int[] arr2 = new int[8];
        System.out.println(Arrays.toString(arr2));
        fillArray(arr2);
        System.out.println(Arrays.toString(arr2));
        System.out.println("Задание 3");
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(arr3));
        changeArray(arr3);
        System.out.println(Arrays.toString(arr3));
        System.out.println("Задание 4");
        int[][] arr4 = new int[5][5];
        fillDiagonal(arr4);
        System.out.println("Задание 5");
        int[] arr5 = {23, 41, 4, 67, 95, 322, 45, 9, 12};
        System.out.println(Arrays.toString(arr5));
        MinAndMax(arr5);
        System.out.println("Задание 6");
        int[] arr6 = {2, 5, 8, 11, 3, 1};
        System.out.println(Arrays.toString(arr6));
        System.out.println(checkBalance(arr6));
        System.out.println("Задание 7");
        int[] arr7 = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(arr7));
        moveRight(arr7, 2);
        System.out.println(Arrays.toString(arr7));
    }
                                                               // Задание 1
    public static void invertArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                array[i] = 0;
            } else array[i] = 1;

        }
    }

                                                                // Задание 2
    public static void fillArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i * 3;
        }
    }

                                                                // Задание 3
    public static void changeArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) array[i] *= 2;
        }

    }

                                                                // Задание 4
    public static void fillDiagonal(int[][] array) {

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (array[i] == array[j] || i + j == 4) {
                    array[i][j] = 1;
                } else array[i][j] = 0;
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }

                                                                // Задание 5
    public static void MinAndMax(int[] array) {
        int max = array[0];
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
            if (min > array[i]) {
                min = array[i];
            }
        }
        System.out.println(max + " " + min);
    }

                                                                // Задание 6
    public static boolean checkBalance(int[] array){
        int a = array[0] + array[1] + array[2];
        int b = array[3] + array[4] + array[5];
        if (a-b == 0) {
            return true;
        }else return false;
    }

                                                                // Задание 7
    public static void moveRight(int[] array, int positions) {
        int size = array.length;
        for (int i = 0; i < positions; i++) {
            int temp = array[size - 1];
            for (int j = size - 1; j > 0; j--) {
                array[j] = array[j - 1];
            }
            array[0] = temp;
        }
    }
}








