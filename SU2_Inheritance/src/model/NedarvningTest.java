package model;

public class NedarvningTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("model.Person:");

		Person person = new Person("Hanne", "Sydbakken 27", "Datalog");

		Student student = new Student("Margrethe", "Ringvej 7", "STX", 9.5, "DMU01");

		Teacher teacher = new Teacher("Victor", "Sønderhøj 30", "HHX", 7500);

		person.udskrivPerson();
		System.out.println();
		teacher.udskrivPerson();
		System.out.println(teacher.getQualification());

		System.out.println();

		student.udskrivPerson();// kalder overrided metode

		System.out.println();

		student.udskrivAdresse(); // kalder egen metode

		System.out.println(student.getName()); // kalder nedarvet metode

	}

}
