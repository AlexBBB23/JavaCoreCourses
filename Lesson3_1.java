package ru.bocharov.lesson3;

import java.util.Random;
import java.util.Scanner;

public class Lesson3_1 {
    static Scanner sc = new Scanner(System.in);
    static Random numbers = new Random();

    public static void main(String[] args) {
        Play();
    }
    public static void Play() {int tries3 = 0;
            int random = numbers.nextInt(9);
            System.out.println("Угадай число от 0 до 9. У тебя есть 3 попытки:");
            while (tries3 < 3) {
                int UserNumber = sc.nextInt();
                if (UserNumber > random) {
                    System.out.println("Не совсем, число чуть меньше");
                    tries3++;
                } else if (UserNumber < random) {
                    System.out.println("Не угадал, число чуть больше");
                    tries3++;
                } else if (UserNumber == random) {
                    System.out.println("Ура! Ты угадал!");
                    System.out.println("Хочешь попробовать еще раз?");
                    System.out.println("Если да, то жми 1, а если нет, то 2");
                    int UserData = sc.nextInt();
                    if (UserData == 1) {
                        main(null);
                    } else System.out.println("Очень жаль! Всего хорошего!");
                    break;
                }

                if (tries3 == 3) {
                    System.out.println("К сожалению, попытки закончились. Может начать игру заново?");
                    System.out.println("Если да, то жми 1, а если нет, то 2");
                    int UserData = sc.nextInt();
                    if (UserData == 1) {
                        main(null);
                    } else System.out.println("Очень жаль! Всего хорошего!");
                }
            }

        }

    }
