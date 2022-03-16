package com.company;

public abstract class Vehicle implements Comparable<Vehicle>{

    private String color;
    private boolean functional;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFunctional() {
        return functional;
    }

    public void setFunctional(boolean functional) {
        this.functional = functional;
    }

    public Vehicle() {
        functional = false;
        color = "ncol";
    }

    public Vehicle(String color, boolean functional) {
        this.color = color;
        this.functional = functional;
    }

    public abstract double charge();
    public abstract double profit();
    public abstract void display();

    @Override
    public String toString() {
        return  "color='" + color + '\'' +
                "functional=" + functional + '\n';
    }

    @Override
    public int compareTo(Vehicle o) {
        return (int)(profit() - o.profit());
    }
}
