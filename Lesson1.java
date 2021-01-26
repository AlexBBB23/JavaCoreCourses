package ru.geekbrains.lesson1;   // Домашнее задание ученика Бочарова Александра

public class Lesson1 {
    public static void main(String[] args) {      // Задание 1
    int f1 = 34;                                  // Задание 2
    byte f2 = 5;
    short f3 = 31;
    long f4 = 2314553322L;
    float f5 = 213.2f;
    double f6 = 214.2314;
    char f7 = 'x';
    boolean f8 = true;
        System.out.println(calculate(1.3f, 5.2f, 9.3f, 3.1f));      // Задание 3
        System.out.println(task10and20(21, 6));                                 // Задание 4
        isPositiveOrNegative(-94);                                           // Задание 5
        System.out.println(isNegative(-65));                                 // Задание 6
        greetings("Аркаша");                                              // Задание 7
        LeapYear(2020);                                                         // Задание 8
    }
    public static float calculate (float a, float b, float c, float d) {
        return a * (b + (c/d));
    }
    public static boolean task10and20 (int x1, int x2){
        int sum = x1 + x2;
        if (sum > 10 && sum < 20) return true;
        else return false;
    }
    public static void isPositiveOrNegative(int q) {
        if (q>=0) {
            System.out.println(q + " is positive");
        }
          else   System.out.println(q + " is negative");
        }
        public static boolean isNegative (int x) {
        if (x<0) return true;
        else return false;
        }
        public static void greetings (String name) {
            System.out.println("Привет, " + name + "!");
        }
        public static void LeapYear (int year) {
        if (!(year %  4 == 0) || ((year % 100 == 0) && !(year % 400 == 0)))
            System.out.println(year + " г. - не високосный");
        else System.out.println(year + "г. - високосный");
        }
    }


