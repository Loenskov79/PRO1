public class KontoApp {
    public static void main(String[] args) {
        Konto konto1 = new Konto("Privatkonto", 82749872);
        konto1.setSaldo(10000);
        konto1.indsætBeløb(2000);
        konto1.hævBeløb(5000);
        konto1.lukKonto();
        konto1.indsætBeløb(1000);
        konto1.åbenKonto();
        konto1.indsætBeløb(4000);
        System.out.println();
        System.out.println();
        konto1.printKonto();
    }
}
