package com.rhattark.gui;

import com.rhattark.businessLogic.Facade;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {

    private Facade facade;

    public GUI() {
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Product Trading and Bidding System");
        facade = Facade.getInstance();
        JPanel test = new JPanel();
        test.setBounds(new GUIOuterRectangle());
        test.setBackground(Color.decode("#e0e0e0"));
        JPanel loginPanel = getLoginPanel(test);
        JPanel userTypePanel = getUserTypePanel(loginPanel);

        setContentPane(userTypePanel);
        setLayout(null);
        setVisible(true);
    }

    private JPanel getUserTypePanel(JPanel loginPanel) {
        UserTypePanel userTypePanel = new UserTypePanel(this, loginPanel);
        return userTypePanel;
    }

    //TODO create login failure page
    private JPanel getLoginPanel(JPanel success) {
        LoginPage loginPanel = new LoginPage(this, success);
        return loginPanel;
    }
}
