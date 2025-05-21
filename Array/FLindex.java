import java.util.*;
public class FLindex {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array ! ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements of the array ! ");
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
            }
        System.out.println("Enter the element whose index is to be seached! ");
        int data = sc.nextInt();
        int l = 0;
        int h = n - 1;
        int fi = -1; 
      
        while(l <= h){
            int mid = l + (h - l) / 2; 
            if(arr[mid] < data ){
                l = mid + 1;
            }
            else if(arr[mid] > data ){
                h = mid - 1;
            }
            else{   
                    fi = mid;
                    h = mid - 1;
                }
                
            }
            if (fi != -1) {
                System.out.println("First Index: " + fi);
            } else {
                System.out.println("Element not found in the array.");
            }



        l = 0;
        h = n - 1;
        int li = -1; 
      
        while(l <= h){
            int mid = l + (h - l) / 2; 
            if(arr[mid] < data ){
                l = mid + 1;
            }
            else if(arr[mid] > data ){
                h = mid - 1;
            }
            else{   
                    li = mid;
                    l = mid + 1;
                }
                
            }
            if (li != -1) {
                System.out.println("Last Index: " + li);
            } else {
                System.out.println("Element not found in the array.");
            }
}
}


