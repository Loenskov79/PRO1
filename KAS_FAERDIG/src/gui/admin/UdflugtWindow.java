package gui.admin;

import application.controller.Controller;
import application.model.Konference;
import application.model.Udflugt;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import storage.Storage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class UdflugtWindow extends Stage {

    private TextField txfNavn = new TextField();
    private TextField txfBeskrivelse = new TextField();
    private TextField txfFrokost = new TextField();
    private DatePicker datePicker = new DatePicker();
    private TextField txfPris = new TextField();
    private Udflugt udflugt;
    public UdflugtWindow() {
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    public Udflugt getUdflugt() {
        return udflugt;
    }

    public void initContent(GridPane pane) {

        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblNavn = new Label("Udflugt navn:");
        Label lblBeskrivelse = new Label("Beskrivelse:");
        Label lblFrokost = new Label("Frokost:");
        Label lblStart = new Label("Start tidspunkt:");
        Label lblPris = new Label("Pris:");
        pane.add(lblNavn,0,0);
        pane.add(lblBeskrivelse,0,1);
        pane.add(lblFrokost,0,2);
        pane.add(lblStart,0,3);
        pane.add(lblPris,0,4);


        pane.add(txfNavn,1,0);
        pane.add(txfBeskrivelse,1,1);
        pane.add(txfFrokost,1,2);
        pane.add(datePicker,1,3);
        pane.add(txfPris,1,4);

        Button btnTilbage = new Button("Tilbage");
        Button btnUdflugt = new Button("Tilføj udflugt");
        pane.add(btnTilbage,0,5);
        pane.add(btnUdflugt,1,5);
        GridPane.setHalignment(btnTilbage, HPos.LEFT);
        GridPane.setHalignment(btnUdflugt,HPos.RIGHT);
        btnUdflugt.setOnAction(e -> this.okAction());
    }

    private void okAction() {
        boolean frokost = false;
        String navn = txfNavn.getText().trim();
        String beskrivelse = txfBeskrivelse.getText().trim();
        String frokostTekst = txfFrokost.getText().trim();
        if (!frokostTekst.isEmpty()) {
            frokost = true;
        }
        LocalDate dato = datePicker.getValue();
        int pris = Integer.parseInt(txfPris.getText().trim());

        udflugt = Controller.opretUdflugt(pris, navn, beskrivelse, dato, frokost);
        this.udflugt = udflugt;
        this.hide();
    }
}
