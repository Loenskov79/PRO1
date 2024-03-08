package exercise4.loopstemplate;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
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
        pane.setPrefSize(200, 200); // may be changed
        this.drawShapes(pane);
        return pane;
    }

    // ------------------------------------------------------------------------

    private void drawShapes(Pane pane) {
        Line line = new Line(10, 10, 150, 80);
        //pane.getChildren().add(line);
        int x = 100;
        int y = 100;
        int r = 20;
        while (r <= 100) {
            Circle circle = new Circle(x, y, r);
            circle.setStroke(Color.BLACK);
            circle.setFill(null);
            pane.getChildren().add(circle);
            r += 20;
        }
    }

    private void drawShapes2(Pane pane) {
        Line line = new Line(10, 10, 150, 80);
        //pane.getChildren().add(line);
        int x = 10;
        int y = 100;
        int r = 10;
        while (r <= 80) {
            Circle circle = new Circle(x, y, r);
            circle.setStroke(Color.BLACK);
            circle.setFill(null);
            pane.getChildren().add(circle);
            r += 10;
            x += 10;
        }
    }
    private void drawShapes3(Pane pane) {
        Line line = new Line(10, 10, 150, 80);
        //pane.getChildren().add(line);
        int x = 100;
        int y = 100;
        int xradius = 15;
        int yradius = 30;
        while (xradius <= 90) {
            Ellipse ellipse = new Ellipse(x, y, xradius, yradius);
            ellipse.setStroke(Color.BLACK);
            ellipse.setFill(null);
            pane.getChildren().add(ellipse);
            xradius += 10;
        }
    }
}
