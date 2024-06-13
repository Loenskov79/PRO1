package Exercise5;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {

        Series gameOfThrones = new Series("Game of Thrones", new ArrayList<>(List.of("Emilia Clarke", "Kit Harrington", "Nicolai C. Waldau", "Lena Headey")));

        Episode got1 = gameOfThrones.createEpisode(1, new ArrayList<>(List.of("Frank Hvam", "Casper Christensen")), 80);
        Episode got2 = gameOfThrones.createEpisode(2, new ArrayList<>(List.of("Anders Matthesen", "Robert Pattinson")), 60);
        Episode got3 = gameOfThrones.createEpisode(3, new ArrayList<>(List.of("Kevin Hart", "Dwayne Johnson")), 58);



        System.out.println(gameOfThrones.totalLength());
        System.out.println(gameOfThrones.getGuestActors());


    }

}
