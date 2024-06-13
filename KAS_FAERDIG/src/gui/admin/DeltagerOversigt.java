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
import java.util.Collections;
import java.util.List;

public class DeltagerOversigt extends Stage {

    private Konference konference;

    public DeltagerOversigt(Konference konference) {
        this.konference = konference;

        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    private ListView<Tilmelding> lvwDeltagere;
    private ArrayList<Tilmelding> deltagere;
    private TextArea deltagerOversigt;

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        deltagere = konference.getTilmeldinger();
        Collections.sort(deltagere);
        lvwDeltagere = new ListView<>();
        pane.add(lvwDeltagere, 0, 0);
        lvwDeltagere.getItems().setAll(deltagere);

        deltagerOversigt = new TextArea();
        pane.add(deltagerOversigt, 1, 0);

        ChangeListener<Tilmelding> listener = (ov, oldDeltager, newDeltager) -> this.selectedDeltagerChanged();
        lvwDeltagere.getSelectionModel().selectedItemProperty().addListener(listener);


    }

    private void selectedDeltagerChanged() {
        Tilmelding tilmelding = lvwDeltagere.getSelectionModel().getSelectedItem();
        String stringBooking = new String();
        String stringLedsager = new String();

        if (tilmelding.getBooking() != null){
            stringBooking += "" + tilmelding.getBooking().getHotel();
        } else {
            stringBooking += "Nej";
        }

        if (tilmelding.harLedsager()){
            stringLedsager = "" + tilmelding.getLedsager().getNavn();
        } else {
            stringLedsager = "Nej";
        }

        deltagerOversigt.setText(
                "Navn: " + tilmelding.getDeltager().getNavn() +
                        "\n Tlf nr: " + tilmelding.getDeltager().getTlfNr() +
                        "\n Ankomst: " + tilmelding.getStart() +
                        "\n Afrejse: " + tilmelding.getSlut() +
                        "\n Ledsager: " + stringLedsager +
                        "\n Hotel: " + stringBooking);
    }
}
