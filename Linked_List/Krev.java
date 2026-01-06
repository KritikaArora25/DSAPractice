package Linked_List;

public class Krev {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static class LinkedList {
        Node head;
        Node tail;
        int size;

        public LinkedList() {
            head = tail = null;
            size = 0;
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
            size++;
        }

        // Print the linked list
        public void printList() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }

        // Remove the first node and return its data
        public int removeFirst() {
            if (head == null) return -1;
            int val = head.data;
            head = head.next;
            size--;
            if (size == 0) tail = null;  // If list becomes empty, reset tail
            return val;
        }

        // Reverse k-group nodes in the linked list
        public void kReverse(int k) {
            if (k <= 1 || head == null) return;

            LinkedList prev = null;

            while (size > 0) {
                LinkedList curr = new LinkedList();

                // Reverse the first k elements if possible
                if (size >= k) {
                    for (int i = 0; i < k; i++) {
                        int val = removeFirst();
                        Node newNode = new Node(val);
                        newNode.next = curr.head; // Reverse by adding at the front
                        curr.head = newNode;
                        if (curr.tail == null) curr.tail = newNode; // Set tail initially
                        curr.size++;
                    }
                } 
                // Append remaining elements if they are less than k
                else {
                    int remainingSize = size;
                    for (int i = 0; i < remainingSize; i++) {
                        int val = removeFirst();
                        curr.add(val);
                    }
                }

                // Connect reversed segments
                if (prev == null) {
                    prev = curr;
                } else {
                    prev.tail.next = curr.head;
                    prev.tail = curr.tail;
                    prev.size += curr.size;
                }
            }

            // Update the original linked list
            head = prev.head;
            tail = prev.tail;
            size = prev.size;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
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
        
        System.out.println("Original List:");
        list.printList();

        int k = 3;
        list.kReverse(k);

        System.out.println("List after k-group reversal:");
        list.printList();
    }
}
