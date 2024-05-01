package application.model;

import enumeration.Gender;

public class Customer {

    private String name;
    private Gender gender;

    public Customer(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Name: " + name + " | Gender: " + gender;
    }
}
