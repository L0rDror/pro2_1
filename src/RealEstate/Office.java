package RealEstate;


class Office extends Property {
    public Office(String address, int area, int price) {
        super(address, area, price);
    }

    @Override
    public void taxIt() {
        System.out.printf("Tax for Office: %.2f\n", getPrice() * 0.05);
    }

    @Override
    public String toString() {
        return "Office: " + super.toString();
    }
}

