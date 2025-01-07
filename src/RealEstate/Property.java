package RealEstate;

public abstract class Property {
    private String address = "Na, na";
    private int area = 0;
    private int price = 0;

    // Constructor
    public Property(String address, int area, int price) {
        setAddress(address);
        setArea(area);
        setPrice(price);
    }

    // Getters and Setters
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address == null || address.isBlank() || address.split(" ").length < 2) {
            throw new IllegalArgumentException("Invalid address: must be at least two words.");
        }
        this.address = address;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        if (area < 0) {
            throw new IllegalArgumentException("Area cannot be negative.");
        }
        this.area = area;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }
        this.price = price;
    }

    // Abstract Method
    public abstract void taxIt();

    @Override
    public String toString() {
        return String.format("Address: %s, Area: %d, Price: %d", address, area, price);
    }
}