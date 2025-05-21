import java.util.*;
public class Stock {
    public static Stack stockSpan(int[] arr){
        Stack<Integer> st = new Stack<>();
        Stack<Integer> nge = new Stack<>();
        

        for(int i = 0 ; i < arr.length ; i++){
           
            if(st.isEmpty()){
                st.push(arr[i]);
                 nge.push(1);
                 
            }else{
                if(arr[i] >= st.peek()){
                    while(!st.isEmpty() && arr[i] > st.peek()){
                        st.pop();
                        
                    }
                    if(st.isEmpty() || st.peek() == arr[i]){
                         nge.push(i+1);
                        
                        
                    }else{
                        nge.push(i - st.peek());
                    }
                        st.push(arr[i]);
                    
                }else{
                    nge.push(1);
                    
                    st.push(arr[i]);
                }
            }
        }
        return nge;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(stockSpan(arr));
       

    }
}
