// 1. Создать массив с набором слов (10-20, должны встречаться повторяющиеся). Найти и вывести список уникальных слов
// из которых состоит массив (дубликаты не считаем). Посчитать, сколько раз встречается каждое слово.


// 2. Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и телефонных  номеров.
// В этот справочник с помощью метода add() можно добавлять записи, а с помощью метода get() искать номер телефона
// по фамилии. Следует учесть, что под одной фамилией может быть несколько телефонов (вслучае однофамильцев), тогда
// при запросе одной фамилии должны выводиться все телефоны. Консоль использовать только для вывода рез-ов проверки
// телефонного справочника
package ru.gb.bocharov.lesson23;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Task1 {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Ford");
        arrayList.add("Audi");
        arrayList.add("BMW");
        arrayList.add("Lada");
        arrayList.add("BMW");
        arrayList.add("Ford");
        arrayList.add("Chevrolet");
        arrayList.add("Jeep");
        arrayList.add("Toyota");
        arrayList.add("Lamborghini");
        arrayList.add("MacLaren");
        arrayList.add("Aston Martin");
        arrayList.add("UAZ");
        arrayList.add("Ford");
        arrayList.add("Lexus");

        Set<String> unique = new HashSet<String>(arrayList);

        System.out.println(arrayList.toString());
        System.out.println(unique.toString());
        for (String key : unique) {
            System.out.println(key + ": " + Collections.frequency(arrayList, key));
        }

    }


}
