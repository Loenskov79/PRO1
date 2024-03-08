package model;

import model.Person;

public class Teacher extends Person {

    private double salary;

    public Teacher(String name, String adress, String qualification, double salary) {

        super(name, adress, qualification);

        this.salary = salary;

    }

    @Override
    public void udskrivPerson() {

        super.udskrivPerson();
        System.out.println("Monthly salary: " + getSalary());
        System.out.println("Yearly salary: " + getYearSalary());
    }

    public double getYearSalary() {
        double holidayPay = salary * 0.125;
        double yearSalary = salary * 12 + holidayPay;
        return yearSalary;
    }

    public double getSalary() {
        return salary;
    }
}
