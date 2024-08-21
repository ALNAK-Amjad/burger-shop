package com.example.burgerparadiesonlineshop.Entity;

import java.util.HashMap;

/**
 * @brief   ChickenBurgers Klasse
 *
 * @author  Xiao-Ou Wang <hoshizawa.yuriko@gmail.com>
 */
public class ChickenBurgers extends Burgers {
    public ChickenBurgers(int id, String name, double price) {
        super(id, name, price);
    }

    public ChickenBurgers(int id, String name, double price, HashMap<String, Double> options) {
        super(id, name, price, options);
    }

    public ChickenBurgers(Products product) {
        super(product);
    }

    public String getCategory() {
        return "ChickenBurgers";
    }
}
