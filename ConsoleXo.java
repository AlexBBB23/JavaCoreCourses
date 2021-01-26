package ru.geekbrains.bocharov.lesson4;

import java.util.Random;
import java.util.Scanner;

public class ConsoleXo {
    public static int SIZE = 3;
    public static final char DOT_PLAYER = 'X';
    public static final char DOT_AI = 'O';
    public static final char DOT_EMPTY = '*';
    public static char map[][];
    public static Scanner sc =new Scanner(System.in);
    public static Random random = new Random();


    public static void main(String[] args) {
        initMap();
        printMap();
    while (true) {
        playerTurn();
        printMap();
        if (checkWin(DOT_PLAYER)) {
            System.out.println("Победил игрок!");
            break;
        }
        if (isMapFull()) {
            System.out.println("Ничья");
            break;
        }

        aiTurn();
        printMap();
        if (checkWin(DOT_AI)) {
            System.out.println("Победил ИИ!");
            break;
        }
        if (isMapFull()) {
            System.out.println("Ничья");
            break;
        }


    }
        System.out.println("Игра завершена");

    }
    public static boolean checkWin(char dot) {
        for (int i = 0; i < 3; i++)
            if ((map[i][0] == dot && map[i][1] == dot &&
                    map[i][2] == dot) ||
                    (map[0][i] == dot && map[1][i] == dot &&
                            map[2][i] == dot))
                return true;
        if ((map[0][0] == dot && map[1][1] == dot &&
                map[2][2] == dot) ||
                (map[2][0] == dot && map[1][1] == dot &&
                        map[0][2] == dot))
            return true;
        return false;
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if ((map[i][j] == DOT_EMPTY)){
                    return false; }

            }
        }
        return true;
    }
    public static void aiTurn(){
        int x,y;
        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (!isCellEmpty(x, y));
        map[x][y] = DOT_AI;
        System.out.printf("Ход ИИ: [%d, %d]\n", x+1,y+1);
    }
    public static void playerTurn(){
        int x, y;
        do {
            System.out.println("Укажите координаты хода в формате [x y]");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellEmpty(x, y));
        map[x][y] = DOT_PLAYER;
    }
    public static boolean isCellEmpty (int x, int y) {
        if (x<0 || x>= SIZE || y<0 || y>= SIZE) {
            return false;
        }
        if (map[x][y] == DOT_EMPTY) {
            return true;
        }
        return false;
    }
    public static void initMap() {
        map = new char [SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }
    public static void printMap() {
        System.out.print("  ");
        for (int i = 1; i <=SIZE ; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i+1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[j][i] + " ");

            }
            System.out.println();
        }
    }
}
