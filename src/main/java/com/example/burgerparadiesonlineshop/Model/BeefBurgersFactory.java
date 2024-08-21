package com.example.burgerparadiesonlineshop.Model;

import com.example.burgerparadiesonlineshop.Entity.BeefBurgers;
import com.example.burgerparadiesonlineshop.Entity.Burgers;
import com.example.burgerparadiesonlineshop.Entity.Products;

/**
 * @brief   BeefBurgersFactory
 *
 * @author  Xiao-Ou Wang <hoshizawa.yuriko@gmail.com>
 */
public class BeefBurgersFactory implements BurgersFactory {
    @Override
    public Burgers createProduct(Products product) {
        return new BeefBurgers(product);
    }
}
