package Task3;

public class Person {

    private String name;
    private String adress;
    private double monthlySalary;
    private int jobs;

    public Person(String inputName, String inputAdress, double inputMonthlySalary, int inputJobs) {
        name = inputName;
        adress = inputAdress;
        monthlySalary = inputMonthlySalary;
        jobs = inputJobs;
    }

    public void setName(String inputName) {
        name = inputName;
    }

    public String getName() { return name; }

    public void setAdress(String inputAdress) {
        adress = inputAdress;
    }

    public String getAdress() {
        return adress;
    }

    public void setMonthlySalary(double inputMonthlySalary) {
        monthlySalary = inputMonthlySalary;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public double yearlySalaryTotal() {
        double yearlySalary = monthlySalary * 12;
        double holidayPay = yearlySalary * 0.025;
        double yearlySalaryTotal = yearlySalary + holidayPay;
        return yearlySalaryTotal;
    }

    public void setAmountOfJobs(int inputJobs) {
        jobs = inputJobs;
    }

    public int getAmountOfJobs() {
        return jobs;
    }

    public void newJob() {
        jobs++;
    }

    public void printPerson() {
        System.out.println("Name: " + name);
        System.out.println("Adress: " + adress);
        System.out.println("Monthly salary: " + monthlySalary);
        System.out.println("The yearly salary in total is: " + yearlySalaryTotal());
        System.out.println(name + " has had " + jobs + " jobs in his lifespan");
    }
}
