package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.dto.Cart;
import model.dto.Order;
import model.dto.OrderDetail;
import model.dto.Product;
import service.CartService;
import service.OrderDetailsService;
import service.OrderService;
import service.ProductService;
import service.impl.CartServiceImpl;
import service.impl.OrderDetailsServiceImpl;
import service.impl.OrderServiceImpl;
import service.impl.ProductServiceImpl;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class OrderManagementFormController implements Initializable {

    OrderService orderService = new OrderServiceImpl();
    CartService cartService = new CartServiceImpl();
    OrderDetailsService orderDetailsService = new OrderDetailsServiceImpl();
    ProductService productService = new ProductServiceImpl();


    @FXML
    private JFXButton addBtn;

    @FXML
    private ImageView backBtn;

    @FXML
    private TextField addressTxt;

    @FXML
    private JFXComboBox<String> custIdCmb;

    @FXML
    private TableColumn<?, ?> addressCol;

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
    private TableView<Order> orderTbl;

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
                custIdCmb.getValue(),
                Integer.parseInt(qtyTxt.getText()),
                Double.parseDouble(totTxt.getText()),
                getStatus(),
                addressTxt.getText(),
                LocalDate.now()

        );
        orderService.add(order);
        orderDetailsService.add(orderIdTxt.getText(),cartService.search(custIdCmb.getValue()));
        for(OrderDetail orderDetail : orderDetailsService.search(orderIdTxt.getText())){
            for(Product product : productService.search(orderDetail.getProd_id(),"","")){
                product.toString();
                product.setQtyInStock(product.getQtyInStock() - orderDetail.getQty());
                productService.update(product);
                product.toString();
            }
        }

        loadTable();
        clear();
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
        orderDetailsService.delete(orderIdTxt.getText());
        orderService.delete(orderIdTxt.getText());
        loadTable();
        clear();
    }

    @FXML
    void searchBtnOnAction(ActionEvent event) {
        orderService.search(orderIdTxt.getText(),custIdCmb.getValue());
    }

    @FXML
    void updateBtnOnAction(ActionEvent event) {
        orderService.update(getStatus());
        loadTable();
        clear();
    }

    @FXML
    void custIdCmbOnAction(ActionEvent event) {
        qtyTxt.setText(String.valueOf(cartService.getTotQty(custIdCmb.getValue())));
        totTxt.setText(String.valueOf(cartService.getTot(custIdCmb.getValue())));

    }

    String getStatus(){
        if(processingBtn.isSelected()){
            return "Processing";
        }else if(shippedBtn.isSelected()){
            return "Shipped";
        }else{
            return "Delivered";
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        custIdCmb.setItems(cartService.getCustIDs());
        orderIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        custIdCol.setCellValueFactory(new PropertyValueFactory<>("custId"));
        qtyCol.setCellValueFactory(new PropertyValueFactory<>("qty"));
        totalCol.setCellValueFactory(new PropertyValueFactory<>("total"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
        addressCol.setCellValueFactory(new PropertyValueFactory<>("address"));

        loadTable();


        orderTbl.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue!=null){
                setValues(newValue);
            }
        });
    }

    public void setValues(Order newValue) {
        orderIdTxt.setText(newValue.getId());
        custIdCmb.setValue(newValue.getCustId());
        qtyTxt.setText(String.valueOf(newValue.getQty()));
        totTxt.setText(String.valueOf(newValue.getTotal()));
        if(newValue.getStatus() =="Processing"){
            processingBtn.isSelected();
        }else if(newValue.getStatus() == "Shipped"){
            shippedBtn.isSelected();
        }else{
            deliveredBtn.isSelected();
        }
        addressTxt.setText(newValue.getAddress());
    }

    public void loadTable(){
        ObservableList<Order> orders = orderService.getAll();
        orderTbl.setItems(orders);

    }

    public void clear(){
        orderIdTxt.setText("");
        custIdCmb.setValue("");
        qtyTxt.setText("");
        totTxt.setText("");
        processingBtn.setSelected(false);
        deliveredBtn.setSelected(false);
        shippedBtn.setSelected(false);
        addressTxt.setText("");
    }


}
