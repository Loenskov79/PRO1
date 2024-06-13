package gui.user;

import application.model.*;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class LedsagerWindow extends Stage {
    private GridPane ledsagerWindow;
    private Ledsager ledsager;
    private ArrayList<Udflugt> udflugter = new ArrayList<>();
    private Konference konference;

    public LedsagerWindow(Konference konference){
        this.konference = konference;
        ledsagerWindow = new GridPane();
        this.initContent(ledsagerWindow);

        Scene scene = new Scene(ledsagerWindow);
        this.setScene(scene);
    }

    private TextField txfName;
    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblName = new Label("Navn:");
        pane.add(lblName,0,0);

        txfName = new TextField();
        pane.add(txfName,0,1);

        Button btnBack = new Button("Tilbage");
        pane.add(btnBack,0,2);
        GridPane.setHalignment(btnBack,HPos.LEFT);
        btnBack.setOnAction(event-> backAction());

        Button btnNext = new Button("Tilføj");
        pane.add(btnNext,0,2);
        GridPane.setHalignment(btnNext,HPos.RIGHT);
        btnNext.setOnAction(event-> tilmeldAction());
    }

    private void tilmeldAction() {
        String navn = txfName.getText().trim();
        Ledsager ledsager = new Ledsager(navn);
        this.ledsager = ledsager;
        UdflugtWindow udflugtWindow = new UdflugtWindow(ledsager,konference);
        udflugtWindow.showAndWait();
        udflugter = udflugtWindow.getUdflugter();
        if (udflugter.size() > 0){
            for (Udflugt u : udflugter){
                ledsager.addUdflugt(u);
            }
        }
        this.hide();
    }

    private void backAction() {
        ledsager = null;
        this.hide();
    }

    public Ledsager getLedsager() {
        return ledsager;
    }
}
