package Trees;

import java.util.*;
public class GenTree {
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

   
    public static int size(Node node){
        int count = 1;
        for(Node child : node.children){
           count += size(child);
        }
        
        return count;

    }

    public static int max(Node node){
        int max = Integer.MIN_VALUE;
        for(Node child : node.children){
            int cm = max(child);
            max = Math.max( cm , max ); // comparing max generted my LHS and RHS
        }
        max = Math.max(node.data , max); // comparing with itself
        return max;
    }

    public static int height(Node node){
        int h = -1;
        for(Node child : node.children){
            int ch = height(child);
            h = Math.max(h , ch);  // comparing ht generted my LHS and RHS
        }
        h = h + 1; // adding its own edge
        return h;

    }

    public static void traversal(Node node){
        System.out.println("Node Pre "+node.data + " ");
        for(Node child : node.children){
            System.out.println("Edge Pre "+node.data+" - "+child.data+" ");
            traversal(child);
            System.out.println("Node Post "+child.data+" ");
            System.out.println("Edge Post "+node.data+" - "+child.data+" ");      
            
          }  
    }

    public static void levelOrder(Node node){
        Queue<Node> q = new ArrayDeque<>();
        q.add(node);
        while(q.size() > 0){
            node = q.remove();
            System.out.print(node.data+" ");

            for(Node child : node.children){
                q.add(child);
            }
        }
        System.out.println(".");
    }

    public static void levelOrderLineWise(Node node){
        Queue<Node> q = new ArrayDeque<>();
        Queue<Node> cq = new ArrayDeque<>();

        q.add(node);

        while(q.size() > 0){
            node = q.remove();
            System.out.print(node.data+" ");

            for(Node child : node.children){
                cq.add(child);
            }
            if(q.size() == 0){
                q = cq;
                cq = new ArrayDeque<>();
                System.out.println();
            }
        }
        
    }

    public static void levelOrderLineWise2(Node node){
        Queue<Node> q = new ArrayDeque<>();

        q.add(node);
        q.add(new Node(-1));

        while(q.size() > 0){
            node = q.remove();
            if(node.data!= -1){
                System.out.print(node.data+" ");

                for(Node child : node.children){
                    q.add(child);
                }
            }else{
                if(q.size() > 0){
                    q.add(new Node(-1));
                    System.out.println();
                }
            }
        }
    }

        public static void levelOrderLineWise3(Node node){
            Queue<Node> mq = new ArrayDeque<>();
            mq.add(node);

            while(mq.size() > 0){
                int cicl = mq.size();

                for(int i = 0 ; i < cicl ; i++){
                    node = mq.remove();
                    System.out.print(node.data+" ");

                    for(Node child : node.children){
                        mq.add(child);
                    }
                }
                System.out.println();
            }
                
            
        }

        private static class Pair{
            Node node; 
            int level;

            Pair(Node node , int level){
                this.node = node;
                this. level = level;
            }
        }
    
        public static void levelOrderLineWise4(Node node){
            Queue<Pair> mq = new ArrayDeque<>();
            mq.add(new Pair(node , 1));

            int level = 1;
            while(mq.size() > 0){
                Pair p = mq.remove();
                if(p.level > level){
                    level = p.level;
                    System.out.println();
                }

                System.out.println(p.node.data +" ");
                for(Node child : p.node.children) {
                    mq.add(new Pair(child, p.level + 1));
                }
            }
        }
    

    
    
    public static void levelOrderZigZag(Node node){
        Stack<Node> ms = new Stack<>();
        ms.push(node);

        Stack<Node> cs = new Stack<>();
        
        int level = 1;
        
        while(ms.size() > 0){
            node = ms.pop();
            System.out.print(node.data+" ");

            if(level % 2 == 0){
                for(int i = 0 ; i < node.children.size() ; i++){
                    Node child = node.children.get(i);
                    cs.push(child);
                }
            }else{
                for(int i = node.children.size() - 1 ; i >= 0 ; i--){
                    Node child = node.children.get(i);
                    cs.push(child);
                }
            }
            if(ms.size() == 0){
                ms = cs;
                cs = new Stack<>();
                level++;
                System.out.println();
            }
        }
    }

    public static void mirrorImgPrint(Node node){
        if (node == null) {
            return;
        }

        Queue<Node> mq = new ArrayDeque<>();
        mq.add(node);
        mq.add(new Node(-1));

        while(mq.size() > 0){
            
            node = mq.remove();
            if(node.data != -1){
                System.out.print(node.data +" ");

                for( int i = node.children.size() - 1 ; i >= 0 ; i --){
                    mq.add(node.children.get(i));
                }
            }else{
                System.out.println();
                if(mq.size() > 0){
                    mq.add(node);
                }
            }
            
    }
}

public static void mirrorImg2(Node node){
    for(Node child: node.children){
        mirrorImg2(child);
    }

    Collections.reverse(node.children);
}

public static void remLeavesPrint(Node node){
    Queue<Node> mq = new ArrayDeque<>();
    mq.add(node);

    while(mq.size() > 0){
        node = mq.remove();

        if(node.children.size() != 0){
            System.out.print(node.data + " ");

            for(Node child: node.children) {
                mq.add(child);
        }
    }
        }
    }

    public static void remLeaves(Node node) {
        for( int i = node.children.size() - 1; i >= 0; i--){
            Node child = node.children.get(i);
            if (child.children.size() == 0) {
                node.children.remove(i);
            }
        }

        for(Node child : node.children){
            remLeaves(child);
        }
    }

    public static void linearize(Node node){
        for(Node child : node.children){
            linearize(child);
        }

        while(node.children.size() > 1){
            Node lastChild = node.children.remove(node.children.size() - 1);
            Node secLstChild = node.children.remove(node.children.size() - 1);
            Node secTail = getTail(secLstChild);
            secTail.children.add(lastChild);

        }
    }

    private static Node getTail(Node node) {
        while(node.children.size() == 1){
            node = node.children.get(0);
        }
        return node;
    }

    public static Node linearize2(Node node){
       if(node.children.size() == 0){
        return node;
       }
       Node lkt = linearize2(node.children.get(node.children.size() - 1));

       while(node.children.size() > 1){
         Node lc = node.children.remove(node.children.size() - 1 );
         Node sl = node.children.get(node.children.size() - 1);
         Node slkt = linearize2(sl);
         slkt.children.add(lc);
       }

       return lkt;
    }

    public static boolean findElement(Node node , int data){
        if(node.data == data){
            System.out.println("Found: " + node.data);
            return true;
        }

        for(Node child : node.children){
            if(findElement(child, data)){
                return true;
            }
        }

        return false;
    }

    public static ArrayList<Integer> nodeToRootPath(Node node , int data){
        if(node.data == data){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(node.data);
            return list;
        }

        for(Node child : node.children){
            ArrayList<Integer> ptc = nodeToRootPath(child, data);
            if(ptc.size() > 0){
                ptc.add(node.data);
                return ptc;
            }
            
        }

        return new ArrayList<>();
    }

    public static int lowCommAncestor(Node node, int data1 , int data2){

        ArrayList<Integer> path1 = nodeToRootPath(node, data1);
        ArrayList<Integer> path2 = nodeToRootPath(node, data2);

        int i = path1.size() - 1;
        int j = path2.size() - 1;

        while( i >= 0 && j >= 0){
            int item1 = path1.get(i);
            int item2 = path2.get(j);

            if(item1 == item2){
                i--;
                j--;
            }else{
                if(i <= path1.size() - 2){
                    int commItem = path1.get(i + 1);
                    return commItem;
                }

            }

        }
        System.out.println("No Common item found!");
        return -1;
    }

    public static int distanceBetweenNodes(Node node , int d1 , int d2){
        ArrayList<Integer> path1 = nodeToRootPath(node, d1);
        ArrayList<Integer> path2 = nodeToRootPath(node, d2);

        int i = path1.size() - 1;
        int j = path2.size() - 1;

        while( i >= 0 && j >= 0){
            int item1 = path1.get(i);
            int item2 = path2.get(j);

            if(item1 == item2){
                i--;
                j--;
            }else{
                if(i <= path1.size() - 2){
                   int dist = (i + 1) + (j + 1);
                   return dist;
                }

            }
           
        }
        System.out.println("No item found!");
        return -1;

    }

    public static boolean areSimilar(Node node1 , Node node2 ){

        if(node1.children.size() != node2.children.size()){
            return false;
        }
        for(int i = 0 ; i < node1.children.size() ; i++ ){
            Node c1 = node1.children.get(i);
            Node c2 = node2.children.get(i);

            if( areSimilar(c1, c2) == false){
                return false;
            }
    }
    return true;
    }
    public static boolean AreMirror(Node n1 , Node n2){
        if(n1.children.size() != n2.children.size()){
            return false;
        }

        for(int i = 0 ; i < n1.children.size() ; i++){
            int j = n2.children.size() - 1 - i;

            Node c1 = n1.children.get(i);
            Node c2 = n2.children.get(j);

            if(areSimilar(c1, c2) == false){
                return false;
            }
        }
        return true;
    }

    public static boolean isSymmetric(Node node){
        return AreMirror(node, node);
    } 



    public static void main(String[] args){
       int[] arr = {10 , 20 , 50 , -1 , 60 , -1 ,-1 , 30 , 70 , -1 , 80 , 110 , -1 , 120 , -1 , -1 , 90 , -1 , -1 , 40 , 100 , -1 , -1 , -1};

       Node root = null;
       Stack<Node> st = new Stack<>();

       for(int i = 0 ; i < arr.length ; i++){
        if(arr[i] == -1){
            st.pop();
        }else{
            Node t = new Node();
            t.data = arr[i];

            if(st.size() > 0){
                st.peek().children.add(t);
            }else{
                root = t;
            }
            st.push(t);
        }
       }
    //    display(root);
       
    //    System.out.print("Size of the tree is : ");
    //    System.out.println(size(root));

    //    System.out.print("Max of the tree is : ");
    //    System.out.println(max(root));

    //    System.out.print("Height of the tree is : ");
    //    System.out.println(height(root));


    //    traversal(root);

    //    levelOrder(root);

    //    levelOrderLineWise(root);

    //    levelOrderZigZag(root);

    //    levelOrderLineWise2(root);

    //    levelOrderLineWise3(root);

    //    mirrorImgPrint(root);

    //    mirrorImg2(root);
       
    //    display(root);

    //    remLeavesPrint(root);

    //    remLeaves(root);

    //    display(root);

    //    System.out.print("Linearized tree: ");
    //    linearize(root);
    //    display(root);

    //    if (!findElement(root, 50)) {
    //     System.out.println("Not Found!");
    // }

    //System.out.println("Lowest Common Ancestor is : "+lowCommAncestor(root, 70, 110));

    //System.out.println("Distance between Nodes is : "+distanceBetweenNodes(root, 70, 1000));
    int[] arr2 = {10 , 20 , 50 , -1 , 60 , -1 ,-1 , 30 , 70 , -1 , 80 , 110 , -1 , 120 , -1 , -1 , 90 , -1 , -1 , 40 , 100 , -1 , -1 , -1};

       Node root2 = null;
       Stack<Node> st2 = new Stack<>();

       for(int i = 0 ; i < arr2.length ; i++){
        if(arr2[i] == -1){
            st2.pop();
        }else{
            Node t = new Node();
            t.data = arr2[i];

            if(st2.size() > 0){
                st2.peek().children.add(t);
            }else{
                root2 = t;
            }
            st2.push(t);
        }
       }

    System.out.println("Are Trees Mirror? "+AreMirror(root, root2));


    }
}
