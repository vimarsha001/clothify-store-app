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

public class AdminDashboardFormController implements Initializable {



    public Label userLbl;
    @FXML
    private ImageView backBtn;

    @FXML
    private Label dateLbl;

    @FXML
    private AnchorPane loadAdminDash;

    @FXML
    private JFXButton orderManBtn;

    @FXML
    private JFXButton productManBtn;

    @FXML
    private JFXButton reportManBtn;

    @FXML
    private JFXButton staffManBtn;

    @FXML
    private JFXButton supplierManBtn;

    @FXML
    void backBtnOnAction(MouseEvent event) throws IOException {
        URL resource = this.getClass().getResource("/view/adminLoginForm.fxml");
        Parent load = FXMLLoader.load(resource);

        this.loadAdminDash.getChildren().clear();
        this.loadAdminDash.getChildren().add(load);
    }

    @FXML
    void reportManBtnOnAction(ActionEvent event) throws IOException {
        URL resource = this.getClass().getResource("/view/reportManagementForm.fxml");
        Parent load = FXMLLoader.load(resource);

        this.loadAdminDash.getChildren().clear();
        this.loadAdminDash.getChildren().add(load);
    }

    @FXML
    void staffManBtnOnAction(ActionEvent event) throws IOException {
        URL resource = this.getClass().getResource("/view/employeeManagementForm.fxml");
        Parent load = FXMLLoader.load(resource);

        this.loadAdminDash.getChildren().clear();
        this.loadAdminDash.getChildren().add(load);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dateLbl.setText(String.valueOf(LocalDate.now()));
    }
}
