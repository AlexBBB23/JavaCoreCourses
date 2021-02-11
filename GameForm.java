package ru.gb.bocharov.lesson8;

import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.concurrent.Flow;

public class GameForm extends JFrame {


    int number = (int) (Math.random() * ((11 - 1) + 1)) + 1;

    private GameField gameField;

    public GameForm() {
        this.setTitle("Угадай число");
        this.setBounds(600, 400, 700, 600);
        this.setResizable(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JTextArea textArea = new JTextArea();
        this.add(textArea, BorderLayout.NORTH);


        JPanel northPanel = new JPanel(new FlowLayout());
        this.add(northPanel, BorderLayout.CENTER);
        for (int i = 1; i <= 10; i++) {
            JButton button = new JButton(String.valueOf(i));
            northPanel.add(button);

            int check = i;
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int tries = 0;

                    if (check == number) {
                        textArea.append("Ты победил" + '\n');
                    } else if (check > number) {
                        textArea.append("Бери меньше" + '\n');
                        tries++;
                    } else if (check < number) {
                        textArea.append("Бери больше" + '\n');
                        tries++;
                    }
                    if (tries == 3) {
                        textArea.append("Попытки кончились.ВСЕ-ГО ХО-РО-ШЕ-ГО");
                    }
                }
            });
        }


        JPanel bottomPanel = new JPanel(new FlowLayout());
        this.add(bottomPanel, BorderLayout.SOUTH);
        Button btnStart = new Button("Start New Game");
        Button btnExit = new Button("Exit Game");
        bottomPanel.add(btnStart);
        bottomPanel.add(btnExit);

        setVisible(true);


        btnStart.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        btnExit.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        btnStart.setBackground(Color.CYAN);
        btnExit.setBackground(Color.CYAN);


        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setVisible(false);
                main(null);

            }
        });
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);

            }
        });

        this.setVisible(true);
    }
    public static void main(String[] args) {
        GameForm gameForm = new GameForm();
    }
}





