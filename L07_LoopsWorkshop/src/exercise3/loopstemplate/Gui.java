package exercise3.loopstemplate;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
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
        /*int x  = 20;
        int y1 = 200;
        int y2 = 10;
        while (x <= 220) {
            Line line1 = new Line(x, y1, x, y2);
            pane.getChildren().add(line1);
            x += 40;
        }
        int x1 = 20;
        int x2 = 180;
        int y = 220;
        while (y >= 20) {
            Line line1 = new Line(x1, y, x2, y);
            pane.getChildren().add(line1);
            y -= 40;
        }*/
        int x1 = 90;
        int x2 = 110;
        int y = 20;
        while (y <= 220) {
            Line line1 = new Line(x1, y, x2, y);
            pane.getChildren().add(line1);
            y += 40;
            x1 -= 20;
            x2 += 20;
        }
    }
}
