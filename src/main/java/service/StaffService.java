package service;

import javafx.collections.ObservableList;
import model.dto.Staff;

public interface StaffService {
    void add(Staff staff);
    void update(Staff staff);
    void delete(String id);
    ObservableList<Staff> getAll();
    Staff search(String id);
}
