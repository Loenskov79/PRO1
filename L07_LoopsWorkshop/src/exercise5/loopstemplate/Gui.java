package exercise5.loopstemplate;

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
        pane.setPrefSize(200, 200); // may be changed
        this.drawShapes(pane);
        return pane;
    }

    // ------------------------------------------------------------------------

    private void drawShapes(Pane pane) {
        Line line = new Line(10, 10, 150, 80);
        //pane.getChildren().add(line);
        String str = "Datamatiker";
        int x = 10;
        int y = 10;
        int count = 0;

        String currentSubstring ="";
        while (count < str.length()) {
            currentSubstring += str.charAt(count);
            Text text = new Text(x, y, currentSubstring);
            pane.getChildren().add(text);
            y+= 15;
            count++;
        }
    }
}

