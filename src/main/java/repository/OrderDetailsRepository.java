package repository;

import javafx.collections.ObservableList;
import model.dto.Cart;
import model.dto.OrderDetail;

import java.sql.ResultSet;

public interface OrderDetailsRepository{
    ResultSet search(String id);
    void add(String id, ObservableList<Cart> carts);
    void delete(String id);
}
