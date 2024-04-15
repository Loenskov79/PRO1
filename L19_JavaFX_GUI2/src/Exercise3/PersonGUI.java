package Exercise3;

import demotwowindows.Movie;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;

public class PersonGUI extends Stage {

    public PersonGUI(String title, Stage owner) {
        this.initOwner(owner);
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setMinHeight(100);
        this.setMinWidth(200);
        this.setResizable(false);

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }
    // ----------------------------------------------------------------

    private final TextField txName = new TextField();
    private final TextField txTitle = new TextField();
    private final CheckBox checkbox = new CheckBox();
    private final Button ok = new Button("OK");
    private final Button Cancel = new Button("Cancel");
    private Person actualPerson = null;


    private void initContent(GridPane pane) {

        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label name = new Label("Name:");
        Label title = new Label("Title:");
        Label senior = new Label("Senior");
        pane.add(name,0,0);
        pane.add(title,0,1);
        pane.add(txName,1,0);
        pane.add(txTitle,1,1);
        pane.add(checkbox,1,3);
        pane.add(senior,1,3);
        GridPane.setMargin(senior,new Insets(0,0,0,20));

        HBox buttonBox = new HBox(20);
        pane.add(buttonBox, 1, 4);
        buttonBox.setPadding(new Insets(10, 10, 0, 10));
        buttonBox.setAlignment(Pos.TOP_RIGHT);

        buttonBox.getChildren().add(Cancel);
        Cancel.setOnAction(event -> this.cancelAction());

        buttonBox.getChildren().add(ok);
        ok.setOnAction(event -> this.okAction());

    }

    public void okAction() {
        String name = txName.getText().trim();
        String title = txTitle.getText().trim();
        boolean senior = checkbox.isSelected();

        if (title.length() > 0 && name.length() > 0) {

            actualPerson = new Person(name, title, senior);
            txName.clear();
            txTitle.clear();
            txName.requestFocus();
            PersonGUI.this.hide();

        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Create movie");
            alert.setHeaderText("Information missing");
            alert.setContentText("Type title and actor");
            alert.show();
        }
    }

    public void cancelAction() {
        txName.clear();
        txTitle.clear();
        actualPerson = null;
        PersonGUI.this.hide();
    }

    public Person getActualPerson() {
        return actualPerson;
    }

    public void clearActualPerson() {
        actualPerson = null;
    }
}
