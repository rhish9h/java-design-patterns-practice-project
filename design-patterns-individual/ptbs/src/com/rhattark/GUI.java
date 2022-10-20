package com.rhattark;

import javax.swing.*;

public class GUI extends JFrame {
    public GUI() {
        setSize(500, 400);
        setLayout(null);
        setVisible(true);

        add(getHeading());
    }

    private JLabel getHeading() {
        JLabel heading = new JLabel("Product Trading and Bidding System");
        heading.setBounds(140, 30, 300, 30);
        return heading;
    }
}
