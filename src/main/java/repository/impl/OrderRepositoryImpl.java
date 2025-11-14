package repository.impl;

import db.DBConnection;
import javafx.collections.ObservableList;
import model.dto.Cart;
import model.dto.Order;
import model.dto.Product;
import repository.OrderRepository;

import java.sql.*;

public class OrderRepositoryImpl implements OrderRepository {

    @Override
    public void add(Order order) {
        try {
            String SQL = "INSERT INTO orders (id,cust_id,qty,total,status,address,date) VALUES (?,?,?,?,?,?,?)";
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1,order.getId());
            preparedStatement.setString(2,order.getCustId());
            preparedStatement.setInt(3,order.getQty());
            preparedStatement.setDouble(4,order.getTotal());
            preparedStatement.setString(5,order.getStatus());
            preparedStatement.setString(6,order.getAddress());
            preparedStatement.setDate(7, Date.valueOf(order.getDate()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void update(String id,String status) {
        String SQL = "UPDATE orders SET status = ? WHERE id=?";
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1,status);
            preparedStatement.setString(2,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void delete(String id) {
        String SQL = "DELETE FROM orders WHERE id = ?";
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
    public ResultSet search(String orderId , String custId) {
        String SQL = "SELECT * FROM orders WHERE id = ? OR cust_id = ?";
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1,orderId);
            preparedStatement.setString(2,custId);
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ResultSet getAll() {
        String SQL = "SELECT * FROM orders";
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
