package amazontech;

public class Laptop extends Computer implements Portable {
    public Laptop(String name, double price) {
        super(name, price);
    }

    public Laptop(Laptop other) {
        super(other);
    }

    @Override
    public void warranty() {
        System.out.println("Warranty covers: hardware and battery");
    }

    @Override
    public void weight() {
        System.out.println("Weight: 2 kilos");
    }

    @Override
    public double calculateVAT() {
        return getPrice() * 0.10; // Override to 10% VAT
    }

    @Override
    public String toString() {
        return "Laptop: " + super.toString();
    }
}
