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

public class OrderDashboardFormController implements Initializable {

    public JFXButton orderBtn;
    @FXML
    private ImageView backBtn;

    @FXML
    private JFXButton cartBtn;

    @FXML
    private Label dateLbl;

    @FXML
    private AnchorPane loadOrderDash;

    @FXML
    private JFXButton orderDetailsBtn;

    @FXML
    void backBtnOnAction(MouseEvent event) throws IOException {
        URL resource = this.getClass().getResource("/view/employeeDashboardForm.fxml");
        Parent load = FXMLLoader.load(resource);

        this.loadOrderDash.getChildren().clear();
        this.loadOrderDash.getChildren().add(load);
    }

    @FXML
    void cartBtnOnAction(ActionEvent event) throws IOException {
        URL resource = this.getClass().getResource("/view/cartForm.fxml");
        Parent load = FXMLLoader.load(resource);

        this.loadOrderDash.getChildren().clear();
        this.loadOrderDash.getChildren().add(load);
    }

    @FXML
    void orderDetailsBtnOnAction(ActionEvent event) throws IOException {
        URL resource = this.getClass().getResource("/view/orderDetailsForm.fxml");
        Parent load = FXMLLoader.load(resource);

        this.loadOrderDash.getChildren().clear();
        this.loadOrderDash.getChildren().add(load);
    }

    public void orderBtnOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = this.getClass().getResource("/view/orderManagementForm.fxml");
        Parent load = FXMLLoader.load(resource);

        this.loadOrderDash.getChildren().clear();
        this.loadOrderDash.getChildren().add(load);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dateLbl.setText(String.valueOf(LocalDate.now()));
    }
}
