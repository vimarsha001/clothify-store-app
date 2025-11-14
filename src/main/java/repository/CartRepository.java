package repository;

import javafx.collections.ObservableList;
import model.dto.Cart;

import java.sql.ResultSet;

public interface CartRepository {
    void add(Cart cart);
    void update(Cart cart);
    void delete(String custId,String prodId);
    ResultSet search(String custId);
    ResultSet getAll();
    ResultSet getCustIDs();
    ResultSet getTot(String custId);
    ResultSet getTotQty(String custId);

}
