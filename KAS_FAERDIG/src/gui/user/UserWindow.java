package gui.user;

import application.model.Konference;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import storage.Storage;

public class UserWindow extends Stage {

    private GridPane userWindow;
    private GridPane startWindow;

    public UserWindow(GridPane pane){
        this.setResizable(false);
        this.startWindow = pane;

        userWindow = new GridPane();
        this.initContent(userWindow);

    }

    private ListView<Konference> lvwKonferencer = new ListView<>();


    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblKonferencer = new Label("Konferencer: ");
        pane.add(lblKonferencer,0,0);
        GridPane.setHalignment(lblKonferencer,HPos.CENTER);

        pane.add(lvwKonferencer,0,1);
        GridPane.setHalignment(lvwKonferencer,HPos.CENTER);
        lvwKonferencer.getItems().setAll(Storage.getKonferencer());

        Button btnBack = new Button("Tilbage");
        pane.add(btnBack,0,2);
        GridPane.setHalignment(btnBack,HPos.LEFT);
        btnBack.setOnAction(event-> backAction());

        Button btnNext = new Button("Næste");
        pane.add(btnNext,0,2);
        GridPane.setHalignment(btnNext,HPos.RIGHT);
        btnNext.setOnAction(event-> nextAction());

    }

    public void backAction(){
        userWindow.getScene().setRoot(startWindow);
    }

    public void nextAction(){
        Konference konference = lvwKonferencer.getSelectionModel().getSelectedItem();
        RegisterWindow registerWindow = new RegisterWindow(this.userWindow,konference);
        this.userWindow.getScene().setRoot(registerWindow.getWindow());
    }

    public GridPane getWindow(){
        return userWindow;
    }




}
