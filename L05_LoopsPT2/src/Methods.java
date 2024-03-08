public class Methods {
    public static void printingOddNumbers () {
        for (int i = 1; i < 100; i++) {
            if (i % 2 != 0)
                System.out.println(i);
        }
    }
    public static void multiplumOffThree () {
        for (int i = 300; i >= 3; i = i - 3) {
            System.out.println(i);
        }
    }
}
