package com.rhattark.businessLogic;

import com.rhattark.gui.GUI;

import java.io.IOException;

public class Facade {
    private final int BUYER = 0;
    private final int SELLER = 1;
    private static Facade facade;
    private int userType = BUYER;
    private Product theSelectedProduct;
    private int nProductCategory;
    private ClassProductList theProductList;
    private OfferingList offeringList;
    private Person thePerson;
    private GUI gui;

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

    public int getUserType() {
        return userType;
    }

    public void setGui(GUI gui) {
        this.gui = gui;
    }

    public GUI getGui() {
        return gui;
    }

    public void setnProductCategory(int productCategory) {
        nProductCategory = productCategory;
    }

    public int getnProductCategory() {
        return nProductCategory;
    }

    public void setThePerson(Person person) {
        this.thePerson = person;
    }

    public Person getThePerson() {
        return thePerson;
    }

    public void setTheProductList(ClassProductList theProductList) {
        this.theProductList = theProductList;
    }

    public ClassProductList getTheProductList() {
        return theProductList;
    }

    public void setTheSelectedProduct(Product product) {
        this.theSelectedProduct = product;
    }

    public Product getTheSelectedProduct() {
        return theSelectedProduct;
    }

    public void setOfferingList(OfferingList offeringList) {
        this.offeringList = offeringList;
    }

    public OfferingList getOfferingList() {
        return offeringList;
    }

    public boolean login(String username, String password) throws IOException {
        Login login = new Login(username, password, userType);
        return login.login();
    }

    public void remind() throws IOException {
        System.out.println("Remind called");
        Reminder reminder = new Reminder();
        reminder.remind();
    }

    public void createProductList() throws IOException {
        ProductListBuilder productListBuilder = new ProductListBuilder();
        setTheProductList(productListBuilder.buildProductList(facade.nProductCategory));
    }

    public void createOfferingList() throws IOException {
        OfferingListBuilder offeringListBuilder = new OfferingListBuilder();
        setOfferingList(offeringListBuilder.buildOfferingList());
    }
}
