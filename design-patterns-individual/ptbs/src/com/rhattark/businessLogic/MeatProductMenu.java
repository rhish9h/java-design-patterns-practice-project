package com.rhattark.businessLogic;

import com.rhattark.gui.GUIOuterRectangle;

import javax.swing.*;
import java.awt.*;

public class MeatProductMenu implements ProductMenu {
    Facade facade;

    @Override
    public void showMenu() {
        facade = Facade.getInstance();
        Person person = facade.getThePerson();
        ProductMenu productMenu = person.createProductMenu("meat");

        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(null);
        menuPanel.setBounds(new GUIOuterRectangle());
        menuPanel.setBackground(Color.decode("#e0e0e0"));
        menuPanel.add(getHeading());
        facade.getGui().setContentPane(menuPanel);
    }

    private JLabel getHeading() {
        JLabel heading = new JLabel("Meat Product Menu");
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

    }

    @Override
    public void showLabels() {

    }

    @Override
    public void showComboxes() {

    }
}
