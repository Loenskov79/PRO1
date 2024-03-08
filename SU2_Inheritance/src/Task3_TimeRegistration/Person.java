package Task3_TimeRegistration;

public class Person {

    private String name;
    private String adress;
    private String phoneNumber;

    public Person(String name, String adress, String phoneNumber) {

        this.name = name;
        this.adress = adress;
        this.phoneNumber = phoneNumber;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void print() {
        System.out.println("My name is: " + name);
        System.out.println("My adress is: " + adress);
        System.out.println("My phonenumber is: " + phoneNumber);
    }
}
