package com.rhattark.businessLogic;

import com.rhattark.gui.MeatProductMenu;
import com.rhattark.gui.ProduceProductMenu;

import java.io.IOException;

/**
 * Buyer class
 * @Pattern Bridge - concrete part of Person - ProductMenu bridge
 * @Pattern Factory - creates different product menu depending on category
 */
public class Buyer extends Person {

    private final int MEAT = 0;
    private final int PRODUCE = 1;

    /**
     * Shows the menu from the Person it is extending
     * @throws IOException
     */
    public void showMenu() throws IOException {
        this.theProductMenu.showMenu();
    }

    /**
     * Displays product menu depending on category - meat / produce
     * @param meat
     * @return product menu panel
     */
    public ProductMenu createProductMenu(String meat) {
        Facade facade = Facade.getInstance();

        if (facade.getnProductCategory() == MEAT) {
            return new MeatProductMenu();
        } else {
            return new ProduceProductMenu();
        }
    }
}
