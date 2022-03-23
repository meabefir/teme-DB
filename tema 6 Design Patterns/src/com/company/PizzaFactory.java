package com.company;

import java.util.ArrayList;
import java.util.List;

public class PizzaFactory extends Observable {
    private static PizzaFactory instance;
    List<Pizza> pizzas;

    private PizzaFactory() {
        pizzas = new ArrayList<>();
    }

    public static PizzaFactory getInstance() {
        if (instance == null) {
            instance = new PizzaFactory();
        }
        return instance;
    }

    public Pizza makePizza(EnumPizza pizzaType, EnumTopping[] toppings) {
        Pizza newPizza = null;
        switch (pizzaType) {
            case Capriciosa:
                newPizza = new Capriciosa();
                break;
            case Marguerita:
                newPizza = new Marguerita();
                break;
            case ProsciuttoFunghi:
                newPizza = new ProsciuttoFunghi();
                break;
            case QuatroStagioni:
                newPizza = new QuatroStagioni();
                break;
            default:
                newPizza = null;
                break;
        }
        if (newPizza == null) return null;

        for (EnumTopping topping: toppings) {
            newPizza = addTopping(newPizza, topping);
        }
        this.notifyObservers(newPizza);
        pizzas.add(newPizza);
        return newPizza;
    }

    public Pizza addTopping(Pizza pizza, EnumTopping toppingType) {
        switch (toppingType) {
            case Pepperoni:
                return new PepperoniTopping(pizza);
            case Cheese:
                return new CheeseTopping(pizza);
            case Mushrooms:
                return new MushroomsTopping(pizza);
            default:
                return null;
        }
    }

    public void addClient(Client client) {
        System.out.println("added client " + client);
        this.addObserver(client);
    }
}
