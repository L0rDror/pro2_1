package RealEstate;

class Villa extends Residential {
    private int levels = 1;

    public Villa(String address, int area, int price, int parkingLots, int levels) {
        super(address, area, price, parkingLots);
        setLevels(levels);
    }

    public int getLevels() {
        return levels;
    }

    public void setLevels(int levels) {
        if (levels < 1) {
            throw new IllegalArgumentException("Levels must be at least 1.");
        }
        this.levels = levels;
    }

    @Override
    public void taxIt() {
        System.out.printf("Tax for Villa: %.2f\n", getPrice() * 0.08);
    }

    @Override
    public String toString() {
        return "Villa: " + super.toString() + ", Levels: " + levels;
    }
}
