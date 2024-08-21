package com.example.burgerparadiesonlineshop.Model;

import com.example.burgerparadiesonlineshop.Entity.Extras;
import com.example.burgerparadiesonlineshop.Entity.Products;

/**
 * @brief   ExtrasFactory
 *
 * @author  Xiao-Ou Wang <hoshizawa.yuriko@gmail.com>
 */
public class ExtrasFactory implements ProductsFactory {
    @Override
    public Products createProduct(Products product) {
        return new Extras(product);
    }
}
