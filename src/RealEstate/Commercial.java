package RealEstate;

class Commercial extends Property {
    private boolean storeroom = false;
    private double yield = 0.0;

    public Commercial(String address, int area, int price, double yield) {
        super(address, area, price);
        setYield(yield);
    }

    public Commercial(String address, int area, int price, double yield, boolean storeroom) {
        this(address, area, price, yield);
        this.storeroom = storeroom;
    }

    public boolean hasStoreroom() {
        return storeroom;
    }

    public void setStoreroom(boolean storeroom) {
        this.storeroom = storeroom;
    }

    public double getYield() {
        return yield;
    }

    public void setYield(double yield) {
        if (yield < 0) {
            throw new IllegalArgumentException("Yield cannot be negative.");
        }
        this.yield = yield;
    }

    public double calculateMonthlyProfit() {
        return (getPrice() * (yield / 100)) / 12;
    }

    @Override
    public void taxIt() {
        System.out.printf("Tax for Commercial Property: %.2f\n", getPrice() * 0.05);
    }

    @Override
    public String toString() {
        return "Commercial: " + super.toString() + ", Yield: " + yield + ", Storeroom: " + storeroom;
    }
}
