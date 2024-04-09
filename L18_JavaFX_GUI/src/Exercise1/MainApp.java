package Exercise1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class MainApp extends Application {

    private final TextField txfName = new TextField();
    private final TextField txlName = new TextField();
    private final TextField txFullName = new TextField();
    @Override
    public void start(Stage stage) {
        stage.setTitle("Gui Demo 2");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    private void initContent(GridPane pane) {

        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        // add a label to the pane (at col=0, row=0)
        Label lblName = new Label("First name:");
        pane.add(lblName, 0, 0);

        Label lblLastName = new Label ("Last name:");
        pane.add(lblLastName,1,0);

        Label lblFullName = new Label ("Full name:");
        pane.add(lblFullName,0,2);

        // add a text field to the pane (at col=1, row=0, extending 2 columns and 1 row)
        pane.add(txfName, 0, 1, 1, 1);

        pane.add(txlName, 1, 1, 1, 1);

        pane.add(txFullName,0,3,2,1);
        txFullName.setDisable(true);

        Button combine = new Button("Combine");
        pane.add(combine,0,4);
//        GridPane.setMargin(combine, new Insets(10, 200, 0, 10));

        combine.setOnAction(event -> this.combineText());
    }

    private void combineText() {
        String name = txfName.getText().trim();
        String lastName = txlName.getText().trim();
        String fullName = name + " " + lastName;
        txFullName.setText(fullName);
    }
}
