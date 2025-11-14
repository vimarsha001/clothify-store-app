package service.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.dto.Employee;
import model.dto.Product;
import repository.ProductRepository;
import repository.impl.ProductRepositoryImpl;
import service.ProductService;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductServiceImpl implements ProductService {
    ProductRepository productRepository = new ProductRepositoryImpl();
    @Override
    public void add(Product product) {
        productRepository.add(product);
    }

    @Override
    public void update(Product product) {
        productRepository.update(product);
    }

    @Override
    public void delete(String id) {
        productRepository.delete(id);
    }

    @Override
    public ObservableList<Product> getAll() {
        ObservableList<Product> products = FXCollections.observableArrayList();
        ResultSet resultSet = productRepository.getAll();
        try {
            while(resultSet.next()){
                Product product = new Product(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getInt(5),
                        resultSet.getDouble(6)
                );
                products.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }


    @Override
    public ObservableList<Product> search(String id, String name, String category) {
        ResultSet resultSet = productRepository.search(id,name,category);
        ObservableList<Product> products = FXCollections.observableArrayList();

            try {
                while (resultSet.next()){
                    Product product = new Product(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getInt(5),
                            resultSet.getDouble(6)
                    );
                    products.add(product);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return products;
    }
}
