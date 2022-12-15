package com.company.app.classes;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<String> productReferences = new ArrayList<>();

    public List< String > getProductReferences ( ) {
        return productReferences;
    }

    public void setProductReferences ( String productReferences ) {
        this.productReferences.add ( productReferences ) ;
    }

    public void clear() {
        this.productReferences.clear ();
    }
    @Override
    public String toString ( ) {
        return "Cart{" +
                "productReferences=" + productReferences +
                '}';
    }
}
