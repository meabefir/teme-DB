package com.company;

public class CheeseTopping extends PizzaDecorator {
    public CheeseTopping(Pizza pizza) {
        super(pizza);
    }
    @Override
    public String toString() {
        return pizza + "with cheese ";
    }
}
