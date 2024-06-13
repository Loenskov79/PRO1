import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Test test = new Test();

        int[] linArray = {1,2,3,4,5,6};
        int[] binArray = {1,4,7,9,12,15,22,27,32,35,42,81};

        System.out.println(test.linearSearch(linArray, 8));
        System.out.println(test.binarySearch(binArray, 33));

        int[] selSortArr = {1,5,2,6,7,324,13,21,5124,12,21,1};
        int[] test1 = {7,6,5,3,2};

        test.selectionSort(selSortArr);
        System.out.println(Arrays.toString(selSortArr));
        System.out.println();
        test.selectionSort(test1);
        System.out.println(Arrays.toString(test1));


    }
}
