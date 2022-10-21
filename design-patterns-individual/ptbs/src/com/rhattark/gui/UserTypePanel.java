package com.rhattark.gui;

import com.rhattark.businessLogic.Facade;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Panel that allows user to choose whether they are buyer or seller
 */
public class UserTypePanel extends JPanel {
    GUI gui;
    JPanel nextPanel;

    public UserTypePanel(GUI gui, JPanel nextPanel) {
        this.gui = gui;
        this.nextPanel = nextPanel;
        setLayout(null);
        setBounds(new GUIOuterRectangle());
        setBackground(Color.decode("#e0e0e0"));
        showHeading();
        showOptions();
    }

    /**
     * Displays heading at the top of the panel
     */
    private void showHeading() {
        JLabel heading = new JLabel("Are you a buyer or seller?");
        heading.setBounds(50, 50, 300, 30);
        add(heading);
    }

    /**
     * Displays all the options for selecting user type
     */
    private void showOptions() {
        JRadioButton buyer = new JRadioButton("Buyer");
        buyer.setBounds(50, 100, 100, 30);
        JRadioButton seller = new JRadioButton("Seller");
        seller.setBounds(50, 150, 100, 30);

        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Facade facade = Facade.getInstance();
                if (buyer.isSelected()) {
                    facade.setUserType(0);
                } else {
                    facade.setUserType(1);
                }
                gui.setContentPane(nextPanel);
            }
        };

        buyer.addActionListener(actionListener);
        seller.addActionListener(actionListener);

        add(buyer);
        add(seller);
    }
}
