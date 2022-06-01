package com.example.adminmodel.entity;

import com.example.adminmodel.entity.base.BaseEntity;
import com.example.adminmodel.entity.entityEnum.ProductStatus;
import com.example.adminmodel.util.ValidationHelper;

import java.time.LocalDateTime;
import java.util.HashMap;

public class Product extends BaseEntity {
    private int id;
    private String name;
    private String description;
    private String detail;
    private double price;
    private String thumbnail;
    private String manufactureEmail;
    private String manufacturePhone;
    private HashMap<String, String> errors;

    public Product() {
        errors = new HashMap<>();
        this.name = "";
        this.description = "";
        this.detail = "";
        this.price = 0.0;
        this.thumbnail = "";
        this.manufactureEmail = "";
        this.manufacturePhone = "";
    }

    public Product( int id, String name, String description, String detail, double price, String thumbnail, String manufactureEmail, String manufacturePhone, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt, int createdBy, int updatedBy, int deletedBy, ProductStatus productStatus) {
        super(createdAt, updatedAt, deletedAt, createdBy, updatedBy, deletedBy, productStatus);
        this.id = id;
        this.name = name;
        this.description = description;
        this.detail = detail;
        this.price = price;
        this.thumbnail = thumbnail;
        this.manufactureEmail = manufactureEmail;
        this.manufacturePhone = manufacturePhone;
        errors = new HashMap<>();
    }

    public Product(int id, String name, String description, String detail, double price, String thumbnail, String manufactureEmail, String manufacturePhone) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.detail = detail;
        this.price = price;
        this.thumbnail = thumbnail;
        this.manufactureEmail = manufactureEmail;
        this.manufacturePhone = manufacturePhone;
        errors = new HashMap<>();

    }

    public Product(String name, String description, String detail, double price, String thumbnail, String manufactureEmail, String manufacturePhone) {
        this.name = name;
        this.description = description;
        this.detail = detail;
        this.price = price;
        this.thumbnail = thumbnail;
        this.manufactureEmail = manufactureEmail;
        this.manufacturePhone = manufacturePhone;
        errors = new HashMap<>();

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getManufactureEmail() {
        return manufactureEmail;
    }

    public void setManufactureEmail(String manufactureEmail) {
        this.manufactureEmail = manufactureEmail;
    }

    public String getManufacturePhone() {
        return manufacturePhone;
    }

    public void setManufacturePhone(String manufacturePhone) {
        this.manufacturePhone = manufacturePhone;
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
        if(manufactureEmail == "" || manufactureEmail == null) {
            errors.put("manufactureEmail", "Please enter manufactureEmail");
        }
        if(manufacturePhone == "" || manufacturePhone == null) {
            errors.put("manufacturePhone", "Please enter manufacturePhone");
        }
        if(manufactureEmail != "" && !ValidationHelper.validateEmail(manufactureEmail)) {
            errors.put("manufactureEmail", "Invalid email");
        }
        if(manufacturePhone != "" && !ValidationHelper.validatePhone(manufacturePhone)) {
            errors.put("manufacturePhone", "Invalid phone number");
        }
        return errors.size() == 0;
    }




}

