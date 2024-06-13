package gui.admin;

import application.controller.Controller;
import application.model.Konference;
import application.model.*;
import gui.admin.AdminWindow;
import gui.admin.HotelWindow;
import gui.admin.UdflugtWindow;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import storage.Storage;

public class MenuWindow extends Stage {

    private GridPane startWindow;
    private GridPane menuWindow;

    public MenuWindow(GridPane startWindow){
        this.startWindow = startWindow;

        this.menuWindow = new GridPane();
        this.initContent(menuWindow);
    }

    private ComboBox<Konference> cbKonferencer;
    public void initContent(GridPane pane){
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);


        Button btnOpret = new Button("Opret Konference");
        pane.add(btnOpret,0,0);
        btnOpret.setOnAction(e-> {
            AdminWindow adminWindow = new AdminWindow(startWindow);
            pane.getScene().setRoot(adminWindow.getAdminPane());
        });

        cbKonferencer = new ComboBox<>();
        cbKonferencer.getItems().setAll(Storage.getKonferencer());
        pane.add(cbKonferencer,0,1);


        Button btnDeltagerOversigt = new Button("Se deltagere");
        pane.add(btnDeltagerOversigt,0,2);
        btnDeltagerOversigt.setOnAction(e->deltagerOversigtAction());

        Button btnUdflugtsOversigt = new Button("Se udflugter");
        pane.add(btnUdflugtsOversigt,0,3);
        btnUdflugtsOversigt.setOnAction(e->udflugtsOversigtAction());

        Button btnHotelOversigt = new Button("Se hoteller");
        pane.add(btnHotelOversigt,0,4);
        btnHotelOversigt.setOnAction(e->hotelOversigtAction());

    }

    private void udflugtsOversigtAction() {
        Konference konference = cbKonferencer.getSelectionModel().getSelectedItem();
        UdflugtOversigt udflugtOversigt = new UdflugtOversigt(konference);
        udflugtOversigt.showAndWait();
    }

    private void hotelOversigtAction() {
        Konference konference = cbKonferencer.getSelectionModel().getSelectedItem();
        HotelOversigt hotelOversigt = new HotelOversigt(konference);
        hotelOversigt.showAndWait();
    }

    private void deltagerOversigtAction() {
        Konference konference = cbKonferencer.getSelectionModel().getSelectedItem();
        DeltagerOversigt deltagerOversigt = new DeltagerOversigt(konference);
        deltagerOversigt.showAndWait();
    }

    public GridPane getWindow(){
        return menuWindow;
    }

}
