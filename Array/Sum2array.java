import java.util.*;
public class Sum2array {
    public static void main(String[] args)throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array 1");
        int n1 = sc.nextInt();
        int[] arr1 = new int[n1];
        System.out.println("Enter the elements of array");
        for(int i=0;i<n1;i++)
        {
            arr1[i] = sc.nextInt();
        }
        System.out.println("Enter the size of array 2");
        int n2 = sc.nextInt();
        int[] arr2 = new int[n2];
        System.out.println("Enter the elements of array");
        for(int i=0;i<n2;i++)
        {
            arr2[i] = sc.nextInt();
        }
        int[] sum;
        sum = new int[n1>n2?n1:n2];
        int i = arr1.length - 1;
        int j = arr2.length - 1;
        int k = sum.length - 1;
        int carry = 0;
        while(k>=0){
            int d = carry;
            if(i>=0)
            {
                d += arr1[i];
            }
            if(j>=0){
                d += arr2[j];
            }
            carry = d / 10;
            d = d % 10;
            sum[k] = d;
            i--;
            k--;
            j--;
        }
        if(carry!=0){
            System.out.println(carry);
        }
        for(int val: sum){
            System.out.print(val+" ");
        }
}}
