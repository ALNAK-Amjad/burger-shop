package com.example.burgerparadiesonlineshop.Entity;

import java.util.HashMap;

/**
 * @brief   Abstrakte Klasse für alle Produktarten (Burgers, Extras, Drinks)
 * 
 * @details Attribut "options" ist für zusätzlich auswählbare Optionen
 *          z.B. Extra Cheese, Ohne Tomate, etc.
 *
 * @author  Xiao-Ou Wang <hoshizawa.yuriko@gmail.com>
 */
public abstract class Products {
    private int id;
    private String name;
    private double price;
    private HashMap<String, Double> options;

    public Products(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.options = new HashMap<>();
    }

    public Products(int id, String name, double price, HashMap<String, Double> options) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.options = options;
    }

    public Products(Products product) {
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.options = new HashMap<>(product.getOptions());
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public HashMap<String, Double> getOptions() {
        return options;
    }

    public void addOption(String option, double price) {
        options.put(option, price);
    }

    public void replaceAllOptions(HashMap<String, Double> options) {
        this.options.clear();
        this.options.putAll(options);
    }

    public void deleteAllOptions() {
        this.options.clear();
    }

    public abstract String getCategory();
}
