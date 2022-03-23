package com.company.topping;

import com.company.pizza.Pizza;

public class PepperoniTopping extends PizzaDecorator {
    public PepperoniTopping(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String toString() {
        return pizza + "with pepperoni ";
    }
}
