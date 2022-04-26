package nl.camiel.novi.backend.TechItEasy.domain;

public class UpdateTelevision {
    private double price;
    private int sold;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }
}
