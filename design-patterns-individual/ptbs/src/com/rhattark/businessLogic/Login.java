package com.rhattark.businessLogic;

import com.rhattark.util.FileManager;

import java.io.IOException;
import java.util.List;

/**
 * Business logic side of the login class
 * Performs checks with the db/text file to authenticate user
 */
public class Login {
    private String username;
    private String password;
    private int userType;
    private final int BUYER = 0;
    private final int SELLER = 1;
    private Facade facade;

    public Login(String username, String password, int userType) {
        this.username = username;
        this.password = password;
        this.userType = userType;
        facade = Facade.getInstance();
    }

    /**
     * Authenticate user
     * @return boolean
     * @throws IOException
     */
    public boolean login() throws IOException {
        FileManager fileManager = FileManager.getInstance();
        String filePath = userType == BUYER ? "BuyerInfo.txt" : "SellerInfo.txt";
        // this can be replaced with map retrieval instead of list,
        // but real application should fetch from db/ldap server anyway
        List<String[]> users = fileManager.readKeyValuesFrom(filePath);

        for (String[] keyVal : users) {
            String user = keyVal[0];
            String pass = keyVal[1];

            if (user.equals(username) && pass.equals(password)) {
                Person person;

                if (userType == BUYER) {
                    person = new Buyer();
                } else {
                    person = new Seller();
                }

                person.setName(username);
                facade.setThePerson(person);
                return true;
            }
        }

        return false;
    }
}
