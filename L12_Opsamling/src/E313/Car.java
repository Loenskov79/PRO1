package E313;

public class Car {

    private int fuelEfficiency;
    private int gas;

    public Car(int fuelEfficiency) {
        this.fuelEfficiency = fuelEfficiency;
        this.gas = 0;
    }

    public int addGas(int gas) {
        return this.gas += gas;
    }

    public int getCurrentGasInTank () {
        return this.gas;
    }

    public void drive(int miles) {

    }
}
