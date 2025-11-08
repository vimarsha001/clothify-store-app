package repository;

import javafx.collections.ObservableList;
import model.dto.Product;

import java.sql.ResultSet;


public interface ProductRepository {
    void add(Product product);
    void update(Product product);
    void delete(String id);
    ResultSet getAll();
    ResultSet search(String id , String name , String category);
}
