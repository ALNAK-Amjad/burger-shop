package com.example.burgerparadiesonlineshop.Model;

import com.example.burgerparadiesonlineshop.Entity.Drinks;
import com.example.burgerparadiesonlineshop.Entity.Products;

/**
 * @brief   DrinksFactory
 *
 * @author  Xiao-Ou Wang <hoshizawa.yuriko@gmail.com>
 */
public class DrinksFactory implements ProductsFactory {
    @Override
    public Products createProduct(Products product) {
        return new Drinks(product);
    }
}
