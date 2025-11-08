package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
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
import model.dto.Order;
import service.OrderService;
import service.impl.OrderServiceImpl;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;

public class OrderManagementFormController {

    OrderService orderService = new OrderServiceImpl();

    @FXML
    private JFXButton addBtn;

    @FXML
    private ImageView backBtn;

    @FXML
    private JFXComboBox<?> custIdCmb;

    @FXML
    private TableColumn<?, ?> custIdCol;

    @FXML
    private Label dateLbl;

    @FXML
    private JFXButton deleteBtn;

    @FXML
    private JFXRadioButton deliveredBtn;

    @FXML
    private AnchorPane loadOrderManagement;

    @FXML
    private TableColumn<?, ?> orderIdCol;

    @FXML
    private TextField orderIdTxt;

    @FXML
    private TableView<?> orderTbl;

    @FXML
    private JFXRadioButton processingBtn;

    @FXML
    private TableColumn<?, ?> qtyCol;

    @FXML
    private TextField qtyTxt;

    @FXML
    private JFXButton searchBtn;

    @FXML
    private JFXRadioButton shippedBtn;

    @FXML
    private TableColumn<?, ?> statusCol;

    @FXML
    private TextField totTxt;

    @FXML
    private TableColumn<?, ?> totalCol;

    @FXML
    private JFXButton updateBtn;

    @FXML
    void addBtnOnAction(ActionEvent event) {
        Order order = new Order(
                orderIdTxt.getText(),
                Integer.parseInt(qtyTxt.getText()),
                Double.parseDouble(totTxt.getText()),
                getStatus(),
                LocalDate.parse(dateLbl.getText())
        );
        orderService.add(order);
    }

    @FXML
    void backBtnOnAction(MouseEvent event) throws IOException {
        URL resource = this.getClass().getResource("/view/orderDashboardForm.fxml");
        Parent load = FXMLLoader.load(resource);

        this.loadOrderManagement.getChildren().clear();
        this.loadOrderManagement.getChildren().add(load);
    }

    @FXML
    void deleteBtnOnAction(ActionEvent event) {
        orderService.delete(orderIdTxt.getText());
    }

    @FXML
    void searchBtnOnAction(ActionEvent event) {
        orderService.search(orderIdTxt.getText());
    }

    @FXML
    void updateBtnOnAction(ActionEvent event) {
        Order order = new Order(
                orderIdTxt.getText(),
                Integer.parseInt(qtyTxt.getText()),
                Double.parseDouble(totTxt.getText()),
                getStatus(),
                LocalDate.parse(dateLbl.getText())
        );
        orderService.update(order);
    }

    String getStatus(){
        if(processingBtn.isSelected()){
            return "Proccesing";
        }else if(shippedBtn.isSelected()){
            return "Shipped";
        }else{
            return "Delivered";
        }
    }

}
