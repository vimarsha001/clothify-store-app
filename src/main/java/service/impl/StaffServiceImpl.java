package service.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import model.dto.Staff;
import repository.StaffRepository;
import repository.impl.StaffRepositoryImpl;
import service.StaffService;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StaffServiceImpl implements StaffService {
    StaffRepository staffRepository = new StaffRepositoryImpl();
    @Override
    public void add(Staff staff) {
        staffRepository.add(staff);
    }

    @Override
    public void update(Staff staff) {
        staffRepository.update(staff);
    }

    @Override
    public void delete(String id) {
        staffRepository.delete(id);
    }

    @Override
    public ObservableList<Staff> getAll() {
        ObservableList<Staff> staff = FXCollections.observableArrayList();
        ResultSet resultSet = staffRepository.getAll();
            try {
                while(resultSet.next()){
                    Staff staff1 = new Staff(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getDouble(5),
                            resultSet.getDate(6).toLocalDate()
                    );
                    staff.add(staff1);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return staff;
    }

    @Override
    public Staff search(String id) {
        ResultSet resultSet = staffRepository.getAll();
        Staff staff = new Staff();
        try {
            while(resultSet.next()){
                staff = new Staff(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getDouble(5),
                        resultSet.getDate(6).toLocalDate()
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return staff;
    }
}
