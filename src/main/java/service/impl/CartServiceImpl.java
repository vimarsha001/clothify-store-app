package service.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.dto.Cart;
import model.dto.Employee;
import repository.CartRepository;
import repository.impl.CartRepositoryImpl;
import service.CartService;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CartServiceImpl implements CartService {
    CartRepository cartRepository = new CartRepositoryImpl();

    @Override
    public void add(Cart cart) {
        cartRepository.add(cart);
    }

    @Override
    public void update(Cart cart) {
        cartRepository.update(cart);
    }

    @Override
    public void delete(String custId,String prodId) {
        cartRepository.delete(custId,prodId);
    }

    @Override
    public ObservableList<Cart> search(String custId) {
        ResultSet resultSet = cartRepository.search(custId);
        ObservableList<Cart> carts = FXCollections.observableArrayList();
        try {
            while (resultSet.next()){
                Cart cart = new Cart(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getInt(4),
                        resultSet.getDouble(5)
                );
                carts.add(cart);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return carts;
    }

    @Override
    public ObservableList<Cart> getAll() {
        ResultSet resultSet = cartRepository.getAll();
        ObservableList<Cart> carts = FXCollections.observableArrayList();
        try {
            while (resultSet.next()){
                Cart cart = new Cart(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getInt(4),
                        resultSet.getDouble(5)
                );
                carts.add(cart);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return carts;
    }

    @Override
    public ObservableList<String> getCustIDs() {
        ResultSet resultSet = cartRepository.getCustIDs();
        ObservableList<String> custIds = FXCollections.observableArrayList();
        try {
            while (resultSet.next()){
                custIds.add(resultSet.getString(1));
                System.out.println(resultSet.getString(2));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return custIds;
    }

    @Override
    public double getTot(String custId) {
      ResultSet resultSet =  cartRepository.getTot(custId);
        try {
            return resultSet.next() ? resultSet.getDouble(1) : null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int getTotQty(String custId) {
        ResultSet resultSet =  cartRepository.getTotQty(custId);
        try {
            return resultSet.next()? resultSet.getInt(1) : null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
