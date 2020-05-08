package asg2_2;

public class Stack {
    public class Node{
        int info;
        Node next;
        
        public Node(){
            info = 0;
            next = null;
        }
        
        public void setInfo(int i){
            info = i;
        }
        
        public void setNext(Node l){
            next = l;
        }
        
        public int getInfo(){
            return info;
        }
        
        public Node getNext(){
            return next;
        }
    }
    
    Node first;
    
    public Stack(){
        first = new Node();
    }
    
    public boolean isEmpty(){
        return first.getNext() == null;
    }
    
    public void push(int x){
        Node n = new Node();
        n.setInfo(x);
        n.setNext(first.getNext());
        first.setNext(n);
    }
    
    public void pop(){
        if(!isEmpty()){
            Node temp = first.getNext();        
            first.setNext(first.getNext().getNext());
            temp.setNext(null);
        }
        else{
            System.out.println("Error! List is empty!");
        }
    }
    
    public int peek(){
        if(!isEmpty())
            return first.getNext().getInfo();
        else
            return 0;
    }
}
