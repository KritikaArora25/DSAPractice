package Linked_List.Adapter;
import java.util.*;
public class StkToQue {
    public static class StkToQueAdapter{
        Stack<Integer> mainStk;
        Stack<Integer> helpStk;
        public StkToQueAdapter(){
            mainStk = new Stack<>();
            helpStk = new Stack<>();
        }
        public void add(int data){
            while(mainStk.size() > 0){
                helpStk.push(mainStk.pop());
            }
            mainStk.push(data);
            while(helpStk.size() > 0){
                mainStk.push(helpStk.pop());
            }
        }

        public int remove(){
            if(mainStk.size() == 0){
                System.out.println("Stack is Empty!");
                return -1;
            }else{
                return mainStk.pop();
            }
        }

        public int top(){
            if(mainStk.size() == 0){
                System.out.println("Stack is Empty!");
                return -1;
            }else{
                return mainStk.peek();
            }
        }
        
    }
    public static void main(String[] args){
        StkToQueAdapter stkToQue = new StkToQueAdapter();
        stkToQue.add(1);
        stkToQue.add(2); 
        stkToQue.add(3);
        System.out.println("Top Element: "+stkToQue.top());
        System.out.println("Removed Element: "+stkToQue.remove());

    }
}
