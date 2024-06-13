package gui.admin;

import application.controller.Controller;
import application.model.Adresse;
import application.model.Hotel;
import application.model.Konference;
import enumeration.TillægType;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class HotelWindow extends Stage {

    private TextField txfWifi = new TextField();
    private TextField txfMorgenmad = new TextField();
    private TextField txfBad = new TextField();
    private TextField txfFitness = new TextField();
    private TextField txfNavn = new TextField();
    private TextField txfAdresse = new TextField();
    private TextField txfPrisSingle = new TextField();
    private TextField txfPrisDouble = new TextField();
    private Hotel hotel;
    private Konference konference;

    public HotelWindow(Konference konference) {
        this.konference = konference;
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void initContent(GridPane pane) {

        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblName = new Label("Hotel navn:");
        pane.add(lblName, 0, 0);
        pane.add(txfNavn,1,0);

        Label lblAdresse = new Label("Adresse:");
        pane.add(lblAdresse,0,1);
        pane.add(txfAdresse,1,1);

        Label lblPrisSingle = new Label("Pris (Single):");
        Label lblPrisDouble = new Label("Pris (Double):");
        pane.add(lblPrisSingle,0,2);
        pane.add(lblPrisDouble,0,3);
        pane.add(txfPrisSingle,1,2);
        pane.add(txfPrisDouble,1,3);

        Label lblWifi = new Label("Wifi");
        Label lblMorgenmad = new Label("Morgenmad");
        pane.add(lblWifi,0,4);
        pane.add(txfWifi,1,4);
        pane.add(lblMorgenmad,2,4);
        pane.add(txfMorgenmad,3,4);

        Label lblBad = new Label("Bad");
        Label lblFitness = new Label("Fitness");
        pane.add(lblBad,0,5);
        pane.add(txfBad,1,5);
        pane.add(lblFitness,2,5);
        pane.add(txfFitness,3,5);

        Button btnTilbage = new Button("Tilbage");
        Button btnHotel = new Button("Tilføj hotel");
        pane.add(btnTilbage,0,6);
        pane.add(btnHotel,1,6);
        GridPane.setHalignment(btnTilbage, HPos.LEFT);
        GridPane.setHalignment(btnHotel,HPos.RIGHT);
        btnHotel.setOnAction(e -> this.okAction());
    }

    private void okAction() {
        String navn = txfNavn.getText().trim();
        String adresse = txfAdresse.getText().trim();
        int singlePris = Integer.parseInt(txfPrisSingle.getText().trim());
        int doublePris = Integer.parseInt(txfPrisDouble.getText().trim());

        this.hotel = Controller.opretHotel(navn, singlePris, doublePris);

        if (!txfWifi.getText().trim().isEmpty()) {
            hotel.opretTillæg(TillægType.WIFI,Double.parseDouble(txfWifi.getText().trim()),"Wifi");
        }

        if (!txfBad.getText().trim().isEmpty()) {
            hotel.opretTillæg(TillægType.BAD,Double.parseDouble(txfBad.getText().trim()),"Bad");
        }

        if (!txfMorgenmad.getText().trim().isEmpty()) {
            hotel.opretTillæg(TillægType.MORGENMAD,Double.parseDouble(txfMorgenmad.getText().trim()),"Morgenmad");
        }

        if (!txfFitness.getText().trim().isEmpty()) {
            hotel.opretTillæg(TillægType.FITNESS,Double.parseDouble(txfFitness.getText().trim()),"Fitness");
        }

        this.hide();
    }
}
