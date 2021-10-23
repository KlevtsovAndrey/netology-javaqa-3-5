package domain;

public class Smartphone extends Product {
    private String brand;

    public Smartphone() {
        super();
    }

    public Smartphone(String name, int id, int price, String brand) {
        super(name, id, price);
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
