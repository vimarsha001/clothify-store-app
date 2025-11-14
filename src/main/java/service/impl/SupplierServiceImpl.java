package service.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.dto.Supplier;
import repository.SupplierRepository;
import repository.impl.SupplierRepositoryImpl;
import service.SupplierService;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SupplierServiceImpl implements SupplierService {
    SupplierRepository supplierRepository = new SupplierRepositoryImpl();

    @Override
    public void add(Supplier supplier) {
        supplierRepository.add(supplier);
    }

    @Override
    public void update(Supplier supplier) {
        supplierRepository.update(supplier);
    }

    @Override
    public void delete(String id) {
        supplierRepository.delete(id);
    }

    @Override
    public ObservableList<Supplier> getAll() {
        ResultSet resultSet = supplierRepository.getAll();
        ObservableList<Supplier> suppliers = FXCollections.observableArrayList();
        try {
            while (resultSet.next()){
                Supplier supplier = new Supplier(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getInt(5)
                );
                suppliers.add(supplier);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return suppliers;
    }

    @Override
    public ObservableList<Supplier> search(String id, String name, String category) {
        ResultSet resultSet = supplierRepository.search(id,name,category);
        ObservableList<Supplier> suppliers = FXCollections.observableArrayList();
        try {
            while (resultSet.next()){
                Supplier supplier = new Supplier(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getInt(5)
                );
                suppliers.add(supplier);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return suppliers;

    }
}
