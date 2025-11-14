package repository.impl;

import db.DBConnection;
import javafx.collections.ObservableList;
import model.dto.Product;
import repository.ProductRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRepositoryImpl implements ProductRepository {
    @Override
    public void add(Product product) {
        try {
            String SQL = "INSERT INTO products (id,description,category,size,qty_in_stock,price) VALUES (?,?,?,?,?,?)";
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1,product.getId());
            preparedStatement.setString(2,product.getDescription());
            preparedStatement.setString(3,product.getCategory());
            preparedStatement.setString(4,product.getSize());
            preparedStatement.setInt(5,product.getQtyInStock());
            preparedStatement.setDouble(6,product.getPrice());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void update(Product product) {
        String SQL = "UPDATE products SET description = ?,category=?,size=?,qty_in_stock=?,price=? WHERE id=?";
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1,product.getDescription());
            preparedStatement.setString(2,product.getCategory());
            preparedStatement.setString(3,product.getSize());
            preparedStatement.setInt(4,product.getQtyInStock());
            preparedStatement.setDouble(5,product.getPrice());
            preparedStatement.setString(6,product.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(String id) {
        String SQL = "DELETE FROM products WHERE id = ?";
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ResultSet getAll() {
        String SQL = "SELECT * FROM products";
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ResultSet search(String id, String name, String category) {
        String SQL = "SELECT * FROM products WHERE id = ? OR description = ? OR category = ?";
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1,id);
            preparedStatement.setString(2,name);
            preparedStatement.setString(3,category);
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
