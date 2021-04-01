package ru.geekbrains.march.chat.server;

import java.sql.*;

public class Database {
    private static Connection connection;
    private static Statement stmt;
    private static PreparedStatement createUserStatement;
    private static PreparedStatement changeUserNicknameStatement;
    private static PreparedStatement deleteUserStatement;

    public static boolean connect(){
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:mydatabase.db");
            System.out.println("Соединение с базой данных");
            stmt = connection.createStatement();
//            createUserTable();
            prepareAllStatement();
            return true;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static void disconnect(){
        try {
            stmt.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    public static void createUserTable() throws SQLException {
//        stmt.executeUpdate("CREATE TABLE IF NOT EXISTS users (" + "id INTEGER PRIMARY KEY AUTOINCREMENT" +
//                " NOT NULL" + "UNIQUE," +
//                "login    TEXT   UNIQUE " +
//                "NOT NULL," +
//                "password TEXT    NOT NULL," +
//                "UNIQUE," +
//                "nickname TEXT   UNIQUE " +
//                "NOT NULL" + ");"
//        );
//
//    }

    public static void prepareAllStatement() throws SQLException{
        createUserStatement = connection.prepareStatement("insert into users(login, password, nickname) values(?, ?, ?);");
        changeUserNicknameStatement = connection.prepareStatement("update users set nickname = ? where nickname = ?;");
        deleteUserStatement = connection.prepareStatement("delete from users where login = ?;");

    }
    public static boolean createUser(String login, String password, String nickname) {
        try {
            createUserStatement.setString(1, login);
            createUserStatement.setString(2, password);
            createUserStatement.setString(3, nickname);
            createUserStatement.executeUpdate();
            return true;
        } catch (SQLException e){
            return false;
        }
    }

    public static String getUserNickname(String login, String password) {

        try {
            ResultSet rs = stmt.executeQuery("select nickname from users where login = '" + login + "' and password = '" + password + "';");
            if (rs.next()) {
                return rs.getString("nickname");
            }
            return null;
        } catch (SQLException throwables){
            throwables.printStackTrace();
            return null;
        }

    }

    public static boolean changeUserNickname (String currentNickname, String newNickname) {
        try {
            changeUserNicknameStatement.setString(1, newNickname);
            changeUserNicknameStatement.setString(2, currentNickname);
            changeUserNicknameStatement.executeUpdate();
            return true;
        }catch (SQLException e) {
            return false;
        }
    }

    public static boolean deleteUser (String login) {
        try {
            deleteUserStatement.setString(1, login);
            deleteUserStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

}