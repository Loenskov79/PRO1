package Exercise1;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {

        String[] s = {"Erna", "Elly", "Laurits", "Bertha", "Christian", "August", "Marius", "John", "Tove", "Poul", "Torkild"};

        bubbleSortString(s);
        System.out.println(Arrays.toString(s));

    }

    private static void swapString(String[] list, int i, int j) {
        String temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }

    public static void bubbleSortString(String[] list) {
        for (int i = list.length - 1; i >= 0; i--) {
            for (int j = 0; j <= i - 1; j++) {
                if (list[j].compareTo(list[j+1]) > 0) {
                    swapString(list, j, j + 1);
                }
            }
        }
    }

}
