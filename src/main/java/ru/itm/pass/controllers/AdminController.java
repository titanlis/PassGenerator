package ru.itm.pass.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import ru.itm.pass.services.AdminService;
import ru.itm.pass.services.AdminServiceImpl;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

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
    private Clipboard clipboard;
    private String passString;


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

        passString = adminService.generatePassword();
        pass_field.setText(passString);
        clipboard.setContents(new StringSelection(passString), null);
    }

    @FXML
    public void initialize() {
        clipboard = getSystemClipboard();
        adminService= new AdminServiceImpl();
        lA.setSelected(adminService.getIsLowAlpha());
        hA.setSelected(adminService.getIsHighAlpha());
        num.setSelected(adminService.getIsNumeric());
        punct.setSelected(adminService.getIsPunctuationMarks());
        len_field.setText(String.valueOf(adminService.getLen()));
        passwordText.setText(" ");

        passString = adminService.generatePassword();
        pass_field.setText(passString);
        clipboard.setContents(new StringSelection(passString), null);

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

    private static Clipboard getSystemClipboard()
    {
        Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
        Clipboard systemClipboard = defaultToolkit.getSystemClipboard();

        return systemClipboard;
    }
}