package com.rhattark.businessLogic;

import com.rhattark.gui.Trading;

import java.io.IOException;

/**
 * Reminder that initiates and calls all visitors
 */
public class Reminder {
    /**
     * Initiates and calls all visitors
     * @throws IOException
     */
    public void remind() throws IOException {
        ReminderVisitor visitor = new ReminderVisitor();
        visitor.visitTrading(new Trading());
        visitor.visitFacade(Facade.getInstance());
    }
}
