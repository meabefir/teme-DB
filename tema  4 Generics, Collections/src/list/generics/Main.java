package list.generics;

public class Main {
    public static void main(String[] args) {
        MyList<Integer> list = new MyList<>(1);
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }

        list.print();

        System.out.println(list.lookup(33));
        System.out.println(list.lookup(333));
    }
}
