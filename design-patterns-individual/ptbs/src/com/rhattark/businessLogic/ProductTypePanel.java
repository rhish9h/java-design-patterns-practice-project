package com.rhattark.businessLogic;

import com.rhattark.gui.GUI;
import com.rhattark.gui.GUIOuterRectangle;
import com.rhattark.gui.MeatProductMenu;
import com.rhattark.gui.ProduceProductMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ProductTypePanel extends JPanel {

    private GUI gui;
    Facade facade = Facade.getInstance();
    int userType = 0;

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public ProductTypePanel(GUI gui) {
        this.gui = gui;

        setLayout(null);
        setBounds(new GUIOuterRectangle());
        setBackground(Color.decode("#e0e0e0"));
        showHeading();
        showProductOptions();
    }

    public void showHeading() {
        JLabel heading = new JLabel("Hi! What is the product type you choose?");
        heading.setBounds(50, 10, 300, 30);
        add(heading);
    }

    public void showProductOptions() {
        JRadioButton meat = new JRadioButton("Meat");
        meat.setBounds(50, 100, 100, 30);
        JRadioButton produce = new JRadioButton("Produce");
        produce.setBounds(50, 150, 100, 30);

        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Facade facade = Facade.getInstance();
                if (meat.isSelected()) {
                    facade.setnProductCategory(0);
                    facade.getThePerson().setTheProductMenu(new MeatProductMenu());
                } else {
                    facade.setnProductCategory(1);
                    facade.getThePerson().setTheProductMenu(new ProduceProductMenu());
                }

                gui.getContentPane().removeAll();
                try {
                    facade.getThePerson().showMenu();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        };

        meat.addActionListener(actionListener);
        produce.addActionListener(actionListener);

        add(meat);
        add(produce);
    }
}
