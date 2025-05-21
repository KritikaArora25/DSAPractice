package Linked_List;

import java.util.*;
public class Rev_LinkedList {
    public static class Node {
        int data;
        Node next;
        public Node(int data){
            this.data = data;
        }
    }

    public static class LL{
        Node head;
        Node tail;
        int size; 
        public LL(){
            head = null;
            tail = null;
            size = 0;
        }
        public void add(int data){
            Node newNode = new Node(data);
            if(head == null){
                head = tail = newNode;
            }
            else{
                tail.next = newNode;
                tail = newNode;
            }
        }
        private Node getNodeAt(int idx){
            Node temp = head;
            for(int i = 0; i < idx; i++){
                temp = temp.next;
        }
        return temp;
    }
        public  void reverseDI(){
            int li = 0 ; 
            int ri = size - 1 ;
            while(li < ri){
                Node left = getNodeAt(li);
                Node right = getNodeAt(ri);

                int temp = left.data;
                left.data = right.data;
                right.data = temp;

                li++;
                ri--;
            }

        }
        public void display(){
            Node temp = head;
            while(temp != null){
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
        }
    }
    public static void main(String[] args){
        LL list = new LL();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        list.display();
    }
}
