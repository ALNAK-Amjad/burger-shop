package com.example.burgerparadiesonlineshop.Model;

import com.example.burgerparadiesonlineshop.Entity.Products;

/**
 * @brief   Factory Method pattern to create instances of Products and its child classes
 *
 * @author  Xiao-Ou Wang <hoshizawa.yuriko@gmail.com>
 */
public interface ProductsFactory {
    Products createProduct(Products product);
}
