package service.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.dto.Employee;
import repository.EmployeeRepository;
import repository.impl.EmployeeRepositoryImpl;
import service.EmployeeService;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeServiceImpl implements EmployeeService {
    EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();
    @Override
    public void add(Employee employee) {
        employeeRepository.add(employee);
    }

    @Override
    public void update(Employee employee) {
        employeeRepository.update(employee);
    }

    @Override
    public void delete(String id) {
        employeeRepository.delete(id);
    }

    @Override
    public ObservableList<Employee> getAll() {
        ObservableList<Employee> employees = FXCollections.observableArrayList();
        ResultSet resultSet = employeeRepository.getAll();
            try {
                while(resultSet.next()){
                    Employee employee1 = new Employee(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getDouble(6),
                            resultSet.getDate(7).toLocalDate()
                    );
                    employees.add(employee1);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return employees;
    }

    @Override
    public ObservableList<Employee> search(String id,String email,String position) {
        ResultSet resultSet = employeeRepository.search(id,email,position);
        ObservableList<Employee> employees = FXCollections.observableArrayList();
        try {
            while(resultSet.next()){
                Employee employee = new Employee(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getDouble(6),
                        resultSet.getDate(7).toLocalDate()
                );
                employees.add(employee);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employees;
    }
}
