package Linked_List;

public class Palindrome {
    public static class Node{
        String data;
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

        public void add(String data){
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
        public boolean isPalindrome(Node right){
            if(right == null){
                return true;
            }

            boolean res = isPalindrome(right.next);

            if(res == false){

                return false;

            }else if(!pleft.data.equals(right.data)){

                return false;

            }else{

                pleft = pleft.next;
                return true;
                
            }
            
            
                

        }

        Node pleft;
        public void reverseDR(){
            pleft = head;
            isPalindrome(head);


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
        ll.add("a");
        ll.add("b");
        ll.add("b");
        ll.add("a");
        // ll.add(5);
        System.out.println("Linked list before reversal : ");
        ll.printlst();
        ll.reverseDR();
        System.out.println("Linked list after reversal : ");
        ll.printlst();




    }
    
}

    

