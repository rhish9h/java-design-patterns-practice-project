package com.rhattark;

import javax.swing.*;

public class GUI extends JFrame {

    Facade facade;

    public GUI() {
        setSize(500, 400);

        addHeading();
        facade = new Facade(this);

        facade.login();
        setLayout(null);
        setVisible(true);
    }

    private void addHeading() {
        JLabel heading = new JLabel("Product Trading and Bidding System");
        heading.setBounds(140, 20, 300, 30);
        add(heading);
    }
}
