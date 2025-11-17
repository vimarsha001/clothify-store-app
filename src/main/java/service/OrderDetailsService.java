package service;

import javafx.collections.ObservableList;
import model.dto.Cart;
import model.dto.OrderDetail;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface OrderDetailsService {
    ObservableList<OrderDetail> search(String id);
    void add(String id, ObservableList<Cart> carts);
    void delete(String id);
}
