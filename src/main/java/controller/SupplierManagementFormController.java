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
import model.dto.Employee;
import model.dto.Product;
import model.dto.Supplier;
import service.ProductService;
import service.SupplierService;
import service.impl.ProductServiceImpl;
import service.impl.SupplierServiceImpl;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class SupplierManagementFormController implements Initializable {
    ProductService productService = new ProductServiceImpl();
    SupplierService supplierService = new SupplierServiceImpl();

    @FXML
    private JFXButton addBtn;

    @FXML
    private ImageView backBtn;

    @FXML
    private TableColumn<?, ?> categoryCol;

    @FXML
    private JFXComboBox<String> categoryCmb;

    @FXML
    private JFXComboBox<String> productIdCmb;

    @FXML
    private TextField categoryTxt;

    @FXML
    private Label dateLbl;

    @FXML
    private JFXButton deleteBtn;

    @FXML
    private TableColumn<?, ?> qtyCol;

    @FXML
    private TextField nameTxt;

    @FXML
    private TableColumn<?, ?> supNameCol;

    @FXML
    private TextField qtyTxt;

    @FXML
    private TableColumn<?, ?> idCol;

    @FXML
    private TextField idTxt;

    @FXML
    private AnchorPane loadStaffManagement;

    @FXML
    private TableColumn<?, ?> prodIdCol;

    @FXML
    private TextField prodIdTxt;

    @FXML
    private JFXButton searchBtn;

    @FXML
    private TableView<Supplier> supplierTbl;

    @FXML
    private JFXButton updateBtn;

    @FXML
    void addBtnOnAction(ActionEvent event) {
        Supplier supplier = new Supplier(
                idTxt.getText(),
                nameTxt.getText(),
                productIdCmb.getValue(),
                categoryCmb.getValue(),
                Integer.parseInt(qtyTxt.getText())
        );
        supplierService.add(supplier);
        loadTable();
        clear();
    }

    @FXML
    void backBtnOnAction(MouseEvent event) throws IOException {
        URL resource = this.getClass().getResource("/view/EmployeeDashboardForm.fxml");
        Parent load = FXMLLoader.load(resource);

        this.loadStaffManagement.getChildren().clear();
        this.loadStaffManagement.getChildren().add(load);
    }

    @FXML
    void deleteBtnOnAction(ActionEvent event) {
        supplierService.delete(idTxt.getText());
        loadTable();
        clear();
    }

    @FXML
    void searchBtnOnAction(ActionEvent event) {
        ObservableList<Supplier> suppliers = FXCollections.observableArrayList(supplierService.search(idTxt.getText(),nameTxt.getText(),categoryCmb.getValue()));
        supplierTbl.setItems(suppliers);
    }

    @FXML
    void updateBtnOnAction(ActionEvent event) {
        Supplier supplier = new Supplier(
                idTxt.getText(),
                nameTxt.getText(),
                productIdCmb.getValue(),
                categoryCmb.getValue(),
                Integer.parseInt(qtyTxt.getText())
        );
        supplierService.update(supplier);
        loadTable();
        clear();
    }

    @FXML
    void productIdCmbOnAction(ActionEvent event) {
        ObservableList<Product> products= productService.search(productIdCmb.getValue(),"","");
        for (Product product : products){
            categoryCmb.setValue(product.getCategory());
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> category = FXCollections.observableArrayList("Activewear","Dress","Jeans","Crop Top","Bottoms");
        categoryCmb.setItems(category);
        dateLbl.setText(String.valueOf(LocalDate.now()));
        ObservableList<Product> products = productService.getAll();
        ObservableList<String> prodIds = FXCollections.observableArrayList();
        for(Product product : products){
            prodIds.add(product.getId());
        }
        productIdCmb.setItems(prodIds);

        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        supNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        prodIdCol.setCellValueFactory(new PropertyValueFactory<>("productId"));
        categoryCol.setCellValueFactory(new PropertyValueFactory<>("category"));
        qtyCol.setCellValueFactory(new PropertyValueFactory<>("qty"));

        loadTable();

        supplierTbl.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue!=null){
                setValues(newValue);
            }
        });
    }

    private void setValues(Supplier newValue) {
        idTxt.setText(newValue.getId());
        nameTxt.setText(newValue.getName());
        productIdCmb.setValue(newValue.getProductId());
        categoryCmb.setValue(newValue.getCategory());
        qtyTxt.setText(String.valueOf(newValue.getQty()));
    }

    public void loadTable(){
        ObservableList<Supplier> suppliers = supplierService.getAll();
        supplierTbl.setItems(suppliers);
    }

    public void clear(){
        idTxt.setText("");
        nameTxt.setText("");
        productIdCmb.setValue("");
        categoryCmb.setValue("");
        qtyTxt.setText("");
    }
}
