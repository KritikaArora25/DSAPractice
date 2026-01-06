import java.util.*;
public class Findelement {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array");
        for(int i=0;i<n;i++){
        arr[i] = sc.nextInt();
    }
    System.out.println("Enter the element to be searched");
    int target = sc.nextInt();
    int flag = 0;
    for( int i = 0; i < arr.length; i++){
        if(arr[i] == target){
            System.out.println("Element found at index " + i);
            flag = 1;
            break;
    }

    }
    if(flag == 0){
    System.out.println("Element not found");
    }
    sc.close();
}

}
