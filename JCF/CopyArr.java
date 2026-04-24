package JCF;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyArr {
    public static void main(String[] args) {
        List<Integer> list = new CopyOnWriteArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println("Intial List: " +list);

        for(Integer i: list){
            list.add(4);
            System.out.println(i);
        }
    }
}
