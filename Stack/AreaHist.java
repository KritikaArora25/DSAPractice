import java.util.*;
public class AreaHist {
    public static void largestArea(int[] arr){
        int maxArea = 0;
        int[] rb = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(arr.length - 1);
        rb[arr.length - 1] = arr.length;
        for(int i = arr.length - 2; i >= 0; i--){
            while(!st.isEmpty() && arr[i] <= arr[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                rb[i] = arr.length;
            }else{
                rb[i] = st.peek();
            }
            st.push(i);
        }

        int[] lb = new int[arr.length];
        st = new Stack<>();

        st.push(arr.length - 1);
        lb[0] = -1;
        for(int i = 0; i < arr.length; i++){
            while(!st.isEmpty() && arr[i] <= arr[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                lb[i] = -1;
            }else{
                lb[i] = st.peek();
            }
            st.push(i);
        }

        maxArea = 0;
        for(int i = 0; i < arr.length; i++){
            int width = rb[i] - lb[i] - 1;
            int area = width * arr[i];
            maxArea = Math.max(maxArea, area);
        }
        System.out.println(maxArea);

    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array: ");
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        largestArea(arr);

        sc.close();
    }
}
