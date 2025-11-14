package repository.impl;

import db.DBConnection;
import javafx.collections.ObservableList;
import model.dto.Cart;
import repository.OrderDetailsRepository;

import java.sql.*;

public class OrderDetailsRepositoryImpl implements OrderDetailsRepository {
    @Override
    public ResultSet search(String id) {
        String SQL = "SELECT * FROM order_details WHERE id = ?";
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1,id);
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void add(String id, ObservableList<Cart> carts) {
        try {
            String SQL = "INSERT INTO order_details (id,prod_id,qty,total) VALUES (?,?,?,?)";
            Connection connection = DBConnection.getInstance().getConnection();
            for(Cart cart : carts){
                PreparedStatement preparedStatement = connection.prepareStatement(SQL);
                preparedStatement.setString(1,id);
                preparedStatement.setString(2,cart.getProdID());
                preparedStatement.setInt(3,cart.getQty());
                preparedStatement.setDouble(4,cart.getTotal());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void delete(String id) {
        String SQL = "DELETE FROM order_details WHERE id = ?";
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
