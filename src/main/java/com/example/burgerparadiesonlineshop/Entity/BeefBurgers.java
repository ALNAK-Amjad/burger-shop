package com.example.burgerparadiesonlineshop.Entity;

import java.util.HashMap;

/**
 * @brief   BeefBurgers Klasse
 *
 * @author  Xiao-Ou Wang <hoshizawa.yuriko@gmail.com>
 */
public class BeefBurgers extends Burgers {
    public BeefBurgers(int id, String name, double price) {
        super(id, name, price);
    }

    public BeefBurgers(int id, String name, double price, HashMap<String, Double> options) {
        super(id, name, price, options);
    }

    public BeefBurgers(Products product) {
        super(product);
    }
    
    public String getCategory() {
        return "BeefBurgers";
    }
}
