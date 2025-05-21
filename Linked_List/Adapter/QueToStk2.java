package Linked_List.Adapter;
import java.util.*;

public class QueToStk2 {
    public static class QueueToStackAdapter{
        Queue<Integer> mainQ;
        Queue<Integer> helperQ;
        public QueueToStackAdapter(){
            mainQ = new ArrayDeque<>();
            helperQ = new ArrayDeque<>();
        }

        int size(){
            return mainQ.size();
        }

        void push(int val){
            mainQ.add(val);
        }

        int pop(){
            
            while(mainQ.size() != 1){    
                helperQ.add(mainQ.remove());
            }
            int val = mainQ.remove();
            
            while(helperQ.size() > 0){
                mainQ.add(helperQ.remove());
            }
            return val;    
        }

        int top(){
            while(mainQ.size() != 1){    
                helperQ.add(mainQ.remove());
            }
            int val = mainQ.remove();
            helperQ.add(val);
            
            while(helperQ.size() > 0){
                mainQ.add(helperQ.remove());
            }
            return val;  

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
