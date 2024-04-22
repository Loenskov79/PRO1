package Exercise2;

public class App {

    public static void main(String[] args) {

        Person p1 = new Person("Kaj", 23);
        Person p2 = new Person("Jens", 38);
        Person p3 = new Person("Linus", 45);

        Gift g1 = new Gift("Lego Sword");
        Gift g2 = new Gift("Waterbottle");
        Gift g3 = new Gift("Flot T-Shirt");

        g1.setPrice(300);
        g2.setPrice(20);
        g3.setPrice(450);

        p1.addGift(g1);
        p1.addGift(g2);

        System.out.println(p1.totalAmount());

        g1.setGiver(p2);
        g2.setGiver(p3);
        System.out.println(g1.getGiver());
        System.out.println();

        System.out.println(p1.getGiftGivers());

    }

}
