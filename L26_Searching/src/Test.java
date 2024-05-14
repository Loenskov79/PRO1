public class Test {

    public int linearSearch(int[] arr, int target) {
        int[] array = {1,2,3,4,5,6};

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public int binarySearch(int[] arr, int target) {
//        int[] array = {1,4,5,6,8,10,12,17,19,22,24,42};

        int max = arr.length - 1;
        int min = 0;


        while (max >= min) {
            int mid = (min + max) / 2;
            if (target < arr[mid]) {
                max = mid - 1;
            } else if (target == arr[mid]) {
                return mid;
            } else {
                min = mid + 1;
            }
        }
        return -1;
    }

    public void selectionSort(int[] arr) {

        for (int i = 0; i < arr.length- 1; i++) {
            int min = arr[i];
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }

}
