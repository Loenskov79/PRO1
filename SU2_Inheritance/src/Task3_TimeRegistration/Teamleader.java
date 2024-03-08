package Task3_TimeRegistration;

import java.time.Year;

public class Teamleader extends Person {

    private String fieldOfResponsibility;
    private double monthlySalary;

    Teamleader(String name, String adress, String phoneNumber, String fieldOfResponsibility, double monthlySalary) {
        super(name, adress, phoneNumber);

        this.fieldOfResponsibility = fieldOfResponsibility;
        this.monthlySalary = monthlySalary;

    }

    public String getFieldOfResponsibility() {
        return fieldOfResponsibility;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public double getYearlySalary() {
        double yearlyHolidayPay = monthlySalary * 0.125 * 12;
        double yearlySalary = monthlySalary * 12 + yearlyHolidayPay;

        return yearlySalary;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("My monthly salary is: " + monthlySalary);
        System.out.println("My field of responsibility is: " + fieldOfResponsibility);
        System.out.println("My yearly salary is: " + getYearlySalary());
    }
}
