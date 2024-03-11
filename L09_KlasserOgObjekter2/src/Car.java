
import javafx.scene.paint.Color;

public class Car {

    private Color color;
    private int doors;
    private int wheels;

    public Car(Color color, int doors, int wheels) {
        this.color = color;
        this.doors = doors;
        this.wheels = wheels;
    }

    public Car() {
        this(Color.RED, 1, 3);
    }

    @Override
    public String toString() {
        return color + " vehicle with " + doors + " doors and " + wheels + " wheels.";
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }
}
