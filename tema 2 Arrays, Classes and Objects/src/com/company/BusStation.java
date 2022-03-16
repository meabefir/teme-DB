package com.company;

import java.util.Arrays;
import java.util.Collections;

public class BusStation {
    private Vehicle[] vehicles = new Vehicle[10];
    int nVehicles = 0;

    public void addVehicle(Vehicle v) {
        if (nVehicles >= vehicles.length)
            return;

        vehicles[nVehicles++] = v;
    }

    public void showAllVehicles() {
        for (int i = 0; i < nVehicles; i++) {
            System.out.println(vehicles[i].toString());
        }
        System.out.println();
    }

    public void showTotalProfit() {
        double profit = 0.;
        for (int i = 0; i < nVehicles; i++) {
            profit += vehicles[i].profit();
        }
        System.out.println("Total profit is " + profit);
    }

    public void sortVehicles() {
        Arrays.sort(vehicles, 0, nVehicles);
    }

    void test() {
        addVehicle(new Bus("red", true, 10, 21));
        addVehicle(new Bus("blue", false, 20, 15));
        addVehicle(new Taxi("orange", false, 4, 25));
        addVehicle(new Taxi("yellow", true, 2, 30));


        showAllVehicles();

        showTotalProfit();

        sortVehicles();

        System.out.println("Sorted vehicles are:\n");
        showAllVehicles();
    }
}
