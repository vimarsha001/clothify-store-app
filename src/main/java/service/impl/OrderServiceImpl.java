package service.impl;

import com.sun.org.apache.xpath.internal.operations.Or;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.dto.Cart;
import model.dto.Employee;
import model.dto.Order;
import model.dto.Product;
import repository.OrderRepository;
import repository.impl.OrderRepositoryImpl;
import service.OrderService;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderServiceImpl implements OrderService {

    OrderRepository orderRepository = new OrderRepositoryImpl();

    @Override
    public void add(Order order) {
        orderRepository.add(order);
    }

    @Override
    public void update(String status) {
        orderRepository.update(status);
    }

    @Override
    public void delete(String id) {
        orderRepository.delete(id);
    }

    @Override
    public ObservableList<Order> search(String orderId,String custId) {
        ResultSet resultSet = orderRepository.search(orderId,custId);
        ObservableList<Order> orders = FXCollections.observableArrayList();
        try {
            while(resultSet.next()){
                Order order = new Order(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getInt(3),
                        resultSet.getDouble(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getDate(7).toLocalDate()
                );
                orders.add(order);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orders;
    }

    @Override
    public ObservableList<Order> getAll() {
        ResultSet resultSet = orderRepository.getAll();
        ObservableList<Order> orders = FXCollections.observableArrayList();
        try {
            while(resultSet.next()){
                Order order = new Order(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getInt(3),
                        resultSet.getDouble(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getDate(7).toLocalDate()
                );
                orders.add(order);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orders;
    }

}
