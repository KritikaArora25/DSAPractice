import java.util.*;
public class SpirArr {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows in the array : ");
        int m = sc.nextInt();
        System.out.println("Enter number of cols in the array : ");
        int n = sc.nextInt();
        int[][] arr = new int[m][n];


        System.out.println("Enter elements of the array : ");
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        int minr = 0;
        int minc = 0;
        int maxr = m - 1;
        int maxc = n - 1;
        int cnt = 0;
        int tne = m * n;

        System.out.println("Elements in spiral traversal : ");

        while(cnt < tne){

            //left wall
            for(int i = minr , j = minc ; i <= maxc && cnt < tne; i++){
                System.out.println(arr[i][j]);
                cnt++;
            }
            minc++;

            //bottom wall
            for(int i = maxr , j = minc ; j <= maxc && cnt < tne; j++){
                System.out.println(arr[i][j]);
                cnt++;
            }
            maxr--;

            //right wall
            for(int i = maxr , j = maxc ; i >= minr && cnt < tne ; i--){
                System.out.println(arr[i][j]);
                cnt++;
            }
            maxc--;

            //top wall
            for(int i = minr , j = maxc ; j >= minc && cnt < tne ; j--){
                System.out.println(arr[i][j]);
                cnt++;
            }
            minr++;
        }

    }
}