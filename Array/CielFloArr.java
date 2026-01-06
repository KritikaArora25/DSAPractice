import java.util.*;
public class CielFloArr {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array Size!");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter array elements in sorted order!");
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            }
        System.out.println("Enter data whose ceil and floor value is to be seached! ");
        int data = sc.nextInt();
        int l = 0 ;
        int h = n - 1;
        int ciel=0;
        int floor= 0;
        while(l <= h){
            int mid = (l + h) / 2;
            if(arr[mid] == data){
                ciel = arr[mid];
                floor = arr[mid];
                break;
            }
            else if(arr[mid] < data){
                l = mid + 1 ;
                ciel = arr[mid];
            }
            else if(arr[mid] > data){
                h = mid - 1 ;
                floor = arr[mid];
            }
        }
        System.out.println("Ceil of " + data + " is " + ciel);
        System.out.println("Floor of " + data + " is " + floor);

    }
    
}
