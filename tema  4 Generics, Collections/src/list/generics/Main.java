package list.generics;

public class Main {
    public static void main(String[] args) {
        MyList<Integer> list = new MyList<>(10);
        list.add(4);
        list.add(2);
        list.add(423);
        list.add(411);

        list.print();

        System.out.println(list.lookup(423));
        System.out.println(list.lookup(4223));
    }
}
