package Exercise2;

public class Gift {

    private String description;
    private double price;
    private Person giver;

    public Gift(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setGiver(Person giver) {
        this.giver = giver;
    }

    public Person getGiver() {
        return giver;
    }
}
