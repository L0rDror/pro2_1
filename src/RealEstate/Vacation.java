package RealEstate;

class Vacation extends Residential {
    private int guests = 1;

    public Vacation(String address, int area, int price, int parkingLots, int guests) {
        super(address, area, price, parkingLots);
        setGuests(guests);
    }

    public int getGuests() {
        return guests;
    }

    public void setGuests(int guests) {
        if (guests < 1) {
            throw new IllegalArgumentException("Guests must be at least 1.");
        }
        this.guests = guests;
    }

    @Override
    public void taxIt() {
        System.out.printf("Tax for Vacation Home: %.2f\n", getPrice() * 0.25);
    }

    @Override
    public String toString() {
        return "Vacation Home: " + super.toString() + ", Guests: " + guests;
    }
}
