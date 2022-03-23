package com.company.topping;

import com.company.pizza.Pizza;

public class MushroomsTopping extends PizzaDecorator {
    public MushroomsTopping(Pizza pizza) {
        super(pizza);
    }
    @Override
    public String toString() {
        return pizza + "with mushrooms ";
    }
}
