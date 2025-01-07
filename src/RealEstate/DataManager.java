package RealEstate;
import java.util.*;
import java.util.stream.Collectors;

class DataManager {

    // Method to create sample properties
    public static ArrayList<Property> createProperties() {
        ArrayList<Property> properties = new ArrayList<>();

        properties.add(new Plot("123 Main St, Urbanville", 500, 200000, TYPE.URBAN));
        properties.add(new Plot("456 Rural Rd, Farmland", 1000, 150000, TYPE.AGRICULTURAL));
        properties.add(new Apartment("789 Elm St, Suburbia", 250, 300000, 1, 3));
        properties.add(new Villa("1010 Downtown Blvd, Citycenter", 400, 600000, 2, 2));
        properties.add(new Vacation("500 Beachside Ln, Seaside", 300, 800000, 3, 8));
        properties.add(new Commercial("75 Business Dr, Industrial Park", 1000, 1200000, 8.5, true));
        properties.add(new Office("33 Corporate Ave, Urbanville", 500, 900000));

        return properties;
    }
    public static void displayProperties(ArrayList<Property> properties) {
        for (Property property : properties) {
            System.out.println(property);
        }
    }

    // Method to find the most expensive property
    public static Property findMostExpensiveProperty(ArrayList<Property> properties) {
        if (properties.isEmpty()) {
            return null;
        }

        Property mostExpensive = properties.get(0);
        for (Property property : properties) {
            if (property.getPrice() > mostExpensive.getPrice()) {
                mostExpensive = property;
            }
        }

        return mostExpensive;
    }

    // Method to find properties below a certain price
    public static ArrayList<Property> findPropertiesByPrice(ArrayList<Property> properties, int maxPrice) {
        return properties.stream()
                .filter(property -> property.getPrice() <= maxPrice)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    // Method to calculate the total value of all properties
    public static double calculateTotalValue(ArrayList<Property> properties) {
        return properties.stream()
                .mapToDouble(Property::getPrice)
                .sum();
    }

    // Main method for testing
    public static void main(String[] args) {
        // Create properties
        ArrayList<Property> properties = createProperties();

        // Display properties
        System.out.println("All Properties:");
        displayProperties(properties);

        // Find and display the most expensive property
        Property mostExpensive = findMostExpensiveProperty(properties);
        System.out.println("\nMost Expensive Property:");
        System.out.println(mostExpensive);

        // Find and display properties below a price
        int maxPrice = 400000;
        System.out.println("\nProperties Below " + maxPrice + ":");
        ArrayList<Property> affordableProperties = findPropertiesByPrice(properties, maxPrice);
        displayProperties(affordableProperties);

        // Calculate and display the total value of all properties
        double totalValue = calculateTotalValue(properties);
        System.out.println("\nTotal Value of All Properties: " + totalValue);
    }
}

