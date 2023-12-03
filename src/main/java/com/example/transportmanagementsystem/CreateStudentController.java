package com.example.transportmanagementsystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;


public class CreateStudentController {
    private ComsatsBusManagement cbm;
    @FXML
    private TextField studentName;
    @FXML
    private PasswordField studentPassword;
    @FXML
    private PasswordField confirmPassword;
    @FXML
    private TextField studentAccNo;
    @FXML
    private TextField studentSemester;
    @FXML
    private RadioButton hostalite;
    @FXML
    private RadioButton nonHostalite;
    @FXML
    private Button createStudentBtn;
    @FXML
    private Hyperlink loginPgBtn;
    @FXML
    private Label createAccStatus;

    public void createStudent() throws Exception{
        if(!checkFields())
        {
            createAccStatus.setText("please fill all fields");
            return;
        }
        String StudentName = studentName.getText();
        String password = studentPassword.getText();
        String confirmPass = confirmPassword.getText();
        String accNo = studentAccNo.getText();
        String semester = studentSemester.getText();

        StudentType studentType = null;
        if(hostalite.isSelected()){
            studentType = StudentType.Hostalite;
        }
        else if(nonHostalite.isSelected()){
            studentType = StudentType.NonHostalite;
        }
        else{
            createAccStatus.setText("please select student type");
            return;
        }


        boolean isCreated = cbm.createAccount(StudentName, password, confirmPass, accNo, semester, studentType);

        if (isCreated) {
            Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
            Stage window = (Stage) createStudentBtn.getScene().getWindow();
            window.setScene(new Scene(root, 691, 469));
        } else {
            createAccStatus.setText("password missmatch or user already exist");
        }


    }
    public boolean checkFields() throws Exception{
        System.out.println("CHEEEEKKKKKK");
        return !studentName.getText().isEmpty() &&
                !studentPassword.getText().isEmpty() &&
                !confirmPassword.getText().isEmpty() &&
                !studentAccNo.getText().isEmpty() &&
                !studentSemester.getText().isEmpty();
    }
    public void loginPage() throws  Exception{
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Stage window = (Stage) loginPgBtn.getScene().getWindow();
        window.setScene(new Scene(root, 691, 469));
    }
}
