package com.company.command;

import com.company.pizza.Pizza;
import com.company.pizza.PizzaFactory;

public class CommandOrder implements Command {
    Client client;
    Pizza pizza;

    public CommandOrder(Client client, Pizza pizza) {
        this.client = client;
        this.pizza = pizza;
    }

    @Override
    public void execute() {
        PizzaFactory pf = PizzaFactory.getInstance();
        Pizza p = pf.orderPizza(pizza);
        if (p == null) {
            System.out.println("client " + client + " tried ordering pizza " + pizza + ", but it was already ordered by another client");
            return;
        }
        client.buyPizza(p);
    }
}
