package exercise8.loopstemplate;

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
        int x = 16;
        int y = 160;
        int x1 = 16;
        int y1= 80;
        for (int i = 1; i < 10; i++) {
            Line line1 = new Line(x, y, x1, y1);
            pane.getChildren().add(line1);
            x += 16;
            x1 += 16;
            y = 160 - i * 12;
            y1 = 80 - i * 4;
        }
    }
}
