import java.util.*;
public class ANDxorOR{
    public static int solution(int[] arr){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int maxF = Integer.MIN_VALUE;

        for(int num : arr){
            while( !st.isEmpty() && st.peek() > num ){
                int secondSmallest= st.pop();
                if(!st.isEmpty()){
                    int smallest = st.peek();
                    int f = (smallest & secondSmallest) + (smallest | secondSmallest) + (smallest ^ secondSmallest);
                    maxF = Math.max(f, maxF);
                }
            }
            st.push(num);
        }
        return maxF;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        

        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(solution(arr));

    }
}