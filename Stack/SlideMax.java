import java.util.*;
public class SlideMax {
    public static void slideMax(int[] arr , int k) {

       Stack<Integer> st = new Stack<>();
       int[] nge = new int[arr.length];

       st.push(arr.length - 1);
       nge[ arr.length - 1 ] = arr.length;

       for(int i = arr.length - 2 ; i >= 0 ; i-- ){

        while(!st.isEmpty() && arr[i] >= arr[st.peek()]){
            st.pop();
        }

        if(st.isEmpty()){
            nge[i] = arr.length;
        }else{
            nge[i] = st.peek();
        }
        st.push(i);
       }

       int j = 0;
       for(int i = 0 ; i < arr.length - k ; i ++ ){
        if(j < i){
            j = i ; 
        }
        if(nge[j] < (i + k)){
            j = nge[j];
        }
        System.out.println( arr[j] );
       }
       
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of elements : ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter the elements : ");
        for(int i = 0 ; i < n ; i ++){
             arr[i] = sc.nextInt();
        }

    System.out.println("Enter the sliding window  ->");
    int k = sc.nextInt();

    slideMax(arr , k);

    sc.close();
    }
}

