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

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class StaffManagementFormController implements Initializable {

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

    }

    @FXML
    void searchBtnOnAction(ActionEvent event) {

    }

    @FXML
    void updateBtnOnAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dateLbl.setText(String.valueOf(LocalDate.now()));
    }
}
