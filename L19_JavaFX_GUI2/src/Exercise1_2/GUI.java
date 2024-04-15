package Exercise1_2;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
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

    private final ListView<Person> lvwNames = new ListView<>();
    private final ArrayList<Person> names = new ArrayList<>();
    private final TextField txName = new TextField();
    private final TextField txTitle = new TextField();
//    private final TextArea txPersons = new TextArea();
    private final CheckBox checkbox = new CheckBox();
    private final Button addPerson = new Button("Add person");
    private final Alert alert = new Alert(Alert.AlertType.INFORMATION);

    private void initContent(GridPane pane) {
        // show or hide grid lines
        pane.setGridLinesVisible(false);
        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        Label name = new Label("Name:");
        Label title = new Label("Title:");
        Label persons = new Label("Persons:");
        Label senior = new Label("Senior");
        GridPane.setMargin(senior, new Insets(0, 0, 0, 20));
        GridPane.setHalignment(addPerson, HPos.RIGHT);

        alert.setTitle("Add person");
        alert.setHeaderText("No name or title typed");
        alert.setContentText("Type the name/title of the person");

        pane.add(name,0,0);
        pane.add(title,0,1);
        pane.add(senior,1,2);
        pane.add(persons,0,3);

        pane.add(txName,1,0);
        pane.add(txTitle,1,1);
        pane.add(lvwNames,1,3);

        pane.add(checkbox,1,2);
        pane.add(addPerson,2,2);

        addPerson.setOnAction(event -> addAction());

    }

    public void addAction() {
        String name = txName.getText().trim();
        String title = txTitle.getText().trim();
        boolean senior = checkbox.isSelected();

        if (txName.getText().trim().isEmpty() || txTitle.getText().trim().isEmpty()) {
            alert.show();
        } else {
            Person person = new Person(name, title, senior);
            names.add(person);
            lvwNames.getItems().setAll(names);
        }
    }
}
