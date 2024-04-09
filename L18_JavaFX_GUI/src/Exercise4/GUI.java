package Exercise4;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

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

    private final TextField txfNumber = new TextField();

    private void initContent(GridPane pane) {
        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        Label number = new Label("Degrees: ");
        pane.add(number, 0, 0);

        pane.add(txfNumber, 1, 0);

        Button fahrenheit = new Button("Turn to fahrenheit");
        pane.add(fahrenheit, 2, 0);
        GridPane.setMargin(fahrenheit, new Insets(40, 10, 0, 10));

        Button celcius = new Button("Turn to celcius");
        pane.add(celcius, 2, 0);
        GridPane.setMargin(celcius, new Insets(0, 10, 40, 10));

        fahrenheit.setOnAction(event -> this.fahrenheit());

        celcius.setOnAction(event -> this.celcius());

    }

    public void fahrenheit() {
        String number = txfNumber.getText().trim();
        double num = Double.parseDouble(number);
        double fahrentheit = (num * 9 / 5) + 32;
        txfNumber.setText(String.valueOf(fahrentheit));
    }

    public void celcius() {
        String number = txfNumber.getText().trim();
        double num = Double.parseDouble(number);
        double celcius = (num-32) * 5/9;
        txfNumber.setText(String.valueOf(celcius));
    }
}



