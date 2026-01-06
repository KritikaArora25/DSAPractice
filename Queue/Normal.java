package Queue;
import java.util.*;
public class Normal {
    public static class CustomQueue {
        int[] data;
        int front;
        int size;

        public CustomQueue(int cap){
            data = new int[cap];
            front = 0;
            size = 0;
        }
        int size(){
            return size;
        }
        void display(){
            for(int i = 0 ; i < size ; i++){
                int idx = ( front + i ) % data.length;
                System.out.println(data[idx]+" ");
            }
            System.out.println();

        }
        void add(int val){
            if( size == data.length){
                System.out.println("Queue overflow");
            }else{
                int rear = (front + size) % data.length;
                data[rear] = val;
                size++;
            }

        }
        int remove(){
            if(size == 0){
                System.out.println("Queue Underflow");
                return -1;
            }else{
                int val = data[front];
                front = (front + 1) % data.length;
                size--;
                return val;
            }

        }
        int peek(){
            if(size == 0){
                System.out.println("Queue Underflow");
                return -1;
            }else{
                return data[front];
            }
            
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        CustomQueue qu = new CustomQueue(n);


    }
    
}
