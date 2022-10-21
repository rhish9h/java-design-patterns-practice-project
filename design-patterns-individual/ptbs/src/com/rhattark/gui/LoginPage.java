package com.rhattark.gui;

import com.rhattark.businessLogic.Facade;
import com.rhattark.businessLogic.ProductTypePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * UI page for login
 */
public class LoginPage extends JPanel {

    GUI gui;
    JPanel success;
    Facade facade;
    JTextField usernameInput;
    JPasswordField passwordInput;

    public LoginPage(GUI gui, JPanel success) {
        this.gui = gui;
        this.success = success;
        facade = Facade.getInstance();

        setLayout(null);
        setBounds(new GUIOuterRectangle());
        setBackground(Color.decode("#e0e0e0"));
        showHeading();
        showLoginForm();
    }

    /**
     * Displays heading at the top of the panel
     */
    private void showHeading() {
        JLabel heading = new JLabel("Login");
        heading.setBounds(180, 10, 100, 30);
        add(heading);
    }

    /**
     * Shows the login form
     */
    private void showLoginForm() {
        JPanel loginForm = new JPanel();
        loginForm.setLayout(null);
        loginForm.setBounds(0, 50, 400, 200);
        loginForm.setBackground(Color.decode("#e0e0e0"));
        loginForm.add(getUsername());
        loginForm.add(getUsernameInput());
        loginForm.add(getPassword());
        loginForm.add(getPasswordInput());
        loginForm.add(getSubmit());
        add(loginForm);
    }

    /**
     * Get username label
     * @return username label
     */
    private JLabel getUsername() {
        JLabel username = new JLabel("Username: ");
        username.setBounds(50, 10, 100, 30);
        return username;
    }

    /**
     * Get text field for username input
     * @return user input text field
     */
    private JTextField getUsernameInput() {
        usernameInput = new JTextField();
        usernameInput.setBounds(130, 10, 200, 30);
        return usernameInput;
    }

    /**
     * Get the label for password
     * @return password label
     */
    private JLabel getPassword() {
        JLabel password = new JLabel("Password: ");
        password.setBounds(50, 50, 100, 30);
        return password;
    }

    /**
     * Get the password field for getting password
     * @return password field
     */
    private JPasswordField getPasswordInput() {
        passwordInput = new JPasswordField();
        passwordInput.setBounds(130, 50, 200, 30);
        return passwordInput;
    }

    /**
     * Get the submit button, redirects to success page on success
     * Shows error message popup on error
     * @return submit button
     */
    private JButton getSubmit() {
        JButton submit = new JButton("Login");
        submit.setBounds(150, 120, 100, 30);
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameInput.getText();
                String password = new String(passwordInput.getPassword());

                try {
                    if (facade.login(username, password)) {
                        gui.setContentPane(success);
                    } else {
                        JOptionPane.showMessageDialog(gui, "Username or password is incorrect.");
                    }
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(gui, "IOException occurred. Database files not loading.");
                }
            }
        };
        submit.addActionListener(actionListener);
        return submit;
    }
}
