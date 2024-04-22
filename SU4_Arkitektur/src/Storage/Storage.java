package Storage;

import Application.model.Customer;

import java.util.ArrayList;

public class Storage {

    private ArrayList<Customer> customers = new ArrayList<>();

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

}
