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

public class SupplierManagementFormController implements Initializable {

    @FXML
    private JFXButton addBtn;

    @FXML
    private ImageView backBtn;

    @FXML
    private TableColumn<?, ?> categoryCol;

    @FXML
    private TextField categoryTxt;

    @FXML
    private Label dateLbl;

    @FXML
    private JFXButton deleteBtn;

    @FXML
    private TableColumn<?, ?> idCol;

    @FXML
    private TextField idTxt;

    @FXML
    private AnchorPane loadStaffManagement;

    @FXML
    private TableColumn<?, ?> prodIdCol;

    @FXML
    private TextField prodIdTxt;

    @FXML
    private JFXButton searchBtn;

    @FXML
    private TableView<?> supplierTbl;

    @FXML
    private JFXButton updateBtn;

    @FXML
    void addBtnOnAction(ActionEvent event) {

    }

    @FXML
    void backBtnOnAction(MouseEvent event) throws IOException {
        URL resource = this.getClass().getResource("/view/staffDashboardForm.fxml");
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
