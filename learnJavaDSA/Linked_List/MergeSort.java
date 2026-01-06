package Linked_List;

import java.util.LinkedList;

public class MergeSort {
    public static class Node{
        int data;
        Node next;
    }
    public static class MergeSortLL{
        Node head;
        Node tail;
        public MergeSortLL(){
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
        public static Node findMid(Node head){
            Node slow = head;
            Node fast = head;
            while(fast.next != null && fast.next.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;

        }
        
        public static Node mergeSort(Node head){
            if(head == null || head.next == null){
                return head;
            }

            Node mid = findMid(head);
            Node midNext = mid.next;
            mid.next = null;

            Node left = mergeSort(head);
            Node right = mergeSort(midNext);
            
            return merge(left, right);

        }
        public void printList(Node head){
            Node temp = head;
            while(temp != null){
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        MergeSortLL list = new MergeSortLL();
        list.add(2);
        list.add(8);
        list.add(1);
        list.add(7);
        list.add(4);
        list.add(6);
        list.add(5);
        list.add(3);
      
        System.out.println("Original Linked List: ");
        list.printList(list.head);

        list.head = list.mergeSort(list.head);

        System.out.println("Sorted Linked List: ");
        list.printList(list.head);


        

    }
    
}
