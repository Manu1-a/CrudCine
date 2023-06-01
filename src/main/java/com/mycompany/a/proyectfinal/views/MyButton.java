package com.mycompany.a.proyectfinal.views;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;

/**
 *
 * @author Manuel Silva
 */
public class MyButton extends JButton {

    private final String title;

    public MyButton(String title) {
        this.title = title;
        init();
    }

    private void init() {
        this.setText(this.title);
        this.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
        this.setBackground(Color.LIGHT_GRAY);
        this.setForeground(Color.BLACK);
    }
}
