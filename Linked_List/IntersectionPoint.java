package Linked_List;
import java.util.*;

public class IntersectionPoint {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public static class LL {
        Node head;
        Node tail;
        int size;

        public LL() {
            head = null;
            tail = null;
            size = 0;
        }

        public void addLast(int val) {
            Node temp = new Node(val);
            temp.next = null;

            if (size == 0) {
                head = tail = temp;
            } else {
                tail.next = temp;
                tail = temp;
            }
            size++;
        }

        public static int findIntersectionPoint(LL one, LL two) {
            Node t1 = one.head;
            Node t2 = two.head;

            int delta = Math.abs(one.size - two.size);

            if (one.size > two.size) {
                for (int i = 1; i <= delta; i++)
                    t1 = t1.next;
            } else if (two.size > one.size) {
                for (int i = 1; i <= delta; i++)
                    t2 = t2.next;
            }

            while (t1 != null && t2 != null) {
                if (t1 == t2) return t1.data;
                t1 = t1.next;
                t2 = t2.next;
        }
        return -1;
    }
}

    public static void main(String[] args) {
        LL list1 = new LL();
        list1.addLast(0);
        list1.addLast(1);
        list1.addLast(2);
        list1.addLast(3);
        list1.addLast(4);
        list1.addLast(5);
        list1.addLast(6);
        

        LL list2 = new LL();
        list2.addLast(9);
        list2.addLast(8);
        

        // Creating an intersection
        list2.tail.next = list1.head.next.next.next.next; // list2's tail points to list1's third node

        list2.size += list1.size - 4;  // Adjust size of list2 since it shares part of list1

        int intersectionData = LL.findIntersectionPoint(list1, list2);
        if (intersectionData != -1) {
            System.out.println("Intersection Point: " + intersectionData);
        } else {
            System.out.println("No intersection found.");
        }
    }
}

