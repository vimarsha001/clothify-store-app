package repository;

import javafx.collections.ObservableList;
import model.dto.Supplier;

import java.sql.ResultSet;

public interface SupplierRepository {
    void add(Supplier supplier);
    void update(Supplier supplier);
    void delete(String id);
    ResultSet getAll();
    ResultSet search(String id , String name, String category);
}
