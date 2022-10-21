package com.rhattark.businessLogic;

import java.util.ArrayList;

/**
 * List of all offerings
 * @Pattern Iterator - contains private class that is returned
 * to be used as an iterator through the offering list
 */
public class OfferingList extends ArrayList {
    public ListIterator getIterator() {
        return new OfferingIterator(this);
    }

    /**
     * Iterator used to traverse through offering list
     */
    private class OfferingIterator implements ListIterator {

        int index = 0;
        OfferingList offeringList;

        public OfferingIterator(OfferingList offeringList) {
            this.offeringList = offeringList;
        }

        /**
         * Check if next element is present
         * @return boolean
         */
        @Override
        public boolean hasNext() {
            if (index < offeringList.size()) {
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
                return offeringList.get(index++);
            }
            return null;
        }

        /**
         * Take the current element and move before the first element
         */
        @Override
        public void moveToHead() {
            if (this.hasNext()) {
                Object next = offeringList.get(index);
                offeringList.remove(index);
                offeringList.add(0, next);
            }
        }

        /**
         * Remove current element
         */
        @Override
        public void remove() {
            if (this.hasNext()) {
                offeringList.remove(index);
            }
        }
    }
}
