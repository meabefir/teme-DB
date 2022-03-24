package com.company.command;

import com.company.observer.Observable;
import com.company.observer.Observer;
import com.company.pizza.Pizza;

import java.util.ArrayList;
import java.util.List;

public class Client implements Observer {
    String name;
    List<Pizza> pizzas;

    public Client(String name) {
        this.name = name;
        this.pizzas = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void buyPizza(Pizza p) {
        pizzas.add(p);
        System.out.println("client " + this + " bought pizza " + p);
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + ' ' +
                '}';
    }

    @Override
    public void update(Observable o, Object arg) {
        Pizza new_pizza = (Pizza)arg;
        System.out.println(this.name + " a fost notificat ca s-a copt pizza " + new_pizza);
    }
}
