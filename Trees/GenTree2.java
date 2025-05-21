package Trees;

import java.util.ArrayList;
import java.util.Stack;

public class GenTree2 {
    private static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();

        Node(){

        }
        Node(int data){
            this.data = data;
        }
    }
    public static void display(Node node){
        String str = node.data + "->";
        for(Node child : node.children){
            str += child.data + ", ";
        }
        str += ".";
        System.out.println(str);

        for(Node child : node.children){
            display(child);
        }

    }

    public static Node construct(int[] arr){
        Stack<Node> st = new Stack<>();
        Node root = null;

        for(int val: arr){
            if(val == -1){
                st.pop();
            }else{
                Node node = new Node(val);

                if(!st.isEmpty()){
                    st.peek().children.add(node);
                }else{
                    root = node;
                }

                st.push(node);
            }
        }
        return root;
    }

    static int size;
    static int min;
    static int max;
    static int ht;

    public static void multisolver(Node node , int depth){
        size++;
        max = Math.max(max , node.data);
        min = Math.min(min , node.data);
        ht = Math.max(ht , depth);

        for(Node child : node.children){
            multisolver(child, depth + 1);
        }

    }

    static Node predecessor;
    static Node successor;
    static int state;
    public static void predecessorAndSuccessor(Node node , int data){
        if(state == 0){
            if(node.data == data){
                state = 1;
            }else{
                predecessor = node;
            }
        }else if(state == 1){
            successor = node;
            state = 2;
        }
        for(Node child : node.children){
            predecessorAndSuccessor(child, data);
        }

    }

    static int ceil;
    static int floor;

    public static void ceilAndFloor(Node node , int data){
        if(node.data > data){
            if(node.data < ceil){
                ceil = node.data;
            }
        }else if(node.data < data){
            if(node.data > floor ){
                floor = node.data;
            }
        }

        for(Node child : node.children){
            ceilAndFloor(child, data);
        }
    }

    public static int kthLargest(Node node, int k){
        floor = Integer.MIN_VALUE;
        int factor = Integer.MAX_VALUE;

        for(int i = 0 ; i < k ; i++){
            ceilAndFloor(node, factor);

            factor = floor;
            floor = Integer.MIN_VALUE;
            
        }
        return factor;
    }

    static int ms = Integer.MIN_VALUE; 
    static int msn = 0;
    public static int mxSumSubtree(Node node ){
        int sum = 0;

        for(Node child : node.children){
           int cm = mxSumSubtree(child);

           sum +=cm;
            
        }

        sum += node.data;

        if(sum > ms){
            ms = sum;
            msn = node.data;
        }

        return sum;
    }

     static int dia;
    public static int calculateDiaReturnHeight(Node node){

        //PRE ORDER : calculate height for each node 
        int dch = -1;
        int sdch = -1;
        
        for(Node child : node.children){
            int ch = calculateDiaReturnHeight(child);

            if(ch > dch){
                sdch = dch;
                dch = ch;
            }else if(ch > sdch){
                sdch = ch;
            }
        }

        //POST ORDER : calculate dia for each node
        int cand = dch + sdch + 2;
        if(cand > dia){
            dia = cand;
        }

        dch += 1;
        return dch;
    }

    static class Pair{
        Node node;
        int state;

        Pair(Node node , int state){
            this.node = node;
            this.state = state;
        }
    }

    public static void iterativePreoderPostOrder(Node node){
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(node, -1));

        String Pre = "";
        String Post = "";

        while(st.size() > 0){

        if(st.peek().state == -1){
            Pre = Pre + st.peek().node.data + " ";
            st.peek().state++;
        }else if(st.peek().state >= 0 && st.peek().state < st.peek().node.children.size()){
            Pair item = new Pair(node.children.get(st.peek().state), -1);
            st.push(item);  
            
            st.peek().state++;
        }else if(st.peek().state == st.peek().node.children.size()){
            Post = Post + st.peek().node.data + " ";
            st.pop();
        }
    }

    System.out.println(Pre);
    System.out.println(Post);
    }

    public static void main(String[] args){
        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, -1, 40, -1, -1};
        Node root = construct(arr);
        display(root);

        size = 0;
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        ht = 0;

        multisolver(root, 0);

        System.out.println("Maximum : "+ max);
        System.out.println("Minimum : "+ min);
        System.out.println("Size : "+ size);
        System.out.println("Height : "+ ht);


        predecessor = null;
        successor = null;
        state = 0;

        predecessorAndSuccessor(root, 60);

        System.out.println("Predecessor : "+predecessor.data);
        System.out.println("Successor : "+successor.data);

        ceil = Integer.MAX_VALUE;
        floor = Integer.MIN_VALUE;

        ceilAndFloor(root, 60);

        System.out.println("CEIL = " + (ceil == Integer.MAX_VALUE ? "No Ceil" : ceil));
        System.out.println("FLOOR = " + (floor == Integer.MIN_VALUE ? "No Floor" : floor));

        System.out.println("Kth largest element in tree is : "+kthLargest(root, 3));

        mxSumSubtree(root);
        System.out.println(msn +"@"+ms);

        System.out.println(calculateDiaReturnHeight(root));

    }

    
}
