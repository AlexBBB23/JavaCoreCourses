package ru.gb.bocharov.lesson5;



public class MainApp {

    public static void main(String[] args) {
       Employee[] employees = new Employee[5];
       employees[0] = new Employee("Бочаров Александр Сергеевич", "Директор", "alex@mail.ru", 220000, 37, "89991234567");
       employees[1] = new Employee("Семенов Владимир Дмитриевич", "Начальник департамента", "vova@mail.ru", 170000, 34, "89997654321");
       employees[2] = new Employee("Алексеев Кирилл Андреевич", "Старший маркетолог", "kirill@mail.ru", 150000, 31, "89994567890");
       employees[3] = new Employee("Жданова Светлана Сергеевна", "Аналитик", "sveta@mail.ru", 132000, 25, "89990987654");
       employees[4] = new Employee("Смирнов Антон Петрович", "PR-менеджер", "anton@mail.ru", 128000, 28, "89991230985");

        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getAge() > 30) employees[i].printInfo();

        }


        }
}
