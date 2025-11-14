package repository;

import model.dto.Employee;

import java.sql.ResultSet;

public interface EmployeeRepository {
    void add(Employee employee);
    void update(Employee employee);
    void delete(String id);
    ResultSet getAll();
    ResultSet search(String id,String email,String position);
}
