package com.rhattark.businessLogic;

import com.rhattark.gui.MeatProductMenu;
import com.rhattark.gui.ProduceProductMenu;

import java.io.IOException;

public class Buyer extends Person {

    private final int MEAT = 0;
    private final int PRODUCE = 1;
    public void showMenu() throws IOException {
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
