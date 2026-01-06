package Linked_List.DoublyLinkedList;

public class Doubly {
    public static class DoublyLinkedList{
        private class Node{
            int data = 0;
            Node next = null;
            Node prev = null;

            Node(int data){
                this.data = data;
            }
        }

        private Node head = null;
        private Node tail = null;
        private int size = 0;

        //BASIC Functions==================================
        public int size(){
            return this.size;
        }

        public boolean isEmpty(){
            return this.size == 0;
        }

        //ADD_FUNCTION=====================================
        private void addFirstNode(Node node){
            if(this.size == 0){
                this.head = this.tail = node;
            }else{
                node.next = this. head;
                node.prev = null;
                this.head.prev = node;
                this.head = node;
            }
            this.size++;
        }

        public void addFirst(int val){
            Node node = new Node(val);
            addFirstNode(node);
        }

        private void addLastNode(Node node){
            if(this.size == 0){
                this.head = this.tail = node;
            }
            else if(this.size == 1){
                this.tail.next = node;
                node.prev = this.tail;
                this.tail = node;
            }else{
                node.prev = this.tail;
                this.tail.next = node;
                this.tail = node;
            }
            this.size++;
        }

        public void addLast(int val){
            Node node = new Node(val);
            addLastNode(node);
        }

        private void addNodeAt(int index , Node node){
            if(index == 0){
                addFirstNode(node);
            }else if(index == size){
                addLastNode(node);
            }else{
                Node forw = getNodeAt(index);
                Node prev = forw.prev;

                prev.next = node;
                node.prev = prev;

                node.next = forw;
                forw.prev = node;

                this.size++;
            }
        }
        public void addAt(int index , int data){
            if(indexInvalidException(index, 0, this.size)){
                System.out.println("-1");
            }else{
                Node node = new Node(data);
                addNodeAt(index , node);                                                                                                                                            
                
            }
        }

        private void addBefore(Node refNode , Node node){
            Node prevNode = refNode.prev;
            if(prevNode == null){

                node.next = head;
                head.prev = node;

                this.head = node;

            }else{

                prevNode.next = node;
                node.prev = prevNode;

                refNode.prev = node;
                node.next = refNode;
            }

            this.size++;
        }
        public void addBefore(Node refNode ,int data){
            Node node = new Node(data);
            addBefore(refNode , node);
        }

        private void addAfter(Node refNode , Node node){
            Node nextNode = refNode.next;
            if(nextNode == null){

                refNode.next = node;
                node.prev = refNode;

                this.tail = node;

            }else{

                refNode.next = node;
                node.prev = refNode;

                node.next = nextNode;
                nextNode.prev = node;

            }

            this.size++;
        }
        public void addAfter(Node refNode , int data){
            Node node = new Node(data);
            addAfter(refNode , node);
        }
        //EXCEPTIONS========================================
        private boolean ListIsEmptyException(){
            if(this.size == 0){
                System.out.println("List is Empty!");
                return true;
            }else{
                return false;
            }
        }

        private boolean indexInvalidException(int index , int leftRange , int rightRange){
            if(index < leftRange || index > rightRange){
                System.out.print("indexInvalid: ");
                return true;
            }
            return false;
        }


        //REMOVE_FUNCTION======================================
        private Node removeFirstNode(){
            Node node = this.head;
            if(this.size == 1){
                this.head = this.tail = null; 
            }else{
                 Node forw = this.head.next;
                 forw.prev = null;
                 node.next = null;

                 this.head = forw;
            }
            this.size--;
            return node;
        }
        public int removeFirst(){
            if(ListIsEmptyException()){
                return -1;
            }

            return removeFirstNode().data;
        }

        private Node removeLastNode(){
            Node node = this.tail;
            if(this.size == 1) this.head = this.tail = null;
            else{
                Node prev = this.tail.prev;
                node.prev = null;
                prev.next = null;

                this.tail = prev;

            }

            this.size--;
            return node;
        }
        public int removeLast(){
            if(ListIsEmptyException()){
                return -1;
            }
            return removeLastNode().data;

        }

        private Node removeNodeAt(int index){
            if(index == 0){
                return removeFirstNode();
            }else if(index == this.size - 1){
                return removeLastNode();
            }else{
                Node node = getNodeAt(index);
                node.prev.next = node.next;
                node.next.prev = node.prev;

                node.next = null;
                node.prev = null;

                this.size--;

                return node;
            }
        }

        public int removeAt(int index){
            if(ListIsEmptyException() || indexInvalidException(index, 0, this.size - 1)){
                return -1;
            }
            return removeNodeAt(index).data;
            
        }

        private Node removeAfter(Node refNode){
            Node node = refNode.next;
            if(node.next == null){
                refNode.next = null;
                

                this.tail = refNode;
            }else{
                refNode.next = node.next;
                node.next.prev = refNode;
            }
            
            this.size--;
            return node;
        }

        public int removeAfter(int idx){
            Node refNode = getNodeAt(idx);
            if(refNode.next == null){
                System.out.println("LoctionIsInvalid : ");
                return -1;
            }
            return removeAfter(refNode).data;
        }


        private Node removeBefore(Node refNode){
            Node prevNode = refNode.prev;
            if(prevNode.prev == null){
                refNode.next = null;
                

                this.head = refNode;
            }else{
                refNode.prev = prevNode.prev;
                prevNode.prev.next = refNode;
            }
            
            this.size--;
            return prevNode;
        }

        public int removeBefore(int idx){
            Node refNode = getNodeAt(idx);
            if(refNode.next == null){
                System.out.println("LocationIsInvalid : ");
                return -1;
            }
            return removeBefore(refNode).data;
        }

        public Node removeNode(Node refNode){
            if(this.size == 1){
                this.head = null;
                this.tail = null;
            }else{
                if(refNode.prev == null){
                    this.head = refNode.next;
                    refNode.next.prev = null;
                    }
                else if(refNode.next == null){
                    this.tail = refNode.prev;
                    refNode.prev.next = null;
                }else{
                    refNode.prev.next = refNode.next;
                    refNode.next.prev = refNode.prev;
                    
                }
                }
                this.size--;
                return refNode;
            }
        



        //GET Functions=================================
        public int getFirst(){
            if(ListIsEmptyException()){
                return -1; 
            }

            return this.head.data;
        }

        public int getLast(){
            if(ListIsEmptyException()){
                return -1; 
            }

            return this.tail.data;
        }

        private Node getNodeAt(int index){
            Node curr = this.head;
            while(index-- > 0) curr = curr.next;

            return curr;
        }

        public int getAt(int index){
            if(ListIsEmptyException()) return -1;
            else if(indexInvalidException(index, 0, this.size - 1)) return -1;

            return getNodeAt(index).data;
        } 


        //DISPLAY============================================
        public void printlst(){
            Node temp = this.head;
            while(temp != null){
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }

        public void printForward(){
            Node curr = this.head;
            if(ListIsEmptyException()){
                System.out.println("-1");
            }else{
                System.out.print("[\t");
            while(curr != null){
                System.out.print(curr.data + "\t");
                if(curr.next != null){
                    System.out.print(",\t");
                }
                curr = curr.next;
            }
            System.out.println("]");
        }
        }


        public void printBackward(){
            Node curr = this.tail;
            if(ListIsEmptyException()){
                System.out.println("-1");
            }else{
                System.out.print("[\t");
            while(curr != null){
                System.out.print(curr.data + "\t");
                if(curr.prev != null){
                    System.out.print(",\t");
                }
                curr = curr.prev;
            }
            System.out.println("]");
        }
        }
        //=====================================================
    }

    public static void main(String[] args){
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.addFirst(10);
        dll.addFirst(20);
        dll.addFirst(30);

        dll.addLast(40);
        dll.addLast(50);

        dll.removeFirst();

        dll.printlst();
        dll.printForward();
        dll.printBackward();

    }
}
