package service;

import javafx.collections.ObservableList;
import model.dto.Supplier;

public interface SupplierService {
    void add(Supplier supplier);
    void update(Supplier supplier);
    void delete(String id);
    ObservableList<Supplier> getAll();
    ObservableList<Supplier> search(String id , String name);

}
