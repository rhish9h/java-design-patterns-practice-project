package com.rhattark.businessLogic;

import com.rhattark.util.FileManager;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OfferingListBuilder {
    private OfferingList offeringList;
    private FileManager fileManager;
    private Facade facade;

    public OfferingListBuilder() {
        offeringList = new OfferingList();
        fileManager = FileManager.getInstance();
        facade = Facade.getInstance();
    }

    public OfferingList buildOfferingList() throws IOException {
        List<String[]> keyVals = fileManager.readKeyValuesFrom("SellerInfo.txt");
        Set<String> sellers = new HashSet<>();

        for (String[] keyVal : keyVals) {
            sellers.add(keyVal[0]);
        }

        List<String[]> userProducts = fileManager.readKeyValuesFrom("UserProduct.txt");

        for (String[] userProduct : userProducts) {
            String user = userProduct[0];
            String product = userProduct[1];

            if (sellers.contains(user) && product.equals(facade.getTheSelectedProduct().getProduct())) {
                offeringList.add(user);
            }
        }

        return offeringList;
    }
}
