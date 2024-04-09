package Exercise2;

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

        Label number = new Label("Number:");
        pane.add(number, 0, 0);

        pane.add(txfNumber,1,0);

        Button decrement = new Button("Decrement");
        pane.add(decrement, 2, 0);
        GridPane.setMargin(decrement, new Insets(40, 10, 0, 10));

        Button increment = new Button("Increment");
        pane.add(increment, 2, 0);
        GridPane.setMargin(increment, new Insets(0, 10, 40, 10));

        decrement.setOnAction(event -> this.decrement());

        increment.setOnAction(event -> this.increment());

    }

    public void increment () {
        String number = txfNumber.getText().trim();
        int num = Integer.parseInt(number) + 1;
        txfNumber.setText(String.valueOf(num));
    }

    public void decrement () {
        String number = txfNumber.getText().trim();
        int num = Integer.parseInt(number) - 1;
        txfNumber.setText(String.valueOf(num));
    }
}
