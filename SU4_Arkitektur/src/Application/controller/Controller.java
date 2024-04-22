package Application.controller;

import Application.model.Adresse;
import Application.model.Customer;
import Storage.Storage;

public class Controller {
    Storage storage = new Storage();

    public Customer createCustomer(String name, Adresse adresse) {
        Customer newCustomer = new Customer(name, adresse);
        storage.addCustomer(newCustomer);
        return newCustomer;
    }
}
