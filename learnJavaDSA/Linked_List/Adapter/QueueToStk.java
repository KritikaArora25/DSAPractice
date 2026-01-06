package Linked_List.Adapter;
import java.util.*;

public class QueueToStk {
    public static class QueueToStackAdapter {
        Queue<Integer> mainQ;
        Queue<Integer> helperQ;

        public QueueToStackAdapter(){
            mainQ = new ArrayDeque<>();
            helperQ = new ArrayDeque<>();
        }
        
       int size(){
        return mainQ.size();
       }

       int pop(){
        if(mainQ.isEmpty()){
            System.out.println("Stack UnderFlow...");
            return -1;
        }else{
            return mainQ.remove();
        }
       }

       int top(){
        if(mainQ.isEmpty()){
            System.out.println("Stack UnderFlow...");
            return -1;
        }else{
            return mainQ.peek();
        }
       }

       void push(int val){
        while(mainQ.size() > 0){
            helperQ.add(mainQ.remove());
        }
        mainQ.add(val);
        while(helperQ.size() > 0){
            mainQ.add(helperQ.remove());
        }
       }


    }
    public static void main(String[] args) {
        QueueToStackAdapter q = new QueueToStackAdapter();
        q.push(1);
        q.push(2);
        q.push(3);
        System.out.println("Top element is " + q.top());
        System.out.println("Popped element is " + q.pop());
        System.out.println("Popped element is " + q.pop());
        

    }
    
}
