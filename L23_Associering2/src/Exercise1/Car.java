package Exercise1;

import java.util.ArrayList;

public class Car {

    private String license;
    private double pricePerDay;
    private int purchaseYear;
    private ArrayList<Rental> rentals = new ArrayList<>();

    public Car(String license, int purchaseYear) {
        this.license = license;
        this.purchaseYear = purchaseYear;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public String getLicense() {
        return license;
    }

    public int getPurchaseYear() {
        return purchaseYear;
    }

    public void addRental(Rental rental) {
        if(!rentals.contains(rental)) {
            rentals.add(rental);
            rental.addCar(this);
        }
    }

    public void removeRental(Rental rental) {
        if(rentals.contains(rental)) {
            rentals.remove(rental);
            rental.removeCar(this);
        }
    }

    public int highestAmountOfDays() {
        int max = Integer.MIN_VALUE;

        for (Rental rentals : rentals) {
            if (rentals.getDays() > max) {
                max = rentals.getDays();
            }
        }
        return max;
    }
}
