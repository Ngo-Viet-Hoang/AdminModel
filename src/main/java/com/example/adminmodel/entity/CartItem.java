package com.example.adminmodel.entity;

public class CartItem {
    private int productId;
    private String productName;
    private String productThumbnail;
    private double unitPrice;
    private int quantity;


    public String toString() {
        return String.format("%s - %.2f - %d", productName, unitPrice, quantity);
    }

    public CartItem() {
    }


    public CartItem(int productId, String productName, String productThumbnail, double unitPrice, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.productThumbnail = productThumbnail;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductThumbnail() {
        return productThumbnail;
    }

    public void setProductThumbnail(String productThumbnail) {
        this.productThumbnail = productThumbnail;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public static final class CartItemBuilder {
        private int productId;
        private String productName;
        private String productThumbnail;
        private double unitPrice;
        private int quantity;

        private CartItemBuilder() {
        }

        public static CartItemBuilder aCartItem() {
            return new CartItemBuilder();
        }

        public CartItemBuilder withProductId(int productId) {
            this.productId = productId;
            return this;
        }

        public CartItemBuilder withProductName(String productName) {
            this.productName = productName;
            return this;
        }

        public CartItemBuilder withProductThumbnail(String productThumbnail) {
            this.productThumbnail = productThumbnail;
            return this;
        }

        public CartItemBuilder withUnitPrice(double unitPrice) {
            this.unitPrice = unitPrice;
            return this;
        }

        public CartItemBuilder withQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public CartItem build() {
            CartItem cartItem = new CartItem();
            cartItem.setProductId(productId);
            cartItem.setProductName(productName);
            cartItem.setProductThumbnail(productThumbnail);
            cartItem.setUnitPrice(unitPrice);
            cartItem.setQuantity(quantity);
            return cartItem;
        }
    }
}
