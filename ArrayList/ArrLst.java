import java.util.*;
public class ArrLst {
    public static void main(String[] args) {
        ArrayList<Integer> lst = new ArrayList<>();
        System.out.println(lst +" -> "+lst.size());

        lst.add(10);
        lst.add(20);
        lst.add(30);

        System.out.println(lst +" -> "+lst.size());

        lst.add(1, 1000);
        System.out.println(lst +" -> "+lst.size());

        int val = lst.get(1);
        System.out.println(val);

        lst.set(1,2000);
        System.out.println(lst +" -> "+lst.size());

        lst.remove(1);
        System.out.println(lst +" -> "+lst.size());

        ArrayList<String> lst2 = new ArrayList<>();
        lst2.add("Apple");
        lst2.add("Banana");
        lst2.add("Cherry");
        System.out.println(lst2 +" -> "+lst2.size());

        for(int i = 0 ; i <lst2.size();i++ ){
            System.out.println(lst2.get(i));
        }

        for(int val1 : lst){
            System.out.println(val1);
        }

        System.out.println(lst);
        System.out.println(lst2);
    }
    
}
