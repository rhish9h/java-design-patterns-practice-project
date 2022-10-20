package com.rhattark.businessLogic;

import com.rhattark.util.FileManager;

import java.io.IOException;
import java.util.List;

public class Login {
    String username;
    String password;
    int userType;

    public Login(String username, String password, int userType) {
        this.username = username;
        this.password = password;
        this.userType = userType;
    }

    public boolean login() throws IOException {
        FileManager fileManager = FileManager.getInstance();
        String filePath = userType == 0 ? "BuyerInfo.txt" : "SellerInfo.txt";
        // this can be replaced with map retrieval instead of list,
        // but real application should fetch from db/ldap server anyway
        List<String[]> users = fileManager.readKeyValuesFrom(filePath);

        for (String[] keyVal : users) {
            String user = keyVal[0];
            String pass = keyVal[1];

            if (user.equals(username) && pass.equals(password)) {
                return true;
            }
        }

        return false;
    }
}
