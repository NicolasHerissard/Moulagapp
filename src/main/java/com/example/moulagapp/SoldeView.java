package com.example.moulagapp;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;

import java.io.IOException;

public class SoldeView {

    @FXML
    private Button AddTransaction;

    @FXML
    private TableView<Historique> historyTable;

    @FXML
    private TableColumn<?, ?> columnAmount;

    @FXML
    private TableColumn<?, ?> columnCategory;

    @FXML
    private TableColumn<?, ?> columnDate;

    @FXML
    private TableColumn<?, ?> columnDescription;

    @FXML
    private Label fundLabel;

    private MoulagappViewModel viewModel;

    public void setViewModel(MoulagappViewModel viewModel)
    {
        this.viewModel = viewModel;
        StringConverter<Number> converter = new NumberStringConverter();
        Bindings.bindBidirectional(fundLabel.textProperty(), viewModel.fundProperty(), converter);
        columnDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        columnAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        columnDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        columnCategory.setCellValueFactory(new PropertyValueFactory<>("category"));

        historyTable.itemsProperty().bind(viewModel.historyProperty());
    }

    @FXML
    public void initialize()
    {

    }

    @FXML
    protected void goToTransaction() throws IOException {
        Scene scene = moulagApplication.getInstance().loadTransactionView();
        moulagApplication.getInstance().getStage().setScene(scene);
        moulagApplication.getInstance().getStage().setTitle("Transaction");
        moulagApplication.getInstance().getStage().show();
    }
}