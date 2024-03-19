package com.example.moulagapp;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.util.Duration;
import javafx.util.converter.LocalDateStringConverter;

import java.time.LocalDate;
import java.util.ArrayList;

public class MoulagappViewModel {

    private DoubleProperty fund = new SimpleDoubleProperty();
    private BooleanProperty addFund = new SimpleBooleanProperty(false);
    private BooleanProperty removeFund = new SimpleBooleanProperty(false);
    private StringProperty type = new SimpleStringProperty();
    private StringProperty description = new SimpleStringProperty();
    private DoubleProperty amount = new SimpleDoubleProperty();
    private ObjectProperty<String> category = new SimpleObjectProperty<>();
    private ObjectProperty<LocalDate> date = new SimpleObjectProperty<>();
    private ListProperty<Historique> history = new SimpleListProperty(FXCollections.observableList(new ArrayList<>()));
    private MoulagappModel model = new MoulagappModel();

    public MoulagappViewModel()
    {
        Timeline timeline = new Timeline(new KeyFrame(
                Duration.millis(1000),
                e -> {
                    fund.set(model.getFund());
                    history.set(FXCollections.observableList(model.getHistory()));
                }
        ));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public void handleRegister()
    {
        int t = 0;
        if(addFund.get())
        {
            t = 1;
            fund.set(fund.get() + amount.get());
        }

        if(removeFund.get())
        {
            t = 0;
            fund.set(fund.get() - amount.get());
        }

        model.register(fund.get(), t, amount.get(), description.get(), date.get(), category.get());
    }

    public double getFund() {
        return fund.get();
    }

    public DoubleProperty fundProperty() {
        return fund;
    }

    public void setFund(double fund) {
        this.fund.set(fund);
    }

    public ObservableList<Historique> getHistory() {
        return history.get();
    }

    public ListProperty<Historique> historyProperty() {
        return history;
    }

    public void setHistory(ObservableList<Historique> history) {
        this.history.set(history);
    }

    public String getType() {
        return type.get();
    }

    public StringProperty typeProperty() {
        return type;
    }

    public void setType(String type) {
        this.type.set(type);
    }

    public String getDescription() {
        return description.get();
    }

    public StringProperty descriptionProperty() {
        return description;
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public double getAmount() {
        return amount.get();
    }

    public DoubleProperty amountProperty() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount.set(amount);
    }

    public String getCategory() {
        return category.get();
    }

    public ObjectProperty<String> categoryProperty() {
        return category;
    }

    public void setCategory(String category) {
        this.category.set(category);
    }

    public LocalDate getDate() {
        return date.get();
    }

    public ObjectProperty<LocalDate> dateProperty() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date.set(date);
    }

    public boolean isAddFund() {
        return addFund.get();
    }

    public BooleanProperty addFundProperty() {
        return addFund;
    }

    public void setAddFund(boolean addFund) {
        this.addFund.set(addFund);
    }

    public boolean isRemoveFund() {
        return removeFund.get();
    }

    public BooleanProperty removeFundProperty() {
        return removeFund;
    }

    public void setRemoveFund(boolean removeFund) {
        this.removeFund.set(removeFund);
    }
}
