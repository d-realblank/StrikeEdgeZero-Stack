public class Stack {
//implementing a stack using a linked list
    //instance variables
    private Node top;
    private int size;
    //constructor
    public Stack(){
        top = null;
        size = 0;
    }
    //methods
    public void push(int item){
        Node newNode = new Node(item);
        newNode.setNext(top);
        top = newNode;
        size++;
    }
    public int pop(){
        if(!isEmpty()){
            int temp = top.getData();
            top = top.getNext();
            size--;
            return temp;
        }
        return -1;
    }
    public int peek(){
        if(!isEmpty()){
            return top.getData();
        }
        return -1;
    }
    public boolean isEmpty(){
        return top == null;
    }
    public int getSize(){
        return size;
    }
    public void printStack(){
        Node curr = top;
        while(curr != null){
            System.out.print(curr.getData() + " ");
            curr = curr.getNext();
        }
        System.out.println();
    }
    
    private class Node {
        //instance variables
        private int data;
        private Node next;
        //constructor
        public Node(int data){
            this.data = data;
            next = null;
        }
        //methods
        public int getData(){
            return data;
        }
        public Node getNext(){
            return next;
        }
        public void setData(int data){
            this.data = data;
        }
        public void setNext(Node next){
            this.next = next;
        }
    }
}
