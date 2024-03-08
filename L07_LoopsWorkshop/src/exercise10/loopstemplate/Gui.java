package exercise10.loopstemplate;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.awt.*;

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
        Circle circle = new Circle();
        circle.setCenterX(100);
        circle.setCenterY(100);
        circle.setRadius(25);
        circle.setStrokeWidth(10);
        circle.setStroke(Color.YELLOW);
        circle.setFill(null);
        pane.getChildren().add(circle);
        int x = 100;
        int y = 70;
        int xradius = 16;
        int yradius = 8;
        Ellipse ellipse = new Ellipse(x, y, xradius, yradius);
        ellipse.setFill(Color.RED);
        pane.getChildren().add(ellipse);
    }
    private void drawRing(Pane pane, int x, int y) {

    }
}
