package Exercise3;

import java.util.ArrayList;
import java.util.Arrays;

public class App {

    public static void main(String[] args) {

        String[] s = {"Erna", "Elly", "Laurits", "Bertha", "Christian", "August", "Marius", "John", "Tove", "Poul", "Torkild"};

        insertionSort(s);
        System.out.println(Arrays.toString(s));

        ArrayList<Exercise3.Customer> customers = new ArrayList<>();

        customers.add(new Exercise3.Customer("Victor", "Møller", 23));
        customers.add(new Exercise3.Customer("Mikkel", "Andersen", 24));
        customers.add(new Exercise3.Customer("Mads", "Hust", 29));
        customers.add(new Exercise3.Customer("Rasmus", "Jerløv", 24));

        System.out.println(customers);
        insertionSortObject(customers);
        System.out.println(customers);

    }

    public static void insertionSort(String[] list) {
        for (int i = 1; i < list.length; i++) {
            String next = list[i];
            int j = i;
            boolean found = false;
            while (!found && j > 0) {
                if (next.compareTo(list[j - 1]) > 0) {
                    found = true;
                } else {
                    list[j] = list[j - 1];
                    j--;
                }
            }
            list[j] = next;
        }
    }

    public static void insertionSortObject(ArrayList<Customer> list) {
        for (int i = 1; i < list.size(); i++) {
            Customer next = list.get(i);
            int j = i;
            boolean found = false;
            while (!found && j > 0) {
                if (next.compareTo(list.get(j-1)) > 0) {
                    found = true;
                } else {
                    list.set(j, list.get(j-1));
                    j--;
                }
            }
            list.set(j, next);
        }
    }

}
