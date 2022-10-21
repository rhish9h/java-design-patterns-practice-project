package com.rhattark.gui;

import com.rhattark.businessLogic.Facade;

import javax.swing.*;
import java.awt.*;

public class Traders extends JPanel {
    Facade facade = Facade.getInstance();

    public Traders() {
        setLayout(null);
        setBounds(new GUIOuterRectangle());
        setBackground(Color.decode("#e0e0e0"));
        showHeading();
    }

    private void showHeading() {
        int userType = facade.getUserType();
        String product = facade.getTheSelectedProduct().getProduct();
        String label = userType == 0 ? "Choose sellers selling product: " +
                product : "Choose buyers wanting product: " + product;
        JLabel heading = new JLabel(label);
        heading.setBounds(50, 10, 300, 30);
        add(heading);
    }
}
