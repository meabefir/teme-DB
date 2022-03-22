package list.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MyList<T> {
    T[] data;
    int size;

    public MyList(int dimension) {
        data = (T[]) new Object[dimension];
        size = 0;
    }

    public void add(T element) {
        if (size >= data.length) {
            System.out.println("doubling capacity...");
            T[] cpy = (T[]) new Object[size];
            for (int i = 0; i < size; i++) {
                cpy[i] = data[i];
            }

            data = (T[]) new Object[data.length * 2];
            for (int i = 0; i < size; i++) {
                data[i] = cpy[i];
            }
        }
        data[size++] = element;
        System.out.println("added element " + element);
    }

    public void print() {
        System.out.println(Arrays.toString(data));
    }

    public boolean lookup(T element) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(element)) {
                return true;
            }
        }
        return false;
    }
}
