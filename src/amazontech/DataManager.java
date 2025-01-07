package amazontech;

import java.util.HashMap;

public class DataManager {
    public static HashMap<Integer, Product> mockProducts() {
        HashMap<Integer, Product> products = new HashMap<>();

        products.put(1, new TV("Samsung 75", 5000));
        products.put(2, new TV("LG 65", 3500));
        products.put(3, new Smartphone("Apple iPhone 16", 1000));
        products.put(4, new Smartphone("Samsung Galaxy S24", 900));
        products.put(5, new Laptop("MacBook Pro", 2000));
        products.put(6, new Laptop("Dell XPS", 1800));
        products.put(7, new PC("Gaming Desktop", 3000));
        products.put(8, new PC("Office Desktop", 1500));

        return products;
    }
}