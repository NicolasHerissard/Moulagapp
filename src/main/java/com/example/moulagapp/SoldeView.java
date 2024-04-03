package com.example.moulagapp;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

public class SoldeView {

    @FXML
    private Button AddTransaction;

    @FXML
    private TableView<Historique> historyTable;

    @FXML
    private TableColumn<Historique, Double> columnAmount;

    @FXML
    private TableColumn<Historique, String> columnCategory;

    @FXML
    private TableColumn<Historique, Date> columnDate;

    @FXML
    private TableColumn<Historique, String> columnDescription;

    @FXML
    private Label fundLabel;

    private MoulagappViewModel viewModel;

    private final String colorGreen = "-fx-background-color: #1cd71c";
    private final String colorRed = "-fx-background-color: red";

    public void setViewModel(MoulagappViewModel viewModel)
    {
        this.viewModel = viewModel;
        StringConverter<Number> converter = new NumberStringConverter();
        Bindings.bindBidirectional(fundLabel.textProperty(), viewModel.fundProperty(), converter);
        columnDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        columnDate.setCellFactory(c -> new TableCell<Historique, Date>() {
            @Override
            protected void updateItem(Date item, boolean empty) {
                super.updateItem(item, empty);

                if(empty || item == null)
                {
                    setText(null);
                    setStyle("");
                }
                else {
                    setText(item.toString());

                    Historique h = getTableView().getItems().get(getIndex());
                    if (h.getType() == 1) {
                        setStyle(colorGreen);
                    }
                    else
                    {
                        setStyle(colorRed);
                    }
                }
            };
        });
        columnAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        columnAmount.setCellFactory(c -> new TableCell<Historique, Double>() {
            @Override
            protected void updateItem(Double item, boolean empty) {
                super.updateItem(item, empty);

                if(empty || item == null)
                {
                    setText(null);
                    setStyle("");
                }
                else {
                    setText(String.valueOf(item));

                    Historique h = getTableView().getItems().get(getIndex());
                    if (h.getType() == 1) {
                        setStyle(colorGreen);
                    }
                    else
                    {
                        setStyle(colorRed);
                    }
                }
            };
        });
        columnDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        cellColor(columnDescription);
        columnCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        cellColor(columnCategory);
        historyTable.itemsProperty().bind(viewModel.historyProperty());
    }

    @FXML
    protected void goToTransaction() {
        Scene scene = moulagApplication.getInstance().loadTransactionView();
        moulagApplication.getInstance().getStage().setScene(scene);
        moulagApplication.getInstance().getStage().setTitle("Transaction");
        moulagApplication.getInstance().getStage().show();
    }

    @FXML
    public void goToSolde() {
        Scene scene = moulagApplication.getInstance().loadSoldeView();
        moulagApplication.getInstance().getStage().setScene(scene);
        moulagApplication.getInstance().getStage().setTitle("Transaction");
        moulagApplication.getInstance().getStage().show();
    }

    private void cellColor(TableColumn<Historique, String> column)
    {
        column.setCellFactory(c -> new TableCell<Historique, String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);

                if(item == null || empty)
                {
                    setText(null);
                    setStyle("");
                }
                else {
                    setText(item);

                    Historique h = getTableView().getItems().get(getIndex());
                    if (h.getType() == 1) {
                        setStyle(colorGreen);
                    }
                    else
                    {
                        setStyle(colorRed);
                    }
                }
            };
        });
    }
}