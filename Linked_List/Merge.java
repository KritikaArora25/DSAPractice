package Linked_List;

import java.util.LinkedList;

public class Merge {
    public static class Node{
        int data;
        Node next;
    }
    public static class LL{
        Node head;
        Node tail;
        public LL(){
            head = null;
            tail = null;
        }
        public void add(int data){
            Node newNode = new Node();
            newNode.data = data;
            if(head == null){
                head = tail = newNode;
            }else{
                tail.next = newNode;
                tail = newNode;

            }
        }
        public void printList(Node head){
            Node temp = head;
            while( temp != null ){
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }
    public static Node merge(Node head1 , Node head2){
        Node first = head1;
        Node second = head2;
        
        Node head = null;
        Node tail = null;

        while(first != null && second != null){
          
        
        if(first.data <= second.data ){
            if(head == null){
                head = first;
                tail = first;

            }else{
            tail.next = first;
            tail = first;
        }
        first = first.next;

        }else{
            if(head == null){
                head = second;
                tail = second;

            }else{
            tail.next = second;
            tail = second;
        }
        second = second.next;
        }
    }
    while(first != null){
        tail.next = first;
        tail = first;
        first = first.next;
    }
    while(second != null){
        tail.next = second;
        tail = second;
        second = second.next;
    }
    return head;



    }
    public static void main(String[] args){
        LL ll1 = new LL();
        ll1.add(1);
        ll1.add(3);
        ll1.add(5); 
        LL ll2 = new LL();
        ll2.add(2);
        ll2.add(4);
        ll2.add(6);
        System.out.println("Linked List 1: ");
        ll1.printList(ll1.head);
        System.out.println("Linked List 2: ");
        ll2.printList(ll2.head);
        System.out.println("Merged Linked List: ");
      
        ll1.printList(merge(ll1.head , ll2.head));
        

        
    }
}
