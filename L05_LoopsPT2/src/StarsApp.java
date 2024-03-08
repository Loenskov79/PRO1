import java.lang.reflect.Method;

public class StarsApp {
    final static int MAX_ROWS = 10;

    public static void starPicture() {
        for (int row = 1; row <= MAX_ROWS; row++) {
            for (int star = 1; star <= row; star++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void starPictureA() {
        for (int row = 1; row <= MAX_ROWS; row++) {

            int starCount = MAX_ROWS + 1 - row;
            for (int star = 1; star <= starCount; star++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void starPictureB() {
        for (int row = MAX_ROWS; row >= 1; row--) {
            int starCount = MAX_ROWS + 1 - row;

            System.out.printf("%2d: ", MAX_ROWS + 1 - row);

            // print dash
            int dashCount = MAX_ROWS - starCount;
            for(int dash = 1; dash <= dashCount; dash++) {
                System.out.print(" ");
            }

            // print star
            for (int star = 1; star <= starCount; star++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }

    public static void starPictureC() {
        for (int row = 1; row <= MAX_ROWS; row++) {
            int starCount = MAX_ROWS + 1 - row;

            System.out.printf("%2d: ", row);

            // print dashes
            int dashCount = MAX_ROWS - starCount;
            for(int dash = 1; dash <= dashCount; dash++) {
                System.out.print(" ");
            }

            // print stars
            starCount = MAX_ROWS + 1 - row;
            for(int star = 1; star <= starCount; star++) {
                System.out.print("*");
            }

            // new line
            System.out.println();
        }
    }

    public static void starPictureD() {
        int n = 55;

        // øvre del af diamanten
        for (int i = 1; i <= n; i++) {
            // print row number
            System.out.printf("%3d: ", i);

            // print leading spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            // print stars
            for (int star = 1; star <= 2 * i - 1; star++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // Nedre del af diamanten
        for (int i = n; i >= 1; i--) {
            // print row number
            System.out.printf("%3d: ", 2*n - i);

            // print leading spaces
            for (int j = 1; j <= n - i; j++){
                System.out.print(" ");
            }

            // print stars
            for (int star = 1; star <= 2 * i - 1; star++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
//        starPicture();
//        starPictureA();
//        starPictureB();
//        starPictureC();
        starPictureD();
    }

}
