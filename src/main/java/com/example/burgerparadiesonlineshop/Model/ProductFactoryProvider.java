package com.example.burgerparadiesonlineshop.Model;

/**
 * @brief   Logic to provide the appropriate factory
 *
 * @author  Xiao-Ou Wang <hoshizawa.yuriko@gmail.com>
 */
public class ProductFactoryProvider {
    // Determine the appropriate factory based on the given productCategory
    public static ProductsFactory getFactory(String productCategory) {

        if (productCategory.equals("BeefBurgers")) {
            return new BeefBurgersFactory();
        } else if (productCategory.equals("ChickenBurgers")) {
            return new ChickenBurgersFactory();
        } else if (productCategory.equals("VeggieBurgers")) {
            return new VeggieBurgersFactory();
        } else if (productCategory.equals("Drinks")) {
            return new DrinksFactory();
        } else if (productCategory.equals("Extras")) {
            return new ExtrasFactory();
        }

        return null;
    }
}
