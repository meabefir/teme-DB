package com.company;

import com.company.observer.Observable;
import com.company.observer.Observer;
import com.company.pizza.Pizza;

public class Client implements Observer {
    String name;

    public Client(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
