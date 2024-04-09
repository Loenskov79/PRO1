package Exercise3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GUI extends Application {

    private TextField txInvestment = new TextField();
    private TextField txYears = new TextField();
    private TextField txInterest = new TextField();
    private TextField txFValue = new TextField();

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

        pane.add(txInvestment,1,0);
        pane.add(txYears,1,1);
        pane.add(txInterest,1,2);
        pane.add(txFValue,1,4);

        Label lblInvestment = new Label("Investment:");
        pane.add(lblInvestment, 0, 0);

        Label lblYears = new Label("Years:");
        pane.add(lblYears, 0, 1);

        Label lblInterest = new Label("Interest (%):");
        pane.add(lblInterest, 0, 2);

        Label lblFValue = new Label("Future value:");
        pane.add(lblFValue, 0, 4);

        Button calculate = new Button("Calculate");
        pane.add(calculate, 1, 3);

        calculate.setOnAction(event -> this.futureValue());
    }

    private void futureValue() {
        String invest = txInvestment.getText().trim();
        String years = txYears.getText().trim();
        String interest = txInterest.getText().trim();

        double inv = Double.parseDouble(String.valueOf(invest));
        double y = Double.parseDouble(String.valueOf(years));
        double i = Double.parseDouble(String.valueOf(interest));

        double FValue = inv * Math.pow(1+(i/100),y);
        txFValue.setText(String.valueOf(FValue));
    }
}
