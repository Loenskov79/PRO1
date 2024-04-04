package E313;

public class CarTester {

    public static void main(String[] args) {
        Car myCar = new Car(50);
        myCar.addGas(25);
        System.out.println(myCar.getCurrentGasInTank());
    }

}
