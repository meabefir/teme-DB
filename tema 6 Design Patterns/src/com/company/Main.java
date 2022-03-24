package com.company;

import com.company.command.Client;
import com.company.command.CommandOrder;
import com.company.pizza.EnumPizza;
import com.company.pizza.Pizza;
import com.company.pizza.PizzaFactory;
import com.company.topping.EnumTopping;

public class Main {

    public static void main(String[] args) {

//        OBS - am implementat eu Observer si Observable deoarece cele din java.utils aveau warning de deprecated si metoda "notifyObservers" nu functiona

        Client c1 = new Client("Gigel");
        Client c2 = new Client("Costel");
        Client c3 = new Client("Marinel");

        PizzaFactory.getInstance().addClient(c1);
        PizzaFactory.getInstance().addClient(c2);
        PizzaFactory.getInstance().addClient(c3);

        Pizza p1 = PizzaFactory.getInstance().makePizza(EnumPizza.Marguerita, new EnumTopping[]{EnumTopping.Cheese});
        Pizza p2 = PizzaFactory.getInstance().makePizza(EnumPizza.Capriciosa, new EnumTopping[]{EnumTopping.Cheese, EnumTopping.Mushrooms});
        Pizza p3 = PizzaFactory.getInstance().makePizza(EnumPizza.QuatroStagioni, new EnumTopping[]{EnumTopping.Pepperoni, EnumTopping.Mushrooms, EnumTopping.Cheese});

        CommandOrder o1 = new CommandOrder(c1, p1);
        CommandOrder o2 = new CommandOrder(c2, p1);
        CommandOrder o3 = new CommandOrder(c3, p2);
        CommandOrder o4 = new CommandOrder(c3, p3);
        o1.execute();
        o2.execute();
        o3.execute();
        o4.execute();
    }
}
