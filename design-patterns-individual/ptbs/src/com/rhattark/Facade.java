package com.rhattark;

public class Facade {
    private int userType;
    private Product theSelectedProduct;
    private int nProductCategory;
    private ClassProductList theProductList;
    private Person thePerson;
    private GUI gui;

    public Facade(GUI gui) {
        this.gui = gui;
    }

    public boolean login() {
        Login login = new Login();
        gui.add(login);
        return false;
    }

    public void addTrading() {

    }

    public void viewTrading() {

    }

    public void decideBidding() {

    }

    public void discussBidding() {

    }

    public void submitBidding() {

    }

    public void remind() {

    }

    public void createUser(UserInfoItem userInfoItem) {

    }

    public void createProductList() {

    }

    public void attachProductToUser() {

    }

    public Product selectProduct() {
        return null;
    }

    public void productOperation() {

    }
}
