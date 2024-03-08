package modelemployee;

/*
 * Anvendelses program der opretter Employee objekter og anvender metoder på disse
 */
public class EmployeeApp {

	public static void main(String[] args) {
		Employee e1 = new Employee("Hans", "Jensen", 40);
		e1.printEmployee();
		e1.setFirstName("Viggo");
		e1.printEmployee();
		e1.setAge(32);
		e1.printEmployee();

		System.out.println(e1.getAge());
		e1.birthday();
		System.out.println(e1.getAge());
		System.out.println(e1);

		Employee e2 = new Employee();
		System.out.println(e2);
		e2.printEmployee();

	}

}
