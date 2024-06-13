package gui;

import application.model.Konference;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import storage.Storage;

public class UserWindow extends Stage {

    private GridPane userPane = new GridPane();
    private ListView<Konference> konferencer = new ListView<>();

    public UserWindow() {
        this.setResizable(false);

        this.initContent(userPane);
    }

    public GridPane getUserPane() {
        return userPane;
    }

    public void initContent(GridPane pane) {
        userPane.add(konferencer,0,1);
        konferencer.getItems().setAll(Storage.getKonferencer());

        Label lblHeading = new Label("Konferencer");
        userPane.add(lblHeading,0,0);
        GridPane.setHalignment(lblHeading, HPos.CENTER);
        GridPane.setMargin(lblHeading,new Insets(10,0,10,0));

        Button næste = new Button("Næste");
        userPane.add(næste,0,2);
        GridPane.setHalignment(næste,HPos.RIGHT);
        GridPane.setMargin(næste,new Insets(10,0,10,0));

        Button tilbage = new Button("Tilbage");
        userPane.add(tilbage,0,2);
        GridPane.setHalignment(tilbage,HPos.LEFT);
        GridPane.setMargin(tilbage,new Insets(10,0,10,0));
    }

}
