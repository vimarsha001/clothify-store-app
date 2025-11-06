package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
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

public class ProductManagementFormController implements Initializable {

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
    private TextField desTxt;

    @FXML
    private TableColumn<?, ?> descCol;

    @FXML
    private TableColumn<?, ?> idCol;

    @FXML
    private AnchorPane loadProductManagement;

    @FXML
    private TableColumn<?, ?> priceCol;

    @FXML
    private TextField priceTxt;

    @FXML
    private TextField productIdTxt;

    @FXML
    private TableView<?> productTbl;

    @FXML
    private TableColumn<?, ?> qtyCol;

    @FXML
    private TextField qtyTxt;

    @FXML
    private JFXButton searchBtn;

    @FXML
    private TableColumn<?, ?> sizeCol;

    @FXML
    private TextField sizeTxt;

    @FXML
    private JFXButton updateBtn;

    @FXML
    private JFXComboBox<String> categoryCmb;

    @FXML
    void addBtnOnAction(ActionEvent event) {

    }

    @FXML
    void backBtnOnAction(MouseEvent event) throws IOException {
        URL resource = this.getClass().getResource("/view/staffDashboardForm.fxml");
        Parent load = FXMLLoader.load(resource);

        this.loadProductManagement.getChildren().clear();
        this.loadProductManagement.getChildren().add(load);
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
