import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        char[][] tictacToe = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
        tictacToe[1][1] = 'X';
        print2D(tictacToe);
    }

    public static void print2D (char[][] ticTacToe) {
        for (char[] row : ticTacToe)
            System.out.println(Arrays.toString(row));
    }
}
