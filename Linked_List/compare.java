package Linked_List;
import java.util.*;

public class compare {
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
            this.head = null;
            this.tail = null;
            this.size = 0;
        }
        public void add(int data){
            Node newNode = new Node(data);
            
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
        public int size(){
            return size;
        }
    }
    public static class Result{
       
        public int comparison(LL one , LL two){
            if(one.size() != two.size()){
                return 0;
            }else{
                Node temp1 = one.head;
                Node temp2 = two.head;
                while(temp1!= null && temp2!=null){
                    if(temp1.data != temp2.data){
                        return 0;
                    }else{
                        temp1 = temp1.next;
                        temp2 = temp2.next;
                    }
                }
                return 1;
            }
        }
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        LL one = new LL();
        System.out.println("Enter LL_1 size!");
        int size1 = sc.nextInt();
        System.out.println("Enter Elements!");
        for(int i = 0 ; i < size1 ; i++){
            int data = sc.nextInt();
            one.add(data);
            }
        LL two = new LL();
        System.out.println("Enter LL_2 size!");
        int size2 = sc.nextInt();
        System.out.println("Enter Elements!");
        for(int i = 0 ; i < size2 ; i++){
            int data = sc.nextInt();
            two.add(data);
            }
            Result res = new Result();
            System.out.println(res.comparison(one, two));
            
        
        
        sc.close();
    }
}
    

