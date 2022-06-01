package com.example.adminmodel.entity.entityEnum;

public enum ProductStatus {
    ACTIVE(1),
    DEACTIVE(0),
    DELETE(-1),
    UNDEFINE(2);

    private int value;
    ProductStatus(int value){
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
    public static ProductStatus of (int value){
        for (ProductStatus productStatus : ProductStatus.values()) {
            if(productStatus.getValue() == value) {
                return productStatus;
            }
        }
        return ProductStatus.UNDEFINE;

    }
}
