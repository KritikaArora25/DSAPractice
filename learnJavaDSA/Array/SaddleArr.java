import java.util.*;
public class SaddleArr {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array: ");
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        System.out.println("Enter the elements of the array: ");
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int svj = 0;
        for(int i = 0; i < arr.length; i++ ){
            for(int j = 1 ; j < arr.length ; j++){
                if(arr[i][j] < arr[i][svj]){
                    svj = j;
                }
            }

            boolean flag = true;
            for(int k = 0 ; k < arr.length ; k++){
                if(arr[k][svj] > arr[i][svj]){
                    flag = false;
                    break;
            }
        }
        if(flag == true){
            System.out.println("The Saddle point is: " + arr[i][svj]);
            return;
        }
    }
    System.out.println("Invalid Input ! ");
}
}
