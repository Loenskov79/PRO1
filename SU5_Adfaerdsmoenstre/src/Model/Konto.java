package Model;

import java.util.ArrayList;

public class Konto {

	private int nr;

	private ArrayList<Transaktion> transaktioner;

	private KontoType kontoType;

	private Tilstand tilstand;

	public Konto(KontoType kontoType, int nr) {

		this.kontoType = kontoType;
		this.nr = nr;
		this.tilstand = Tilstand.AABEN;
		transaktioner = new ArrayList<Transaktion>();
	}

	public int getNr() {
		return this.nr;
	}

	public Transaktion createTransaktion(int beløb) {
		Transaktion transaktion = null;
		if (!(tilstand == Tilstand.LUKKET)) {
			if (!(tilstand == Tilstand.OVERTRUKKET && beløb < 0)) {
				transaktion = new Transaktion(beløb);
				transaktioner.add(transaktion);
				if (beregnSaldo() < 0) {
					tilstand = Tilstand.OVERTRUKKET;
				} else {
					tilstand = Tilstand.AABEN;
				}
			} else
				throw new RuntimeException("Du forsøger at hæve på en overtrukket konto!");
		} else {
			throw new RuntimeException ("Du forsøger at interagere med en lukket konto!");
		}
		return transaktion;
	}

	public int beregnSaldo() {
		int saldo = 0;
		for (Transaktion transaktion : transaktioner) {
			saldo += transaktion.getBeløb();
		}
		return saldo;

	}

	public void lukKonto() {
		tilstand = Tilstand.LUKKET;
	}

	@Override
	public String toString() {
		return "Saldo på konto nr. " + getNr() + " med kontotype: "+ kontoType.getNavn()+ " er " + beregnSaldo() + "\nKontoen er: " + tilstand;
	}

	public void åbenKonto() {
		tilstand = Tilstand.AABEN;
	}
}
