package com.company;

public class MushroomsTopping extends PizzaDecorator {
    public MushroomsTopping(Pizza pizza) {
        super(pizza);
    }
    @Override
    public String toString() {
        return pizza + "with mushrooms ";
    }
}
