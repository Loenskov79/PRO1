package gui;

import controller.Controller;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Bane;
import model.Booking;
import model.Spiller;
import storage.Storage;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class MainWindow extends Application {

    private Scene scene;
    private static GridPane mainWindow;
    public void start(Stage stage) {

        stage.setTitle("Padelbooking");
        mainWindow = new GridPane();
        this.initContent(mainWindow);

        scene = new Scene(mainWindow);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setMinHeight(400);
        stage.setMinWidth(400);
        stage.show();
    }

    private ListView<Bane> lvwBaner = new ListView<>();
    private ListView<Spiller> lvwSpillere = new ListView<>();
    private ArrayList<Spiller> spillere = new ArrayList<>();
    private ArrayList<Bane> baner = new ArrayList<>();
    private TextArea txaBookinger = new TextArea();
    private TextArea txaSpillerBookinger = new TextArea();
    private TextField txfDato = new TextField();
    private TextField txfTid = new TextField();
    private CheckBox cbSingle = new CheckBox();

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(5));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblBaner = new Label("Baner");
        pane.add(lblBaner,0,0);

        Label lblSpillere = new Label("Spillere");
        pane.add(lblSpillere,1,0);

        Label lblBookinger = new Label("Spillerens bookinger");
        pane.add(lblBookinger,2,0);

        Label lblAntalBookinger = new Label("Antal bookinger på banen");
        pane.add(lblAntalBookinger,0,2);

        Label lblOpretBooking = new Label("Opret booking:");
        Label lblDato = new Label("Dato:");
        Label lblTid = new Label("Tid:");

        Button btnBook = new Button("Book bane til spiller");
        btnBook.setOnAction(event -> bookButtonAction());

        Label lblSingle = new Label("Single");

        pane.add(txaBookinger,0,3);
        pane.add(txaSpillerBookinger,2,1);

        baner = Storage.getBaner();
        pane.add(lvwBaner,0,1);
        lvwBaner.getItems().setAll(baner);
        lvwBaner.setMaxHeight(200);

        spillere = Storage.getSpillere();
        pane.add(lvwSpillere,1,1);
        lvwSpillere.getItems().setAll(spillere);
        lvwSpillere.setMaxHeight(200);

        VBox vBox1 = new VBox(5);
        vBox1.setPadding(new Insets(2.5));
        vBox1.getChildren().addAll(lblOpretBooking,lblDato,lblTid,btnBook);

        VBox vBox2 = new VBox(5);
        vBox2.setPadding(new Insets(2.5));
        vBox2.getChildren().addAll(txfDato,txfTid,cbSingle,lblSingle);

        HBox hBox = new HBox(10);
        hBox.setPadding(new Insets(5));
        hBox.getChildren().addAll(vBox1,vBox2);
        pane.add(hBox,2,2);

        ChangeListener<Bane> listener1 = (ov, oldBane, newBane) -> this.selectedBaneChanged();
        lvwBaner.getSelectionModel().selectedItemProperty().addListener(listener1);

        ChangeListener<Spiller> listener2 = (ov, oldSpiller, newSpiller) -> this.selectedSpillerChanged();
        lvwSpillere.getSelectionModel().selectedItemProperty().addListener(listener2);

    }

    private void bookButtonAction() {
        Spiller spiller = lvwSpillere.getSelectionModel().getSelectedItem();
        Bane bane = lvwBaner.getSelectionModel().getSelectedItem();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate dato = LocalDate.parse(txfDato.getText());
        LocalTime tid = LocalTime.parse(txfTid.getText());
        boolean single = cbSingle.isSelected();

        if (Controller.findLedigBane(dato, tid, bane.getKategori()).equals(true)) {
            Booking booking = spiller.createBooking(dato, tid, single, bane);
            txaSpillerBookinger.setText(booking.toString());
        }
    }

    private void selectedSpillerChanged() {
        StringBuilder str = new StringBuilder();
        Spiller spiller = lvwSpillere.getSelectionModel().getSelectedItem();
        Bane bane = lvwBaner.getSelectionModel().getSelectedItem();

        for (Booking b : spiller.getBookings()) {
            if (b.getBane() == bane) {
                str.append(b.getDato() + " Kl. " + b.getTid() + " Single: " + b.isSingle() + " bane nr. " + b.getBane().getNummer() + ", " + b.getSpiller());
            }
        }

        txaSpillerBookinger.setText(str.toString());



    }

    private void selectedBaneChanged() {

        Bane bane = lvwBaner.getSelectionModel().getSelectedItem();

        txaBookinger.setText("Tid:" + bane.antalBookningerPrTime().toString());


    }
}
