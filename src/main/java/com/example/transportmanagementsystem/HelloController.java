package com.example.transportmanagementsystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;


public class HelloController {
    private ComsatsBusManagement cbm;
    @FXML
    private Label loginStatusLabel;
    @FXML
    private Button loginBtn;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Hyperlink createAccPgBtn;

    public void handleLoginBtn() throws Exception{
        String userName = username.getText();
        String passWord = password.getText();
        boolean isLogin = cbm.logIn(userName, passWord);
        System.out.println(isLogin);
        if(isLogin) {
            Parent root = FXMLLoader.load(getClass().getResource("transport-type.fxml"));
            Stage window = (Stage) loginBtn.getScene().getWindow();
            window.setScene(new Scene(root, 691, 469));
        }
        loginStatusLabel.setText("login failed");
    }
    public void createAccPage() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("create-student.fxml"));
        Stage window = (Stage) createAccPgBtn.getScene().getWindow();
        window.setScene(new Scene(root, 691, 469));
    }
}