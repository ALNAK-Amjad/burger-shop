package com.example.burgerparadiesonlineshop.Entity;

import java.util.HashMap;

/**
 * @brief   VeggieBurgers Klasse
 *
 * @author  Xiao-Ou Wang <hoshizawa.yuriko@gmail.com>
 */
public class VeggieBurgers extends Burgers {
    public VeggieBurgers(int id, String name, double price) {
        super(id, name, price);
    }

    public VeggieBurgers(int id, String name, double price, HashMap<String, Double> options) {
        super(id, name, price, options);
    }

    public VeggieBurgers(Products product) {
        super(product);
    }

    public String getCategory() {
        return "VeggieBurgers";
    }
}
