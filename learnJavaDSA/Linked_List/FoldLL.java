package Linked_List;

import java.util.Stack;

public class FoldLL {
    public static class Node{
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
        }
    }
    public static class LL{
        Node head;
        Node tail;
        int size;

        public LL() {
            head = null;
            tail = null;
            size = 0;
        }

        public void addLast(int val){

            Node temp = new Node(val);
           
            temp.next = null;

            if(size == 0){
                head = tail = temp;
            }
            else{
                tail.next = temp;
                tail = temp;
        }
         size++;  
    }

        Node left;
        public void foldHelper(Node right , int floor){
            if(right == null){
                return;
            }

            foldHelper(right.next , floor + 1);

            if(floor > size / 2){
                Node temp = left.next;
                left.next = right;
                right.next = temp;
                left = right;
            }else if( floor == size /  2){
                tail = right;
                tail.next = null;
            }

            
            
           

        }

        public void fold(){

            left = head;

            foldHelper(head , 0); 
 

        }
        public void printlst(){
            Node temp = head ;
            while(temp != null){
                System.out.print(temp.data + " ");
                temp = temp.next ;
            }
        }
    }


    public static void main(String[] args){
        LL list = new LL();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.fold();
        list.printlst();


    }
    
}
