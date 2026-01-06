package Linked_List;

public class Middle {
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
        public void findMiddle(){
            Node slow = head;
            Node fast = head;
            
            while(fast.next  != null && fast.next.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }
            
            System.out.println(slow.data);

        }

    }
    public static void main(String[] args){
        LL list = new LL();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.findMiddle();
    }
}
