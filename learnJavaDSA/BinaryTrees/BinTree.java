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

    static ArrayList<Node> pathNodes = new ArrayList<>();;
    public static boolean nodeToRootPath2(Node node , int data){
        if(node == null){
            return false;
        }
        if(node.data == data){
            pathNodes.add(node);
            return true;
        }

        boolean findLftChild = nodeToRootPath2(node.left, data);
        if(findLftChild){
            pathNodes.add(node);
            return true;
        }
        boolean findRgtChild = nodeToRootPath2(node.right, data);
        if(findRgtChild){
            pathNodes.add(node);
            return true;
        }

       return false;
        
    }

    public static void printKLevelsDown(Node node , int k){
        if(node == null || k < 0){
            return;
        }
        if(k == 0){
            System.out.print(node.data + " ");
        }
        printKLevelsDown(node.left, k - 1 );
        printKLevelsDown(node.right, k - 1);
    }

    public static void printKLevelsDownWithBlocker(Node node , int k , Node blocker){
        if(node == null || k < 0 || node == blocker ){
            return;
        }
        if(k == 0){
            System.out.print(node.data + " ");
        }
        printKLevelsDownWithBlocker(node.left, k - 1 , blocker);
        printKLevelsDownWithBlocker(node.right, k - 1 , blocker);
    }

    public static void printKNodesFar(Node node, int data, int k){
        pathNodes = new ArrayList<>();
        nodeToRootPath2(node, data);
        for(int i = 0 ; i < pathNodes.size() ; i++){
            printKLevelsDownWithBlocker(pathNodes.get(i), k - i, i == 0 ? null : pathNodes.get(i-1));
        } 
    }

    public static void pathToLeafFromRoot(Node node , String path, int sum , int lo , int hi){
        if(node == null) return;

        if(node.left == null && node.right == null){
            sum += node.data;

            if(sum >= lo && sum <= hi){
                System.out.println(path + node.data);
            }
            return;
        }

        pathToLeafFromRoot(node.left, path + node.data + " ", sum + node.data, lo, hi);
        pathToLeafFromRoot(node.right, path + node.data + " ", sum + node.data, lo, hi);
    }

    public static Node createLeftCloneTree(Node node){
        if(node == null){
            return null;
        }

        Node lcr = createLeftCloneTree(node.left);
        Node rcr = createLeftCloneTree(node.right);

        Node nn = new Node(node.data, lcr, null);
        node.left = nn;
        node.right = rcr;

        return node;
    }

    public static Node transBackFromLeftClonedTree(Node node){
        if(node == null){
            return null;
        }

        Node lcr = transBackFromLeftClonedTree(node.left != null? node.left.left : null);
        Node rcr = transBackFromLeftClonedTree(node.right);

        
        node.left = lcr;
        node.right = rcr;

        return node;
    }


    public static void printSingleChildNode(Node node){

       if(node == null) return;

       if(node.left != null && node.right == null){
            System.out.println(node.left.data);
        }else if(node.left == null && node.right != null){
            System.out.println(node.right.data);
        }

        printSingleChildNode(node.left);
        printSingleChildNode(node.right);
    }

    public static Node removeLeaves(Node node){

        if(node == null){
            return null;
        }

        if(node.left == null && node.right == null){
            return null;
        }
        
        node.left = removeLeaves(node.left);
        node.right = removeLeaves(node.right);

        return node;
    }


    public static int diaBinTree(Node node){

        if(node == null){
            return 0;
        }

        int ld = diaBinTree(node.left);
        int rd = diaBinTree(node.right);
        int f = ht(node.left) + ht(node.right) + 2;

        int dia = Math.max(f , Math.max(ld,rd));
        return dia;

    }

    static class DiaPair{
        int ht;
        int dia;
    }

    public static DiaPair diameter2(Node node){
        if(node == null){
            DiaPair bp = new DiaPair();
            bp.ht = -1;
            bp.dia = 0;
            return bp;
        }
        DiaPair lp = diameter2(node.left);
        DiaPair rp = diameter2(node.right);

        DiaPair mp = new DiaPair();
        mp.ht = Math.max(lp.ht , rp.ht) + 1;

        int fes = lp.ht + rp.ht + 2;
        mp.dia = Math.max(fes , Math.max(lp.dia , rp.dia));

        return mp;

    }

    static int sum = 0 ;
    static int til = 0 ; 
    public static int tilt(Node node){
        if(node == null){
            return 0;
        }
        
        int sl = tilt(node.left);
        int sr = tilt(node.right);

        sum = sl + sr + node.data;
        til += Math.abs(sl - sr);

        return sum;
    }
    
    public static class BSTPair{
        boolean isBST;
        int min;
        int max;
    }

    public static BSTPair isBST(Node node){

        if (node == null) {

            BSTPair base = new BSTPair();

            base.isBST = true;
            base.min = Integer.MAX_VALUE;
            base.max = Integer.MIN_VALUE;

            return base;
        }
        
    
        BSTPair lp = isBST(node.left);
        BSTPair rp = isBST(node.right);

        BSTPair regular = new BSTPair();

        regular.isBST = lp.isBST && rp.isBST && node.data > lp.max && node.data < rp.min ; 
        regular.min = Math.min(node.data, Math.min(lp.min, rp.min));
        regular.max = Math.max(node.data, Math.max(lp.max, rp.max));

        

        return regular;
    }


    public static class BalPair{
        boolean isBal;
        int ht;
    }

    public static BalPair isBalanced(Node node){
        if(node == null){

            BalPair basePair = new BalPair();

            basePair.ht = 0;
            basePair.isBal = true;

            return basePair;
        }

        BalPair lftPair = new BalPair();
        lftPair = isBalanced(node.left);

        BalPair rgtPair = new BalPair();
        rgtPair = isBalanced(node.right);

        BalPair myPair = new BalPair();
        myPair.ht = Math.max( lftPair.ht ,  rgtPair.ht) + 1;
        myPair.isBal = lftPair.isBal && rgtPair.isBal && Math.abs(lftPair.ht - rgtPair.ht) <= 1 ;

        return myPair;
    }

    public static class BSTPair2{
        boolean isBST;
        int min;
        int max;
        Node root;
        int size;
    }
    public static BSTPair2 larBST(Node node){
        if (node == null) {

            BSTPair2 base = new BSTPair2();

            base.isBST = true;
            base.min = Integer.MAX_VALUE;
            base.max = Integer.MIN_VALUE;
            base.root = null;
            base.size = 0;

            return base;
        }
        
    
        BSTPair2 lp = larBST(node.left);
        BSTPair2 rp = larBST(node.right);

        BSTPair2 regular = new BSTPair2();

        regular.isBST = lp.isBST && rp.isBST && node.data > lp.max && node.data < rp.min ; 
        regular.min = Math.min(node.data, Math.min(lp.min, rp.min));
        regular.max = Math.max(node.data, Math.max(lp.max, rp.max));

        if(regular.isBST){
            regular.root = node;
            regular.size = lp.size + rp.size + 1;
        }else if(lp.size > rp.size){
            regular.root = lp.root;
            regular.size = lp.size;
        }else{
            regular.root = rp.root;
            regular.size = rp.size;
        }

        

        return regular;
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


        System.out.println("ORIGINAL TREE (level order):");
        levelOrder(root);
        System.out.println();

        /* ---------- 3. Transform to left‑cloned tree ---------- */
        createLeftCloneTree(root);
        System.out.println("LEFT‑CLONED TREE:");
        levelOrder(root);
        System.out.println();

        /* ---------- 4. Transform back to original ---------- */
        root = transBackFromLeftClonedTree(root);
        System.out.println("RESTORED ORIGINAL TREE:");
        levelOrder(root);
        System.out.println();

        removeLeaves(root);
        display(root);

        DiaPair p = diameter2(root);
        System.out.println(p.dia);



    }
}
