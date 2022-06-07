package com.example.adminmodel.entity;

import com.example.adminmodel.entity.base.BaseEntity;
import com.example.adminmodel.entity.entityEnum.ProductStatus;
import com.example.adminmodel.util.ValidationHelper;

import java.time.LocalDateTime;
import java.util.HashMap;

public class Product extends BaseEntity {
    private int id;
    private int categoryId;
    private String name;
    private String description;
    private String detail;
    private double price;
    private String thumbnail;
    private HashMap<String, String> errors;

    public Product() {
        errors = new HashMap<>();
        this.name = "";
        this.description = "";
        this.detail = "";
        this.price = 0.0;
        this.thumbnail = "";
    }

    public Product(int categoryId, String name, String description, String detail, double price, String thumbnail) {
        this.categoryId = categoryId;
        this.name = name;
        this.description = description;
        this.detail = detail;
        this.price = price;
        this.thumbnail = thumbnail;
        errors = new HashMap<>();
    }

    public Product(int id, int categoryId, String name, String description, String detail, double price, String thumbnail) {
        this.id = id;
        this.categoryId = categoryId;
        this.name = name;
        this.description = description;
        this.detail = detail;
        this.price = price;
        this.thumbnail = thumbnail;
        errors = new HashMap<>();

    }

    public Product( int id, int categoryId, String name, String description, String detail, double price, String thumbnail, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt, int createdBy, int updatedBy, int deletedBy, ProductStatus productStatus) {
        super(createdAt, updatedAt, deletedAt, createdBy, updatedBy, deletedBy, productStatus);
        this.id = id;
        this.categoryId = categoryId;
        this.name = name;
        this.description = description;
        this.detail = detail;
        this.price = price;
        this.thumbnail = thumbnail;
        errors = new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }


    public HashMap<String, String> getErrors() {
        return errors;
    }
    public boolean isValid() {return this.checkValid();}

    public boolean checkValid() {
        if(name == "" || name == null) {
            errors.put("name", "Please enter name");
        }
        if(price == 0) {
            errors.put("price", "Please enter price");
        }
        if(thumbnail == "" || thumbnail == null) {
            errors.put("thumbnail", "Please enter thumbnail");
        }
        return errors.size() == 0;
    }




}

