package Queue;
import java.util.*;

public class Dynamic {
    public static class CustomQueue{
        int[] data;
        int size;
        int front;
        public CustomQueue(int cap){
            data = new int[cap];
            size = 0;
            front = 0;
        }
        void enqueue(int val){
            if(size == data.length) {
                
                int[] temp = new int[data.length*2];
                for(int i = 0 ; i < size ; i ++){
                    temp[i] = data[(front + i) % data.length];
                }
                data = temp;
                front = 0;
                
            }
                data[(front + size) % data.length] = val;
                size++;
            
        }

        int dequeue(){
            if(size == 0){
                System.out.println("Queue Underflow!");
                return -1;
            }else{
                int val = data[front];
                front = (front + 1) % data.length;
                size--;
                return val;
            }
        }

        void display(){
            for(int i = 0 ; i < size ; i ++){
                System.out.print(data[(front + i) % data.length] + " ");
            }
            System.out.println();
        }
        int size(){
            return size;
        }
        int peek(){
            if(size == 0){
                System.out.println("Queue Underflow!");
                return -1;
            }else{
                return data[front];
            }
        }

    }
    public static void main(String[] args ){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        CustomQueue que = new CustomQueue(n);
        que.enqueue(10);
        que.display();
        que.enqueue(20);
        que.display();
        que.enqueue(30);
        que.display();
        que.enqueue(40);
        que.display();
        que.enqueue(50);
        que.display();
        System.out.println("Dequeued item is " + que.dequeue());
        
        que.display();
        System.out.println("Dequeued item is " + que.dequeue());
        
        que.display();


        sc.close();
    }
    
}
