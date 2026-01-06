package Revision;

import java.util.Scanner;

public class Diff {
    public static void main(String[] args) {
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

        int[] diff = new int[n1>n2? n1:n2];

        int i = arr1.length - 1;
        int j = arr2.length - 1;
        int k = diff.length - 1;
        
        while( i >= 0){
            if(arr1[i] < arr2[j]){
                int m = 1;
                while(arr1[i - m] == 0){
                    m++;
                }
                arr1[i - m ] = arr1[i - m] - 1 ; 
                m = m - 1;

                while(m != 0){
                    arr1[i - m] = arr1[i - m] + 10 - 1;
                    m--;
                }

                arr1[i] +=10;
                diff[k] = arr1[i] - arr2[j];
                k--;
                i--;
                j--;
            }
        }
        for(int value : diff){
            System.out.print(value + " ");
        }

    }   
}
