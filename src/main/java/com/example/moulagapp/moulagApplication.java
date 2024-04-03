package com.example.moulagapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class moulagApplication extends Application {

    private static moulagApplication application;
    private Stage stage = new Stage();

    @Override
    public void start(Stage stage) {
        application = this;
        Scene scene = loadSoldeView();
        this.stage.setTitle("Solde disponible");
        this.stage.setScene(scene);
        this.stage.show();
    }

    public Scene loadSoldeView() {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(moulagApplication.class.getResource("solde-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            MoulagappViewModel viewModel = new MoulagappViewModel();
            SoldeView soldeView = fxmlLoader.getController();
            soldeView.setViewModel(viewModel);
            scene.getStylesheets().add(moulagApplication.class.getResource("solde.css").toString());
            return scene;
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Scene loadTransactionView() {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(moulagApplication.class.getResource("transaction-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            MoulagappViewModel viewModel = new MoulagappViewModel();
            TransactionView transactionView = fxmlLoader.getController();
            transactionView.setViewModel(viewModel);
            scene.getStylesheets().add(moulagApplication.class.getResource("transaction.css").toString());
            return scene;
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public static moulagApplication getInstance()
    {
        return application;
    }

    public static void main(String[] args) {
        launch();
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}