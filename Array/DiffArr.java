import java.util.*;
public class DiffArr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int[] a1 = new int[n1];
        for(int i = 0; i < n1; i++){
            a1[i] = sc.nextInt();
        }
        int n2 = sc.nextInt();
        int[] a2 = new int[n2];
        for(int i = 0; i < n2; i++){
            a2[i] = sc.nextInt();
        }
        int[] diff = new int[n2];
        int i = n1 - 1;
        int j = n2 - 1;
        int k = n2 - 1;
        int c = 0;

       while(k >= 0){
            int d = 0;
            int a1v = (i >= 0) ? a1[i] : 0;
            if(a2[j] + c >=a1v){
                d = a2[j] + c  - a1v;
                c = 0;
            }
            else{
                d = a2[j] + c + 10 - a1v;
                c = -1;
            }
            diff[k] = d;
            i--;
            j--;
            k--;
       }
       
       
       int x = 0;
        while (x < diff.length && diff[x] == 0) {
            x++;
        }

        // Print the result
        if (x == diff.length) {
            System.out.println(0); // If all digits are 0, print 0
        } else {
            while (x < diff.length) {
                System.out.print(diff[x] + " ");
                x++;
            }
}
}
}
