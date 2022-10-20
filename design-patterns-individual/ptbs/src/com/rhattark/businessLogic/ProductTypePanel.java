package com.rhattark.businessLogic;

import com.rhattark.gui.GUI;
import com.rhattark.gui.GUIOuterRectangle;

import javax.swing.*;
import java.awt.*;

public class ProductTypePanel extends JPanel {

    private GUI gui;
    private JPanel nextPanel;
    Facade facade = Facade.getInstance();
    int userType = 0;

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public ProductTypePanel(GUI gui, JPanel nextPanel) {
        this.gui = gui;
        this.nextPanel = nextPanel;

        setLayout(null);
        setBounds(new GUIOuterRectangle());
        setBackground(Color.decode("#e0e0e0"));
        showHeading();
    }

    public void showHeading() {
        JLabel heading = new JLabel("Hi! What is the product type you choose?");
        heading.setBounds(50, 10, 300, 30);
        add(heading);
    }
}
