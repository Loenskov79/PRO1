package GUIBilOpgave;

import javafx.animation.Animation;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.animation.AnimationTimer;

public class Gui extends Application {

    private Rectangle sky;
    private int blueValue = 255;

    @Override
    public void start(Stage stage) {
        Pane root = this.initContent();
        Scene scene = new Scene(root);

        stage.setTitle("Loops"); // may be changed
        stage.setScene(scene);
        stage.show();

        AnimationTimer timer = new AnimationTimer() {
            private boolean isDarkening = true;
            @Override
            public void handle(long now) {
                if (isDarkening) {
                    blueValue -= 1;
                    if (blueValue <= 0) {
                        blueValue = 0;
                        isDarkening = false;
                    }
                } else {
                    blueValue += 1;
                    if (blueValue >= 255);
                    blueValue = 255;
                    isDarkening = true;
                }

                sky.setFill(Color.rgb(0, 0, blueValue));
            }
        };
        timer.start();
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

        sky = new Rectangle();
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
        for (int i = 0; i < car.getDoors(); i++) {
            Line handle = new Line();
            handle.setStartX(235 + i * 100);
            handle.setStartY(180);
            handle.setEndX(225 + i * 100);
            handle.setEndY(180);
            pane.getChildren().addAll(handle);
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

        Circle head = new Circle(115,150,10);
        head.setFill(Color.BLACK);
        pane.getChildren().add(head);

        Circle eye1 = new Circle(112,146,2);
        eye1.setFill(Color.WHITE);
        Circle eye2 = new Circle(118,146,2);
        eye2.setFill(Color.WHITE);
        pane.getChildren().addAll(eye1,eye2);

        Line personBody = new Line(115, 160, 115, 170);
        pane.getChildren().add(personBody);

        Line arm1 = new Line(115, 170, 105, 160);
        Line arm2 = new Line(115,170,105,165);
        pane.getChildren().addAll(arm1,arm2);
    }


}
