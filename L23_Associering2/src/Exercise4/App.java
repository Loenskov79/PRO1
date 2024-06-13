package Exercise4;

import java.util.ArrayList;

public class App {

    public static void main(String[] args) {

        ArrayList<Hund> hunde = new ArrayList<>();

        Hund h1 = new Hund("Jakob", true, 80000, Race.PUDDEL);
        Hund h2 = new Hund("Jens", false, 2000, Race.TERRIER);
        Hund h3 = new Hund("Line", true, 35000, Race.PUDDEL);
        Hund h4 = new Hund("Josie", true, 12000, Race.BOKSER);
        Hund h5 = new Hund("King", false, 4000, Race.TERRIER);
        Hund h6 = new Hund("Yoshi", true, 14000, Race.BOKSER);

        hunde.add(h1);
        hunde.add(h2);
        hunde.add(h3);
        hunde.add(h4);
        hunde.add(h5);
        hunde.add(h6);

        System.out.println(h1);
        System.out.println(h3+"\n");
        System.out.println("Samlet pris for alle hunde med racen 'Puddel' er: " + samletPris(hunde, Race.PUDDEL) + "\n");
        System.out.println(h2);
        System.out.println(h5+"\n");
        System.out.println("Samlet pris for alle hunde med racen 'Bokser' er: " + samletPris(hunde, Race.BOKSER) + "\n");
        System.out.println(h4);
        System.out.println(h6+"\n");
        System.out.println("Samlet pris for alle hunde med racen 'Terrier' er: " + samletPris(hunde, Race.TERRIER));

    }

    public static int samletPris(ArrayList<Hund> hunde, Race race) {
        int samletPris = 0;

        for (Hund hund : hunde) {
            if (hund.getRace() == race) {
                samletPris += hund.getPris();
            }
        }
        return samletPris;
    }

}
