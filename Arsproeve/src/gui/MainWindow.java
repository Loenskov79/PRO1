package gui;

import controller.Controller;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Deltager;
import model.Hold;
import model.Tur;
import storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;

public class MainWindow extends Application {

    private Scene scene;
    private static GridPane mainWindow;

    public void start(Stage stage) {
        stage.setTitle("Vi cykler til sønderhøj");
        mainWindow = new GridPane();
        this.initContent(mainWindow);

        scene = new Scene(mainWindow);

        stage.setScene(scene);
        stage.setResizable(false);
        stage.setMinHeight(400);
        stage.setMinWidth(400);
        stage.show();
    }

    private ListView<Hold> lvwHold = new ListView<>();
    private ListView<Deltager> lvwDeltagere = new ListView<>();
    private ListView<Tur> lvwTure = new ListView<>();
    private ArrayList<Hold> holds = new ArrayList<>();
    private TextField valgtDeltager = new TextField();
    private TextField kmIAlt = new TextField();
    private TextField minutterIAlt = new TextField();
    private TextField turDato = new TextField();
    private TextField turMinutter = new TextField();
    private TextField turKm = new TextField();

    public void initContent(GridPane pane) {
        pane.setPadding(new Insets(5));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(true);

        Label hold = new Label("Hold");
        pane.add(hold,0,0);

        Label deltagere = new Label("Deltagere");
        pane.add(deltagere,1,0);

        Label ture = new Label("Ture");
        pane.add(ture,2,0);

        holds = Storage.getHold();
        lvwHold.getItems().setAll(holds);
        pane.add(lvwHold,0,1);

        pane.add(lvwDeltagere,1,1);

        pane.add(lvwTure,2,1);

        pane.add(valgtDeltager,1,2);
        pane.add(kmIAlt,1,3);
        pane.add(minutterIAlt,1,4);

        Label turDatolbl = new Label("Tur dato:");
        Label turMinutterlbl = new Label("Tur minutter:");
        Label turKmlbl = new Label("Tur km:");
        pane.add(turDatolbl,2,2);
        pane.add(turMinutterlbl,2,3);
        pane.add(turKmlbl,2,4);
        pane.add(turDato,3,2);
        pane.add(turMinutter,3,3);
        pane.add(turKm,3,4);

        Button btnOpretTur = new Button("Opret tur");
        pane.add(btnOpretTur,3,5);

        ChangeListener<Hold> listener1 = (ov, oldVagt, newVagt) -> this.selectedHoldChanged();
        lvwHold.getSelectionModel().selectedItemProperty().addListener(listener1);

        ChangeListener<Deltager> listener2 = (ov, oldVagt, newVagt) -> this.selectedDeltagerChanged();
        lvwDeltagere.getSelectionModel().selectedItemProperty().addListener(listener2);

        btnOpretTur.setOnAction(e -> opretTurButtonAction());
    }

    private void selectedHoldChanged() {

        Hold hold = lvwHold.getSelectionModel().getSelectedItem();
        lvwDeltagere.getItems().setAll(hold.getDeltagere());

    }

    private void selectedDeltagerChanged() {

        Deltager deltager = lvwDeltagere.getSelectionModel().getSelectedItem();
        lvwTure.getItems().setAll(deltager.getTure());
        valgtDeltager.setText("Valgt deltager: " + deltager.getNavn());
        kmIAlt.setText("Km i alt: " + deltager.kmIAlt());
        int deltagerMinutterIAlt = 0;
        for (Tur t : deltager.getTure()) {
            deltagerMinutterIAlt += t.getAntalMinutter();
        }
        minutterIAlt.setText("Minutter i alt: " + deltagerMinutterIAlt);
    }

    private void opretTurButtonAction() {

        Deltager deltager = lvwDeltagere.getSelectionModel().getSelectedItem();

        LocalDate dato = LocalDate.parse(turDato.getText());
        int minutter = Integer.parseInt(turMinutter.getText());
        int km = Integer.parseInt(turKm.getText());

        deltager.createTur(dato, minutter, km);

        turDato.clear();
        turMinutter.clear();
        turKm.clear();

        selectedDeltagerChanged();

    }


}
