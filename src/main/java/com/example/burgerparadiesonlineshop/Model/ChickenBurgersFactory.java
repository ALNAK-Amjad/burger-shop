package com.example.burgerparadiesonlineshop.Model;

import com.example.burgerparadiesonlineshop.Entity.Burgers;
import com.example.burgerparadiesonlineshop.Entity.ChickenBurgers;
import com.example.burgerparadiesonlineshop.Entity.Products;

/**
 * @brief   ChickenBurgersFactory
 *
 * @author  Xiao-Ou Wang <hoshizawa.yuriko@gmail.com>
 */
public class ChickenBurgersFactory implements BurgersFactory {
    @Override
    public Burgers createProduct(Products product) {
        return new ChickenBurgers(product);
    }
}
