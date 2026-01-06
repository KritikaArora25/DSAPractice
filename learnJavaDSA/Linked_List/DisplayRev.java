package Linked_List;

public class DisplayRev {
    public static class Node{
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static class Link{
        Node head;
        Node tail;
        
        public Link(){
            head = null;
            tail = null;
            
        }
        // Add a node at the end of the list
        public void add(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
            
        }
         
    
    public static void displayRev1(Node head){
        if( head == null ){
            return;
        }
        displayRev1(head.next);
        System.out.print(head.data + " ");
    }

    private static Node displayRev2Helper(Node node){
        if(node == null || node.next == null){
            return node;
        }
        Node newHead = displayRev2Helper(node.next);
        
        node.next.next = node;
        node.next = null;

        return newHead;

    }

    
    public void displayRev2(){
        head = displayRev2Helper(head);
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
    public static void main(String[] args) {
        Link list = new Link();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        System.out.println("Reverse Order: ");
        list.displayRev2(); // Pass the head of the list
        list.printList(list.head);

    }
    
}
