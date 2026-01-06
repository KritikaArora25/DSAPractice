package BinaryTrees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class BinTree {
    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data , Node left, Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    public static class Pair{
        Node node;
        int state;

        Pair(Node node , int state){
            this.node = node;
            this.state = state;
        }
    }

    public static void display(Node node){
        //base case
        if(node == null){
            return;
        }

        //root node printing
        String str = "";

        str += node.left == null?"." : node.left.data +"";
        str += "<-"+node.data+"->";
        str += node.right == null? "." :node.right.data + "";
        System.out.println(str);

        //recursion calls 
        display(node.left);
        display(node.right);

    }
    static int size = 0;
    public static int size(Node node){
        if(node == null){
            return 0;
        }
      
        int left = size(node.left);
        int right = size(node.right);

        return left + right + 1;
    }

    public static int sum(Node node){
        if(node == null){
            return 0;
        }
      
        int left = sum(node.left);
        int right = sum(node.right);

        return left + right + node.data;

    }
    public static int max(Node node){
        if(node == null){
            return Integer.MIN_VALUE;
        }
        int maxLeft = max(node.left);
        int maxRight = max(node.right);
        int max1 = Math.max(maxLeft , maxRight);
        int max = Math.max(max1 , node.data);

        return max;
    }
    public static int ht(Node node){
        if(node == null){
            return -1; // you have come 1 node forward , go back it is not req it is a null node wont add up the ht 
            //return 0 for nodes
        }
        int htLeft = ht(node.left);
        int htRgt = ht(node.right);

        int maxht = Math.max(htLeft , htRgt);
        
        return maxht + 1;
    }

    public static void traversal(Node node){
        if(node == null){
            return;
        }
        System.out.println("Preoder   : " + node.data);
        traversal(node.left);
        System.out.println("Inorder   : " + node.data);
        traversal(node.right);
        System.out.println("Postorder : "+ node.data);
    }

    public static void levelOrder(Node node){
        Queue<Node> q = new ArrayDeque<>();
        q.add(node);
        while(q.size()>0){
            int count = q.size();
            for(int i = 0 ; i < count ; i++){
                Node rem = q.remove();
                System.out.print(rem.data + " ");
                
                if(rem.left != null){
                    q.add(rem.left);
                }
                if(rem.right != null){
                    q.add(rem.right);
                }
        }
        System.out.println();
        }
    }

    public static void iterativePrePostInTraversal(Node node){
        String pre = "";
        String post = "";
        String in = "";

        Stack<Pair> st = new Stack<>();
        st.push(new Pair(node , 1));
        while(st.size() > 0){
            Pair top = st.peek();
            if(top.state == 1){
                pre += top.node.data + " ";
                top.state++;
                if(top.node.left != null){
                    st.add(new Pair(top.node.left , 1));
                }
            }
            else if(top.state == 2){
                in += top.node.data + " ";
                top.state++;
                if(top.node.right!= null){
                    st.add(new Pair(top.node.right , 1));
                }
            }
            else if(top.state == 3){
                post += top.node.data + " ";
                st.pop();
            }
        }
        System.out.println("Preorder : " + pre );
        System.out.println("Inorder : "+ in);
        System.out.println("Postorder : "+ post);
    }

    static ArrayList<Integer> path = new ArrayList<>();;
    public static boolean nodeToRootPath(Node node , int data){
        if(node == null){
            return false;
        }
        if(node.data == data){
            path.add(node.data);
            return true;
        }

        boolean findLftChild = nodeToRootPath(node.left, data);
        if(findLftChild){
            path.add(node.data);
            return true;
        }
        boolean findRgtChild = nodeToRootPath(node.right, data);
        if(findRgtChild){
            path.add(node.data);
            return true;
        }

       return false;
        
    }

    public static void printKLevelsDown(Node node , int k){
        if(node == null && k < 0){
            return;
        }
        if(k == 0){
            System.out.print(node.data + " ");
        }
        printKLevelsDown(node.left, k - 1 );
        printKLevelsDown(node.right, k - 1);
    }

    
    
    public static void main(String[] args)throws Exception{
        Integer[] arr = {50 , 25 , 12 , null , null , 37 , 30 , null , null , null , 75 , 62 , null , 70 , null , null , 87 , null , null};
        
        Node root = new Node(arr[0], null, null);
        Pair rootPair = new Pair(root, 1);

        Stack<Pair> st = new Stack<>();
        st.push(rootPair);

        int idx = 0;
        while(st.size() > 0){
            Pair top = st.peek();

            if(top.state == 1){
                idx++;

                if(arr[idx] != null){
                    top.node.left = new Node(arr[idx], null, null);
                    Pair lp = new Pair(top.node.left , 1);
                    st.push(lp);      
                }

                top.state++;
            }else if(top.state == 2){
                idx++;

                if(arr[idx] != null){
                    top.node.right = new Node(arr[idx], null, null);
                    Pair rp = new Pair(top.node.right , 1);
                    st.push(rp);      
                }
                
                top.state++;
            }else{
                st.pop();
            }
        }

        // display(root);
        // System.out.println(size(root));
        // System.out.println(sum(root));
        // System.out.println(max(root));
        // System.out.println(ht(root));
        // traversal(root);
        levelOrder(root);
        iterativePrePostInTraversal(root);
        if(nodeToRootPath(root, 70)){
            System.out.println(path);
        }
        printKLevelsDown(root, 2);



    }
}
