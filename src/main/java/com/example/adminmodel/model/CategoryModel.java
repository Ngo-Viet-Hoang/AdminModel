package com.example.adminmodel.model;

import com.example.adminmodel.entity.Category;

import java.util.List;

public interface CategoryModel {

    boolean save(Category category);
    boolean update(int id, Category category);
    boolean delete (int id);
    Category findById(int id);
    List<Category> findAll();
}
