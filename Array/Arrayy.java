import java.util.*;
public class Arrayy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Array is : ");
        int n = sc.nextInt();
        int[] arr;
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Array input successfull !");
        sc.close();

    }    
}
