import java.util.*;
public class NormalStk {
    public static class CustomStack{
        int[] data;
        int tos;
        public CustomStack(int cap){
            data = new int[cap];
            tos = -1;
        }
        int size(){
            return tos+1;
        }
        void display(int tos){
            for(int i = tos ; i >=0 ; i--){
                System.out.print(data[i] + " ");
            }
            System.out.println();
        }
        int pop(){
            if(tos == -1){ 
                System.out.println("Stack Underflow!");
                return -1;
            }else{
            return data[tos--];}
        }
        void push(int val){
            if(tos == data.length - 1){
                System.out.println("Stack Overflow!");
            }else{
            data[++tos] = val;
            }
        }
        int top(){
            if(tos == -1){
                System.out.println("Stack Underflow!");
                return -1;
            }else{
                return data[tos];
            }
        }
        }

    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the stack");
        int cap = sc.nextInt();
        int[] data = new int[cap];

        CustomStack stk = new CustomStack(cap);
        System.out.println("Enter the elements in the stack");
        for(int i = 0 ; i < cap ; i++){
            stk.push(sc.nextInt());
        }
        System.out.println("Stack elements:");
        stk.display(stk.tos);
        System.out.println("Top element of the stack: " + stk.top());
        System.out.println("Size of stack : "+stk.size());
        System.out.println("Poping an element from the stack ->"+stk.pop());
        System.out.println("Stack elements:");
        stk.display(stk.tos);
        System.out.println("Size of stack : "+stk.size());

    }

}
