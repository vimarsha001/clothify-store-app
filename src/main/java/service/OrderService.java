package service;

import javafx.collections.ObservableList;
import model.dto.Cart;
import model.dto.Order;
import model.dto.Product;

public interface OrderService {
    void add(Order order);
    void update(String id,String status);
    void delete(String id);
    ObservableList<Order> search(String orderId,String custId);
    ObservableList<Order> getAll();

}
