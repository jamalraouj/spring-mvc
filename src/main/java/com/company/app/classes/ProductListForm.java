package com.company.app.classes;

public class ProductListForm {
    private String productList;

    public ProductListForm ( String productList ) {
        this.productList = productList;
    }

    public ProductListForm ( ) {
    }

    public String getProductList ( ) {
        return productList;
    }

    public void setProductList ( String productList ) {
        this.productList = productList;
    }

    @Override
    public String toString ( ) {
        return productList;
    }
}
