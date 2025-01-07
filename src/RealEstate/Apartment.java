package RealEstate;

class Apartment extends Residential {
    private int rooms = 1;

    public Apartment(String address, int area, int price, int parkingLots, int rooms) {
        super(address, area, price, parkingLots);
        setRooms(rooms);
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        if (rooms <= 1) {
            throw new IllegalArgumentException("Rooms must be greater than 1.");
        }
        this.rooms = rooms;
    }

    @Override
    public void taxIt() {
        System.out.printf("Tax for Apartment: %.2f\n", getPrice() * 0.08);
    }

    @Override
    public String toString() {
        return "Apartment: " + super.toString() + ", Rooms: " + rooms;
    }
}
