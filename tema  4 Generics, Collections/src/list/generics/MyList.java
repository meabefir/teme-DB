package list.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MyList<T> {
    List<T> data;

    public MyList(int dimension) {
        data = new ArrayList<>(dimension);
    }

    public void add(T element) {
        data.add(element);
    }

    public void print() {
        System.out.println(Arrays.toString(data.toArray()));
    }

    public boolean lookup(T element) {
        for (T el: data) {
            if (el.equals(element)) {
                return true;
            }
        }
        return false;
    }
}
