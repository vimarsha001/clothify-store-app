package service;

import javafx.collections.ObservableList;
import model.dto.Cart;
import model.dto.OrderDetail;

public interface OrderDetailsService {
    ObservableList<OrderDetail> search(String id);
    void add(String id, ObservableList<Cart> carts);
    void delete(String id);
}
