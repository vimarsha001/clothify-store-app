package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
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

public class EmployeeLoginFormController implements Initializable {

    @FXML
    private ImageView backBtn;

    @FXML
    private Label dateLbl;

    @FXML
    private AnchorPane loadStaffLogin;

    @FXML
    private JFXButton loginBtn;

    @FXML
    private TextField pwTxt;

    @FXML
    private Label errorLbl;

    @FXML
    private TextField usernameTxt;

    @FXML
    void backBtnOnAction(MouseEvent event) throws IOException {
        URL resource = this.getClass().getResource("/view/homePageForm.fxml");
        Parent load = FXMLLoader.load(resource);

        this.loadStaffLogin.getChildren().clear();
        this.loadStaffLogin.getChildren().add(load);
    }

    @FXML
    void loginBtnOnAction(ActionEvent event) throws IOException {
        if(usernameTxt.getText().equals("staff@1234") || pwTxt.getText().equals("pw1234")){
            errorLbl.setText("");
            URL resource = this.getClass().getResource("/view/EmployeeDashboardForm.fxml");
            Parent load = FXMLLoader.load(resource);

            this.loadStaffLogin.getChildren().clear();
            this.loadStaffLogin.getChildren().add(load);

        }else{
            errorLbl.setText("Username or password is incorrect!");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dateLbl.setText(String.valueOf(LocalDate.now()));
    }
}
