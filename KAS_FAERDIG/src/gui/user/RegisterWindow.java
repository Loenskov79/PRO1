package gui.user;

import application.controller.Controller;
import application.model.*;
import gui.StartWindow;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

public class RegisterWindow extends Stage {

    private GridPane registerWindow;
    private GridPane userWindow;
    private Konference konference;
    private Ledsager ledsager;
    private Deltager deltager;
    private Tilmelding tilmelding;
    private Hotel hotel;
    private Booking booking;
    private ArrayList<Tillæg> tillæg = new ArrayList<>();
    private DatePicker startPicker;
    private DatePicker slutPicker;

    public RegisterWindow(GridPane pane, Konference konference) {
        this.userWindow = pane;
        this.konference = konference;

        registerWindow = new GridPane();
        this.initContent(registerWindow);

    }

    private TextField txfName;
    private TextField txfTlf;
    private CheckBox cbForedragsholder;

    private void initContent(GridPane pane) {

        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblTitel = new Label(konference.getNavn());
        pane.add(lblTitel, 0, 0, 2, 1);
        lblTitel.setFont(Font.font("Verdana", FontWeight.BOLD, 30));

        Label lblName = new Label("Navn: ");
        pane.add(lblName, 0, 1);

        txfName = new TextField();
        pane.add(txfName, 1, 1);

        Label lblTlf = new Label("Tlf. Nr: ");
        pane.add(lblTlf, 0, 2);

        txfTlf = new TextField();
        pane.add(txfTlf, 1, 2);

        cbForedragsholder = new CheckBox("Foredragsholder: ");
        pane.add(cbForedragsholder, 0, 3);

        Button btnHotel = new Button("Vælg hotel");
        pane.add(btnHotel, 0, 4);
        GridPane.setHalignment(btnHotel, HPos.LEFT);
        btnHotel.setOnAction(e -> hotelAction());

        Button btnLedsager = new Button("Tilføj Ledsager");
        pane.add(btnLedsager, 0, 4);
        GridPane.setHalignment(btnLedsager, HPos.RIGHT);
        GridPane.setMargin(btnLedsager, new Insets(0, 0, 0, 100));
        btnLedsager.setOnAction(e -> ledsagerAction());


        Button btnBack = new Button("Tilbage");
        pane.add(btnBack, 0, 7);
        GridPane.setHalignment(btnBack, HPos.LEFT);
        btnBack.setOnAction(event -> backAction());

        Button btnNext = new Button("Tilmeld");
        pane.add(btnNext, 0, 7);
        GridPane.setHalignment(btnNext, HPos.RIGHT);
        btnNext.setOnAction(event -> tilmeldAction());

        Label lblAnkomst = new Label("Ankomst dato: ");
        pane.add(lblAnkomst,0,5);
        Label lblAfrejse = new Label("Afrejse dato: ");
        pane.add(lblAfrejse,0,6);

        startPicker = new DatePicker(konference.getStart());
        slutPicker = new DatePicker(konference.getSlut());
        pane.add(startPicker,1,5);
        pane.add(slutPicker,1,6);


    }

    private void hotelAction() {
        HotelWindow hotelWindow = new HotelWindow(konference);
        hotelWindow.showAndWait();
        if (hotelWindow.getHotel() != null) {
            hotel = hotelWindow.getHotel();
        }
        if (hotelWindow.getValgteTillæg().size() > 0) {
            tillæg = hotelWindow.getValgteTillæg();
        }
    }

    private void ledsagerAction() {
        LedsagerWindow ledsagerWindow = new LedsagerWindow(konference);
        ledsagerWindow.showAndWait();
        if (ledsagerWindow.getLedsager() != null) {
            ledsager = ledsagerWindow.getLedsager();
        }
    }

    private void tilmeldAction() {
        String name = txfName.getText().trim();
        String tlfNr = txfTlf.getText().trim();
        boolean foredragsholder = cbForedragsholder.isSelected();

        Deltager deltager = Controller.opretDeltager(name, foredragsholder, tlfNr);
        Tilmelding tilmelding = deltager.opretTilmelding(konference);

        String stringLedsager = new String();

        if (ledsager != null) {
            tilmelding.setLedsager(ledsager);
            ledsager.setTilmelding(tilmelding);
            this.tilmelding = tilmelding;
            stringLedsager = ledsager.getNavn();
            if (ledsager.getUdflugter().size() > 0){
                for (Udflugt u : ledsager.getUdflugter()){
                    ledsager.addUdflugt(u);
                    u.addDeltager(ledsager);
                }
            }
        } else {
            stringLedsager = "Nej";
        }

        if (hotel != null) {
            Booking booking = new Booking(hotel, tilmelding.harLedsager(), tilmelding);
            this.booking = booking;
            if (tillæg.size() > 0) {
                for (Tillæg t : tillæg) {
                    booking.addTillæg(t);
                }
            }
            tilmelding.setBooking(booking);
        }

        String stringBooking = new String();

        if (hotel != null) {
            stringBooking = hotel.getNavn() + "(";
            if (tillæg.size() > 0) {
                for (Tillæg t : tillæg) {
                    stringBooking += " " + t.getBeskrivelse();
                }
            }
            stringBooking += ")";
        }

        tilmelding.setTidsperiode(startPicker.getValue(),slutPicker.getValue());

        Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
        confirmation.setHeaderText("Bekræftelse");
        confirmation.setContentText(
                "Navn: " + deltager.getNavn() +
                        "\nTlf. nr: " + deltager.getTlfNr() +
                        "\nKonference: " + konference.getNavn() +
                        "\nLedsager : " + stringLedsager +
                        "\nBooking: " + stringBooking +
                        "\nTotal pris: " + tilmelding.getTotalPris()
        );

        Optional<ButtonType> result = confirmation.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            returnAction();
        }
    }

    private void backAction() {
        this.hide();
    }

    public GridPane getWindow() {
        return registerWindow;
    }

    private void returnAction() {
        registerWindow.getScene().setRoot(StartWindow.getWindow());
    }

}
