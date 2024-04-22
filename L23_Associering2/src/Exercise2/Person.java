package Exercise2;

import java.util.ArrayList;

public class Person {

    private String name;
    private int age;
    private ArrayList<Gift> gifts = new ArrayList<>();

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "Name: " + name;
    }

    public void addGift(Gift gift) {
        if(!gifts.contains(gift)) {
            gifts.add(gift);
        }
    }

    public void removeGift(Gift gift) {
        if(gifts.contains(gift)) {
            gifts.remove(gift);
        }
    }

    public ArrayList<Person> getGiftGivers() {
        ArrayList<Person> giftGivers = new ArrayList<>();

        for (Gift gifts : gifts) {
            if (!giftGivers.contains(gifts.getGiver())) {
                giftGivers.add(gifts.getGiver());
            }
        }
        return giftGivers;
    }

    public double totalAmount () {
        double amount = 0;

        for (Gift gifts : gifts) {
            amount += gifts.getPrice();
        }
        return amount;
    }
}
