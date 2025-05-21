import java.util.*;
public class ShellRotArr {
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

        int s = sc.nextInt();
        int r = sc.nextInt();
        
        rotateShell(arr , s , r);
        display(arr);

        sc.close();

        }
        public static void rotateShell(int[][] arr , int s , int r) {
            int[] oned = fillOnedFromShell(arr, s);
            rotate(oned , r);
            fillShellFromOned(arr , s , oned);

        }

        public static int[] fillOnedFromShell(int[][] arr , int s){
            int minr = s - 1;
            int minc = s - 1;
            int maxr = arr.length - s ;
            int maxc = arr[0].length - s ;

            int sz = 2 * ((maxr - minr) + (maxc - minc));

            int[] oned = new int[sz];

            int idx = 0;
            //lw
            for(int i = minr , j = minc ; i <= maxr; i++){
                oned[idx] = arr[i][j];
                idx++;
            }
            minc++;

            //bw
            for(int i = maxr , j = minc ; j <= maxc; j++){
                oned[idx] = arr[i][j];
                idx++;
            }
            maxr--;
            

            //rw
            for(int i = maxr , j = maxc ; i >= minr; i--){
                oned[idx] = arr[i][j];
                idx++;
            }
            maxc--;

            //tw
            for(int i = minr , j = maxc ; j >= minc; j--){
                oned[idx] = arr[i][j];
                idx++;
            }

            return oned;
        }

        public static void rotate( int[] oned , int r ){
            r = r % oned.length;
            if( r < 0 ){
                r = oned.length + r;
            } 
            reverse(oned , 0 , oned.length - r - 1);
            reverse(oned , oned.length - r , oned.length - 1);
            reverse(oned , 0 , oned.length - 1);
        }

        public static void reverse(int[] oned, int li , int ri ){
            while(li < ri){
                int temp = oned[li];
                oned[li] = oned[ri];
                oned[ri] = temp;
                li++;
                ri--;
            }
        }

        public static void fillShellFromOned(int[][] arr, int s, int[] oned){
            int minr = s - 1;
            int minc = s - 1;
            int maxr = arr.length - s ;
            int maxc = arr[0].length - s ;


            int idx = 0;
            //lw
            for(int i = minr , j = minc ; i <= maxr; i++){
              arr[i][j] = oned[idx];
                idx++;
            }
            minc++;

            //bw
            for(int i = maxr , j = minc ; j <= maxc; j++){
                arr[i][j] = oned[idx];
                idx++;
            }
            maxr--;
            

            //rw
            for(int i = maxr , j = maxc ; i >= minr; i--){
                arr[i][j] = oned[idx];
                idx++;
            }
            maxc--;

            //tw
            for(int i = minr , j = maxc ; j >= minc; j--){
                arr[i][j] = oned[idx];
                idx++;
            }
        }

        public static void display(int[][] arr){
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    System.out.print(arr[i][j]+"  ");
                }
                System.out.println();
            }
    
        }

    }
    

