package Task3_TimeRegistration;

public class Main {
    public static void main(String[] args) {
        Person Victor = new Person("Victor", "Vindrosen", "+45 87654321");
        Teamleader San = new Teamleader("San", "Skjoldhøj", "+44 21346578", "Grocery shopping", 45000);
        Employee Andreas = new Employee("Andreas", "Vimpelmasten 32", "+45 67453299", 170);

        Victor.print();
        System.out.println();
        San.print();
        System.out.println();
        Andreas.print();
    }
}
