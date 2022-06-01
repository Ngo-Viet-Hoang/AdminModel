package com.example.adminmodel.model;

import com.example.adminmodel.constant.SqlConstant;
import com.example.adminmodel.entity.Product;
import com.example.adminmodel.entity.entityEnum.ProductStatus;
import com.example.adminmodel.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MySqlProductModel implements ProductModel{

    @Override
    public boolean save(Product product) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.PRODUCT_INSERT);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setString(3, product.getDetail());
            preparedStatement.setDouble(4, product.getPrice());
            preparedStatement.setString(5, product.getThumbnail());
            preparedStatement.setString(6, product.getManufactureEmail());
            preparedStatement.setString(7, product.getManufacturePhone());
            preparedStatement.setString(8, product.getCreatedAt().toString());
            preparedStatement.setString(9, product.getUpdatedAt().toString());
            if(product.getDeletedAt() != null) {
                preparedStatement.setString(10, product.getDeletedAt().toString());
            }else {
                preparedStatement.setString(10, null);
            }
            preparedStatement.setInt(11, product.getCreatedBy());
            preparedStatement.setInt(12, product.getUpdatedBy());
            preparedStatement.setInt(13, product.getDeletedBy());
            preparedStatement.setInt(14, product.getProductStatus().getValue());

            return preparedStatement.executeUpdate() >0;

        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(int id, Product product) {
        try{
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.PRODUCT_UPDATE);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setString(3, product.getDetail());
            preparedStatement.setDouble(4, product.getPrice());
            preparedStatement.setString(5, product.getThumbnail());
            preparedStatement.setString(6, product.getManufactureEmail());
            preparedStatement.setString(7, product.getManufacturePhone());
            preparedStatement.setString(8, product.getCreatedAt().toString());
            preparedStatement.setString(9, product.getUpdatedAt().toString());
            if(product.getDeletedAt() != null) {
                preparedStatement.setString(10, product.getDeletedAt().toString());
            }else {
                preparedStatement.setString(10, null);
            }
            preparedStatement.setInt(11, product.getCreatedBy());
            preparedStatement.setInt(12, product.getUpdatedBy());
            preparedStatement.setInt(13, product.getDeletedBy());
            preparedStatement.setInt(14, product.getProductStatus().getValue());
            preparedStatement.setInt(15, id);
            return preparedStatement.executeUpdate() > 0;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        try{
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.PRODUCT_DELETE);
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    @Override
    public Product findById(int id) {
        try{
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.PRODUCT_FIND_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, ProductStatus.ACTIVE.getValue());
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                String name = rs.getString("name");
                String description = rs.getString("description");
                String detail = rs.getString("detail");
                Double price = rs.getDouble("price");
                String thumbnail = rs.getString("thumbnail");
                String manufactureEmail = rs.getString("manufactureEmail");
                String manufacturePhone = rs.getString("manufacturePhone");
                LocalDateTime createdAt = rs.getTimestamp("createdAt").toLocalDateTime();
                LocalDateTime updatedAt = rs.getTimestamp("updatedAt").toLocalDateTime();
                LocalDateTime deletedAt = null;
                if(rs.getTimestamp("deletedAt") != null) {
                    deletedAt = rs.getTimestamp("deletedAt").toLocalDateTime();
                }
                int createdBy = rs.getInt("createdBy");
                int updatedBy = rs.getInt("updatedBy");
                int deletedBy = rs.getInt("deletedBy");
                ProductStatus status = ProductStatus.values()[rs.getInt("status")];
                Product product = new Product(id, name, description, detail, price, thumbnail,manufactureEmail, manufacturePhone, createdAt, updatedAt, deletedAt, createdBy, updatedBy,deletedBy, status);
                return product;
            }
        }catch (SQLException e) {
//            e.printStackTrace();
            System.out.println(e);
        }
        return null;
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        try{
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.PRODUCT_FIND_ALL);
            preparedStatement.setInt(1, ProductStatus.ACTIVE.getValue());
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String detail = rs.getString("detail");
                Double price = rs.getDouble("price");
                String thumbnail = rs.getString("thumbnail");
                String manufactureEmail = rs.getString("manufactureEmail");
                String manufacturePhone = rs.getString("manufacturePhone");
                LocalDateTime createdAt = rs.getTimestamp("createdAt").toLocalDateTime();
                LocalDateTime updatedAt = rs.getTimestamp("updatedAt").toLocalDateTime();
                LocalDateTime deletedAt = null;
                if(rs.getTimestamp("deletedAt") != null) {
                    deletedAt = rs.getTimestamp("deletedAt").toLocalDateTime();
                }
                int createdBy = rs.getInt("createdBy");
                int updatedBy = rs.getInt("updatedBy");
                int deletedBy = rs.getInt("deletedBy");
                ProductStatus status = ProductStatus.of(rs.getInt("status"));
                Product product = new Product(id, name, description, detail, price, thumbnail, manufactureEmail, manufacturePhone, createdAt, updatedAt, deletedAt, createdBy, updatedBy, deletedBy, status);
                products.add(product);
            }
        }catch (SQLException e) {
//            e.printStackTrace();
            System.out.println(e);
        }
        return products;
    }
}
