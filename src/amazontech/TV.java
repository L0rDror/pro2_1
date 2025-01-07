package amazontech;

public class TV extends Product {
    public TV(String name, double price) {
        super(name, price);
    }

    public TV(TV other) {
        super(other);
    }

    @Override
    public void warranty() {
        System.out.println("Warranty covers: screen and power supply");
    }

    @Override
    public String toString() {
        return "TV: " + super.toString();
    }
}
