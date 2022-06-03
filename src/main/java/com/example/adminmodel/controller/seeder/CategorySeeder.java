package com.example.adminmodel.controller.seeder;

import com.example.adminmodel.entity.Category;
import com.example.adminmodel.model.CategoryModel;
import com.example.adminmodel.model.MySqlCategoryModel;

public class CategorySeeder {
    private CategoryModel categoryModel;

    public CategorySeeder() {
        this.categoryModel = new MySqlCategoryModel();
    }
//    public void seedData(){
//        categoryModel.save();
//    }
}
