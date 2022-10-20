package com.rhattark.businessLogic;

import java.io.IOException;

public class Buyer extends Person {
    public void showMenu() throws IOException {
        this.theProductMenu.showMenu();
    }

    public ProductMenu createProductMenu(String meat) {
        return null;
    }
}
