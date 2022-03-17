package com.company;

public class Bus extends Vehicle {
    private int noPassengers;
    private int ticketPrice;

    public Bus(String color, boolean functional, int noPassengers, int ticketPrice) {
        super(color, functional);
        this.noPassengers = noPassengers;
        this.ticketPrice = ticketPrice;
    }

    public Bus() {
        noPassengers = -1;
        ticketPrice = -1;
    }

    public int getNoPassengers() {
        return noPassengers;
    }

    public void setNoPassengers(int noPassengers) {
        this.noPassengers = noPassengers;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    @Override
    public String toString() {
        return "Bus{\n" +
                super.toString() +
                "noPassengers=" + noPassengers +
                ", ticketPrice=" + ticketPrice + "\n" +
                "proft= " + String.valueOf(profit()) +
                '}';
    }

    @Override
    public double charge() {
        return ticketPrice * .25;
    }

    @Override
    public double profit() {
        return isFunctional() ? noPassengers * charge() : 0.;
    }

    @Override
    public void display() {
        System.out.println(this);
    }
}
