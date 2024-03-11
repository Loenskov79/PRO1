import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
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
        pane.setPrefSize(600, 350); // may be changed

        Car c1 = new Car();
        c1.setWheels(4);
        c1.setColor(Color.RED);
        c1.setDoors(2);
        this.drawCar(pane, c1);
        return pane;
    }

    // ------------------------------------------------------------------------

    private void drawShapes(Pane pane) {
        Line line = new Line(10, 10, 150, 80);
//        pane.getChildren().add(line);
    }

    private void drawCar(Pane pane, Car car) {

        Rectangle sky = new Rectangle();
        sky.setX (0);
        sky.setY(0);
        sky.setWidth(600);
        sky.setHeight(275);
        sky.setFill(Color.BLUE);
        pane.getChildren().add(sky);

        Rectangle rectangle = new Rectangle();

        rectangle.setX(150);
        rectangle.setY(95);
        rectangle.setWidth(car.getWheels()*70);
        rectangle.setHeight(130);
        rectangle.setFill(car.getColor());
        pane.getChildren().add(rectangle);

        Rectangle frontEnd = new Rectangle();

        frontEnd.setX(75);
        frontEnd.setY(125);
        frontEnd.setWidth(75);
        frontEnd.setHeight(100);
        frontEnd.setFill(car.getColor());
        pane.getChildren().add(frontEnd);

        Rectangle window = new Rectangle();
        window.setX(80);
        window.setY(130);
        window.setWidth(70);
        window.setHeight(40);
        window.setFill(Color.BLUE);
        pane.getChildren().add(window);

        for (int i =  0; i < car.getWheels(); i++) {
            Circle outerCircle = new Circle(185 + i*70, 250, 25);
            Circle innerCircle = new Circle (185 + i*70, 250, 15);
            outerCircle.setFill(Color.BLACK);
            innerCircle.setFill(Color.GREY);
            pane.getChildren().add(outerCircle);
            pane.getChildren().add(innerCircle);
        }

        for (int i = 0; i < car.getDoors(); i++) {
            Rectangle door = new Rectangle();
            door.setX(190 + i * 100);
            door.setY(125);
            door.setWidth(50);
            door.setHeight(85);
            door.setStroke(Color.BLACK);
            door.setFill(null);
            pane.getChildren().add(door);
        }

        Rectangle earth = new Rectangle();
        earth.setX (0);
        earth.setY(275);
        earth.setWidth(600);
        earth.setHeight(75);
        earth.setFill(Color.GREEN);
        pane.getChildren().add(earth);

        Circle sun = new Circle(575,0,100);
        sun.setFill(Color.YELLOW);
        pane.getChildren().add(sun);
    }


}
