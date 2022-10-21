package com.rhattark.businessLogic;

import com.rhattark.gui.Trading;

public class ReminderVisitor extends NodeVisitor {
    private Reminder m_Reminder;

    @Override
    public void visitTrading(Trading trading) {
        System.out.print("Visiting offers in Trading Offer list => ");
        trading.accept(this);
        System.out.println();
    }

    @Override
    public void visitFacade(Facade facade) {
        System.out.print("Visiting products in the product list of facade => ");
        ClassProductList productList = facade.getTheProductList();
        ListIterator listIterator = productList.getIterator();

        while (listIterator.hasNext()) {
            System.out.print(listIterator.next() + " : ");
        }

        System.out.println();
    }

    @Override
    public void visitOffer(String value) {
        System.out.print(value + " : ");
    }
}
