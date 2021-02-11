package ru.gb.bocharov.lesson8;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameField extends JPanel {
    private final int CELL_SIZE = 120;


    private boolean isGameOn;


    public GameField(){
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (isGameOn) {
                    if (e.getButton() == MouseEvent.BUTTON1) {
                        int cellX = e.getX() / CELL_SIZE;
                        int cellY =  e.getY() / CELL_SIZE;
                    }
                }

            }
        });
    }


    }



