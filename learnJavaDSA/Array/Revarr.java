import java.util.Scanner;

public class Revarr {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the array size ");
        int n = sc.nextInt();
        int[] arr;
        arr = new int[n];
        System.out.println("Enter the array elements!");
        for(int i = 0; i < n; i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("Original array: ");
        for(int val: arr){
            System.out.print(val+" ");
        }
        int l= n-1;
        for(int i = 0; i < n/2 ;i++){
            int temp = arr[l];
            arr[l] = arr[i];
            arr[i] = temp;
            l--;


        }
        System.out.println("\nReversed array: ");
        for(int val: arr){
            System.out.print(val+" ");
        }
        
    }
    
    
}
