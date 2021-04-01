package ru.geekbrains.march.chat.server;

public interface AuthenticationProvider {
    String getNickname(String login, String password);
    boolean changeNickname(String currentNickname, String newNickname);
}
