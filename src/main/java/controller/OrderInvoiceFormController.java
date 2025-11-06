package controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class OrderInvoiceFormController implements Initializable {

    @FXML
    private ImageView backBtn;

    @FXML
    private Label dateLbl;

    @FXML
    private AnchorPane loadOrderInvoice;

    @FXML
    private JFXComboBox<?> orderIdCmb;

    @FXML
    private JFXComboBox<?> productIdCmb;

    @FXML
    private TextField qtyTxt;

    @FXML
    private TextField qtyTxt1;

    @FXML
    void backBtnOnAction(MouseEvent event) throws IOException {
        URL resource = this.getClass().getResource("/view/orderManagementForm.fxml");
        Parent load = FXMLLoader.load(resource);

        this.loadOrderInvoice.getChildren().clear();
        this.loadOrderInvoice.getChildren().add(load);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dateLbl.setText(String.valueOf(LocalDate.now()));
    }
}
