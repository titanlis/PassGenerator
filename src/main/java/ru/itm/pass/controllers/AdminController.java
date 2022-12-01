package ru.itm.pass.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import ru.itm.pass.services.AdminService;
import ru.itm.pass.services.AdminServiceImpl;

public class AdminController {

    @FXML
    private CheckBox lA;

    @FXML
    private CheckBox hA;

    @FXML
    private CheckBox num;

    @FXML
    private CheckBox punct;

    @FXML
    private TextField len_field;

    @FXML
    private Label passwordText;

    @FXML
    private TextField pass_field;


    private AdminService adminService;



    @FXML
    protected void onGenerateButtonClick() {
        adminService.setIsLowAlpha(lA.isSelected());
        adminService.setIsHighAlpha(hA.isSelected());
        adminService.setIsNumeric(num.isSelected());
        adminService.setIsPunctuationMarks(punct.isSelected());
        String number = len_field.getText();
        if(isNumeric(number)){
            adminService.setLen(Integer.parseInt(len_field.getText()));
        }
        else{
            len_field.setText(String.valueOf(adminService.getLen()));
        }
        passwordText.setText(" ");
        pass_field.setText(adminService.generatePassword());
    }


    @FXML
    public void initialize() {
        adminService= new AdminServiceImpl();
        lA.setSelected(adminService.getIsLowAlpha());
        hA.setSelected(adminService.getIsHighAlpha());
        num.setSelected(adminService.getIsNumeric());
        punct.setSelected(adminService.getIsPunctuationMarks());
        len_field.setText(String.valueOf(adminService.getLen()));
        passwordText.setText(" ");
        pass_field.setText(adminService.generatePassword());
    }


    public static boolean isNumeric(String str)
    {
        Integer n;
        try
        {
            n = Integer.parseInt(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }

        return n>0 && n<50;
    }
}