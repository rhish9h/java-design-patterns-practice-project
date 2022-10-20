package com.rhattark.businessLogic;

public class ProduceProductMenu implements ProductMenu {
    @Override
    public void showMenu() {
        Facade facade = Facade.getInstance();
        Person person = facade.getThePerson();
        ProductMenu productMenu = person.createProductMenu("produce");
        // display product menu here
    }

    @Override
    public void showAddButton() {

    }

    @Override
    public void showViewButton() {

    }

    @Override
    public void showRadioButton() {

    }

    @Override
    public void showLabels() {

    }

    @Override
    public void showComboxes() {

    }
}
