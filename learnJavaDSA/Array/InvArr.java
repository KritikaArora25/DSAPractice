import java.util.*;
public class InvArr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i ++){
            arr[i] = sc.nextInt();
        }
        int[] res = new int[n];

        for( int i = 0 ; i < n ; i ++ ){
            res[arr[i]] = i;
        }

        for(int val : res){
            System.out.print(val + " ");
        }

        sc.close();
    }
    
}
