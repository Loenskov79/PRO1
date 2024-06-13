package gui.user;

import application.controller.Controller;
import application.model.Deltager;
import application.model.Hotel;
import application.model.Konference;
import application.model.Tillæg;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import storage.Storage;

import java.util.ArrayList;

public class HotelWindow extends Stage {

    private Konference konference;
    private Hotel hotel;
    private ArrayList<Tillæg> valgteTillæg = new ArrayList<>();
    private ArrayList<Tillæg> tillæg = new ArrayList<>();
    private GridPane hotelWindow;

    public HotelWindow(Konference konference) {
        this.konference = konference;

        hotelWindow = new GridPane();
        this.initContent(hotelWindow);

        Scene scene = new Scene(hotelWindow);
        this.setScene(scene);
    }

    private ListView<Hotel> lvwHoteller;
    private ListView<Tillæg> lvwTillæg;
    private ListView<Tillæg> lvwValgteTillæg;
    private Label lblValgHotel = new Label("Valgt hotel: ");

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblHoteller = new Label("Mulige hoteller: ");
        pane.add(lblHoteller,0,0);

        lvwHoteller = new ListView<>();
        pane.add(lvwHoteller,0,1);
        lvwHoteller.getItems().setAll(konference.getHoteller());
        lvwHoteller.setEditable(false);
        lvwHoteller.getSelectionModel().select(0);

        Label lblTillæg = new Label("Mulige tillæg: ");
        pane.add(lblTillæg,1,0);
        tillæg = lvwHoteller.getSelectionModel().getSelectedItem().getTillæg();
        lvwTillæg = new ListView<>();
        pane.add(lvwTillæg,1,1);
        lvwTillæg.getItems().setAll(tillæg);

        ChangeListener<Hotel> listener = (ov, oldHotel, newHotel) -> this.selectedHotelChanged();
        lvwHoteller.getSelectionModel().selectedItemProperty().addListener(listener);

        lvwValgteTillæg = new ListView<>();
        pane.add(lvwValgteTillæg,1,2);
        lvwValgteTillæg.setMaxSize(150,100);
        lvwValgteTillæg.getItems().setAll(valgteTillæg);

        pane.add(lblValgHotel,0,2);


        Button btnBack = new Button("Tilbage");
        pane.add(btnBack,0,3);
        GridPane.setHalignment(btnBack,HPos.LEFT);
        btnBack.setOnAction(event-> backAction());

        Button btnVælgHotel = new Button("Vælg Hotel");
        pane.add(btnVælgHotel,0,3);
        GridPane.setHalignment(btnVælgHotel,HPos.RIGHT);
        btnVælgHotel.setOnAction(event-> vælgHotelAction());

        Button btnVælgTillæg = new Button("Vælg Tillæg");
        pane.add(btnVælgTillæg,1,3);
        GridPane.setHalignment(btnVælgTillæg,HPos.LEFT);
        btnVælgTillæg.setOnAction(e -> vælgTillægAction());

        Button btnOk = new Button("Ok");
        pane.add(btnOk,1,3);
        GridPane.setHalignment(btnOk,HPos.RIGHT);
        btnOk.setOnAction(e->okAction());

    }

    private void okAction() {
        this.hide();
    }

    private void vælgTillægAction() {
        Tillæg tillæg = lvwTillæg.getSelectionModel().getSelectedItem();
        if (!this.valgteTillæg.contains(tillæg)){
            this.valgteTillæg.add(tillæg);
            this.tillæg.remove(tillæg);
            updateControls();
        }
    }

    private void vælgHotelAction() {

        if (this.hotel != lvwHoteller.getSelectionModel().getSelectedItem()) {
            this.hotel = lvwHoteller.getSelectionModel().getSelectedItem();
            lblValgHotel.setText("Valgt hotel: " + this.hotel.getNavn());
        }
    }

    private void backAction() {
        this.hotel = null;
        this.valgteTillæg = null;
        this.hide();
    }

    private void selectedHotelChanged() {
        this.updateControls();
    }

    private void updateControls() {
        lvwTillæg.getItems().setAll(lvwHoteller.getSelectionModel().getSelectedItem().getTillæg());
        lvwValgteTillæg.getItems().setAll(valgteTillæg);
    }

    public Hotel getHotel(){
        return this.hotel;
    }

    public ArrayList<Tillæg> getValgteTillæg(){
        return new ArrayList<>(valgteTillæg);
    }

}
