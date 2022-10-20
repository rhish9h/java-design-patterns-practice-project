package com.rhattark.businessLogic;

public abstract class Person {
    ProductMenu theProductMenu;

    public abstract void showMenu();
    public void showAddButton() {}
    public void showViewButton() {}
    public void showRadioButton() {}
    public void showLabels() {}
    public abstract ProductMenu createProductMenu();

    public void setTheProductMenu(ProductMenu theProductMenu) {
        this.theProductMenu = theProductMenu;
    }

    public ProductMenu getTheProductMenu() {
        return theProductMenu;
    }
}
