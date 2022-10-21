package com.rhattark.businessLogic;

import java.util.ArrayList;

public class ClassProductList extends ArrayList {
    public void accept(NodeVisitor visitor) {}

    public ListIterator getIterator() {
        return new ProductIterator(this);
    }

    private class ProductIterator implements ListIterator {

        int index = 0;
        ClassProductList classProductList;

        public ProductIterator(ClassProductList classProductList) {
            this.classProductList = classProductList;
        }

        @Override
        public boolean hasNext() {
            if (index < classProductList.size()) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if (this.hasNext()) {
                return classProductList.get(index++);
            }
            return null;
        }

        @Override
        public void moveToHead() {
            if (this.hasNext()) {
                Object next = classProductList.get(index);
                classProductList.remove(index);
                classProductList.add(0, next);
            }
        }

        @Override
        public void remove() {
            if (this.hasNext()) {
                classProductList.remove(index);
            }
        }
    }
}