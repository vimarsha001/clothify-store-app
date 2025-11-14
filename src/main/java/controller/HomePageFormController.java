package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;


import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class HomePageFormController implements Initializable {

    public AnchorPane loadHomePage;
    @FXML
    private JFXButton adminBtn;

    @FXML
    private JFXButton staffBtn;

    @FXML
    private Label dateLbl;

    @FXML
    void adminBtnOnAction(ActionEvent event) throws IOException {
        URL resource = this.getClass().getResource("/view/adminLoginForm.fxml");
        Parent load = FXMLLoader.load(resource);

        this.loadHomePage.getChildren().clear();
        this.loadHomePage.getChildren().add(load);
    }

    @FXML
    void staffBtnOnAction(ActionEvent event) throws IOException {
        URL resource = this.getClass().getResource("/view/EmployeeLoginForm.fxml");
        Parent load = FXMLLoader.load(resource);

        this.loadHomePage.getChildren().clear();
        this.loadHomePage.getChildren().add(load);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dateLbl.setText(String.valueOf(LocalDate.now()));
    }
}
