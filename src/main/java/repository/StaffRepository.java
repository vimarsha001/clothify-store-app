package repository;

import javafx.collections.ObservableList;
import model.dto.Staff;

import java.sql.ResultSet;

public interface StaffRepository {
    void add(Staff staff);
    void update(Staff staff);
    void delete(String id);
    ResultSet getAll();
    Staff search(String id);
}
