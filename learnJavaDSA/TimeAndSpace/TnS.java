package TimeAndSpace;

import java.util.Arrays;
import java.util.Scanner;

public class TnS {

    public static void swap(int[] arr , int i , int j){
        System.out.println("Swapping " + arr[i] + " and " + arr[j]);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static boolean isSmaller(int[] arr , int i , int j){
        System.out.println("Comparing " + arr[i] + " and " + arr[j]);
        if(arr[i] < arr[j]){
            return true;
        }else{
            return false;
        }
    }

    public static void bubbleSort(int[] arr){
        for(int i = 0 ; i < arr.length - 1 ; i++){
            for( int j = 0 ; j < arr.length - i - 1 ; j++){
                if( isSmaller(arr, j+1, j) ){
                    swap(arr, j+1, j);
                }
            }
        }
    }

    public static void selectionSort(int[] arr){
        for(int i = 0 ; i < arr.length - 1 ; i++){
            int min = i;
            for( int j = i + 1 ; j < arr.length ; j++){
                if(isSmaller(arr, j, min)){
                    min = j;
                }
            }
            swap(arr, i, min);
        }
    }

    public static void inserSort(int[] arr){
        for(int i = 1 ; i < arr.length ; i++){   //since 0th element already considered sorted
            for(int j = i - 1 ; j >= 0 ; j--){
                if(isSmaller(arr, j+1, j)){
                    swap(arr, j+1, j);
                }else{
                    break;
                }
            }
        }
    }

    public static int[] mergeTwoSortedArrays(int[] arr1 , int[] arr2){

        int[] arr = new int[arr1.length + arr2.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while( i < arr1.length && j < arr2.length){
            if(arr1[i] < arr2[j]){
                arr[k] = arr1[i];
                i++;
            }else{
                arr[k] = arr2[j];
                j++;
            }
            k++;
        }

        while(i != arr1.length){
            arr[k] = arr1[i];
            i++;
            k++;
        }

        while(j != arr2.length){
            arr[k] = arr2[j];
            j++;
            k++;
        }

        return arr;
    }

    public static int[] mergeSort(int[] arr , int lo , int hi){
        if (lo == hi) {

            int[] base = new int[1];
            base[0] = arr[lo];

            return base;
    }

        int mid = (lo + hi) / 2;

        return mergeTwoSortedArrays(mergeSort(arr, lo , mid) , mergeSort(arr, mid + 1 , hi));
    }

    public static int[] partition(int[] arr , int pivot){
        
        int j = 0;
        int i = 0;
        while(i < arr.length){
            if(arr[i] > pivot){
                i++;
            }else{
                swap(arr, i, j);
                i++;
                j++;
            }
        }
        return arr;
    }

    public static int partitionHelper(int[] arr , int lo , int hi , int pivot){
        
        int j = lo;
        int i = lo;
        while(i <= hi){
            if(arr[i] > pivot){
                i++;
            }else{
                swap(arr, i, j);
                i++;
                j++;
            }
        }

        System.out.println("pivot index  -> " +(j - 1));
        return (j-1);
    }

    public static void quickSort(int[] arr , int lo , int hi){

        if(lo >= hi){
            return;
        }

        int pivot = arr[hi];

        int pi = partitionHelper(arr, lo , hi ,pivot);

        quickSort(arr, lo, pi - 1);
        quickSort(arr, pi + 1, hi);

    }

    public static int quickSelect(int[] arr , int lo , int hi ,int k){
        int pivot = arr[hi];
        int pi = partitionHelper(arr, lo, hi, pivot);

        if(pi == k){
            return arr[pi];
        }else if(k < pi){
            return quickSelect(arr, lo, pi - 1, k);
        }else{
            return quickSelect(arr, pi + 1, hi, k);
        }
    }

    public static int[] countSort(int[] arr , int max , int min){

        int range = max - min + 1;
        int[] farr = new int[range];

        for(int i = 0 ; i < arr.length ; i++){
            int idx = arr[i] - min;
            farr[idx]++;
        }

        int[] ans = new int[arr.length];

        for(int i = arr.length - 1 ; i >= 0 ; i++){

            int val = arr[i];
            int pos = farr[val - min];

            int idx = pos - 1;
            ans[idx] = val; 

            farr[val - min] --;

        }

        for(int i = 0 ; i < ans.length ; i++){
            arr[i] = ans[i];
        }

        return arr;
    }

    public static void countSortHelper(int[] arr , int exp){
        int[] ans = new int[arr.length];

        int[] farr = new int[10];
        for(int i = 0; i < arr.length ; i++){
            farr[arr[i] / exp % 10]++;
        }

        for(int i = 0 ; i < arr.length ; i++){
            farr[i] = farr[i] + farr[i - 1];
        }

        for(int i = arr.length - 1 ; i >= 0 ; i++){
            int val = arr[i] / exp % 10;
            int pos = farr[val] - 1;
            ans[pos] = arr[i];
            farr[val]--;
        }

        for(int i = 0 ; i < ans.length ; i++){
            arr[i] = ans[i];
        }

    }

    public static int[] radixSort(int[] arr){

        int max = Integer.MIN_VALUE;
        for(int val: arr){
            if(val > max){
                max = val;
            }
        }

        int exp = 1;
        while(exp <= max){
            countSortHelper(arr, exp);
            exp *= 10;
        }

        return arr;
    }

    public static void countSortHelper2(int[] arr , int div , int mod , int range){
        int[] ans = new int[arr.length];

        int[] farr = new int[range];
        for(int i = 0; i < arr.length ; i++){
            farr[arr[i] / div % mod]++;
        }

        for(int i = 1 ; i < farr.length ; i++){
            farr[i] = farr[i] + farr[i - 1];
        }

        for(int i = arr.length - 1 ; i >= 0 ; i++){
            int val = arr[i] / div % mod;
            int pos = farr[val] - 1;
            ans[pos] = arr[i];
            farr[val]--;
        }

        for(int i = 0 ; i < ans.length ; i++){
            arr[i] = ans[i];
        }

    }

    public static void SortDates(int[] arr){
        // int[] day = countSortHelper(arr % 100, 0);

        countSortHelper2(arr, 1000000, 100 , 32);
        countSortHelper2(arr, 10000, 100 , 13);
        countSortHelper2(arr, 1, 10000 , 2501);
    }

    public static void sort01(int[] arr){
        for(int i = 0 , j = 0; i < arr.length ; i++){
           if(arr[i] == 0){
            swap(arr, i, j);
            j++;
           }
        }
    }

    public static void sort012(int[] arr){
        int i = 0 , j = 0 , k = arr.length - 1;
        while(i <= k){
           if(arr[i] == 0){
            swap(arr, i, j);
            i++;
            j++;
           }else if(arr[i] == 1){
            i++;
           }else{
            swap(arr, i, k);
            k--;
           }
        }
    }

    public static void targetSumPair(int[] arr , int target){

        Arrays.sort(arr);

        int left = 0;
        int right = arr.length - 1;
        while(left <= right){
            if(arr[left] + right > target){
                right--;
            }else if(left + right < target){
                left++;
            }else{
                System.out.println(arr[left] + ", " + arr[right]);
                left++;
                right--;
            }
        }

    }

    public static int pivotSearchRotatedArray(int[] arr){
        int lo = 0;
        int hi = arr.length;

        while(lo < hi){
            int mid = (lo + hi)/2;
            if(arr[mid] < arr[hi]){
                hi = mid;
            }else{
                lo = mid + 1;
            }
        }
        return arr[lo];
    }

    public static void display(int[] arr){
        for(int i = 0 ; i < arr.length ; i++){
            System.out.print(arr[i] + " ");
            
        }
        System.out.println();
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of elements you want to put in array : ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        for(int i = 0 ; i < n ; i++){
            System.out.print("Element "+i+" : ");
            arr[i] = sc.nextInt();
        }

        //bubble sort

        // System.out.println("Elements before sorting : ");
        // display(arr);

        // bubbleSort(arr);

        // System.out.println("Elements after sorting : ");
        // display(arr);

        //Selection Sort

        // System.out.println("Elements before sorting : ");
        // display(arr);

        // selectionSort(arr);

        // System.out.println("Elements after sorting : ");
        // display(arr);

        //insertion Sort

        // System.out.println("Elements before sorting : ");
        // display(arr);

        // inserSort(arr);

        // System.out.println("Elements after sorting : ");
        // display(arr);

        //partition

        // System.out.println("Elements before sorting : ");
        // display(arr);

        // System.out.println("Elements after sorting : ");
        // display(partition(arr , 5));

        quickSort(arr, 0, arr.length - 1);

        System.out.println("Elements after sorting : ");
        display(arr);

        sc.close();
    }
    
}
