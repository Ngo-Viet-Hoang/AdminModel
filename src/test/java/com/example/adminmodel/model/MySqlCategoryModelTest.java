package com.example.adminmodel.model;

import com.example.adminmodel.entity.Category;
import com.example.adminmodel.entity.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MySqlCategoryModelTest {

    private CategoryModel categoryModel;
    @BeforeEach
    void setUp() {
        categoryModel = new MySqlCategoryModel();
    }


    @Test
    void save() {
        Category category = new Category("pen" );
        assertEquals(true, categoryModel.save(category));

    }
}