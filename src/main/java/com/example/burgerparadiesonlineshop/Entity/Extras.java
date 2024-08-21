package com.example.burgerparadiesonlineshop.Entity;

import java.util.HashMap;

/**
 * @brief   Extras Klasse
 * 
 * @details Extras beinhalten u.a. Fingerfood, Pommes, Saucen etc.
 *
 * @author  Xiao-Ou Wang <hoshizawa.yuriko@gmail.com>
 */
public class Extras extends Products {
    public Extras(int id, String name, double price) {
        super(id, name, price);
    }

    public Extras(int id, String name, double price, HashMap<String, Double> options) {
        super(id, name, price, options);
    }

    public Extras(Products product) {
        super(product);
    }

    public String getCategory() {
        return "Extras";
    }
}
