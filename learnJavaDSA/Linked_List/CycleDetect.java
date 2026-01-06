package Linked_List;


public class CycleDetect{

    public static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;

        SinglyLinkedListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    
        public static int has_cycle(SinglyLinkedListNode head) {
            if (head == null) return 0; // No cycle in an empty list

            SinglyLinkedListNode slow = head;
            SinglyLinkedListNode fast = head;

            while (fast != null && fast.next != null) {
                slow = slow.next;         // Move slow pointer 1 step
                fast = fast.next.next;    // Move fast pointer 2 steps

                if (slow == fast) {
                    return 1; // Cycle detected
                }
            }

            return 0; // No cycle
        }

        // Test method (optional)
        public static void main(String[] args) {
            SinglyLinkedListNode head = new SinglyLinkedListNode(1);
            head.next = new SinglyLinkedListNode(2);
            head.next.next = new SinglyLinkedListNode(3);
            head.next.next.next = new SinglyLinkedListNode(4);

            // Creating a cycle (4 -> 2)
            head.next.next.next.next = head.next; 

            System.out.println(has_cycle(head)); // Output: 1 (cycle detected)
        }
    }

