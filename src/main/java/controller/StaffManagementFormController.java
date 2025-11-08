package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.dto.Staff;
import service.StaffService;
import service.impl.StaffServiceImpl;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class StaffManagementFormController implements Initializable {

    StaffService staffService = new StaffServiceImpl();

    @FXML
    private JFXButton addBtn;

    @FXML
    private TableColumn<?, ?> addressCol;

    @FXML
    private TextField addressTxt;

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
    private TableView<?> staffTbl;

    @FXML
    private JFXButton updateBtn;

    @FXML
    void addBtnOnAction(ActionEvent event) {
        Staff staff = new Staff(
                staffIdTxt.getText(),
                nameTxt.getText(),
                addressTxt.getText(),
                positionTxt.getText(),
                Double.parseDouble(salaryTxt.getText()),
                LocalDate.parse(dateLbl.getText())
        );
        staffService.add(staff);
    }

    @FXML
    void backBtnOnAction(MouseEvent event) throws IOException {
        URL resource = this.getClass().getResource("/view/staffManagementForm.fxml");
        Parent load = FXMLLoader.load(resource);

        this.loadStaffManagement.getChildren().clear();
        this.loadStaffManagement.getChildren().add(load);

    }

    @FXML
    void deleteBtnOnAction(ActionEvent event) {
        staffService.delete(staffIdTxt.getText());
    }

    @FXML
    void searchBtnOnAction(ActionEvent event) {
        staffService.search(staffIdTxt.getText());
    }

    @FXML
    void updateBtnOnAction(ActionEvent event) {
        Staff staff = new Staff(
                staffIdTxt.getText(),
                nameTxt.getText(),
                addressTxt.getText(),
                positionTxt.getText(),
                Double.parseDouble(salaryTxt.getText()),
                LocalDate.parse(dateLbl.getText())
        );
        staffService.update(staff);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dateLbl.setText(String.valueOf(LocalDate.now()));
    }
}
