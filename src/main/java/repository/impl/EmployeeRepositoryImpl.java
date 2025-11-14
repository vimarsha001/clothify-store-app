package repository.impl;

import db.DBConnection;
import model.dto.Employee;
import repository.EmployeeRepository;

import java.sql.*;

public class EmployeeRepositoryImpl implements EmployeeRepository {
    @Override
    public void add(Employee employee) {
        try {
            String SQL = "INSERT INTO employees (id,name,email,phone_num,position,salary,join_date) VALUES (?,?,?,?,?,?,?)";
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1,employee.getId());
            preparedStatement.setString(2,employee.getName());
            preparedStatement.setString(3,employee.getEmail());
            preparedStatement.setString(4,employee.getPhoneNumber());
            preparedStatement.setString(5,employee.getPosition());
            preparedStatement.setDouble(6,employee.getSalary());
            preparedStatement.setDate(7, Date.valueOf(employee.getJoinDate()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Employee employee) {
        String SQL = "UPDATE employees SET name=?,email=?,phone_num=?,position=?,salary=?,join_date=? WHERE id=?";
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1,employee.getName());
            preparedStatement.setString(2,employee.getEmail());
            preparedStatement.setString(3,employee.getPhoneNumber());
            preparedStatement.setString(4,employee.getPosition());
            preparedStatement.setDouble(5,employee.getSalary());
            preparedStatement.setDate(6, Date.valueOf(employee.getJoinDate()));
            preparedStatement.setString(7,employee.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(String id) {
        String SQL = "DELETE FROM employees WHERE id = ?";
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ResultSet getAll() {
        String SQL = "SELECT * FROM employees";
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ResultSet search(String id,String email,String position) {
        String SQL = "SELECT * FROM employees WHERE id = ? OR email=? OR position=?";
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1,id);
            preparedStatement.setString(2,email);
            preparedStatement.setString(3,position);
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
