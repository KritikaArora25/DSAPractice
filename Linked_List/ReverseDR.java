package Linked_List;

public class ReverseDR {
    public static class Node{
        int data;
        Node next;
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
            Node newNode = new Node();
            newNode.data = data;
            if(head == null){
                head = newNode;
                tail = newNode;
                }
                else{
                    tail.next = newNode;
                    tail = newNode;
                }
                size++;
        }
        public void reverseDRHelper(Node right , int floor){
            if(right == null){
                return;
            }

            reverseDRHelper(right.next , floor + 1);

            if(floor > size / 2 ){

                int temp ;
                temp = right.data;
                right.data = rleft.data;
                rleft.data = temp ;

                rleft = rleft.next;
                
            }


        }

        Node rleft;
        public void reverseDR(){
            rleft = head;
            reverseDRHelper(head , 0);
        }

        public void printlst(){
            Node temp = head ;
            while(temp != null){
                System.out.print(temp.data + " ");
                temp = temp.next ;
            }
        }
    }
   
    public static void main(String[] args) {

        LL ll = new LL();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);
        System.out.println("Linked list before reversal : ");
        ll.printlst();
        ll.reverseDR();
        System.out.println("Linked list after reversal : ");
        ll.printlst();




    }
    
}
