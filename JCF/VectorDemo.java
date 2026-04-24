package JCF;

import java.util.*;
import java.util.LinkedList;

public class VectorDemo {
    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<>(5,3);
        vector.add(1);
        vector.add(1);
        vector.add(1);
        vector.add(1);
        vector.add(1);
        System.out.println("Capacity : "+ vector.capacity());
        vector.add(1);
        System.out.println("Capacity : "+ vector.capacity());

        LinkedList<Integer> lst = new LinkedList<>();
        lst.add(1);
        lst.add(2);
        lst.add(3);

        Vector<Integer> vector1 = new Vector<>(lst);
        Vector<Integer> vector2 = new Vector<>(Arrays.asList(1,2,3));
    }
}
