package BST;

import java.util.*;

public class Bst {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data , Node left , Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static Node construct(int[] arr , int lo , int hi){
        if(lo > hi){
            return null;
        }

        int mid = (lo + hi)/2;

        int data = arr[mid];
        Node lc = construct(arr, lo, mid - 1);
        Node rc = construct(arr, mid + 1, hi);

        Node node = new Node(data, lc, rc);
        return node;
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

    public static int sum(Node node){
        if(node == null){
            return 0;
        }
        int left = sum(node.left);
        int right = sum(node.right);
        

        return left + right + node.data;
    }

    public static int size(Node node){
        if(node == null){
            return 0;
        }
        int left = size(node.left);
        int right = size(node.right);

        return left + right + 1;
    }

    public static int max(Node node){
        if(node.right != null){
            return max(node.right);
        }else{
            return node.data;
        }
    }

    public static int min(Node node){
        if(node.left != null){
            return max(node.left);
        }else{
            return node.data;
        }
    }

    public static boolean find(Node node , int data){
        if(node == null){
            return false;
        }
        if(data > node.data){
            return find(node.right , data);
        }else if(data < node.data){
            return find(node.left , data);
        }else{
            return true;
        }
    }

    public static Node addNode(Node node , Node nodeAdd){
        if(node == null){
            return nodeAdd;
        }
        if(node.data > nodeAdd.data){
            node.left = addNode(node.left, nodeAdd);
        }else if(node.data < nodeAdd.data){
            node.right = addNode(node.right, nodeAdd);
        }else{
            //nothing to do
        }

        return node;
    }

    public static Node remNode(Node node, int data){

        if(node == null) return null;

        if(node.data > data){
           node.left = remNode(node.left , data);
        }else if(node.data < data){
            node.right = remNode(node.right, data);
        }else{
            if(node.left == null && node.right == null){
                return null;
            }
            else if(node.left != null && node.right == null){
                return node.left;
            }else if(node.left == null && node.right != null){
                return node.right;
            }else{
                int lmax = max(node.left);
                node.data = lmax;
                node.left = remNode(node, lmax);
                return node;
            }
        }
        return node;
    }

    static int sum = 0;
    public static void rwsl(Node node){
        if(node == null) return;

        rwsl(node.right);

        int od = node.data;
        node.data = sum;
        sum += od;

        rwsl(node.left);
    }

    public static int lca(Node node , int d1 , int d2){
        
        if(node.data > d1 && node.data > d2){
            return lca(node.left, d1, d2);
        }else if(node.data < d1 && node.data < d2){
            return lca(node.right, d1, d2);
        }else{
            return node.data;
        }
        
    }

    public static void pir(Node node , int d1 , int d2){

        if(node.data > d2){
            pir(node.left , d1 , d2);  //travel left
        }
        if (node.data >= d1 && node.data <= d2) {
        System.out.println(node.data);  // print if in range
        }
        if (node.data < d2) {
        pir(node.right, d1, d2);  // travel right
    }
}

    public static void travelAndChange(Node root , Node node , int target){
        travelAndChange(root, node.left, target);

        int comp = target - node.data;
        if(comp > node.data && find(root , comp)){
            System.out.println(node.data + " " + comp);
        }

        travelAndChange(root, node.right, target);
    }

    public static void inorder(Node node , ArrayList<Integer> list){

        inorder(node.left, list);
        list.add(node.data);
        inorder(node.right, list);

    }
    public static void travelAndChange2(Node node , int tar){
        ArrayList<Integer> list = new ArrayList<>();
        inorder(node, list);

        int i = 0;
        int j = list.size() - 1;

        while( i < j ){
            if(list.get(i) + list.get(j) == tar ){
                System.out.println(list.get(i) + " " + list.get(j));
                i++;
                j--;
            }else if(list.get(i) + list.get(j) < tar ){
                i++;
            }else if(list.get(i) + list.get(j) > tar){
                j--;
            }
        }
    }

    public static class ITPair{
        Node node;
        int state = 0;
        ITPair(Node node , int state){
            this.node = node;
            this.state = state;
        }
    }

    public static Node getNextFromInorder(Stack<ITPair> st){
        while(st.size() > 0){

            ITPair top = st.peek();

            if(top.state == 0){

                if(top.node.left != null){
                    st.push(new ITPair(top.node.left, 0));
                }
                top.state++;

            }else if(top.state == 1){

                if(top.node.right != null){
                    st.push(new ITPair(top.node.right, 0));
                }
                top.state++;
                
                return top.node;

            }else{
                st.pop();
            }
        }
        return null;
    }

    public static Node getNextFromReverseInorder(Stack<ITPair> st){
        while(st.size() > 0){

            ITPair top = st.peek();

            if(top.state == 0){

                if(top.node.right != null){
                    st.push(new ITPair(top.node.right, 0));
                }
                top.state++;

            }else if(top.state == 1){

                if(top.node.left != null){
                    st.push(new ITPair(top.node.left, 0));
                }
                top.state++;
                
                return top.node;

            }else{
                st.pop();
            }
        }
        return null;
    }

    public static void travelAndChange3(Node node , int tar){
        Stack<ITPair> ls = new Stack<>();
        Stack<ITPair> rs = new Stack<>();

        ls.push(new ITPair(node, 0));
        rs.push(new ITPair(node, 0));

        Node left = getNextFromInorder(ls);
        Node right = getNextFromReverseInorder(rs);

        while (left != null && right != null && left.data < right.data) {

            if(left.data + right.data < tar){
                left = getNextFromInorder(ls);
            }else if(left.data + right.data > tar){
                right = getNextFromReverseInorder(rs);
            }else{
                System.out.println(left.data + " " + right.data);
                left = getNextFromInorder(ls);
                right = getNextFromReverseInorder(rs);
            }
        }
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] arr = {12 , 25 , 37 , 50 , 62 , 75 , 87};
        Node root = construct(arr , 0 , arr.length - 1);
        display(root);

        System.out.println("Sum : "+sum(root));
        System.out.println("Size : "+size(root));

        System.out.println("Enter the node to be added : ");
        int data = sc.nextInt();
        Node newNode = new Node(data, null, null);
        addNode(root, newNode);

        sc.close();
    }
}
