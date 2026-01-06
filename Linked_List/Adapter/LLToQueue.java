package Linked_List.Adapter;
import java.util.*;

public class LLToQueue {
    public static class Node{
        int data;
        Node next;
    }
    public static class LLToQueueAdapter{
        LinkedList<Integer> list;
        Node head;
        Node tail;

        public LLToQueueAdapter(){
            list = new LinkedList<>();
            head = null;
            tail = null;
        }

        int size(){
            return list.size();
        }

        void enqueue(int val){
            Node newNode = new Node();
            newNode.data = val;
            newNode.next = null;
            if(head == null){
                head = tail = newNode;
            }else{
                tail.next = newNode;
                tail = newNode;
            }

        }
        int dequeue(){
            if(head == null){
                System.out.println("Queue UnderFlow!");
                return -1;
            }else{
                int data = head.data;
                head = head.next;
                return data;
            }
        }
        int peek(){
            if(head == null){
                System.out.println("Queue UnderFlow!");
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
        Scanner sc = new Scanner(System.in);
        LLToQueueAdapter Queue = new LLToQueueAdapter();
        Queue.enqueue(10);
        Queue.enqueue(20);
        Queue.enqueue(30);
        Queue.enqueue(40);
        Queue.display();
        System.out.println("Dequeued element is : "+Queue.dequeue());
        Queue.display();


        sc.close();
    }
    
}
