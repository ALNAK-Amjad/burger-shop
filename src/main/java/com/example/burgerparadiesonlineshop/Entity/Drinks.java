package com.example.burgerparadiesonlineshop.Entity;

import java.util.HashMap;

/**
 * @brief   Drinks Klasse
 *
 * @author  Xiao-Ou Wang <hoshizawa.yuriko@gmail.com>
 */
public class Drinks extends Products {
    public Drinks(int id, String name, double price) {
        super(id, name, price);
    }

    public Drinks(int id, String name, double price, HashMap<String, Double> options) {
        super(id, name, price, options);
    }

    public Drinks(Products product) {
        super(product);
    }

    public String getCategory() {
        return "Drinks";
    }
}
