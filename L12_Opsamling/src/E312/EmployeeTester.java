package E312;

public class EmployeeTester {

    public static void main(String[] args) {
        Employee Harry = new Employee("Harry", 25000);
        System.out.println(Harry.getSalary());
        Harry.raiseSalary(10.0);
        System.out.println(Harry.getSalary());
    }

}
