package ru.bocharov.lesson3;

import java.util.Random;
import java.util.Scanner;

public class Lesson3_2 {
    public static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
                "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom",
                "nut", "olive", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

        String guess = getRandomWord(words);
        String maskedGuess = maskWord(guess);
        System.out.println("Привет! Попробуй угадать слово!");
        while (true) {
            String MyWord = sc.nextLine();
            MyWord = maskWord(MyWord);
            if (maskedGuess.equals(MyWord)) {
                System.out.println("Ты победил, это слово - " + guess + ", поздравляю!");
                break;
            } else {
                String maskedResult = "";
                for (int i = 0; i < maskedGuess.length(); i++) {
                    if (maskedGuess.charAt(i) == MyWord.charAt(i)) maskedResult += maskedGuess.charAt(i);
                    else maskedResult += "#";
                }
                System.out.println(maskedResult);
                System.out.println("Неправильно! Попробуй снова!");
            }
        }
    }
    public static String getRandomWord(String[] s) {
        Random r = new Random();
        return s[r.nextInt(s.length - 1)];
    }
    public static String maskWord(String s) {
        String mask = "###############";
        for (int i = s.length() - 1; i < mask.length() - 1; i++) {
            s += mask.charAt(i);
        }
return s;
    }
}
