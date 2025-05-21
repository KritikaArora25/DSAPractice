import java.util.*;
public class Barchart {
    public static int max(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }

    }
    return max;
}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for(int i = 0 ; i < arr.length; i++ ){
            System.out.println(arr[i]);
        }
        for(int i = max(arr) ; i >= 1; i-- ){
            for(int j = 0 ; j < arr.length; j++){
                if( arr[j] >= i){
                    System.out.print("*\t");
                }else{
                    System.out.print(" \t");
                }

            }
            System.out.println();
            
        }

    }
    
}
