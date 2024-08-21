package com.example.burgerparadiesonlineshop.Entity;

import java.util.HashMap;

/**
 * @brief   Abstrakte Klasse für alle Burgerarten (BeefBurgers, ChickenBurgers, VeggieBurgers)
 *
 * @author  Xiao-Ou Wang <hoshizawa.yuriko@gmail.com>
 */
public abstract class Burgers extends Products {
    public Burgers(int id, String name, double price) {
        super(id, name, price);
    }

    public Burgers(int id, String name, double price, HashMap<String, Double> options) {
        super(id, name, price, options);
    }

    public Burgers(Products product) {
        super(product);
    }
}
