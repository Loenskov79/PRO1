package E314;

public class ProductPrinter {

    public static void main(String[] args) {
        Product p1 = new Product("Pizza", 8);
        Product p2 = new Product("Bagel", 9);

        p1.printInfo();
        p2.printInfo();

        p1.reducePrice(5);
        p2.reducePrice(5);

        p1.printInfo();
        p2.printInfo();

    }

}
