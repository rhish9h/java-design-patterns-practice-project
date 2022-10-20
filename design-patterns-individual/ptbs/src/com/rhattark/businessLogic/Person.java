package com.rhattark.businessLogic;

import java.io.IOException;

public abstract class Person {
    ProductMenu theProductMenu;

    public abstract void showMenu() throws IOException;
    public void showAddButton() {}
    public void showViewButton() {}
    public void showRadioButton() {}
    public void showLabels() {}
    public abstract ProductMenu createProductMenu(String meat);

    public void setTheProductMenu(ProductMenu theProductMenu) {
        this.theProductMenu = theProductMenu;
    }

    public ProductMenu getTheProductMenu() {
        return theProductMenu;
    }
}
