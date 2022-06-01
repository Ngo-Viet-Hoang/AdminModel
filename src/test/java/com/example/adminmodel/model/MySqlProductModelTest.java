package com.example.adminmodel.model;

import com.example.adminmodel.entity.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MySqlProductModelTest {
    private ProductModel productModel;
    @BeforeEach
    void setUp() {
        productModel = new MySqlProductModel();
    }

    @Test
    void save() {
        Product product = new Product("Product 3335552", "description", "detail", 10000,"src/image/product.png","admin@gmail.com", "0123456789" );
        assertEquals(true, productModel.save(product));

    }
}