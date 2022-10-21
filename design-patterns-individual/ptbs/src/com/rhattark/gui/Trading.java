package com.rhattark.gui;

import com.rhattark.businessLogic.Facade;
import com.rhattark.businessLogic.ListIterator;
import com.rhattark.businessLogic.NodeVisitor;
import com.rhattark.businessLogic.OfferingList;
import com.rhattark.util.FileManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Panel that displays the list of all traders depending on the logged in user
 * If logged in user is buyer, this will show sellers for the selected product
 * If logged in user is seller, this will show buyers for the selected product
 * @Pattern Visitor - Node visitor will visit this class to access the offering list
 */
public class Trading extends JPanel {
    Facade facade = Facade.getInstance();
    OfferingList offeringList;

    /**
     * Path for visitor to access this object
     * @param visitor
     */
    public void accept(NodeVisitor visitor) {
        ListIterator listIterator = offeringList.getIterator();

        while (listIterator.hasNext()) {
            String value = (String)(listIterator.next());
            visitor.visitOffer(value);
        }
    }

    public Trading() throws IOException {
        setLayout(null);
        setBounds(new GUIOuterRectangle());
        setBackground(Color.decode("#e0e0e0"));
        facade.createOfferingList();
        offeringList = facade.getOfferingList();
        showHeading();
        showTraders();
    }

    /**
     * Displays heading at the top of the panel
     */
    private void showHeading() {
        int userType = facade.getUserType();
        String product = facade.getTheSelectedProduct().getProduct();
        String label = userType == 0 ? "Choose sellers selling product: " +
                product : "Choose buyers wanting product: " + product;
        JLabel heading = new JLabel(label);
        heading.setBounds(50, 10, 300, 30);
        add(heading);
    }

    /**
     * Displays the list of all traders depending on the logged in user
     */
    private void showTraders() {
        ListIterator listIterator = offeringList.getIterator();
        int y = 50;
        int userType = facade.getUserType();
        String product = facade.getTheSelectedProduct().getProduct();
        FileManager fileManager = FileManager.getInstance();

        while (listIterator.hasNext()) {
            JRadioButton trader = new JRadioButton((String)(listIterator.next()));
            trader.setBounds(50, y, 300, 30);
            String traderName = facade.getThePerson().getName();

            ActionListener actionListener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (userType == 0) {
                        JOptionPane.showMessageDialog(facade.getGui(), "Buying: " + product
                                + " by: " + traderName);
                    } else {
                        JOptionPane.showMessageDialog(facade.getGui(), "Selling: " + product
                                + " by: " + traderName);
                    }

                    try {
                        String toAppend = traderName+":"+product;
                        fileManager.appendStringToFile(toAppend, "UserProduct.txt");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }

                    try {
                        facade.remind();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }

                    System.exit(0);
                }
            };
            trader.addActionListener(actionListener);
            add(trader);

            y += 40;
        }
    }
}
