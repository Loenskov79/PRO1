package exercise6.loopstemplate;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Gui extends Application {

    @Override
    public void start(Stage stage) {
        Pane root = this.initContent();
        Scene scene = new Scene(root);

        stage.setTitle("Loops"); // may be changed
        stage.setScene(scene);
        stage.show();
    }

    private Pane initContent() {
        Pane pane = new Pane();
        pane.setPrefSize(200, 250); // may be changed
        this.drawAxis2(pane);
        return pane;
    }

    // ------------------------------------------------------------------------

    private void drawShapes(Pane pane) {
        Line line = new Line(10, 10, 150, 80);
        //pane.getChildren().add(line);
        int x = 10;
        int x1 = 180;
        int y = 180;
        int y1 = 180;
        Line line1 = new Line(x, x1, y, y1);
        pane.getChildren().add(line1);
        Line line2 = new Line(180, 180, 170, 183);
        Line line3 = new Line(180, 180, 170, 177);
        pane.getChildren().addAll(line2, line3);
        y = 177;
        y1 = 183;
        for (int i = 0; i < 11; i++) {
            x = 15 + i * 14;
            Line line4 = new Line(x, y, x, y1);
            pane.getChildren().add(line4);
        }
    }
    private void drawAxis2(Pane pane) {
        int x = 10;
        int y = 180;
        int x1 = 180;
        int y1 = 180;

        Line line1 = new Line(x, y, x1, y1);
        pane.getChildren().add(line1);

        Line line2 = new Line(180, 180, 170, 183);
        Line line3 = new Line(180, 180, 170, 177);
        pane.getChildren().addAll(line2,line3);

        int verticalLineX = 10;
        int verticalLineY1 = 170;
        int verticalLineY2 = 190;
        for (int i = 0; i < 11; i++) {
            if (i % 5 == 0) {
                Line verticalLine = new Line(verticalLineX, verticalLineY1 - 10, verticalLineX, verticalLineY2+10);
                pane.getChildren().add(verticalLine);
            } else {
                Line verticalLine = new Line(verticalLineX, verticalLineY1, verticalLineX, verticalLineY2);
                pane.getChildren().add(verticalLine);
            }

            // Tilføjer markeringer
            if (i == 0 || i == 5 || i == 10) {
                Text text = new Text(verticalLineX-5, verticalLineY2+20, Integer.toString(i));
                pane.getChildren().add(text);
            }
            verticalLineX += 14;
        }
    }
}
