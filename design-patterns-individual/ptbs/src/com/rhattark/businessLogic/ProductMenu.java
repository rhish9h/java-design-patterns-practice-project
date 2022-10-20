package com.rhattark.businessLogic;

import java.io.IOException;

public interface ProductMenu {
    public abstract void showMenu() throws IOException;
    public abstract void showAddButton();
    public abstract void showViewButton();
    public abstract void showRadioButton();
    public abstract void showLabels();
    public abstract void showComboxes();
}
