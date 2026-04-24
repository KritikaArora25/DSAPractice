package JCF;
import java.util.*;
import java.util.LinkedList;

public class LinkedLst {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(1);
        ll.add(2);
        ll.add(2);
        ll.add(2);

        System.out.println(ll.get(2));
        System.out.println(ll.getFirst());
        System.out.println(ll.getLast());

        System.out.println(ll);

        ll.removeIf(x -> x % 2 != 0);

        System.out.println(ll);

        LinkedList<String> animals = new LinkedList<>(Arrays.asList("cat","dog","Elephant"));
        LinkedList<String> animalstoRemove = new LinkedList<>(Arrays.asList("lion","dog"));
        animals.removeAll(animalstoRemove);

        System.out.println(animals);


    }
}
