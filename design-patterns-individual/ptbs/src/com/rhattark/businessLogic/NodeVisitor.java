package com.rhattark.businessLogic;

import com.rhattark.gui.Trading;

public abstract class NodeVisitor {
    public abstract void visitTrading(Trading trading);
    public abstract void visitFacade(Facade facade);
    public abstract void visitOffer(String value);
}
