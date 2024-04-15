package Exercise3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
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

        PersonGUIWindow = new PersonGUI("Person Information", stage);
    }

    private final ListView<Person> lvwNames = new ListView<>();
    private final ArrayList<Person> persons = new ArrayList<>();
    private final Button addPerson = new Button("Add person");
    private PersonGUI PersonGUIWindow;


    private void initContent(GridPane pane) {
        // show or hide grid lines
        pane.setGridLinesVisible(false);
        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        Label persons = new Label("Persons:");
        pane.add(persons,0,0);
        pane.add(lvwNames,0,1);
        pane.add(addPerson,1,1);

        addPerson.setOnAction(event -> addAction());
    }

    public void addAction() {
        PersonGUIWindow.showAndWait();

        if(PersonGUIWindow.getActualPerson() != null) {
            Person person = PersonGUIWindow.getActualPerson();
            persons.add(person);
            lvwNames.getItems().setAll(persons);
        }
    }


}
