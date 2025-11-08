package service;

import javafx.collections.ObservableList;
import model.dto.Product;

public interface ProductService {
    void add(Product product);
    void update(Product product);
    void delete(String id);
    ObservableList<Product> getAll();
    ObservableList<Product> search(String id , String name, String category);

}
