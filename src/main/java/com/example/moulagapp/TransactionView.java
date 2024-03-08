package com.example.moulagapp;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class TransactionView {

    @FXML
    private RadioButton AddFund;

    @FXML
    private TextField AmountTextfield;

    @FXML
    private Button BackToButton;

    @FXML
    private DatePicker DateDatepicker;

    @FXML
    private TextField DescriptionTextfield;

    @FXML
    private Button RegisterButton;

    @FXML
    private RadioButton RemoveFund;

    @FXML
    private ComboBox<?> WordingCombobox;

}