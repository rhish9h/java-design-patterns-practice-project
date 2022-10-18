package com.rhattark;

public abstract class Person {
    ProductMenu theProductMenu;

    public abstract void showMenu();
    public void showAddButton() {}
    public void showViewButton() {}
    public void showRadioButton() {}
    public void showLabels() {}
    public abstract ProductMenu createProductMenu();
}
