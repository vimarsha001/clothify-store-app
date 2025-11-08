package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class StaffDashboardFormController implements Initializable {

    @FXML
    private ImageView backBtn;

    @FXML
    private Label dateLbl;

    @FXML
    private AnchorPane loadStaffDash;

    @FXML
    private JFXButton orderManBtn;

    @FXML
    private JFXButton productManBtn;

    @FXML
    private JFXButton supplierManBtn;

    @FXML
    void backBtnOnAction(MouseEvent event) throws IOException {
        URL resource = this.getClass().getResource("/view/staffLoginForm.fxml");
        Parent load = FXMLLoader.load(resource);

        this.loadStaffDash.getChildren().clear();
        this.loadStaffDash.getChildren().add(load);
    }

    @FXML
    void orderManBtnOnAction(ActionEvent event) throws IOException {
        URL resource = this.getClass().getResource("/view/orderDashboardForm.fxml");
        Parent load = FXMLLoader.load(resource);

        this.loadStaffDash.getChildren().clear();
        this.loadStaffDash.getChildren().add(load);
    }

    @FXML
    void productManBtnOnAction(ActionEvent event) throws IOException {
        URL resource = this.getClass().getResource("/view/productManagementForm.fxml");
        Parent load = FXMLLoader.load(resource);

        this.loadStaffDash.getChildren().clear();
        this.loadStaffDash.getChildren().add(load);
    }

    @FXML
    void supplierManBtnOnAction(ActionEvent event) throws IOException {
        URL resource = this.getClass().getResource("/view/supplierManagementForm.fxml");
        Parent load = FXMLLoader.load(resource);

        this.loadStaffDash.getChildren().clear();
        this.loadStaffDash.getChildren().add(load);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dateLbl.setText(String.valueOf(LocalDate.now()));
    }
}
