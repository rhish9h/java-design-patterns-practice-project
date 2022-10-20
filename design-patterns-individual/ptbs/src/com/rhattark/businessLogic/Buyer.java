package com.rhattark.businessLogic;

public class Buyer extends Person {
    public void showMenu() {
        this.theProductMenu.showMenu();
    }

    public ProductMenu createProductMenu(String meat) {
        return null;
    }
}
