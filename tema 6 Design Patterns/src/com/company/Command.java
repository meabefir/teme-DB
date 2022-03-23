package com.company;

import com.company.pizza.Pizza;

public interface Command {
    public void execute(Client c, Pizza p);
}
