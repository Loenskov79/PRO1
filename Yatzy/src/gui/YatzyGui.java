package gui;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.YatzyDice;

import java.util.ArrayList;

public class YatzyGui extends Application {
    private YatzyDice dice = new YatzyDice();

    @Override
    public void start(Stage stage) {
        stage.setTitle("Yatzy");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    // -------------------------------------------------------------------------

    // txfValues shows the face values of the 5 dice.
    private final TextField[] txfValues = new TextField[5];
    // cbxHolds shows the hold status of the 5 dice.
    private final CheckBox[] cbxHolds = new CheckBox[5];
    // txfResults shows the obtained results.
    // For results not set yet, the possible result of 
    // the actual face values of the 5 dice are shown.
    private final ArrayList<TextField> txfResults = new ArrayList<>(15);
    // Shows points in sums, bonus and total.
    private final TextField txfSumSame = new TextField("0");
    private final TextField txfBonus = new TextField("0");
    private final TextField txfSumOther = new TextField("0");
    private final TextField txfTotal = new TextField("0");

    private final Label lblThrowCount = new Label();
    private final Button btnThrow = new Button(" Throw ");

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);

        // ---------------------------------------------------------------------

        GridPane dicePane = new GridPane();
        pane.add(dicePane, 0, 0);
        dicePane.setGridLinesVisible(false);
        dicePane.setPadding(new Insets(10));
        dicePane.setHgap(10);
        dicePane.setVgap(10);
        dicePane.setStyle("-fx-border-color: black");

        // add txfValues, chbHolds
        for (int i = 0; i < txfValues.length; i++) {
            txfValues[i] = new TextField();
            dicePane.add(txfValues[i], i, 0);
            txfValues[i].setPrefWidth(75);
            txfValues[i].setPrefHeight(75);
        }

        for (int i = 0; i < cbxHolds.length; i++) {
            cbxHolds[i] = new CheckBox();
            Label holds = new Label("Hold");
            dicePane.add(cbxHolds[i], i, 1);
            dicePane.add(holds, i, 1);
            GridPane.setHalignment(holds, HPos.CENTER);

        }
        // add lblThrowCount and btnThrow
        dicePane.add(btnThrow, 4, 2);
        lblThrowCount.setText("Throw " + dice.getThrowCount());
        btnThrow.setOnAction(event -> btnThrowAction());


        // ---------------------------------------------------------------------

        GridPane scorePane = new GridPane();
        pane.add(scorePane, 0, 1);
        scorePane.setGridLinesVisible(false);
        scorePane.setPadding(new Insets(10));
        scorePane.setVgap(2);
        scorePane.setHgap(10);
        scorePane.setStyle("-fx-border-color: black");
        int width = 50; // width of the text fields

        // add labels for results
        // add txfResults,
        String[] categories = {"1-s", "2-s", "3-s", "4-s", "5-s", "6-s", "", "One Pair", "Two Pairs", "Three-same", "Four-same", "Full House", "Small Str.", "Large Str.", "Chance", "Yatzy"};

        for (int i = 0; i < categories.length; i++) {

            TextField textField = new TextField();
            Label label = new Label(categories[i]);

            if (i == 6) {

            } else {

                scorePane.add(label, 0, i);
                scorePane.add(textField, 1, i);
                txfResults.add(textField);
            }
        }

        for (int i = 0; i < txfResults.size(); i++) {
            txfResults.get(i).setOnMouseClicked(event -> mouseClickOnTextfield(event));
        }

        Label bonus = new Label("Bonus");
        scorePane.add(bonus,2, 6);
        // add labels and text fields for sums, bonus and total.
        Label sum = new Label("Sum");
        Label total = new Label ("TOTAL");
        Label sum1 = new Label("Sum");
        scorePane.add(sum,2,5);
        scorePane.add(sum1,2,15);
        scorePane.add(total,2,16);
        scorePane.add(txfSumSame,3,5);
        scorePane.add(txfBonus,3,6);
        scorePane.add(txfSumOther,3,15);
        scorePane.add(txfTotal,3,16);

    }

    // -------------------------------------------------------------------------

    // Create an action method for btnThrow's action.
    // Hint: Create small helper methods to be used in the action method.
    private void btnThrowAction() {

        boolean[] hold = new boolean[5];
        for (int i = 0; i < cbxHolds.length; i++) {
            if (cbxHolds[i].isSelected()) {
                hold[i] = true;
            }
        }

        dice.throwDice(hold);

        for (int i = 0; i < txfValues.length; i++) {
            txfValues[i].setText(String.valueOf(dice.getValues()[i]));
        }
        btnThrow.setText("Throw " + dice.getThrowCount());

        for (int i = 0; i < txfResults.size(); i++ ) {

            if (txfResults.get(i).isEditable() != false) {
                txfResults.get(i).setText(String.valueOf(dice.getResults()[i]));
                txfResults.get(i).setStyle("-fx-control-inner-background: yellow");
            }

        }

        if (dice.getThrowCount() == 3) {
            btnThrow.setDisable(true);
        }
    }

    // -------------------------------------------------------------------------

    // Create a method for mouse click on one of the text fields in txfResults.
    // Hint: Create small helper methods to be used in the mouse click method.
    private void mouseClickOnTextfield(MouseEvent event) {
        TextField txf = (TextField) event.getSource();
        if (!txf.getText().isBlank()) {
            for (int i = 0; i < txfResults.size(); i++) {
                if (txf == txfResults.get(i)) {
                    txfResults.get(i).setDisable(true);
                    txfResults.get(i).setStyle("-fx-control-inner-background: white");
                    txfResults.get(i).setEditable(false);

                    int sumSame = 0;
                    int sumOther = 0;
                    int bonus = 0;
                    int total = 0;

                    if (i < 6) {
                        sumSame = Integer.parseInt(txfSumSame.getText()) + Integer.parseInt(txfResults.get(i).getText());
                        txfSumSame.setText(String.valueOf(sumSame));
                    }

                    if (i >= 6) {
                        sumOther = Integer.parseInt(txfSumOther.getText()) + Integer.parseInt(txfResults.get(i).getText());
                        txfSumOther.setText(String.valueOf(sumOther));
                    }

                    if (sumSame >= 63) {
                        txfBonus.setText("50");
                    }

                    total = Integer.parseInt(txfSumSame.getText()) + Integer.parseInt(txfSumOther.getText()) + Integer.parseInt(txfBonus.getText());
                    txfTotal.setText(String.valueOf(total));
                }

                if (txfResults.get(i).isEditable() != false) {
                    txfResults.get(i).clear();
                }

            }
            dice.resetThrowCount();
            btnThrow.setText("Throw");
            btnThrow.setDisable(false);

            for (int i = 0; i < cbxHolds.length; i++) {
                cbxHolds[i].setSelected(false);
            }

            for (int i = 0; i < txfValues.length; i++) {
                txfValues[i].clear();
            }
        }
    }
}
