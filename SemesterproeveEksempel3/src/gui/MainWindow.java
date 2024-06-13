package gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Deltagelse;
import model.Fag;
import model.Lektion;
import storage.Storage;

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

    private ListView<Fag> lvwFag = new ListView<>();
    private ListView<Lektion> lvwLektion = new ListView<>();
    private ListView<Deltagelse> lvwDeltagelse = new ListView<>();
    private ArrayList<Fag> fags = new ArrayList<>();
    private ArrayList<Lektion> lektioner = new ArrayList<>();

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(5));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label fag = new Label("Fag");
        pane.add(fag,0,0);

        Label lektioner = new Label("Lektioner");
        pane.add(lektioner,1,0);

        Label deltagelse = new Label("Deltagelse");
        pane.add(deltagelse,2,0);

        fags = Storage.getFag();
        lvwFag.getItems().setAll(fags);
        pane.add(lvwFag,0,1);

        pane.add(lvwLektion,1,1);

        pane.add(lvwDeltagelse,2,1);
    }

}
