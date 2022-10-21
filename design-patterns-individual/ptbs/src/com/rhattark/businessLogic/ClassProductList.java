package com.rhattark.businessLogic;

import java.util.ArrayList;

/**
 * List of products, also contains private class for iterator
 * @Pattern Iterator
 */
public class ClassProductList extends ArrayList {
    public void accept(NodeVisitor visitor) {}

    public ListIterator getIterator() {
        return new ProductIterator(this);
    }

    /**
     * Iterator to traverse through class product list
     */
    private class ProductIterator implements ListIterator {

        int index = 0;
        ClassProductList classProductList;

        public ProductIterator(ClassProductList classProductList) {
            this.classProductList = classProductList;
        }

        /**
         * Check if next element is present
         * @return boolean
         */
        @Override
        public boolean hasNext() {
            if (index < classProductList.size()) {
                return true;
            }
            return false;
        }

        /**
         * Fetches the next element if it is present
         * @return next element
         */
        @Override
        public Object next() {
            if (this.hasNext()) {
                return classProductList.get(index++);
            }
            return null;
        }

        /**
         * Take the current element and move before the first element
         */
        @Override
        public void moveToHead() {
            if (this.hasNext()) {
                Object next = classProductList.get(index);
                classProductList.remove(index);
                classProductList.add(0, next);
            }
        }

        /**
         * Remove current element
         */
        @Override
        public void remove() {
            if (this.hasNext()) {
                classProductList.remove(index);
            }
        }
    }
}