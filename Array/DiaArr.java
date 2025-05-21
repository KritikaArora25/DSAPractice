import java.util.*;
public class DiaArr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of row elements : ");
        int n = sc.nextInt();

       

        int[][] arr = new int[n][n];

        System.out.println("Enter elements in 2D array : ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println("Output : ");
        for(int g = 0 ; g < arr.length ; g++){
            for(int i = 0 , j = g ; j < arr.length ; i++ , j++){
                System.out.print(arr[i][j] + " ");
            }
        }

        sc.close();
    }
    
}
