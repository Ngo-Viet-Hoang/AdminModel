package com.example.adminmodel.model;

import com.example.adminmodel.entity.Product;

import java.util.List;

public interface ProductModel {
    boolean save(Product product);
    boolean update(int id, Product product);
    boolean delete (int id);
    Product findById(int id);
    List<Product> findAll();

}
