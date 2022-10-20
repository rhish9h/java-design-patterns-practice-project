package com.rhattark.businessLogic;

import com.rhattark.util.FileManager;

import java.io.IOException;
import java.util.List;

public class ProductListBuilder {
    private ClassProductList classProductList;
    private final int MEAT = 0;
    private final int PRODUCE = 1;
    FileManager fileManager;

    public ProductListBuilder() {
        classProductList = new ClassProductList();
        fileManager = FileManager.getInstance();
    }

    public ClassProductList buildProductList(int productCategory) throws IOException {
        String key = "";

        if (productCategory == MEAT) {
            key = "Meat";
        } else {
            key = "Produce";
        }

        List<String[]> keyVals = fileManager.readKeyValuesFrom("ProductInfo.txt");

        for (String[] keyVal : keyVals) {
            String category = keyVal[0];
            String product = keyVal[1];

            if (category.equals(key)) {
                classProductList.add(product);
            }
        }

        return classProductList;
    }
}
