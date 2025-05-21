package Linked_List;

public class RemDup {
    public static class Node{
        int data;
        Node next;
    }
    public static class Link{
        Node head;
        Node tail;
        public Link(){
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
    
        public static void removeDuplicates(Node head){
            if(head == null){
                return;
            }
            Node current = head;
            while(current != null && current.next != null){
                if(current.data == current.next.data){
                    current.next = current.next.next;
                }else{
                    current = current.next;
                }
            }
    }
}

public static void main(String[] args) {
    Link l = new Link();
    l.add(1);
    l.add(1);
    l.add(1);
    l.add(2);
    l.add(2);
    l.add(4);
    l.add(4);
    l.add(4);

    System.out.println("Original List:");
    l.printList(l.head);

    l.removeDuplicates(l.head);

    System.out.println("List after removing duplicates:");
    l.printList(l.head);
        
}
}

