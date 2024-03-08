package exercise11.loopstemplate;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
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
        pane.setPrefSize(300, 200); // may be changed
        this.print(pane);
        return pane;
    }

    // ------------------------------------------------------------------------

    private void drawShapes(Pane pane) {
        Line line = new Line(10, 10, 150, 80);
        //pane.getChildren().add(line);
        int x = 50; // center: (x,y)
        int y = 100;
        int r = 40; // radius: r
        while (x <= 150) {
            Circle circle = new Circle(x, y, r);
            circle.setStroke(Color.BLACK);
            circle.setFill(null);
            pane.getChildren().add(circle);
            x += 25;
        }
    }
    private void print(Pane pane) {
        drawCircleAndCross(pane, 5);
    }

    private void drawCircleAndCross(Pane pane, int numberOfCircles) {
        int x = numberOfCircles * 40;
        int y = 100;
        int r = 40;
        for (int i = 1; i <= numberOfCircles; i++) {
            x = i * 40;
            Circle circle = new Circle(x, y, r);
            circle.setStroke(Color.BLACK);
            circle.setFill(null);
            pane.getChildren().add(circle);
        }
    }
}
