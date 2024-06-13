package gui.admin;

import application.controller.Controller;
import application.model.Konference;
import application.model.*;
import gui.admin.AdminWindow;
import gui.admin.HotelWindow;
import gui.admin.UdflugtWindow;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
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

import java.util.ArrayList;
import java.util.List;

public class HotelOversigt extends Stage {

    private Konference konference;
    public HotelOversigt(Konference konference){
        this.konference = konference;

        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }
    private ListView<Hotel> lvwHoteller;
    private TextArea hotelOversigt;
    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        lvwHoteller = new ListView<>();
        pane.add(lvwHoteller,0,0);
        lvwHoteller.getItems().setAll(Storage.getHoteller());

        hotelOversigt = new TextArea();
        pane.add(hotelOversigt,1,0);

        ChangeListener<Hotel> listener = (ov, oldHotel, newHotel) -> this.selectedHotelChanged();
        lvwHoteller.getSelectionModel().selectedItemProperty().addListener(listener);


    }

    private void selectedHotelChanged() {
        StringBuilder str = new StringBuilder();
        Hotel hotel = lvwHoteller.getSelectionModel().getSelectedItem();
        str.append("Reservationer: ");
        for (Booking b : hotel.getBookings()){
            str.append("\n" + b.getTilmelding().getDeltager().getNavn());
            if (b.getTilmelding().harLedsager()){
                str.append(" og " + b.getTilmelding().getLedsager().getNavn());
            }
        }
        hotelOversigt.setText(str.toString());
    }
}
