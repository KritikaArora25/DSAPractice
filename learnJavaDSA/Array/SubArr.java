import java.util.*;
public class SubArr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the array length");
        int n = sc.nextInt();
        String[] arr = new String[n];
        System.out.println("Enter the array elements");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
            }
            System.out.println("Enter the sub array is : ");
            for(int i = 0 ; i < n ; i++){
                for(int j = i ; j < n ; j++){
                    for(int k = i; k <= j ; k++){
                        System.out.print(arr[k] + "\t");
                    }
                    System.out.println();
                }
            }

    }
    
}
