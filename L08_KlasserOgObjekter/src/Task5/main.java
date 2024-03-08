package Task5;

public class main {
    public static void main(String[] args) {

        Rectangle r1 = new Rectangle();
        r1.printRectangle();
        System.out.println();
        System.out.println("***************************************");
        System.out.println();
        Rectangle r2 = new Rectangle(4,40);
        r2.printRectangle();
        System.out.println();
        System.out.println("***************************************");
        System.out.println();
        Rectangle r3 = new Rectangle(3.5, 35.9);
        r3.printRectangle();

        System.out.println();
        System.out.println(r2);

        //Stock s1 = new Stock("ORCL", "Oracle Corporation", 34.5, 34.35);
        //s1.printStock();

    }
}
