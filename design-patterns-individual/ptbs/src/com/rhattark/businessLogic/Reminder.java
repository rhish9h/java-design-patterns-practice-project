package com.rhattark.businessLogic;

import com.rhattark.gui.Trading;

import java.io.IOException;

public class Reminder {
    public void remind() throws IOException {
        ReminderVisitor visitor = new ReminderVisitor();
        visitor.visitTrading(new Trading());
        visitor.visitFacade(Facade.getInstance());
    }
}
