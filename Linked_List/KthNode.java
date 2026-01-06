package Linked_List;

import java.util.LinkedList;

public class KthNode {
    public static class Node{
        int data;
        Node next;
    }
    public static class LL{
        LinkedList<Integer> list;
        Node head;
        Node tail;

        public LL(){
            list = new LinkedList<>();
            head = null;
            tail = null;
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
        
        public void KthLast(int k){
            if (head == null || k < 0) {
                System.out.println("Invalid value of k or empty list!");
                return;
             
            }

            Node slow = head;
            Node fast = head;
            for(int i = 0; i <= k; i++){
                if (fast == null) { // If `k` is greater than the length of the list
                    System.out.println("K is larger than the linked list size!");
                    return;
                }
                fast = fast.next;
            }
            while(fast != null){
                slow = slow.next;
                fast = fast.next;
            }
            System.out.println(slow.data);
        }
    }
    public static void main(String[] args) {
        LL ll = new LL();
        ll.enqueue(1);
        ll.enqueue(2);
        ll.enqueue(3);
        ll.enqueue(4);
        ll.KthLast(0);
    }
    
}
