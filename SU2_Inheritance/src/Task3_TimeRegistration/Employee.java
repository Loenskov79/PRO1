package Task3_TimeRegistration;

public class Employee extends Person{

    private double hourlyWage;

    public Employee(String name, String adress, String phoneNumber, double hourlyWage) {

        super(name, adress, phoneNumber);

        this.hourlyWage = hourlyWage;
    }

    public void setHourlyWage(double hourlyWage) {
        this.hourlyWage = hourlyWage;
    }

    public double getHourlyWage() {
        return hourlyWage;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("My hourly wage is: " + hourlyWage);
    }
}
