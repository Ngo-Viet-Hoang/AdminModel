package com.example.adminmodel.entity.entityEnum;

public enum CategoryStatus {
    ACTIVE(1),
    DEACTIVE(0),
    DELETE(-1),
    UNDEFINE(2);

    private int value;
    CategoryStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public static CategoryStatus of(int value) {
        for (CategoryStatus categoryStatus : CategoryStatus.values()) {
            if(categoryStatus.getValue() == value) {
                return categoryStatus;
            }
        }
        return CategoryStatus.UNDEFINE;
    }

}
