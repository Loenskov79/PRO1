package gui;

import application.controller.Controller;
import application.model.Konference;
import application.model.*;
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

import java.util.ArrayList;
import java.util.Optional;

public class AdminWindow extends Stage {

    private final GridPane adminPane = new GridPane();
    private final ListView<Konference> lvwKonferencer = new ListView<>();
    private ListView<Hotel> lvwHoteller = new ListView<>();
    private ListView<Udflugt> lvwUdflugter = new ListView<>();
    private ArrayList<Udflugt> udflugter = new ArrayList<>();
    private ArrayList<Hotel> hoteller = new ArrayList<>();
    Konference konference;

    public AdminWindow() {
        this.setResizable(false);

        this.initContent(adminPane);
    }

    public GridPane getAdminPane() {
        return adminPane;
    }

    private TextField txfNavn;
    private TextField txfBeskrivelse;
    private TextField txfStart;
    private TextField txfSlut;
    private TextField txfAdresse;
    private TextField txfPris;



    private void initContent(GridPane pane) {
        Label lblHeading = new Label("Opret konferencer");
        adminPane.add(lblHeading,0,0);
        lblHeading.setMinSize(50,50);
        lblHeading.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 30));
        GridPane.setHalignment(lblHeading, HPos.CENTER);
        GridPane.setColumnSpan(lblHeading,4);
        GridPane.setMargin(lblHeading,new Insets(25,0,25,0));

        VBox VBoxVenstre = new VBox();
        VBoxVenstre.setSpacing(15);
        adminPane.add(VBoxVenstre,0,1);
        VBox VBoxHøjre = new VBox();
        VBoxHøjre.setSpacing(5);
        adminPane.add(VBoxHøjre,1,1);
        VBoxHøjre.setTranslateX(-50);
        VBoxHøjre.setPadding(new Insets(0,0,30,0));
        VBoxVenstre.setPadding(new Insets(0,0,30,0));


        txfNavn = new TextField();
        Label lblNavn = new Label("Navn på konference:");
//        adminPane.add(txfNavn,0,1);
//        adminPane.add(lblNavn,0,1);
        GridPane.setHalignment(txfNavn,HPos.CENTER);
        GridPane.setColumnSpan(txfNavn,4);
        GridPane.setMargin(txfNavn,new Insets(0,10,0,150));

        txfBeskrivelse = new TextField();
        Label lblBeskrivelse = new Label("Beskrivelse:");
//        adminPane.add(txfBeskrivelse,0,2);
//        adminPane.add(lblBeskrivelse,0,2);
        GridPane.setColumnSpan(txfBeskrivelse,4);
        GridPane.setMargin(txfBeskrivelse,new Insets(0,10,0,100));

        txfStart = new TextField();
        Label lblStart = new Label("Start tidspunkt:");
//        adminPane.add(txfStart,0,3);
//        adminPane.add(lblStart,0,3);
        GridPane.setColumnSpan(txfStart,4);
        GridPane.setMargin(txfStart,new Insets(0,10,0,100));

        txfSlut = new TextField();
        Label lblSlut = new Label("Slut tidspunkt:");
//        adminPane.add(txfSlut,0,4);
//        adminPane.add(lblSlut,0,4);
        GridPane.setColumnSpan(txfSlut,4);
        GridPane.setMargin(txfSlut,new Insets(0,10,0,100));

        txfAdresse = new TextField();
        Label lblAdresse = new Label("Adresse:");
//        adminPane.add(txfAdresse,0,5);
//        adminPane.add(lblAdresse,0,5);
        GridPane.setColumnSpan(txfAdresse,4);
        GridPane.setMargin(txfAdresse,new Insets(0,10,0,50));

        txfPris = new TextField();
        Label lblPris = new Label("Pris:");
//        adminPane.add(txfPris,0,6);
//        adminPane.add(lblPris,0,6);
        GridPane.setColumnSpan(txfPris,4);
        GridPane.setMargin(txfPris,new Insets(0,10,0,50));

        VBoxVenstre.getChildren().addAll(lblNavn,lblBeskrivelse,lblStart,lblSlut,lblAdresse,lblPris);
        VBoxHøjre.getChildren().addAll(txfNavn,txfBeskrivelse,txfStart,txfSlut,txfAdresse,txfPris);

        Button btnNæste = new Button("Se konferencer");
        adminPane.add(btnNæste,3,0);

        adminPane.add(lvwHoteller,0,7);
        GridPane.setMargin(lvwHoteller,new Insets(0,10,0,0));
        Button btnHotel = new Button("Tilføj hotel");
        adminPane.add(btnHotel,1,7);
        GridPane.setHalignment(btnHotel,HPos.CENTER);
        GridPane.setMargin(btnHotel,new Insets(0,0,0,-70));
        btnHotel.setOnAction(e -> this.tilføjHotelAction());

        adminPane.add(lvwUdflugter,2,7);
        GridPane.setMargin(lvwUdflugter,new Insets(0,0,0,-65));
        Button btnUdflugt = new Button("Tilføj udflugt");
        adminPane.add(btnUdflugt,3,7);
        GridPane.setHalignment(btnUdflugt,HPos.CENTER);
        GridPane.setMargin(btnUdflugt,new Insets(0,0,0,5));
        btnUdflugt.setOnAction(e -> this.tilføjUdflugtAction());

        Button btnTilbage = new Button("Tilbage");
        adminPane.add(btnTilbage,0,8);
        GridPane.setHalignment(btnTilbage,HPos.CENTER);
        GridPane.setMargin(btnTilbage,new Insets(10,0,10,0));
        Button btnOpret = new Button("Opret konference");
        adminPane.add(btnOpret,2,8);
        GridPane.setHalignment(btnOpret,HPos.CENTER);
        GridPane.setMargin(btnOpret,new Insets(10,0,10,0));
        btnOpret.setOnAction(e -> this.opretKonferenceAction());
    }

    private void opretKonferenceAction() {

        String navn = txfNavn.getText().trim();
        String beskrivelse = txfBeskrivelse.getText().trim();
        String tidStart = txfStart.getText().trim();
        String tidSlut = txfSlut.getText().trim();
        String adresse = txfAdresse.getText().trim();
        int pris = Integer.parseInt(txfPris.getText().trim());

        Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
        confirmation.setTitle("Opret konference");
        confirmation.setHeaderText("Er du sikker på, at du vil oprette konferencen?");

        Optional<ButtonType> result = confirmation.showAndWait();
        if ((result.isPresent()) && result.get() == ButtonType.OK) {
            konference = Controller.opretKonference(navn, pris, beskrivelse);
            if (udflugter.size() > 0) {
                for (Udflugt u : udflugter) {
                    konference.setUdflugt(u);
                }
            }
            txfNavn.clear();
            txfBeskrivelse.clear();
            txfStart.clear();
            txfSlut.clear();
            txfAdresse.clear();
            txfPris.clear();

            lvwUdflugter.getItems().clear();
            lvwHoteller.getItems().clear();
        }
    }

    private void tilføjHotelAction() {
        HotelWindow hw = new HotelWindow(konference);
        hw.showAndWait();

        if(hw.getHotel() != null) {
            hoteller.add(hw.getHotel());
        }

        lvwHoteller.getItems().setAll(hoteller);
    }

    private void tilføjUdflugtAction() {
        UdflugtWindow uw = new UdflugtWindow();
        uw.showAndWait();
        if (uw.getUdflugt() != null) {
            udflugter.add(uw.getUdflugt());
        }
        lvwUdflugter.getItems().setAll(udflugter);
    }

}
