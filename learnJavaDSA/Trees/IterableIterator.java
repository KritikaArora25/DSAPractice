package Trees;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class IterableIterator {
    public static class GenericTree implements Iterable<Integer>{
        Node root;
        GenericTree(Node root){
            this.root = root;
        }

        public Iterator<Integer> iterator(){
            Iterator<Integer> obj = new GTPreorderItertor(root);
            return obj;
        }
    }

    public static class GTPreorderItertor implements Iterator<Integer>{
        Integer nval;
        Stack<Pair> st;

        public GTPreorderItertor(Node root){
            st = new Stack<>();
            st.push(new Pair(root,-1));
            next();
        }
        public boolean hasNext(){
            if(nval == null){
                return false;
            }else{
                return true;
            }

        }
        public Integer next(){
            Integer fr = nval;

            //moves nval forward, if not possible sets it to null
            nval = null;
            while(st.size() > 0){
                Pair top = st.peek();
                if(top.state == -1){
                    nval = top.node.data;
                    top.state++;
                    break;
                }else if( top.state >= 0 && top.state < top.node.children.size()){
                    Pair cp = new Pair(top.node.children.get(top.state), -1);
                    st.push(cp);
                    top.state++;
                }else{
                    st.pop();
                }
            }


            return fr;
        }
    }
    private static class Pair{
        Node node;
        int state;

        Pair(Node node , int state){
            this.node = node;
            this.state = state;
        }
    }
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
     public static void main(String[] args){
        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, -1, 40, -1, -1};
        Node root = construct(arr);
        GenericTree gt = new GenericTree(root);
        for(int val : gt){//Syntactical sugar dependent on iterable
            System.out.println(val);
        }

        Iterator<Integer> gti = gt.iterator();
        while(gti.hasNext() == true){
            System.out.println(gti.next());
        }
        display(root);
     }

    
}
