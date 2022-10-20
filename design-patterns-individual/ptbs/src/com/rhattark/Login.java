package com.rhattark;

import javax.swing.*;
import java.awt.*;

public class Login extends JPanel {
    public Login() {
        setLayout(null);
        setBounds(50, 70, 400, 250);
        setBackground(Color.decode("#e0e0e0"));
        showHeading();
        showLoginForm();
    }

    private void showHeading() {
        JLabel heading = new JLabel("Login");
        heading.setBounds(180, 10, 100, 30);
        add(heading);
    }

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

    private JLabel getUsername() {
        JLabel username = new JLabel("Username: ");
        username.setBounds(50, 10, 100, 30);
        return username;
    }

    private JTextField getUsernameInput() {
        JTextField usernameInput = new JTextField();
        usernameInput.setBounds(130, 10, 200, 30);
        return usernameInput;
    }

    private JLabel getPassword() {
        JLabel password = new JLabel("Password: ");
        password.setBounds(50, 50, 100, 30);
        return password;
    }

    private JTextField getPasswordInput() {
        JTextField passwordInput = new JTextField();
        passwordInput.setBounds(130, 50, 200, 30);
        return passwordInput;
    }

    private JButton getSubmit() {
        JButton submit = new JButton("Login");
        submit.setBounds(150, 120, 100, 30);
        return submit;
    }
}
