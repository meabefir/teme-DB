package com.company;

public class Taxi extends Vehicle {
    private int noPassengers;
    private int ticketPrice;

    public Taxi(String color, boolean functional, int noPassengers, int ticketPrice) {
        super(color, functional);
        this.noPassengers = noPassengers;
        this.ticketPrice = ticketPrice;
    }

    public Taxi() {
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
        return "Taxi{\n" +
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
        return noPassengers * charge();
    }

    @Override
    public void display() {

    }
}
