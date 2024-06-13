package Exercise2;

import sortering.SelectionSort;

import java.util.ArrayList;
import java.util.Arrays;

public class App {

    public static void main(String[] args) {

        String[] s = {"Erna", "Elly", "Laurits", "Bertha", "Christian", "August", "Marius", "John", "Tove", "Poul", "Torkild"};

        ArrayList<Customer> customers = new ArrayList<>();

        customers.add(new Customer("Victor", "Møller", 23));
        customers.add(new Customer("Mikkel", "Andersen", 24));
        customers.add(new Customer("Mads", "Hust", 29));
        customers.add(new Customer("Rasmus", "Jerløv", 24));

        System.out.println(customers);
        selectionSortList(customers);
        System.out.println(customers);

        selectionSort(s);
        System.out.println(Arrays.toString(s));



    }

    private static void swap(String[] list, int i, int j) {
        String temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }

    private static void swapAList(ArrayList<Customer> list, int i, int j) {
        Customer temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    public static void selectionSort(String[] list) {
        for (int i = 0; i < list.length; i++) {
            int minPos = i;
            for (int j = i + 1; j < list.length; j++) {
                if (list[j].compareTo(list[minPos]) > 0) {
                    minPos = j;
                }
            }
            swap(list, i, minPos);
        }
    }

    public static void selectionSortList(ArrayList<Customer> customers) {
        for (int i = 0; i < customers.size(); i++) {
            int minPos = i;
            for (int j = i + 1; j < customers.size(); j++) {
                if (customers.get(j).compareTo(customers.get(minPos)) < 0) {
                    minPos = j;
                }
            }
            swapAList(customers, i, minPos);
        }
    }

}
