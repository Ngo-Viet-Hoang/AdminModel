package com.example.adminmodel.model;

import com.example.adminmodel.entity.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MySqlProductModelTest {
    private ProductModel productModel;
    @BeforeEach
    void setUp() {
        productModel = new MySqlProductModel();
    }

    @Test
    void save() {
        Product product = new Product("Product 32", "description", "detail", 10000,"src/image/product.png","admin@gmail.com", "0123456789" );
        assertEquals(true, productModel.save(product));

    }

    @Test
    void update() {
        List<Product> products = productModel.findAll();
        assertNotEquals(0, products.size());
        Product product = products.get(0);
        assertNotEquals(null, product);
        product.setName("Product 13333333333333");
        productModel.update(product.getId(), product);
        Product productUpdated = productModel.findById(product.getId());
        assertEquals("Product 13333333333333", productUpdated.getName());

    }
}