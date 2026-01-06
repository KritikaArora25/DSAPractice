import java.util.*;
public class BinSer {
    public static void main(String[] args){
        int[] arr = {10,20,30,40,50,60,70,80,90,100};
        int data = 70;

        int l = 0;
        int h = arr.length - 1;

        while(l <= h){
            int m = (l+h)/2;
            if(arr[m] == data){
                System.out.println("Element is present at index " + m);
                return;
            }if(arr[m] < data){
                l = m + 1;
            }
            if(arr[m] > data){
                h = m - 1;
                
            }
        }
        System.out.println(-1);

    }
    
}
