package Linked_List;

import java.util.*;
public class Add{
    public static class Node{
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

        public void addFirst(int val){
            Node newNode = new Node(val);
            if(head == null){
                head = tail = newNode;
            }
            else{
                newNode.next = head;
                head = newNode;
            }
            size++;
        }

        public static int addListHelper(Node one , int pv1 , Node two , int pv2 , LL res){

            if(one == null || two == null){
                return 0;
            }
            
            int data = 0;
            int oc = 0;

            if( pv1 > pv2 ){
                oc = addListHelper(one.next , pv1 - 1 , two, pv2, res);
                data = one.data + oc;
            }
            else if(pv1 < pv2){ 
                oc = addListHelper(one, pv1, two.next, pv2 - 1 , res);
                data = two.data + oc;
            }else{
               oc = addListHelper(one.next, pv1 - 1, two.next, pv2 - 1, res);
               data = one.data + two.data + oc;
            }

            int nd = data % 10;
            int nc = data / 10;

            res.addFirst(nd);

            return nc;
            }

            public static LL addTwoLists(LL one , LL two){
                LL res = new LL();

                int oc = addListHelper(one.head, one.size , two.head , two.size , res);
                if(oc > 0){
                    res.addFirst(oc);
                }

                return res;
            }

            public void display() {
                Node temp = head;
                while (temp != null) {
                    System.out.print(temp.data + " -> ");
                    temp = temp.next;
                }
                System.out.println("null");
            }

        
        }
    
    public static void main(String[] args) {
        LL list1 = new LL();
        list1.addLast(9);
        list1.addLast(7);
        list1.addLast(8);
        list1.addLast(5);

        LL list2 = new LL();
        list2.addLast(4);
        list2.addLast(6);

        LL result = LL.addTwoLists(list1, list2);

        // **Print the result properly**
        System.out.print("Sum: ");
        result.display();



    }
}