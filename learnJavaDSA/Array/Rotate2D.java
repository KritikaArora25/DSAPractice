import java.util.*;
public class Rotate2D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[m][n];


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }


        //Transpose
        for(int i = 0; i < m; i++ ){
            for(int j = i ; j < n ; j++ ){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }

        }

        //Reverse
        for(int i = 0; i < m ; i++ ){
            int li = 0 ;
            int ri = m-1;

            while(li < ri){
                int temp = arr[i][li];
                arr[i][li] = arr[i][ri];
                arr[i][ri] = temp;
                li++;
                ri--;
            }

        }
        System.out.println("Output : ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j]+"  ");
            }
            System.out.println();
        }

        }
    }

