import java.util.Stack;

public class MinStk2 {
    public static class MinStkk2{
       Stack<Integer> data;
       int min;

       public MinStkk2(){
        data = new Stack<>();
        min = Integer.MAX_VALUE;
       }
       int size(){
        return data.size();
       }
       void push(int val){
        if(size() == 0){
            data.push(val);
            min = val;
        }else if(val >= min){
            data.push(val);
        }else{
            data.push(val+(val-min));//detection, fake smaller value stored in stack
            min = val;//orignal value stored in min
        }
       }
       int pop(){
        if(size() == 0){
            System.out.println("Underflow");
            return -1;
        }
        else {
            if(data.peek() >= min){
                return data.pop();
            }else{
                int ov = min;
                min = 2 * min - data.pop();
                return ov;
            }
            
            }
        }
        int top(){
            if(size() == 0){
                System.out.println("Underflow");
                return -1;
            }else{
                if(data.peek() >= min){
                    return data.peek();
                }else{
                    return min;
                }
            }
        }
       
       int min(){
        return min;
       }

    }
    public static void main(String[] args){
        MinStkk2 minStk = new MinStkk2();
        minStk.push(5);
        minStk.push(10);
        minStk.push(15);
        System.out.println(minStk.top());
        minStk.pop();
        System.out.println(minStk.top());
        System.out.println(minStk.size());

    }
}
