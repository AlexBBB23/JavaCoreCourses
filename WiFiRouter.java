package ru.gb.bocharov.lesson5;

public class WiFiRouter {
    String color;
    String manufacturer;
    boolean distribution;
    boolean switchOn;
    int internetSpeed;
    int user;
    boolean connection;

    public void routerOn(){
        switchOn = true;
        System.out.println("Роутер включен");
    }
    public void wifi(){
        if (switchOn = true) {
            distribution = true;
            System.out.println("Раздача интернета включена");

        }

    }
    public void routerOff() {
        switchOn = false;
        System.out.println("Роутер выключен");
    }

    public void trouble(){
        if (internetSpeed == 0) {
            distribution = false;
            System.out.println("Проверьте всталвен ли в роутер провод Ethernet");
        }
    }

    public void connect(){
        if (user > 8) {
            connection = false;
            System.out.println("Невозможно подключиться к сети, достигнуто максимальное количество подключений");
        } else {
            System.out.println("Подключение установлено");
        }
    }




}
