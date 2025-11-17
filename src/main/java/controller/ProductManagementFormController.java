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
import model.dto.Product;
import service.OrderDetailsService;
import service.ProductService;
import service.impl.OrderDetailsServiceImpl;
import service.impl.ProductServiceImpl;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ProductManagementFormController implements Initializable {

    ProductService productService = new ProductServiceImpl();
    OrderDetailsService orderDetailsService = new OrderDetailsServiceImpl();

    @FXML
    private Label  restockLbl;

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
    private JFXComboBox<String> sizeCmb;

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
    private TableView<Product> productTbl;

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
        Product product = new Product(
                productIdTxt.getText(),
                desTxt.getText(),
                categoryCmb.getValue(),
                sizeCmb.getValue(),
                Integer.parseInt(qtyTxt.getText()),
                Double.parseDouble(priceTxt.getText())
        );

        productService.add(product);
        loadTable();
        clear();
    }

    @FXML
    void backBtnOnAction(MouseEvent event) throws IOException {
        URL resource = this.getClass().getResource("/view/employeeDashboardForm.fxml");
        Parent load = FXMLLoader.load(resource);

        this.loadProductManagement.getChildren().clear();
        this.loadProductManagement.getChildren().add(load);
    }

    @FXML
    void deleteBtnOnAction(ActionEvent event) {
        productService.delete(productIdTxt.getText());
        loadTable();
        clear();
    }

    @FXML
    void searchBtnOnAction(ActionEvent event) {
        ObservableList<Product> products = productService.search(productIdTxt.getText(),desTxt.getText(),categoryCmb.getValue());
        productTbl.setItems(products);


    }

    @FXML
    void updateBtnOnAction(ActionEvent event) {
        Product product = new Product(
                productIdTxt.getText(),
                desTxt.getText(),
                categoryCmb.getValue(),
                sizeCmb.getValue(),
                Integer.parseInt(qtyTxt.getText()),
                Double.parseDouble(priceTxt.getText())
        );
        productService.update(product);
        loadTable();
        clear();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dateLbl.setText(String.valueOf(LocalDate.now()));
        ObservableList<String> category = FXCollections.observableArrayList("Activewear","Dress","Jeans","Crop Top","Bottoms");
        categoryCmb.setItems(category);

        ObservableList<String> size = FXCollections.observableArrayList("XS","S","M","L","XL","XXL");
        sizeCmb.setItems(size);

        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        descCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        categoryCol.setCellValueFactory(new PropertyValueFactory<>("category"));
        sizeCol.setCellValueFactory(new PropertyValueFactory<>("size"));
        qtyCol.setCellValueFactory(new PropertyValueFactory<>("qtyInStock"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        loadTable();

        productTbl.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue!=null){
                setValues(newValue);
            }
        });
    }

    public void setValues(Product newValue) {
        productIdTxt.setText(newValue.getId());
        desTxt.setText(newValue.getDescription());
        categoryCmb.setValue(newValue.getCategory());
        sizeCmb.setValue(newValue.getSize());
        qtyTxt.setText(String.valueOf(newValue.getQtyInStock()));
        priceTxt.setText(String.valueOf(newValue.getPrice()));

        if(Integer.parseInt(qtyTxt.getText())<10){
            restockLbl.setText("Restock Required!");
        }else{
            restockLbl.setText("");
        }
    }

    public void loadTable(){
        ObservableList<Product> products = productService.getAll();
        productTbl.setItems(products);

    }

    public void clear(){
        productIdTxt.setText("");
        desTxt.setText("");
        categoryCmb.setValue("");
        sizeCmb.setValue("");
        qtyTxt.setText("");
        priceTxt.setText("");
    }


}
