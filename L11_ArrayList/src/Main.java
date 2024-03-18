import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        list.add("Hans");
        list.add("Viggo");
        list.add("Jens");
        list.add("Bente");
        list.add("Bent");

        System.out.println(list.size());

        list.add(2, "Jane");

        System.out.println(list.toString());
        list.remove(1);
        list.add(0,"Pia");
        list.add("Ib");

        System.out.println(list.size());
        list.set(2, "Hansi");
        System.out.println(list.size());

        System.out.println(list.toString());

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).length());
        }

        for (String str: list) {
            System.out.println(str.length());
        }



    }
}
