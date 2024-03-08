public class Konto {

    int nr;
    int saldo;
    String kontoType;
    String status;

    public Konto(String kontoType, int nr) {
        this.kontoType = kontoType;
        this.nr = nr;
        this.saldo = 0;
        this.status = "open";
    }

    public int getNr() {
        return nr;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public String getKontoType() {
        return kontoType;
    }

    public void setKontoType(String kontoType) {
        this.kontoType = kontoType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void indsætBeløb(int beløb) {
        if (this.status == "open") {
            this.saldo += beløb;
            System.out.println("Du har lige indsat: " + beløb + " og din nuværende saldo er nu: " + this.saldo);
        } else {
            System.out.println("Du kan ikke indsætte penge på en lukket konto!");
        }
    }

    public void hævBeløb(int beløb) {
        if (this.status == "open") {
            this.saldo -= beløb;
            System.out.println("Du har lige hævet: " + beløb + " og din nuværende saldo er nu: " + this.saldo);
        } else {
            System.out.println("Du kan ikke hæve penge fra en lukket konto!");
        }
    }

    public void lukKonto() {
        this.status = "closed";
    }

    public void åbenKonto() {
        this.status = "open";
    }

    public void printKonto() {
        System.out.println("---------------------------------");
        System.out.println("Dit kontonr er: " + nr);
        System.out.println("Din kontotype er: " + kontoType);
        System.out.println("Lige nu står der: " + this.saldo + "$ på din konto");
        System.out.println("Din konto er: " + this.status);
        System.out.println("---------------------------------");
    }
}
