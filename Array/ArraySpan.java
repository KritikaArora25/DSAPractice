import java.util.*;
public class ArraySpan {
    public static int span(int[] arr){
        int max = arr[0];
        int min = arr[0];
        for(int i = 0 ; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }if(arr[i] < min){
                min = arr[i];
            }

            }
            return max - min;
        }
    
    public static void main(String[] args)throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements of array : ");
        for(int i = 0 ; i < n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Span is : "+span(arr));
    }
}
