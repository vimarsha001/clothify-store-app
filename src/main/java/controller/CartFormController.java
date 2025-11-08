package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.dto.Cart;
import service.CartService;
import service.impl.CartServiceImpl;

import java.io.IOException;
import java.net.URL;

public class CartFormController {

    public TextField totTxt;
    CartService cartService = new CartServiceImpl();

    @FXML
    private JFXButton addBtn;

    @FXML
    private ImageView backBtn;

    @FXML
    private TextField custIdTxt;

    @FXML
    private Label dateLbl;

    @FXML
    private JFXButton deleteBtn;

    @FXML
    private TableColumn<?, ?> descCol;

    @FXML
    private JFXButton invoiceBtn;

    @FXML
    private AnchorPane loadCartForm;

    @FXML
    private JFXComboBox<String> prodIdCmb;

    @FXML
    private JFXComboBox<?> categoryCmb;

    @FXML
    private TableView<?> productTbl;

    @FXML
    private TableColumn<?, ?> qtyCol;

    @FXML
    private TextField qtyTxt;

    @FXML
    private JFXButton searchBtn;

    @FXML
    private TableColumn<?, ?> totCol;

    @FXML
    private JFXButton updateBtn;

    @FXML
    void addBtnOnAction(ActionEvent event) {
        Cart cart = new Cart(
                custIdTxt.getText(),
                prodIdCmb.getValue(),
                Integer.parseInt(qtyTxt.getText()),
                Double.parseDouble(totTxt.getText())
        );
        cartService.add(cart);
    }

    @FXML
    void backBtnOnAction(MouseEvent event) throws IOException {
        URL resource = this.getClass().getResource("/view/orderDashboardForm.fxml");
        Parent load = FXMLLoader.load(resource);

        this.loadCartForm.getChildren().clear();
        this.loadCartForm.getChildren().add(load);
    }

    @FXML
    void deleteBtnOnAction(ActionEvent event) {
        cartService.delete(custIdTxt.getText(),prodIdCmb.getValue());
    }

    @FXML
    void searchBtnOnAction(ActionEvent event) {
        cartService.search(custIdTxt.getText());
    }

    @FXML
    void updateBtnOnAction(ActionEvent event) {
        Cart cart = new Cart(
                custIdTxt.getText(),
                prodIdCmb.getValue(),
                Integer.parseInt(qtyTxt.getText()),
                Double.parseDouble(totTxt.getText())
        );
        cartService.update(cart);
    }

}
