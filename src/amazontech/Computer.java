package amazontech;

public abstract class Computer extends Product {
    public Computer(String name, double price) {
        super(name, price);
    }

    public Computer(Computer other) {
        super(other);
    }
}
