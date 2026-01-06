import java.util.*;
public class wave2D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int[][] arr = new int[n1][n2];
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                arr[i][j] = sc.nextInt();
                }
                }
        for(int j = 0; j < n2 ; j ++){
            if(j % 2 == 0){
                for(int i = 0; i < n1 ; i ++){
                    System.out.println(arr[i][j]);
            }

            }else{
            for(int i = n1-1 ; i >= 0 ; i --){
                System.out.println(arr[i][j]);
        }
    }
    
}}}