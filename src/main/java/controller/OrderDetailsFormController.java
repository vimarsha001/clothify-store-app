package controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.dto.Order;
import model.dto.OrderDetail;
import service.OrderDetailsService;
import service.OrderService;
import service.impl.OrderDetailsServiceImpl;
import service.impl.OrderServiceImpl;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class OrderDetailsFormController implements Initializable {

    OrderDetailsService orderDetailsService = new OrderDetailsServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @FXML
    private TableView<OrderDetail> orderDetailsTbl;

    @FXML
    private ImageView backBtn;

    @FXML
    private Label dateLbl;

    @FXML
    private AnchorPane loadOrderDetails;

    @FXML
    private JFXComboBox<String> orderIdCmb;

    @FXML
    private TableColumn<?, ?> prodIdCol;

    @FXML
    private TableColumn<?, ?> qtyCol;

    @FXML
    private TableColumn<?, ?> totalCol;

    @FXML
    void backBtnOnAction(MouseEvent event) throws IOException {
        URL resource = this.getClass().getResource("/view/orderDashboardForm.fxml");
        Parent load = FXMLLoader.load(resource);

        this.loadOrderDetails.getChildren().clear();
        this.loadOrderDetails.getChildren().add(load);
    }

    @FXML
    void orderIdCmbOnAction(ActionEvent event) {
        orderDetailsTbl.setItems(orderDetailsService.search(String.valueOf(orderIdCmb.getValue())));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        prodIdCol.setCellValueFactory(new PropertyValueFactory<>("prod_id"));
        qtyCol.setCellValueFactory(new PropertyValueFactory<>("qty"));
        totalCol.setCellValueFactory(new PropertyValueFactory<>("total"));

        ObservableList<String> ids = FXCollections.observableArrayList();
        ObservableList<Order> orders = orderService.getAll();
        for(Order order : orders){
            ids.add(order.getId());
        }

        orderIdCmb.setItems(ids);
    }

}
