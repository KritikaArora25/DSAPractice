import java.util.*;
public class MinStk {
    public static class MinStkk{
        Stack<Integer> allData ;
        Stack<Integer> minStk;
        public MinStkk(){
            allData = new Stack<>();
            minStk = new Stack<>();
        }
        int size(){
            return allData.size();
        }
        
        int pop(){
            if(size() == 0){
                System.out.println("Stack is empty");
                return -1 ;
            }else{
                int val = allData.pop();
                if(val == minStk.peek()){
                    minStk.pop();
                }
                return val ;
            }
        }
        void push(int val){
            allData.push(val);
            
            if(minStk.size() == 0 || val <= minStk.peek()){
                minStk.push(val);
            }
        }
        int min(){
            if(size() == 0){
                System.out.println("Stack Underflow");
                return -1;
            }else{
                return minStk.peek();
            }
        }
        
        }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the stack");
        int cap = sc.nextInt();
        
        MinStkk stk = new MinStkk();
        System.out.println("Enter the elements in the stack");
        for(int i = 0 ; i < cap ; i++){
            stk.push(sc.nextInt());
        }
        System.out.println("Minimum element in the stack is " + stk.min());
        sc.close();
    }
}
