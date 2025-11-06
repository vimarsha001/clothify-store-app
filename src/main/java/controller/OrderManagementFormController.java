package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
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

public class OrderManagementFormController implements Initializable {

    @FXML
    private JFXButton addBtn;

    @FXML
    private ImageView backBtn;

    @FXML
    private Label dateLbl;

    @FXML
    private JFXButton deleteBtn;

    @FXML
    private JFXRadioButton deliveredBtn;

    @FXML
    private TableColumn<?, ?> descCol;

    @FXML
    private JFXButton invoiceBtn;

    @FXML
    private AnchorPane loadOrderManagement;

    @FXML
    private TextField orderID;

    @FXML
    private JFXRadioButton processingBtn;

    @FXML
    private JFXComboBox<?> prodIdCmb;

    @FXML
    private JFXComboBox<?> prodIdCmb1;

    @FXML
    private TableView<?> productTbl;

    @FXML
    private TableColumn<?, ?> qtyCol;

    @FXML
    private TextField qtyTxt;

    @FXML
    private JFXButton searchBtn;

    @FXML
    private JFXRadioButton shippedBtn;

    @FXML
    private TableColumn<?, ?> totCol;

    @FXML
    private JFXButton updateBtn;

    @FXML
    void addBtnOnAction(ActionEvent event) {

    }

    @FXML
    void backBtnOnAction(MouseEvent event) throws IOException {
        URL resource = this.getClass().getResource("/view/staffDashboardForm.fxml");
        Parent load = FXMLLoader.load(resource);

        this.loadOrderManagement.getChildren().clear();
        this.loadOrderManagement.getChildren().add(load);
    }

    @FXML
    void deleteBtnOnAction(ActionEvent event) {

    }

    @FXML
    void invoiceBtnOnAction(ActionEvent event) {

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
