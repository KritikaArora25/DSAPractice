package JCF;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception{
        // ArrayList<Integer> lst = new ArrayList<>();

        // lst.add(1);
        // lst.add(2);
        // lst.add(3);
        // lst.add(4);
        // lst.add(5);
        // lst.add(3);
        // lst.add(4);
        // lst.add(5);
        // lst.add(3);
        // lst.add(4);
        // // lst.add(5);

        // Field field = ArrayList.class.getDeclaredField("elementData");
        // field.setAccessible(true);
        // Object[] elementData = (Object[]) field.get(lst);
        // System.out.println("ArrayList capacity: " + elementData.length);


        // lst.add(1);


        // elementData = (Object[]) field.get(lst);
        // System.out.println("ArrayList capacity: " + elementData.length);

        // lst.remove(1);
        // lst.remove(2);
        // lst.remove(3);
        // lst.remove(4);
        // lst.remove(5);
        // // lst.remove(6);
        // // lst.remove(7);
        // // lst.remove(8);

        // elementData = (Object[]) field.get(lst);
        // System.out.println("ArrayList Capacity: "+elementData.length);

        // lst.trimToSize();

        // elementData = (Object[]) field.get(lst);
        // System.out.println("ArrayList Capacity: "+elementData.length);


        // List<String> lst1 = new ArrayList<>();
        // System.out.println(lst1.getClass().getName());

        // List<String> lst2 = Arrays.asList("Krishn", " Radha", "Gurudev", "Harivansh Mahaprabhu");
        // System.out.println(lst2.getClass().getName());
        // lst2.set(1,"Kishori");
        // System.out.println(lst2);

        // String[] arr = {"Radha", "Madan","Mohan","Govind"};
        // List<String> lst3 = Arrays.asList(arr);
        // System.out.println(lst3.getClass().getName());

        // lst1.add("Shri Vrindavan");
        // lst1.add("Shri Vanchand");
        // lst1.add("Shri Hariram Vyas ji");   

        // lst1.add(0, "Harivansh Mahaprabhu");
        // System.out.println(lst1);

        // List<String> newlst = List.of("Shri Roop Lal", "Shri Swami Haridas ji","Shri Nagri das ji", "Shri Dhruv das ji", "Shri Surdas ji");
        // lst1.addAll(newlst);

        // System.out.println(lst1);

        // lst1.add("Shri Hariram Vyas ji");
        // System.out.println(lst1);

        // lst1.remove("Shri Hariram Vyas ji");
        // System.out.println(lst1);

        // Object[] array = lst1.toArray();
        // Integer[] array2 = lst1.toArray(new Integer[0]);

        ArrayList<Integer> lst = new ArrayList<>();
        lst.add(3);
        lst.add(1);
        lst.add(2);

        // Collections.sort(lst);
        lst.sort(null);

        System.out.println(lst);

    }
}
