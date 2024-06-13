package guifx;

import application.controller.Controller;
import application.model.Company;
import application.model.Customer;
import enumeration.Gender;
import javafx.application.Application;

public class App {

	public static void main(String[] args) {
		initStorage();
		Application.launch(StartWindow.class);
	}
	/**
	 * Initializes the storage with some objects.
	 */
	public static void initStorage() {
		Company c1 = Controller.createCompany("IBM", 37);
		Company c2 = Controller.createCompany("AMD", 40);
		Controller.createCompany("SLED", 45);
		Controller.createCompany("Vector", 32);

		Controller.createEmployee("Bob Dole", 210, c2, 2020);
		Controller.createEmployee("Alice Schmidt", 250, c1, 2012);
		Controller.createEmployee("George Down", 150, c2, 2013);

		Controller.createEmployee("Rita Uphill", 300, 2018);

		Customer cus1 = Controller.createCustomer("Victor", Gender.MALE);
		Customer cus2 = Controller.createCustomer("Sille", Gender.FEMALE);
		Customer cus3 = Controller.createCustomer("Mads", Gender.MALE);
		Customer cus4 = Controller.createCustomer("Anna", Gender.FEMALE);
		Customer cus5 = Controller.createCustomer("Loui", Gender.MALE);
		Customer cus6 = Controller.createCustomer("Freya", Gender.FEMALE);

		Controller.addCustomerToCompany(cus1,c1);
		Controller.addCustomerToCompany(cus2,c2);
		Controller.addCustomerToCompany(cus3,c2);
		Controller.addCustomerToCompany(cus4,c1);
		Controller.addCustomerToCompany(cus5,c1);
		Controller.addCustomerToCompany(cus6,c2);
	}


}
