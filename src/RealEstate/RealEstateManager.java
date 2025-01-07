package RealEstate;
import java.util.*;
import java.util.stream.Collectors;

class RealEstateManager {
    private String name;
    private ArrayList<Property> properties;

    public RealEstateManager(String name) {
        this.name = name;
        this.properties = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Property> getProperties() {
        return properties;
    }

    public void addProperty(Property property) {
        properties.add(property);
    }
    
    public ArrayList<Property> getPropertiesByPrice(int price) throws PriceException {
        if (price < 0) {
            throw new PriceException("Price cannot be negative.");
        }
    
        return properties.stream()
                .filter(property -> property.getPrice() <= price)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public double calculateTotalValue() {
        return properties.stream()
                .mapToDouble(Property::getPrice)
                .sum();
    }

    public ArrayList<Property> getPropertiesByCity(String city) {
        String normalizedCity = city.replace("-", " ").toLowerCase();
        return properties.stream()
                .filter(property -> property.getAddress().toLowerCase().contains(normalizedCity))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public int getUniqueCitiesCount() {
        return (int) properties.stream()
                .map(property -> property.getAddress().split(",")[1].trim().toLowerCase())
                .distinct()
                .count();
    }

    public Set<String> getUniqueCities() {
        return properties.stream()
                .map(property -> property.getAddress().split(",")[1].trim())
                .collect(Collectors.toSet());
    }
}
