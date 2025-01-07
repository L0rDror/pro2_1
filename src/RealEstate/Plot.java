package RealEstate;

class Plot extends Property {
    private TYPE type;

    public Plot(String address, int area, int price, TYPE type) {
        super(address, area, price);
        this.type = type;
    }

    public TYPE getType() {
        return type;
    }

    public void setType(TYPE type) {
        this.type = type;
    }

    @Override
    public void taxIt() {
        double taxRate;
        switch (type) {
            case URBAN -> taxRate = 0.10;
            case AGRICULTURAL -> taxRate = 0.02;
            case INDUSTRIAL -> taxRate = 0.05;
            default -> throw new IllegalStateException("Unexpected value: " + type);
        }
        System.out.printf("Tax for %s: %.2f\n", type, getPrice() * taxRate);
    }

    @Override
    public String toString() {
        return "Plot: " + super.toString() + ", Type: " + type;
    }
}
