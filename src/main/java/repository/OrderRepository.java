package repository;

import javafx.collections.ObservableList;
import model.dto.Cart;
import model.dto.Order;
import model.dto.Product;

import java.sql.ResultSet;

public interface OrderRepository {
    void add(Order order);
    void update(String status);
    void delete(String id);
    ResultSet search(String id,String custId);
    ResultSet getAll();
}
