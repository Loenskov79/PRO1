package exercise1.loopstemplate;

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
        int height = 10*2;
        int length = 4*2;

        int x = 100;
        int y = 75;
        Line line1 = new Line(x,y,x + height, y - length);
        Line line2 = new Line(x, y, x + height, y + length);
        pane.getChildren().addAll(line1,line2);

        x = 100;
        y = 125;
        Line line3 = new Line(x, y, x + height, y - length);
        Line line4 = new Line(x, y, x + height, y + length);
        pane.getChildren().addAll(line3,line4);

        x = 20;
        y = 50;
        Line line5 = new Line(x, y, x + height, y - length);
        Line line6 = new Line(x, y, x + height, y + length);
        pane.getChildren().addAll(line5, line6);
    }
}
