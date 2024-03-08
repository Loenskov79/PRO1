package Task3;

public class PersonApp {
    public static void main(String[] args) {
        Person p1 = new Person("Victor", "Vindrosen", 4000, 4);
        p1.printPerson();
        p1.newJob();
        System.out.println();
        p1.printPerson();
    }
}
