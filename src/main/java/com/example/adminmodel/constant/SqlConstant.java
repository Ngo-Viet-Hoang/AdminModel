package com.example.adminmodel.constant;

public class SqlConstant {
    public static final String PRODUCT_INSERT = "INSERT INTO products (name, description, detail, price, thumbnail, manufactureEmail, manufacturePhone," +
            "createdAt, updatedAt, deletedAt, createdBy, updatedBy, deletedBy, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    public static final String PRODUCT_UPDATE = "UPDATE products SET name = ?, description = ?, detail = ?, price = ?, thumbnail = ?, manufactureEmail = ?, manufacturePhone = ?," +
            "createdAt = ?, updatedAt = ?, deletedAt = ?, createdBy = ?, updatedBy = ?, deletedBy = ?, status = ? WHERE id = ?;";
    public static final String PRODUCT_DELETE = "DELETE FROM products WHERE id = ?;";
    public static final String PRODUCT_FIND_BY_ID = "SELECT * FROM products WHERE id = ? AND status = ?;";
    public static final String PRODUCT_FIND_ALL = "SELECT * FROM products WHERE status = ?;";

}
