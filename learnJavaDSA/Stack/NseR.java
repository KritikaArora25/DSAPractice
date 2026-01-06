import java.util.*;
public class NseR {
    public static void sol2( int[] arr ){
        Stack<Integer> st = new Stack<>();
        st.push(arr[0]);
        for(int i = 1 ; i < arr.length; i ++){
            if(arr[i] < st.peek()){
                while(!st.isEmpty() && arr[i] < st.peek()){
                    System.out.println(st.peek() +"  ->  "+arr[i]);
                    st.pop();
                }
                st.push(arr[i]);
            }else{
                st.push(arr[i]);
            }
        }while(!st.isEmpty()){
            System.out.println(st.peek() +"  ->  "+-1);
            st.pop();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the value of n : ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        for(int i = 0 ; i < arr.length ; i++ ){
            arr[i] = sc.nextInt();
        }
        // int[] results = solution(arr);
        // System.out.println(Arrays.toString(results));

        sol2(arr);

        sc.close();
    }
}

