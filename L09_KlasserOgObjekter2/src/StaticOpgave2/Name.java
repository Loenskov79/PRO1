package StaticOpgave2;

public class Name {

    private String firstName;
    private String middleName;
    private String lastName;

    public Name(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        if (middleName == null) {
            return "The full name is: " + firstName + " " + lastName;
        } else
        return "The full name is: " + firstName + " " + middleName + " " + lastName;
    }

    public String getInit() {
        if (middleName == null) {
            return firstName.substring(0,1) + lastName.substring(0,1);
        } else
            return firstName.substring(0,1) + middleName.substring(0,1) + lastName.substring(0,1);
    }

    public String getUsername() {
        if (middleName == null) {
            return "The username is: " + firstName.toUpperCase().substring(0,2) + "0" + lastName.toLowerCase().substring(lastName.length() - 2, lastName.length());
        } else
            return "The username is: " + firstName.toUpperCase().substring(0,2) + middleName.length() + lastName.toLowerCase().substring(lastName.length()-2,lastName.length());
    }

    public String getCryptoInit (int count) {
        String alfabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String init = getInit();
        String cryptoInit = "";

        for(int i = 0; i <= init.length()-1; i++) {
            char ch = init.charAt(i);
            cryptoInit += alfabet.charAt(alfabet.indexOf(ch)+count);
//            int index = alfabet.indexOf(ch);
//            int newIndex = (index + count) % alfabet.length();
//            cryptoInit += alfabet.charAt(newIndex);
        }
        return cryptoInit;
    }
}
