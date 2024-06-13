package gui;

import controller.Controller;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.*;
import model.Medarbejder;
import model.Vagt;
import storage.Storage;

import javafx.beans.value.ChangeListener;
import java.util.ArrayList;

public class MainWindow extends Application {

    private Scene scene;
    private static GridPane mainWindow;

    public void start(Stage stage) {
        stage.setTitle("Kantinens vagtplanlægning");
        mainWindow = new GridPane();
        this.initContent(mainWindow);

        scene = new Scene(mainWindow);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setMinHeight(400);
        stage.setMinWidth(400);
        stage.show();
    }

    private ListView<Medarbejder> lvwMedarbejder = new ListView<>();
    private ListView<Vagt> lvwVagter = new ListView<>();
    private ArrayList<Medarbejder> medarbejdere = new ArrayList<>();
    private ArrayList<Vagt> vagter = new ArrayList<>();
    private TextArea txaValgtVagt = new TextArea();

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(5));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblAlleMedarbejdere = new Label("Alle medarbejdere");
        pane.add(lblAlleMedarbejdere,0,0);

        Label lblAlleVagter = new Label("Alle vagter");
        pane.add(lblAlleVagter,1,0);

        Label lblValgtVagt = new Label("Valgt vagt");
        pane.add(lblValgtVagt,2,0);

        medarbejdere = Storage.getMedarbejdere();
        pane.add(lvwMedarbejder,0,1);
        lvwMedarbejder.getItems().setAll(medarbejdere);

        vagter = Storage.getVagter();
        pane.add(lvwVagter,1,1);
        lvwVagter.getItems().setAll(vagter);

        pane.add(txaValgtVagt,2,1);

        Button btnTildel = new Button("Tildel vagt");
        pane.add(btnTildel,1,2);

        Button btnUdskriv = new Button("Udskriv vagt til fil");
        pane.add(btnUdskriv,2,2);

        ChangeListener<Vagt> listener1 = (ov, oldVagt, newVagt) -> this.selectedVagtChanged();
        lvwVagter.getSelectionModel().selectedItemProperty().addListener(listener1);

        btnTildel.setOnAction(e -> tildelButtonAction());
        btnUdskriv.setOnAction(e -> udskrivButtonAction());

    }

    private void tildelButtonAction() {
        Vagt vagt = lvwVagter.getSelectionModel().getSelectedItem();
        Medarbejder medarbejder = lvwMedarbejder.getSelectionModel().getSelectedItem();

        if (vagt != null && medarbejder != null) {
            medarbejder.addVagt(vagt);
        }
    }

    private void udskrivButtonAction() {
        Vagt vagt = lvwVagter.getSelectionModel().getSelectedItem();
        String fileName = "\\C:\\Users\\VicMan\\Desktop\\udskrivVagtplan.txt\\";

        if (vagt != null) {
            Controller.udskrivVagtplan(vagt, fileName);
        }
    }

    private void selectedVagtChanged() {

        Vagt vagt = lvwVagter.getSelectionModel().getSelectedItem();

        txaValgtVagt.setText("Navn: " + vagt.getNavn() + "\n" +
                "Fra: " + vagt.getTidFra() + "\n" +
                "Til: " + vagt.getTidTil() + "\n" +
                "Status: " + vagt.status() + "\n" +
                "Tilknyttede medarbejdere: \n" +
                medarbejdere.toString());

    }

}
