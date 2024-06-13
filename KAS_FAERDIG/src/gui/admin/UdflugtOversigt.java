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

public class UdflugtOversigt extends Stage {

    private Konference konference;

    public UdflugtOversigt(Konference konference){
        this.konference = konference;

        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);

    }
    private ListView<Udflugt> lvwUdflugter;
    private TextArea udflugtsOversigt;

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        lvwUdflugter = new ListView<>();
        pane.add(lvwUdflugter,0,0);
        lvwUdflugter.getItems().setAll(konference.getUdflugter());

        udflugtsOversigt = new TextArea();
        pane.add(udflugtsOversigt,1,0);

        ChangeListener<Udflugt> listener = (ov, oldUdflugt, newUdflugt) -> this.selectedUdflugtChanged();
        lvwUdflugter.getSelectionModel().selectedItemProperty().addListener(listener);


    }

    private void selectedUdflugtChanged() {
        StringBuilder str = new StringBuilder();
        Udflugt udflugt = lvwUdflugter.getSelectionModel().getSelectedItem();
        str.append("Deltagere på " + udflugt.toString());
        for (Ledsager l : udflugt.getDeltagere()){
            str.append("\n Navn: " + l.getNavn() + " (" + l.getDeltager().getNavn() + " " + l.getDeltager().getTlfNr() + ")");
        }
        udflugtsOversigt.setText(str.toString());
    }
}
