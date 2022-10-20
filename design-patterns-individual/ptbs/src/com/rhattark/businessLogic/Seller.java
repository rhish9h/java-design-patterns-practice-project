package com.rhattark.businessLogic;

public class Seller extends Person {
    private final int MEAT = 0;
    private final int PRODUCE = 1;

    public void showMenu() {
        this.theProductMenu.showMenu();
    }

    public ProductMenu createProductMenu(String meat) {
        Facade facade = Facade.getInstance();

        if (facade.getnProductCategory() == MEAT) {
            return new MeatProductMenu();
        } else {
            return new ProduceProductMenu();
        }
    }
}
