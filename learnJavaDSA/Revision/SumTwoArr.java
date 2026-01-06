package Revision;

import java.util.*;
public class SumTwoArr {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array sizes!");
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();

        //Input
        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];

        System.out.println("Array1 Elements?");
        for(int i = 0; i < n1; i++){
            arr1[i] = sc.nextInt();
        }

        System.out.println("Array2 Elements?");
        for(int i = 0; i < n2; i++){
            arr2[i] = sc.nextInt();
        }

        int[] sum = new int[n1>n2? n1:n2];

        int i = arr1.length - 1;
        int j = arr2.length - 1;
        int k = sum.length - 1;

        int carry = 0;

        while(k >= 0){
            int d = carry;

            if( i >= 0){
                d += arr1[i];
            }

            if( j >= 0){
                d += arr2[j];
            }

            carry = d / 10;
            d = d % 10;

            sum[k] = d;

            i--;
            j--;
            k--;

        }
        if(carry != 0){
            System.out.print(carry+" ");
        }
        //Output
        for(int value : sum){
            System.out.print(value + " ");
        }
        sc.close();
    }
}
