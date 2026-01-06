package Revision;

import java.util.*;

public class BarCh {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        //Input
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        //Cal max
        int max = a[0];
        for (int i = 1; i < n; i++) {
            max = Math.max(a[i] , max);
        }

        //Printing BarChart
        for(int floor = max ; floor >= 1 ; floor--){
            for(int i = 0 ; i < n ; i++){
                if(a[i] >= floor){
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
    
}
