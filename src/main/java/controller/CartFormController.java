package controller;

import com.jfoenix.controls.JFXButton;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import model.dto.Cart;
import model.dto.Product;
import service.CartService;
import service.ProductService;
import service.impl.CartServiceImpl;
import service.impl.ProductServiceImpl;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class CartFormController implements Initializable {

    public TextField totTxt;
    public TableColumn prodIdCol;
    public TableColumn sizeCol;
    public TextField sizeTxt;
    public Label qtyStockTxt;
    CartService cartService = new CartServiceImpl();
    ProductService productService = new ProductServiceImpl();

    @FXML
    private JFXButton addBtn;

    @FXML
    private TextField priceTxt;

    @FXML
    private TableColumn<?, ?> custIdCol;

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
    private JFXComboBox<String> categoryCmb;

    @FXML
    private TableView<Cart> cartTbl;

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
                sizeTxt.getText(),
                Integer.parseInt(qtyTxt.getText()),
                Integer.parseInt(qtyTxt.getText()) * Double.parseDouble(priceTxt.getText())
        );
        cartService.add(cart);
        loadTable();
        clear();
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
        loadTable();
        clear();
    }

    @FXML
    void searchBtnOnAction(ActionEvent event) {
        cartTbl.setItems(cartService.search(custIdTxt.getText()));
        clear();
    }

    @FXML
    void updateBtnOnAction(ActionEvent event) {
        Cart cart = new Cart(
                custIdTxt.getText(),
                prodIdCmb.getValue(),
                sizeTxt.getText(),
                Integer.parseInt(qtyTxt.getText()),
                Integer.parseInt(qtyTxt.getText()) * Double.parseDouble(priceTxt.getText())
        );
        cartService.update(cart);
        loadTable();
        clear();
    }

    public void loadTable(){
        ObservableList<Cart> carts = cartService.getAll();
        cartTbl.setItems(carts);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        custIdCol.setCellValueFactory(new PropertyValueFactory<>("custID"));
        prodIdCol.setCellValueFactory(new PropertyValueFactory<>("prodID"));
        sizeCol.setCellValueFactory(new PropertyValueFactory<>("size"));
        qtyCol.setCellValueFactory(new PropertyValueFactory<>("qty"));
        totCol.setCellValueFactory(new PropertyValueFactory<>("total"));

        dateLbl.setText(String.valueOf(LocalDate.now()));

        ObservableList<String> category = FXCollections.observableArrayList("Activewear","Dress","Jeans","Crop Top","Bottoms");
        categoryCmb.setItems(category);

        loadTable();

        cartTbl.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue!=null){
                setValues(newValue);
            }
        });
    }

    private void setValues(Cart newValue) {
        System.out.println(newValue.toString());

        custIdTxt.setText(newValue.getCustID());
        prodIdCmb.setValue(newValue.getCustID());
        sizeTxt.setText(newValue.getSize());
        qtyTxt.setText(String.valueOf(newValue.getQty()));
    }

    public void clear(){
        custIdTxt.setText("");
        prodIdCmb.setValue("");
        categoryCmb.setValue("");
        sizeTxt.setText("");
        qtyTxt.setText("");
        qtyStockTxt.setText("");
        priceTxt.setText("");
        totTxt.setText("");
    }

    public void categoryCmbOnAction(ActionEvent actionEvent) {
        ObservableList<Product> products = productService.search("","",categoryCmb.getValue());
        ObservableList<String> prodIds = FXCollections.observableArrayList();
        for(Product product : products){
            prodIds.add(product.getId());
        }
        prodIdCmb.setItems(prodIds);

    }

    public void prodIdCmbOnAction(ActionEvent actionEvent) {
        ObservableList<Product> products1 = productService.search(prodIdCmb.getValue(),"","");
        for(Product product : products1){
            sizeTxt.setText(product.getSize());
            priceTxt.setText(String.valueOf(product.getPrice()));
            if (product.getQtyInStock() ==0 ){
                qtyStockTxt.setText("Out of Stock!");
                qtyStockTxt.setTextFill(Color.RED);
            }else {
                qtyStockTxt.setText("In Stock : "+product.getQtyInStock());
                qtyStockTxt.setTextFill(Color.GREEN);
            }
        }
    }

}
