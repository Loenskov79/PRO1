package StaticOpgave2;

public class Main {
    public static void main(String[] args) {
        Name name1 = new Name("Victor", "Lønskov", "Møller");
        Name name2 = new Name("Victor", "Møller");
        System.out.println(name1.getFullName());
        System.out.println(name2.getFullName());
        System.out.println();
        System.out.println("The initials of the full name is: " + name1.getInit());
        System.out.println("The initials of the full name is: " + name2.getInit());
        System.out.println();
        System.out.println(name1.getUsername());
        System.out.println(name2.getUsername());
        System.out.println();
        System.out.println(name1.getCryptoInit(2));
        System.out.println(name2.getCryptoInit(2));
    }
}
