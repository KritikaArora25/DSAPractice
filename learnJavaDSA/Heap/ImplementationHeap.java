package Heap;

import java.util.ArrayList;

class ImplementationHeap {
    static class MaxHeap{

        ArrayList<Integer> heap;

        MaxHeap(){
            heap = new ArrayList<>();
        }

        void add(int val){
            heap.add(val); // add at last
            int i = heap.size() - 1;

            //heapify
            while(i > 0){
                int parent = (i - 1) / 2;

                if(heap.get(i) > heap.get(parent)){

                    //swap
                    int temp = heap.get(i);
                    heap.set(i , heap.get(parent));
                    heap.set(parent, temp);

                    i = parent;
                }else{
                    break;
                }
            }
        }

        int del(){
            if(heap.size() == 0) return -1;

            int max = heap.get(0);
            int last = heap.remove(heap.size() - 1);

            if(heap.size() == 0) return max;

            heap.set(0, last);

            int i = 0;
            //heapify
            while( i < heap.size()){
                int left = 2 * i + 1;
                int rgt = 2 * i + 2;

                int largest = i;

                if(left < heap.size() && heap.get(left) > heap.get(largest)){
                    largest = left;
                }
                if(rgt < heap.size() && heap.get(rgt) > heap.get(largest)){
                    largest = rgt;
                }
                if(largest != i){
                    //swap(largest, i)
                    int temp = heap.get(i);
                    heap.set(i, heap.get(largest));
                    heap.set(largest, temp);

                    i = largest;
                }else{
                    break;
                }
            }
            return max;
        }

        int peek(){
            if(heap.size() == 0) return -1;

            return heap.get(0);
        }

        public boolean isEmpty() {
            return heap.isEmpty();
        }

    }
    


    public static void main(String[] args) {
        MaxHeap h = new MaxHeap();

        h.add(10);
        h.add(30);
        h.add(20);
        h.add(5);

        while (!h.isEmpty()) {
            System.out.println(h.del());  // Output in descending: 30, 20, 10, 5
        }
    }
}

    
