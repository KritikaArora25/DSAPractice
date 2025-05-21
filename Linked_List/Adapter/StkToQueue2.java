package Linked_List.Adapter;
import java.util.*;

public class StkToQueue2 {
    public static class StkToQueAdapter{
        Stack<Integer> mainStk;
        Stack<Integer> helpStk;
        public StkToQueAdapter(){
            mainStk = new Stack<Integer>();
            helpStk = new Stack<Integer>();
        }

        public void add(int data){
            mainStk.push(data);
        }

        public int remove(){
            if(mainStk.size() == 0){
                System.out.println("Queue UnderFlow!");
                return -1;
            }else{
                while(mainStk.size() != 1){
                    helpStk.push(mainStk.pop());
                }
                int data = mainStk.pop();
                while(helpStk.size() > 0){
                    mainStk.push(helpStk.pop());
                }
                return data;
            }
        }

        public int top(){
            if(mainStk.size() == 0){
                System.out.println("Queue UnderFlow!");
                return -1;
            }else{
                while(mainStk.size() != 1){
                    helpStk.push(mainStk.pop());
                }
                int data = mainStk.pop();
                helpStk.push(data);
                while(helpStk.size() > 0){
                    mainStk.push(helpStk.pop());
                }
                return data;
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
