package com.rhattark.gui;

import com.rhattark.businessLogic.Facade;
import com.rhattark.businessLogic.ProductTypePanel;

import javax.swing.*;

/**
 * Main GUI starter class - main jframe
 */
public class GUI extends JFrame {

    private Facade facade;

    /**
     * Display panels in the following order based on inputs -
     * user type - buyer / seller
     * login
     * product type - meat / product ...
     */
    public GUI() {
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Product Trading and Bidding System");
        facade = Facade.getInstance();
        facade.setGui(this);

        JPanel productTypePanel = getProductTypePanel();
        JPanel loginPanel = getLoginPanel(productTypePanel);
        JPanel userTypePanel = getUserTypePanel(loginPanel);

        setContentPane(userTypePanel);
        setLayout(null);
        setVisible(true);
    }

    /**
     * Fetches user type choosing form
     * @param loginPanel
     * @return user type panel
     */
    private JPanel getUserTypePanel(JPanel loginPanel) {
        UserTypePanel userTypePanel = new UserTypePanel(this, loginPanel);
        return userTypePanel;
    }

    /**
     * Fetches login page UI
     * @param success
     * @return login UI
     */
    private JPanel getLoginPanel(JPanel success) {
        LoginPage loginPanel = new LoginPage(this, success);
        return loginPanel;
    }

    /**
     * Fetches product type page UI
     * @return product type UI
     */
    private JPanel getProductTypePanel() {
        ProductTypePanel productTypePanel = new ProductTypePanel(this);
        return productTypePanel;
    }
}
