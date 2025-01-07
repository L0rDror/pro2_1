package amazontech;

public class Smartphone extends Product implements Portable {
    public Smartphone(String name, double price) {
        super(name, price);
    }

    public Smartphone(Smartphone other) {
        super(other);
    }

    @Override
    public void warranty() {
        System.out.println("Warranty covers: screen and battery");
    }

    @Override
    public void weight() {
        System.out.println("Weight: 200 grams");
    }

    @Override
    public String toString() {
        return "Smartphone: " + super.toString();
    }
}

// src/main/java/com/amazontech/models/TV.java
