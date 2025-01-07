package RealEstate;

import java.util.*;

public class Main {
    private static RealEstateManager realEstateManager;

    public static void main(String[] args) {
        // אתחול מנהל משרד התיווך והוספת הנכסים שהתקבלו מה-DataManager
        realEstateManager = new RealEstateManager("RealEstate Agency");
        ArrayList<Property> properties = DataManager.createProperties();
        for (Property property : properties) {
            realEstateManager.addProperty(property);
        }

        // תפריט אינסופי
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("בחר אחת מהאפשרויות:");
            System.out.println("1 > חיפוש נכסים");
            System.out.println("2 > דו״ח פיננסי");
            System.out.println("3 > תשואת נדל״ן מסחרי");
            System.out.println("4 > נכסים לפי עיר");
            System.out.println("5 > כמות ערים");
            System.out.println("6 > יציאה מהתוכנית");

            int option = scanner.nextInt();
            scanner.nextLine();  // לקרוא את שורת השאילתא שנותרה

            switch (option) {
                case 1:
                    propertiesList(scanner);
                    break;
                case 2:
                    financialReport();
                    break;
                case 3:
                    commercialYield();
                    break;
                case 4:
                    propertiesByCity(scanner);
                    break;
                case 5:
                    numberOfCities();
                    break;
                case 6:
                    System.out.println("תוכנית הסתיימה. להתראות!");
                    return;  // יציאה מהתוכנית
                default:
                    System.out.println("בחירה לא חוקית. נסה שוב.");
            }
        }
    }

    // פונקציה לחיפוש נכסים לפי מחיר
    public static void propertiesList(Scanner scanner) {
        try {
            System.out.print("הכנס מחיר: ");
            int price = scanner.nextInt();
            if (price < 0) {
                throw new PriceException("מחיר לא יכול להיות שלילי");
            }
            ArrayList<Property> properties = realEstateManager.getPropertiesByPrice(price);
            if (properties.isEmpty()) {
                System.out.println("לא נמצאו נכסים במחיר הנבחר.");
            } else {
                properties.forEach(System.out::println);
            }
        } catch (PriceException e) {
            System.out.println(e.getMessage());
        }
    }

    // דו"ח פיננסי – הצגת מסים
    public static void financialReport() {
        System.out.println("דו״ח פיננסי:");
        realEstateManager.getProperties().forEach(property -> {
            property.taxIt();
        });
    }

    // תשואת נדל״ן מסחרי – חישוב התשואה הכוללת של הנכסים המסחריים
    public static void commercialYield() {
        double totalYield = 0.0;
        for (Property property : realEstateManager.getProperties()) {
            if (property instanceof Commercial) {
                totalYield += ((Commercial) property).getYield();
            }
        }
        System.out.printf("התשואה הכוללת של הנכסים המסחריים: %.2f%%\n", totalYield);
    }

    // נכסים לפי עיר
    public static void propertiesByCity(Scanner scanner) {
        System.out.print("הכנס שם עיר: ");
        String city = scanner.nextLine().replace("-", " ").toLowerCase();
        ArrayList<Property> cityProperties = realEstateManager.getPropertiesByCity(city);
        if (cityProperties.isEmpty()) {
            System.out.println("לא נמצאו נכסים בעיר הזו.");
        } else {
            cityProperties.forEach(System.out::println);
        }
    }

    // כמות ערים – חישוב מספר הערים הייחודיות
    public static void numberOfCities() {
        Set<String> cities = new HashSet<>();
        for (Property property : realEstateManager.getProperties()) {
            String city = property.getAddress().split(",")[1].trim().toLowerCase();
            cities.add(city);
        }
        System.out.println("מספר הערים הייחודיות: " + cities.size());
        System.out.println("הערים הן: " + String.join(", ", cities));
    }
}

