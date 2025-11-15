package controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.dto.Employee;
import model.dto.Product;
import service.EmployeeService;
import service.impl.EmployeeServiceImpl;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class EmployeeManagementFormController implements Initializable {

    public Label errorLbl;
    EmployeeService employeeService = new EmployeeServiceImpl();

    @FXML
    private JFXButton addBtn;

    @FXML
    private TableColumn<?, ?> emailCol;

    @FXML
    private DatePicker joinDate;

    @FXML
    private TableColumn<?, ?> joinDateCol;

    @FXML
    private TextField emailTxt;

    @FXML
    private TableColumn<?, ?> phoneCol;

    @FXML
    private TextField phoneNumTxt;

    @FXML
    private ImageView backBtn;

    @FXML
    private Label dateLbl;

    @FXML
    private JFXButton deleteBtn;

    @FXML
    private TableColumn<?, ?> idCol;

    @FXML
    private AnchorPane loadStaffManagement;

    @FXML
    private TableColumn<?, ?> nameCol;

    @FXML
    private TextField nameTxt;

    @FXML
    private TableColumn<?, ?> positionCol;

    @FXML
    private TextField positionTxt;

    @FXML
    private TableColumn<?, ?> salaryCol;

    @FXML
    private TextField salaryTxt;

    @FXML
    private JFXButton searchBtn;

    @FXML
    private TextField staffIdTxt;

    @FXML
    private TableView<Employee> staffTbl;

    @FXML
    private JFXButton updateBtn;

    @FXML
    void addBtnOnAction(ActionEvent event) {
        if(phoneNumTxt.getText().length() != 10){
            errorLbl.setText("**Invalid phone number !");
        }else{
            errorLbl.setText("");
            Employee employee = new Employee(
                    staffIdTxt.getText(),
                    nameTxt.getText(),
                    emailTxt.getText(),
                    phoneNumTxt.getText(),
                    positionTxt.getText(),
                    Double.parseDouble(salaryTxt.getText()),
                    joinDate.getValue()
            );
            employeeService.add(employee);
            loadTable();
            clear();

        }
    }

    @FXML
    void backBtnOnAction(MouseEvent event) throws IOException {
        URL resource = this.getClass().getResource("/view/adminDashboardForm.fxml");
        Parent load = FXMLLoader.load(resource);

        this.loadStaffManagement.getChildren().clear();
        this.loadStaffManagement.getChildren().add(load);

    }

    @FXML
    void deleteBtnOnAction(ActionEvent event) {
        employeeService.delete(staffIdTxt.getText());
        loadTable();
        clear();
    }

    @FXML
    void searchBtnOnAction(ActionEvent event) {
        ObservableList<Employee> employees = FXCollections.observableArrayList(employeeService.search(staffIdTxt.getText(),emailTxt.getText(),positionTxt.getText()));
        staffTbl.setItems(employees);

    }

    @FXML
    void updateBtnOnAction(ActionEvent event) {
        Employee employee = new Employee(
                staffIdTxt.getText(),
                nameTxt.getText(),
                emailTxt.getText(),
                phoneNumTxt.getText(),
                positionTxt.getText(),
                Double.parseDouble(salaryTxt.getText()),
                joinDate.getValue()
        );
        employeeService.update(employee);
        loadTable();
        clear();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dateLbl.setText(String.valueOf(LocalDate.now()));

        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        phoneCol.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        positionCol.setCellValueFactory(new PropertyValueFactory<>("position"));
        salaryCol.setCellValueFactory(new PropertyValueFactory<>("salary"));
        joinDateCol.setCellValueFactory(new PropertyValueFactory<>("joinDate"));

        loadTable();

        staffTbl.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue!=null){
                setValues(newValue);
            }
        });
    }

    public void setValues(Employee newValue) {
        staffIdTxt.setText(newValue.getId());
        nameTxt.setText(newValue.getName());
        emailTxt.setText(newValue.getEmail());
        phoneNumTxt.setText(newValue.getPhoneNumber());
        positionTxt.setText(newValue.getPosition());
        salaryTxt.setText(String.valueOf(newValue.getSalary()));
        joinDate.setValue(newValue.getJoinDate());
    }

    public void loadTable(){
        ObservableList<Employee> employees = employeeService.getAll();
        staffTbl.setItems(employees);
    }

    public void clear(){
        staffIdTxt.setText("");
        nameTxt.setText("");
        emailTxt.setText("");
        phoneNumTxt.setText("");
        positionTxt.setText("");
        salaryTxt.setText("");
        joinDate.setValue(null);
    }
}
