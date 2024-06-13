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

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

public class AdminWindow extends Stage {

    private final GridPane adminPane = new GridPane();
    private final ListView<Konference> lvwKonferencer = new ListView<>();
    private ListView<Hotel> lvwHoteller;
    private ListView<Hotel> lvwValgteHoteller;
    private ListView<Udflugt> lvwUdflugter;
    private ArrayList<Udflugt> udflugter = new ArrayList<>();
    private ArrayList<Hotel> hoteller = new ArrayList<>();
    private ArrayList<Hotel> valgteHoteller = new ArrayList<>();
    private Konference konference;
    private GridPane startWindow;


    public AdminWindow(GridPane startWindow) {
        this.startWindow = startWindow;
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
    private DatePicker startPicker;
    private DatePicker slutPicker;



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

        startPicker = new DatePicker();
        Label lblStart = new Label("Start tidspunkt:");
//        adminPane.add(txfStart,0,3);
//        adminPane.add(lblStart,0,3);
        GridPane.setColumnSpan(startPicker,4);
        GridPane.setMargin(startPicker,new Insets(0,10,0,100));

        slutPicker = new DatePicker();
        Label lblSlut = new Label("Slut tidspunkt:");
//        adminPane.add(txfSlut,0,4);
//        adminPane.add(lblSlut,0,4);
        GridPane.setColumnSpan(slutPicker,4);
        GridPane.setMargin(slutPicker,new Insets(0,10,0,100));

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
        VBoxHøjre.getChildren().addAll(txfNavn,txfBeskrivelse,startPicker,slutPicker,txfAdresse,txfPris);

        hoteller = Storage.getHoteller();
        lvwHoteller = new ListView<>();
        adminPane.add(lvwHoteller,0,7);
        GridPane.setMargin(lvwHoteller,new Insets(0,10,0,0));
        lvwHoteller.getItems().setAll(hoteller);
        Button btnHotel = new Button("Opret hotel");
        adminPane.add(btnHotel,1,7);
        GridPane.setHalignment(btnHotel,HPos.CENTER);
        GridPane.setMargin(btnHotel,new Insets(0,0,0,-70));
        btnHotel.setOnAction(e -> this.tilføjHotelAction());

        lvwUdflugter = new ListView<>();
        adminPane.add(lvwUdflugter,2,7);
        GridPane.setMargin(lvwUdflugter,new Insets(0,0,0,-65));
        Button btnUdflugt = new Button("Tilføj udflugt");
        adminPane.add(btnUdflugt,3,7);
        GridPane.setHalignment(btnUdflugt,HPos.CENTER);
        GridPane.setMargin(btnUdflugt,new Insets(0,0,0,5));
        btnUdflugt.setOnAction(e -> this.tilføjUdflugtAction());

        Button btnTilbage = new Button("Tilbage");
        adminPane.add(btnTilbage,0,9);
        GridPane.setHalignment(btnTilbage,HPos.CENTER);
        GridPane.setMargin(btnTilbage,new Insets(10,0,10,0));
        btnTilbage.setOnAction(e-> tilbageAction());
        Button btnOpret = new Button("Opret konference");
        adminPane.add(btnOpret,2,9);
        GridPane.setHalignment(btnOpret,HPos.CENTER);
        GridPane.setMargin(btnOpret,new Insets(10,0,10,0));
        btnOpret.setOnAction(e -> this.opretKonferenceAction());

        lvwValgteHoteller = new ListView<>();
        adminPane.add(lvwValgteHoteller,0,8);
        GridPane.setMargin(lvwValgteHoteller,new Insets(0,10,0,0));
        lvwHoteller.getItems().setAll(Storage.getHoteller());
        Button btnVælgHotel = new Button("Vælg hotel");
        adminPane.add(btnVælgHotel,1,8);
        GridPane.setHalignment(btnVælgHotel,HPos.CENTER);
        GridPane.setMargin(btnVælgHotel,new Insets(0,0,0,-70));
        btnVælgHotel.setOnAction(e -> this.vælgHotelAction());
        
    }

    private void vælgHotelAction() {
        Hotel hotel = lvwHoteller.getSelectionModel().getSelectedItem();
        if (!valgteHoteller.contains(hotel)) {
            valgteHoteller.add(hotel);
        }
        hoteller.remove(hotel);
        updateControls();
    }

    private void tilbageAction() {
        adminPane.getScene().setRoot(startWindow);
    }

    private void opretKonferenceAction() {

        String navn = txfNavn.getText().trim();
        String beskrivelse = txfBeskrivelse.getText().trim();
        LocalDate tidStart = startPicker.getValue();
        LocalDate tidSlut = slutPicker.getValue();
        String adresse = txfAdresse.getText().trim();
        int pris = Integer.parseInt(txfPris.getText().trim());

        Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
        confirmation.setTitle("Opret konference");
        confirmation.setHeaderText("Er du sikker på, at du vil oprette konferencen?");

        Optional<ButtonType> result = confirmation.showAndWait();
        if ((result.isPresent()) && result.get() == ButtonType.OK) {
            konference = Controller.opretKonference(navn, pris, beskrivelse);
            konference.setTidsperiode(tidStart,tidSlut);
            if (udflugter.size() > 0) {
                for (Udflugt u : udflugter) {
                    konference.setUdflugt(u);
                }
            }
            if (valgteHoteller.size() > 0) {
                for (Hotel h : valgteHoteller){
                    konference.addHotel(h);
                }
            }
            txfNavn.clear();
            txfBeskrivelse.clear();
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
        updateControls();
    }

    private void tilføjUdflugtAction() {
        UdflugtWindow uw = new UdflugtWindow();
        uw.showAndWait();
        if (uw.getUdflugt() != null) {
            udflugter.add(uw.getUdflugt());
        }

        updateControls();
    }

    public void updateControls(){
        lvwHoteller.getItems().setAll(hoteller);
        lvwValgteHoteller.getItems().setAll(valgteHoteller);
        lvwUdflugter.getItems().setAll(udflugter);
    }

}
