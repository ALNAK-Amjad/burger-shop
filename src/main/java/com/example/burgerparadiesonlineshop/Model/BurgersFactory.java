package com.example.burgerparadiesonlineshop.Model;

import com.example.burgerparadiesonlineshop.Entity.Burgers;
import com.example.burgerparadiesonlineshop.Entity.Products;

/**
 * @brief   BurgersFactory
 *
 * @author  Xiao-Ou Wang <hoshizawa.yuriko@gmail.com>
 */
public interface BurgersFactory extends ProductsFactory {
    Burgers createProduct(Products product);
}
