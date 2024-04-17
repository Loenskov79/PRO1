package Exercise3;

public class App {

    public static void main(String[] args) {

        Car c1 = new Car("ABCD207", 2014);
        Car c2 = new Car("ACBD188", 1980);
        Car c3 = new Car("GJNS902", 2018);
        Car c4 = new Car("KLOW302", 2003);
        Car c5 = new Car("MAII111", 2010);

        Rental r1 = new Rental(1, 30, "17/04/2024");
        Rental r2 = new Rental(2, 60, "10/3/2024");

        r1.addCar(c1);
        r1.addCar(c2);
        r1.addCar(c3);
        r2.addCar(c4);
        r2.addCar(c5);

        c1.setPricePerDay(55);
        c2.setPricePerDay(27.5);
        c3.setPricePerDay(18);
        c4.setPricePerDay(65);
        c5.setPricePerDay(23.7);

        System.out.println("The total price of all the cars in r1 is: " + r1.getPrice());
        System.out.println("The total price of all the cars in r2 is: " + r2.getPrice());

    }

}
