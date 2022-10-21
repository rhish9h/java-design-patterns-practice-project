package com.rhattark.gui;

import com.rhattark.businessLogic.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ProduceProductMenu implements ProductMenu {

    Facade facade;
    JPanel menuPanel;
    ButtonGroup buttonGroup;

    @Override
    public void showMenu() throws IOException {
        facade = Facade.getInstance();
        Person person = facade.getThePerson();
        ProductMenu productMenu = person.createProductMenu("produce");

        menuPanel = new JPanel();
        menuPanel.setLayout(null);
        menuPanel.setBounds(new GUIOuterRectangle());
        menuPanel.setBackground(Color.decode("#e0e0e0"));
        menuPanel.add(getHeading());

        facade.createProductList();
        showRadioButton();
        showViewButton();

        facade.getGui().setContentPane(menuPanel);
    }

    private JLabel getHeading() {
        JLabel heading = new JLabel("Produce Product Menu");
        heading.setBounds(130, 0, 200, 30);
        return heading;
    }

    @Override
    public void showAddButton() {

    }

    @Override
    public void showViewButton() {

    }

    @Override
    public void showRadioButton() {
        ListIterator productsIterator = facade.getTheProductList().getIterator();
        int y = 50;
        buttonGroup = new ButtonGroup();

        while (productsIterator.hasNext()) {
            JRadioButton product = new JRadioButton((String)(productsIterator.next()));
            product.setBounds(50, y, 300, 30);
            ActionListener actionListener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    facade.setTheSelectedProduct(new Product(product.getText()));
                    try {
                        facade.getGui().setContentPane(new Trading());
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            };
            product.addActionListener(actionListener);
            buttonGroup.add(product);
            menuPanel.add(product);
            y += 40;
        }
    }

    @Override
    public void showLabels() {

    }

    @Override
    public void showComboxes() {

    }
}
