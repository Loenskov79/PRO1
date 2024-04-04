public class KontoApp {
    public static void main(String[] args) {

        KontoType madKonto = new KontoType("Madkonto", "En konto til alle udgifter vedrørende mad", "Ingen");
        Konto konto1 = new Konto(madKonto, 1);

        konto1.printKonto();

    }
}
