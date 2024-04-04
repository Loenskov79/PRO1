package E314;

import java.sql.SQLOutput;

public class Product {

    private String name;
    private int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void reducePrice(int reduction) {
        this.price = price - reduction;
        System.out.println("The price of " + name + " was reduced by $" + reduction + "!");
    }

    public void printInfo() {
        System.out.println("Name of the item: " + name + ", and price of the item is: $" + price);
    }
}
