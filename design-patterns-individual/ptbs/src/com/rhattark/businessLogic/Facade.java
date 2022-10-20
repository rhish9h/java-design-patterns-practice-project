package com.rhattark.businessLogic;

public class Facade {
    private static Facade facade;
    private int userType;
    private Product theSelectedProduct;
    private int nProductCategory;
    private ClassProductList theProductList;
    private Person thePerson;

    private Facade() {
    }

    public static Facade getInstance() {
        if (facade == null) {
            facade = new Facade();
        }
        return facade;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public boolean login(String username, String password) {

        return true;
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
