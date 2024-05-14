package Model;

import Controller.Controller;

public class TilstandeTest {

	public static void main(String[] args) {

		KontoType kontotype = Controller
				.createKontoType(
						"Ungdomskonto",
						"En kontotype til unge under 25, som for at beskytte du unge ikke tillader at der hæves på en konto med saldo under 0");

		Konto k1 = Controller.createKonto(kontotype);
		Konto k2 = Controller.createKonto(kontotype);

		Controller.foretagTransaktion(k1, 100);
		Controller.foretagTransaktion(k1, 200);
		Controller.foretagTransaktion(k1, -400);

		Controller.foretagTransaktion(k1, -200); // giver exception

		System.out.println(k1);
		System.out.println();
		Controller.lukKonto(k2);
		Controller.foretagTransaktion(k2, 200);
		System.out.println(k2);
		Controller.åbenKonto(k2);
		System.out.println();
		Controller.foretagTransaktion(k2, 200);
		System.out.println(k2);


	}
}
