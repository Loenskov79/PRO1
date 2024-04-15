package Exercise5;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class GUI extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("GUI");
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final TextField txfName = new TextField();
    private final TextArea txfArrayOfNames = new TextArea();

    private void initContent(GridPane pane) {
        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        Label lblName = new Label("Name:");
        pane.add(lblName,0,0);

        pane.add(txfName,0,1);

        Button add = new Button("Add");
        GridPane.setHalignment(add, HPos.CENTER);
        pane.add(add,0,2);


        pane.add(txfArrayOfNames,0,3);
        txfArrayOfNames.setEditable(false);

        add.setOnAction(event -> this.addPerson());
    }

    private void addPerson() {

        String name = txfName.getText().trim();
        ArrayList<String> allNames = new ArrayList<>();

        allNames.add(name.toString());

        for (String names: allNames) {
            txfArrayOfNames.appendText(names + "\n");
        }
        txfName.clear();
    }
}
