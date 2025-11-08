package repository;

import javafx.collections.ObservableList;
import model.dto.Order;
import model.dto.Product;

public interface OrderRepository {
    void add(Order order);
    void update(Order order);
    void delete(String id);
    void search(String id);
    void addDetails(String id, ObservableList<Product> products);
}
