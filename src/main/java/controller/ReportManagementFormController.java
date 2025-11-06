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

public class ReportManagementFormController implements Initializable {

    public AnchorPane loadRepManage;
    @FXML
    private ImageView backBtn;

    @FXML
    private Label dateLbl1;

    @FXML
    private JFXButton inventRepBtn;

    @FXML
    private JFXButton salesRepBtn;

    @FXML
    private JFXButton staffRepBtn;

    @FXML
    void backBtnOnAction(MouseEvent event) throws IOException {
        URL resource = this.getClass().getResource("/view/adminDashboardForm.fxml");
        Parent load = FXMLLoader.load(resource);

        this.loadRepManage.getChildren().clear();
        this.loadRepManage.getChildren().add(load);
    }

    @FXML
    void inventRepBtnOnAction(ActionEvent event) {

    }

    @FXML
    void salesRepBtnOnAction(ActionEvent event) {

    }

    @FXML
    void staffRepBtnOnAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dateLbl1.setText(String.valueOf(LocalDate.now()));
    }
}
