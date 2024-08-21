package com.example.burgerparadiesonlineshop.Model;

import com.example.burgerparadiesonlineshop.Entity.Burgers;
import com.example.burgerparadiesonlineshop.Entity.Products;
import com.example.burgerparadiesonlineshop.Entity.VeggieBurgers;

/**
 * @brief   VeggieBurgersFactory
 *
 * @author  Xiao-Ou Wang <hoshizawa.yuriko@gmail.com>
 */
public class VeggieBurgersFactory implements BurgersFactory {
    @Override
    public Burgers createProduct(Products product) {
        return new VeggieBurgers(product);
    }
}
