package ru.geekbrains.march.chat.server;


public class DatabaseAuth implements AuthenticationProvider {

    @Override
    public String getNickname(String login, String password) {
        return Database.getUserNickname(login, password);
    }

    @Override
    public boolean changeNickname(String oldNickname, String newNickname) {
        return Database.changeUserNickname(oldNickname, newNickname);
    }
}
