package com.example.moulagapp;

import javafx.beans.binding.Binding;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;

import java.io.IOException;
import java.text.ParseException;

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
    private ComboBox<String> WordingCombobox;

    @FXML
    private ToggleGroup radioButtonGroup;

    private MoulagappViewModel viewModel;

    ToggleGroup toggleGroup = new ToggleGroup();

    @FXML
    public void goToSolde() {
        Scene scene = moulagApplication.getInstance().loadSoldeView();
        moulagApplication.getInstance().getStage().setScene(scene);
        moulagApplication.getInstance().getStage().setTitle("Transaction");
        moulagApplication.getInstance().getStage().show();
    }

    public void setViewModel(MoulagappViewModel viewModel)
    {
        this.viewModel = viewModel;
        StringConverter<Number> converter = new NumberStringConverter();
        Bindings.bindBidirectional(AmountTextfield.textProperty(), viewModel.amountProperty(), converter);
        DescriptionTextfield.textProperty().bindBidirectional(viewModel.descriptionProperty());
        DateDatepicker.valueProperty().bindBidirectional(viewModel.dateProperty());
        WordingCombobox.valueProperty().bindBidirectional(viewModel.categoryProperty());
        AddFund.selectedProperty().bindBidirectional(viewModel.addFundProperty());
        RemoveFund.selectedProperty().bindBidirectional(viewModel.removeFundProperty());
    }

    public void initialize()
    {
        WordingCombobox.setItems(FXCollections.observableArrayList(
                "Alimentaire",
                    "Loisir",
                    "Essence"
        ));

        AddFund.setToggleGroup(toggleGroup);
        RemoveFund.setToggleGroup(toggleGroup);
    }

    @FXML
    public void register() {
        viewModel.handleRegister();
        goToSolde();
    }

    @FXML
    protected void goToTransaction() {
        Scene scene = moulagApplication.getInstance().loadTransactionView();
        moulagApplication.getInstance().getStage().setScene(scene);
        moulagApplication.getInstance().getStage().setTitle("Transaction");
        moulagApplication.getInstance().getStage().show();
    }
}