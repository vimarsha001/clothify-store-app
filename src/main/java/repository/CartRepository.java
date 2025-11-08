package repository;

import model.dto.Cart;

public interface CartRepository {
    void add(Cart cart);
    void update(Cart cart);
    void delete(String custId,String prodId);
    void search(String custId);
}
