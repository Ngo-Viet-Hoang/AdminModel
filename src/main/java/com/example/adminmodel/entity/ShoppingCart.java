package com.example.adminmodel.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShoppingCart {
    private double totalPrice;
    private String shipName;
    private String shipPhone;
    private String shipAddress;
    private String shipNote;
    private HashMap<Integer, CartItem> items;

    public ShoppingCart() {
        items = new HashMap<>();
    }
    public List<CartItem> getListItem(){
        return new ArrayList<>(items.values());
    }
    public boolean add(Product product, int quantity){
        CartItem cartItem = null;
        if(items.containsKey(product.getId())){
            cartItem = items.get(product.getId());
            cartItem.setQuantity(cartItem.getQuantity() + quantity);
        }else {
            cartItem = CartItem.CartItemBuilder.aCartItem()
                    .withProductId(product.getId())
                    .withProductName(product.getName())
                    .withProductThumbnail(product.getThumbnail())
                    .withUnitPrice(product.getPrice())
                    .withQuantity(quantity)
                    .build();

        }
        items.put(product.getId(), cartItem);
            return true;
    }
    public boolean sub(Product product, int quantity){
        CartItem cartItem = null;
        if(items.containsKey(product.getId())){
            cartItem = items.get(product.getId());
            int updateQuantity = cartItem.getQuantity() - quantity;
            if(updateQuantity <=0 ){
                items.remove(product.getId());
            }else{
                cartItem.setQuantity(updateQuantity);
            }
        }
        return true;
    }
    public boolean remove(int productId){
        if(items.containsKey(productId)){
            items.remove(productId);
            return true;
        }
        return false;
    }
    public void clear(){
        items.clear();
    }
    public double getTotalPrice(){
        if(items.size() == 0){
            return 0;
        }
        totalPrice = 0;
        for (CartItem cartItem: getListItem()
             ) {
            totalPrice += cartItem.getUnitPrice() * cartItem.getQuantity();
        }
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public String getShipPhone() {
        return shipPhone;
    }

    public void setShipPhone(String shipPhone) {
        this.shipPhone = shipPhone;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }

    public String getShipNote() {
        return shipNote;
    }

    public void setShipNote(String shipNote) {
        this.shipNote = shipNote;
    }

    public HashMap<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(HashMap<Integer, CartItem> items) {
        this.items = items;
    }
}
