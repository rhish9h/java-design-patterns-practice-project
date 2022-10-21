package com.rhattark.businessLogic;

import java.util.ArrayList;

public class OfferingList extends ArrayList {
    public ListIterator getIterator() {
        return new OfferingIterator(this);
    }

    private class OfferingIterator implements ListIterator {

        int index = 0;
        OfferingList offeringList;

        public OfferingIterator(OfferingList offeringList) {
            this.offeringList = offeringList;
        }

        @Override
        public boolean hasNext() {
            if (index < offeringList.size()) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if (this.hasNext()) {
                return offeringList.get(index++);
            }
            return null;
        }

        @Override
        public void moveToHead() {
            if (this.hasNext()) {
                Object next = offeringList.get(index);
                offeringList.remove(index);
                offeringList.add(0, next);
            }
        }

        @Override
        public void remove() {
            if (this.hasNext()) {
                offeringList.remove(index);
            }
        }
    }
}
