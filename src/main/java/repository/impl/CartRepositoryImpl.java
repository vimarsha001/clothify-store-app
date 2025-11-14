package repository.impl;

import db.DBConnection;
import model.dto.Cart;
import repository.CartRepository;

import java.sql.*;

public class CartRepositoryImpl implements CartRepository {
    @Override
    public ResultSet getCustIDs() {
        String SQL = "SELECT cust_id , COUNT(cust_id) FROM carts GROUP BY cust_id HAVING COUNT(cust_id) >= 1";
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ResultSet getTot(String custId) {
        String SQL = "SELECT SUM(total) FROM carts where cust_id=?";
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1,custId);
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public ResultSet getTotQty(String custId) {
        String SQL = "SELECT SUM(qty) FROM carts where cust_id=?";
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1,custId);
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void add(Cart cart) {
        String SQL = "INSERT INTO carts (cust_id,prod_id,size,qty,total) VALUES (?,?,?,?,?)";
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1,cart.getCustID());
            preparedStatement.setString(2,cart.getProdID());
            preparedStatement.setString(3,cart.getSize());
            preparedStatement.setInt(4,cart.getQty());
            preparedStatement.setDouble(5,cart.getTotal());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Cart cart) {
        String SQL = "UPDATE carts SET prod_id =?,size = ?,qty = ?,total=? WHERE cust_id=?";
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1,cart.getProdID());
            preparedStatement.setString(2,cart.getSize());
            preparedStatement.setInt(3,cart.getQty());
            preparedStatement.setInt(4,cart.getQty());
            preparedStatement.setDouble(5,cart.getTotal());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(String custId,String prodId) {
        String SQL = "DELETE FROM carts WHERE cust_id = ? OR prod_id =?";
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1,custId);
            preparedStatement.setString(2,prodId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ResultSet search(String custId) {
        String SQL = "SELECT * FROM carts WHERE cust_id = ?";
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1,custId);
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ResultSet getAll() {
        String SQL = "SELECT * FROM carts";
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
