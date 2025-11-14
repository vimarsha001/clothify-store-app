package service;

import javafx.collections.ObservableList;
import model.dto.Cart;

public interface CartService {
    void add(Cart cart);
    void update(Cart cart);
    void delete(String custId,String prodId);
    ObservableList<Cart> search(String custId);
    ObservableList<Cart> getAll();
    ObservableList<String> getCustIDs();
    double getTot(String custId);
    int getTotQty(String custId);
}
