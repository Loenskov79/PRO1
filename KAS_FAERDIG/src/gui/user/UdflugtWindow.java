package gui.user;

import application.controller.Controller;
import application.model.*;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import storage.Storage;

import java.util.ArrayList;
import java.util.List;

public class UdflugtWindow extends Stage {
    private Ledsager ledsager;
    private Konference konference;
    private GridPane udflugtWindow;

    public UdflugtWindow(Ledsager ledsager, Konference konference){
        this.konference = konference;
        this.ledsager = ledsager;

        this.udflugtWindow = new GridPane();
        this.initContent(udflugtWindow);

        Scene scene = new Scene(udflugtWindow);
        this.setScene(scene);
    }

    private ListView<Udflugt> lvwUdflugter;
    private ListView<Udflugt> lvwValgteUdflugter;
    private ArrayList<Udflugt> udflugter = new ArrayList<>();
    private ArrayList<Udflugt> valgteUdflugter = new ArrayList<>();
    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        udflugter = konference.getUdflugter();

        Label lblUdflugter = new Label("Udlugter: ");
        pane.add(lblUdflugter,0,0);

        Label lblValgteUdflugter = new Label("Valgte: ");
        pane.add(lblValgteUdflugter,1,0);

        lvwUdflugter = new ListView<>();
        pane.add(lvwUdflugter,0,1);
        lvwUdflugter.getItems().setAll(udflugter);

        lvwValgteUdflugter = new ListView<>();
        pane.add(lvwValgteUdflugter,1,1);

        HBox hb = new HBox(50);
        pane.add(hb,0,2,2,1);
        Button btnBack = new Button("Tilbage");
        Button btnVælg = new Button("Vælg");
        Button btnGem = new Button("Gem");
        hb.getChildren().setAll(btnBack,btnVælg,btnGem);

        btnBack.setOnAction(e-> backAction());
        btnVælg.setOnAction(e-> vælgAction());
        btnGem.setOnAction(e-> gemAction());

    }

    private void gemAction() {
        this.hide();
    }

    private void vælgAction() {
        Udflugt udflugt = lvwUdflugter.getSelectionModel().getSelectedItem();
        valgteUdflugter.add(udflugt);
        udflugter.remove(udflugt);
        lvwValgteUdflugter.getItems().setAll(valgteUdflugter);
        lvwUdflugter.getItems().setAll(udflugter);
    }

    private void backAction() {
        valgteUdflugter = null;
        this.hide();
    }

    public ArrayList<Udflugt> getUdflugter(){
        return new ArrayList<>(valgteUdflugter);
    }

}
