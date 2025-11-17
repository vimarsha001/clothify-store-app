package service.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.dto.Cart;
import model.dto.OrderDetail;
import repository.OrderDetailsRepository;
import repository.impl.OrderDetailsRepositoryImpl;
import service.OrderDetailsService;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDetailsServiceImpl implements OrderDetailsService {

    OrderDetailsRepository orderDetailsRepository = new OrderDetailsRepositoryImpl();

    @Override
    public ObservableList<OrderDetail> search(String id) {
        ResultSet resultSet = orderDetailsRepository.search(id);
        ObservableList<OrderDetail> orderDetails = FXCollections.observableArrayList();
            try {
                while (resultSet.next()){
                    OrderDetail orderDetail = new OrderDetail(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getInt(3),
                            resultSet.getDouble(4)
                    );
                    orderDetails.add(orderDetail);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return orderDetails;
    }

    @Override
    public void add(String id, ObservableList<Cart> carts) {
        orderDetailsRepository.add(id,carts);
    }

    @Override
    public void delete(String id) {
        orderDetailsRepository.delete(id);
    }

}
