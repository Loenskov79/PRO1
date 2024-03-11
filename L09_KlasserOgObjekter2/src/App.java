import javafx.scene.paint.Color;

public class App {
    public static void main(String[] args) {

        Car car = new Car();
        Car car1 = new Car(Color.BLUEVIOLET, 4, 4);

//        System.out.println(car.toString());
//        System.out.println(car1.toString());

		Gui.launch(Gui.class);
    }
}
