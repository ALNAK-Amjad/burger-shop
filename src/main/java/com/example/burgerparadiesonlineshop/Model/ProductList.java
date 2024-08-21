package com.example.burgerparadiesonlineshop.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.burgerparadiesonlineshop.Entity.*;

/**
 * @brief   Mockup Daten für verfügbare Produkte sowie Hilfsmethoden zum Handling der Liste
 *
 * @author  Xiao-Ou Wang <hoshizawa.yuriko@gmail.com>
 */
public class ProductList {
    // Initial Product List
    private static List<Products> productList = new ArrayList<>(Arrays.asList(
        new BeefBurgers(1, "Hamburger", 5.99,
            new HashMap<String, Double>() {{
                put("Double Patty", 2.00);
                put("Ohne Tomaten", 0.00);
            }}
        ),
        new BeefBurgers(2, "Cheeseburger", 6.49,
            new HashMap<String, Double>() {{
                put("Double Patty", 2.00);
                put("Extra Käse", 1.00);
                put("Ohne Tomaten", 0.00);
            }}
        ),
        new BeefBurgers(3, "Big Tasty Bacon", 7.99,
            new HashMap<String, Double>() {{
                put("Double Patty", 2.50);
                put("Extra Bacon", 1.50);
            }}
        ),
        new BeefBurgers(4, "Big Angus Beef", 7.99,
            new HashMap<String, Double>() {{
                put("Double Patty", 2.50);
                put("Extra Bacon", 1.50);
            }}
        ),
        new BeefBurgers(5, "Ultimate Beef King", 9.99,
            new HashMap<String, Double>() {{
                put("Double Patty", 2.50);
                put("Extra Bacon", 1.50);
            }}
        ),
        new ChickenBurgers(6, "Fresh Chicken", 6.99,
            new HashMap<String, Double>() {{
                put("Double Patty", 2.50);
                put("Extra Bacon", 1.50);
            }}
        ),
        new ChickenBurgers(7, "Long Chicken", 7.99,
            new HashMap<String, Double>() {{
                put("Double Patty", 2.50);
                put("Extra Bacon", 1.50);
            }}
        ),
        new ChickenBurgers(8, "Long Chicken Chili-Cheese", 8.49,
            new HashMap<String, Double>() {{
                put("Double Patty", 2.50);
                put("Extra Bacon", 1.50);
            }}
        ),
        new VeggieBurgers(9, "Vegan Beef", 6.99,
            new HashMap<String, Double>() {{
                put("Double Patty", 2.50);
            }}
        ),
        new VeggieBurgers(10, "Vegan Chicken", 6.99,
            new HashMap<String, Double>() {{
                put("Double Patty", 2.50);
            }}
        ),
        new VeggieBurgers(11, "Inca King", 8.99,
            new HashMap<String, Double>() {{
                put("Double Patty", 2.50);
            }}
        ),
        new Extras(12, "6 Chicken Nuggets", 4.99,
            new HashMap<String, Double>() {{
                put("Süßsauer Dip", 0.49);
                put("Curry Dip", 0.49);
            }}
        ),
        new Extras(13, "12 Chicken Nuggets", 7.99 ,
            new HashMap<String, Double>() {{
                put("Süßsauer Dip", 0.49);
                put("Curry Dip", 0.49);
            }}
        ),
        new Extras(14, "6 Vegan Nuggets", 4.99,
            new HashMap<String, Double>() {{
                put("Süßsauer Dip", 0.49);
                put("Curry Dip", 0.49);
            }}
        ),
        new Extras(15, "12 Vegan Nuggets", 7.99,
            new HashMap<String, Double>() {{
                put("Süßsauer Dip", 0.49);
                put("Curry Dip", 0.49);
            }}
        ),
        new Extras(16, "Pommes Frites", 3.99,
            new HashMap<String, Double>() {{
                put("Ketchup 20ml", 0.50);
                put("Mayo 20ml", 0.50);
            }}
        ),
        new Drinks(17, "Cola 0,5l", 2.99),
        new Drinks(18, "Fanta 0,5l", 2.99)
    ));

    // Return all products as List
    public static List<Products> getProductsAsList() {
        return productList;
    }

    // Filter the product list
    public static List<Products> filterProductList(String filter) {
        // Initialize the filtered list
        List<Products> filteredProductList = new ArrayList<>();

        // Add all products that match the filter criteria
        for (Products product : productList) {
            // Check the if the category matches
            if (product.getCategory().equals(filter)) {
                filteredProductList.add(product);
            }
        }

        return filteredProductList;
    }

    // Find a product via its id attribute (returns the reference to the product)
    public static Products getProductById(List<Products> productList, int targetId) {
        for (Products product : productList) {
            // Return the object if the id matches
            if (product.getId() == targetId) {
                return product;
            }
        }

        // Return null if the object is not found
        return null;
    }

    // Find a product via its id attribute (returns a new object instead of the reference)
    public static Products getProductByIdWithoutReference(List<Products> productList, int targetId) {
        for (Products product : productList) {
            if (product.getId() == targetId) {
                // Create a new instance of the product
                ProductsFactory factory = ProductFactoryProvider.getFactory(product.getCategory());
                if (factory != null) {
                    return factory.createProduct(product);
                }
            }
        }

        // Return null if no product is not found
        return null;
    }

    // Returns all options from a product via the option key
    public static HashMap<String, Double> getProductOptionsFromKeys(Products product, String[] filterKeys) {
        // Get all available options
        HashMap<String, Double> options = product.getOptions();

        // Create a new HashMap for filtered options
        HashMap<String, Double> filteredMap = new HashMap<>();

        // Filter the options and add to the new HashMap
        for (Map.Entry<String, Double> entry : options.entrySet()) {
            if (filterHashMapByKeys(entry, filterKeys)) {
                filteredMap.put(entry.getKey(), entry.getValue());
            }
        }

        return filteredMap;
    }

    // Helper method to filter a HashMap with a given array of keys
    public static boolean filterHashMapByKeys(HashMap.Entry<String, Double> entry, String[] filterKeys) {
        for (String key : filterKeys) {
            if (entry.getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

}
