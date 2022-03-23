package com.company;

public class PepperoniTopping extends PizzaDecorator {
    public PepperoniTopping(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String toString() {
        return pizza + "with pepperoni ";
    }
}
