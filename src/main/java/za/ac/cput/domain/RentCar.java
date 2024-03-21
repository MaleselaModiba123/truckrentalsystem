package za.ac.cput.domain;

import java.time.LocalDate;
import java.util.Objects;

/**
 * RentCar.java
 * This is the Domain program
 * @auther ZukhanyeAneleMene (219404275)
 * Date: 20 March 2024
 */

public class RentCar {
    private int rentalID;
    private int customerID;
    private int truckID;
    private LocalDate  rentalStartDate;
    private LocalDate rentalEndDate;
    private double rentalCost;


    public RentCar() {

    }

    private RentCar (Builder builder) {
        this.rentalID = builder.rentalID;
        this.customerID = builder.customerID;
        this.truckID = builder.truckID;
        this.rentalStartDate = builder.rentalStartDate;
        this.rentalEndDate = builder.rentalEndDate;
        this.rentalCost = builder.rentalCost;
    }

    public int getRentalID() {

        return rentalID;
    }

    public int getCustomerID() {

        return customerID;
    }

    public int getTruckID() {

        return truckID;
    }

    public LocalDate getRentalStartDate() {

        return rentalStartDate;
    }

    public LocalDate getRentalEndDate() {

        return rentalEndDate;
    }

    public double getRentalCost() {

        return rentalCost;
    }

    @Override
    public boolean equals(Object rent) {
        if (this == rent) return true;
        if (rent == null || getClass() != rent.getClass()) return false;
        RentCar rentCar  = (RentCar) rent;
        return rentalID == rentCar.rentalID
                && Objects.equals(customerID, rentCar.customerID)
                && Objects.equals(truckID, rentCar.truckID)
                && Objects.equals(rentalStartDate, rentCar.rentalStartDate)
                && Objects.equals(rentalEndDate, rentCar.rentalEndDate)
                && Double.compare(rentalCost, rentCar.rentalCost ) == 0;

    }


    @Override
    public int hashCode() {
        return Objects.hash(rentalID, customerID,truckID,rentalStartDate, rentalEndDate,rentalCost );
    }


    @Override
    public String toString() {
        return "RentCar{" +
                "rentalID='" + rentalID + '\'' +
                ", customerID=" + customerID +
                ", truckID=" + truckID +
                ", rentalStartDate=" + rentalStartDate +
                ", rentalEndDate=" + rentalEndDate +
                ", rentalCost=" + rentalCost +
                '}';
    }

    public static class Builder{

        private int rentalID;
        private int customerID;
        private int truckID;
        private LocalDate rentalStartDate;
        private LocalDate rentalEndDate;

        private double rentalCost;



        public Builder setRentalID(int rentalID) {
            this.rentalID = rentalID;
            return this;
        }

        public Builder setCustomerID(int customerID ) {
            this.customerID = customerID;
            return this;
        }

        public Builder setTruckID(int truckID) {
            this.truckID = truckID;
            return this;
        }

        public Builder setRentalStartDate(LocalDate rentalStartDate) {
            this.rentalStartDate = rentalStartDate;
            return this;
        }

        public Builder setRentalEndDate(LocalDate rentalEndDate) {
            this.rentalEndDate = rentalEndDate;
            return this;
        }

        public Builder setRentalCost(double rentalCost) {
            this.rentalCost = rentalCost;
            return this;
        }
        public Builder copy(RentCar rentCar){
            this.rentalID = rentCar.rentalID;
            this.customerID = rentCar.customerID;
            this.truckID = rentCar.truckID;
            this.rentalStartDate = rentCar.rentalStartDate;
            this.rentalEndDate = rentCar.rentalEndDate;
            this.rentalCost = rentCar.rentalCost;
            return this;
        }

        public RentCar build() {

            return new RentCar(this);
        }

        // Additional methods
        // Method to calculate the duration of the rental
        public int calculateRentalDuration() {
            return (int) rentalStartDate.until(rentalEndDate).getDays();
        }

        // Method to calculate the total rental cost
        public double calculateTotalRentalCost() {
            return rentalCost * calculateRentalDuration();
        }
    }
}


