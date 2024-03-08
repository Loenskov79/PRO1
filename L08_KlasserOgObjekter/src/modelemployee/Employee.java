package modelemployee;

/**
 * Klasse der beskriver en ansat
 *
 * @author mad
 *
 */
public class Employee {
	/*
	 * Attributter der beskriver den ansattes tilstand
	 */
	private String firstName;
	private String lastName;
	private boolean trainee;
	private int age;

	/*
	 * Constructor, når den ansatte oprettes, skal den have et navn. Ved
	 * oprettelse er den ansatte en trainee
	 */
	public Employee(String inputFirstName, String inputLastName, int inputAge) {
		age = inputAge;
		firstName = inputFirstName;
		lastName = inputLastName;
		trainee = true;
	}public Employee() {

	}

	/*
	 * Den ansattes navn kan ændres ved kald af setName metoden
	 */
	public void setFirstName(String inputFirstName) {
		firstName = inputFirstName;
	}

	/*
	 * Man kan få oplyst den ansattes navn, ved at kalde metoden getName
	 */
	public String getFirstName() {
		return firstName;
	}

	public void setLastname (String inputLastName) {
		lastName = inputLastName;
	}

	public String getLastname() {
		return lastName;
	}

	public void setAge(int inputAge) {
		age = inputAge;
	}

	public int getAge() {
		return age;
	}

	public void birthday() {
		age++;
	}

	/*
	 * Den ansatte kan få ændret trainee status ved at kalde metoden setTrainess
	 */
	public void setTrainee(boolean isTrainee) {
		trainee = isTrainee;
	}

	/*
	 * Man kan få oplyst den ansatte er trainess aktivitet, ved at kalde metoden
	 * isTrainee
	 */
	public boolean isTrainee() {
		return trainee;
	}

	public void printEmployee() {
		System.out.println("*******************");
		System.out.println("Firstname: " + firstName);
		System.out.println("Lastname: " + lastName);
		System.out.println("Age: " + age);
		System.out.println("Trainee " + trainee);
		System.out.println();
	}


	/*
	 * Returnerer en kort tekst repræsentation af objektet
	 */
//	public String toString(){
//		return name;
//	}
}
