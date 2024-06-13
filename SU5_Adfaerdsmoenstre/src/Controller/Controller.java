package Controller;

import Model.Konto;
import Model.KontoType;
import Storage.Storage;

public class Controller {

	public static KontoType createKontoType(String navn, String beskrivelse) {

		KontoType kontoType = new KontoType(navn, beskrivelse);
		Storage.addKontoType(kontoType);
		return kontoType;
	}

	public static Konto createKonto(KontoType kontoType) {
		int nr = Storage.getKonti().size()+1;
		Konto konto = new Konto(kontoType,nr);
		Storage.addKonto(konto);

		return konto;
	}

	public static void lukKonto(Konto konto) {
		try {
			konto.lukKonto();
		} catch (RuntimeException exception) {
			System.out.println(exception.getMessage());
		}
	}

	public static void åbenKonto(Konto konto) {
		try {
			konto.åbenKonto();
		} catch (RuntimeException exception) {
			System.out.println(exception.getMessage());
		}
	}

	public static void foretagTransaktion(Konto konto, int beløb) {
		try {
			konto.createTransaktion(beløb);
		} catch (RuntimeException exception) {
			System.out.println(exception.getMessage());
		}
	}

}
