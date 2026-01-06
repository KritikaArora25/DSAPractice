package Linked_List.Adapter;

import java.util.LinkedList;

public class LlToStack {
    public static class Node{
        int data;
        Node next;
    }
    public static class LlToStackAdapter{
        LinkedList<Integer> list;
        Node tail;
        Node head;
        int size;

        public LlToStackAdapter(){
            list = new LinkedList<>();
        }

        int size(){
            return size;
        }
        void push(int val){
            Node  temp = new Node();
            temp.data = val;
            temp.next = head;
            head = temp;

            if(size() == 0){

                tail = head;

            }
    
            size++;

            
        }
        int pop(){
            if(size() == 0){
                System.out.println("Stack underflow!");
                return -1;
            }else if(size() == 1){
                int val = head.data;
                head = tail = null;
                size = 0;
                return val;
            }
            else{
                int val = head.data;
                head = head.next;
                size--;
                return val;
            }
        }

            int peek(){
                if(size() == 0){
                    System.out.println("Stack underflow!");
                    return -1;
                }else{
                    return head.data;
                }
            }

            void display(){
                Node temp = head;
                while(temp != null){
                    System.out.print(temp.data + " ");
                    temp = temp.next;
                }
                System.out.println();

            }
        }

        public static void main(String[] args){
            LlToStackAdapter st = new LlToStackAdapter();
            st.push(10);
            st.push(20);
            st.push(30);
            st.display();
            System.out.println(st.pop());
            st.display();

        

    }
}

    

