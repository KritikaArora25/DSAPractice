package Linked_List;

public class OddEven {
    public static class Node{
        int data;
        Node next;
        public Node(int data){
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
        public void add(int data){
            Node newNode = new Node(data);
            
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
        public static Node oddEven(Node head){
            if(head == null || head.next == null) return head; //Edge case: empty list or single node
            Node oddHead = null , oddTail = null;
            Node evenHead = null , evenTail = null;
            Node temp = head;

            while(temp != null){
                if(temp.data % 2 == 0){
                    if(evenHead == null){
                        evenHead = evenTail = temp;
                    }else{
                        evenTail.next = temp;
                        evenTail = evenTail.next;
                    }
                }else{
                    if(oddHead == null){
                        oddHead = oddTail = temp;
                    }else{
                        oddTail.next = temp;
                        oddTail = oddTail.next;
                    }
                }
                temp = temp.next;
            }
            if (oddHead == null) return evenHead; // No odd numbers
            if (evenHead == null) return oddHead; // No even numbers

            // Combine odd and even lists
            oddTail.next = evenHead;
            evenTail.next = null; // Important to avoid cycle

            return oddHead;
    }
}
    public static void main(String[] args) {
        Link list = new Link();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(11);
        list.add(12);

        System.out.println("Original List:");
        list.printList(list.head);

        list.oddEven(list.head);

        System.out.println("List after removing duplicates:");
        list.printList(list.head);


    }
    
}
