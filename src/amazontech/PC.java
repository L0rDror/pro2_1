package amazontech;

public class PC extends Computer {
    public PC(String name, double price) {
        super(name, price);
    }

    public PC(PC other) {
        super(other);
    }

    @Override
    public void warranty() {
        System.out.println("Warranty covers: hardware and power supply");
    }

    @Override
    public String toString() {
        return "PC: " + super.toString();
    }
}