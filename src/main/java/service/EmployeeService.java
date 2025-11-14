package service;

import javafx.collections.ObservableList;
import model.dto.Employee;

public interface EmployeeService {
    void add(Employee employee);
    void update(Employee employee);
    void delete(String id);
    ObservableList<Employee> getAll();
    ObservableList<Employee> search(String id,String email,String position);
}
