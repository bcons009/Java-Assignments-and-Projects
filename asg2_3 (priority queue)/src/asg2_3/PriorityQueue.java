package asg2_3;

public class PriorityQueue {
    public class Node{
        private int info;
        private Node next;
        private Node prev;
        
        public Node(){
            info = 0;
            next = null;
            prev = null;
        }
        
        public void setInfo(int i){
            info = i;
        }
        
        public void setNext(Node l){
            next = l;
        }
        
        public void setPrev(Node l){
            prev = l;
        }
        
        public int getInfo(){
            return info;
        }
        
        public Node getNext(){
            return next;
        }
        
        public Node getPrev(){
            return prev;
        }
    }
    
    private Node first;
    private Node last;
    
    public PriorityQueue(){
        first = new Node();
        last = new Node();
        first.setPrev(null);
        first.setNext(last);
        last.setPrev(first);
        last.setNext(null);
    }
    
    public boolean isEmpty(){
        return (first.getNext() == last) && (last.getPrev() == first);
    }
    
    public void add(int x){
        Node n = new Node();
        n.setInfo(x);
        n.setNext(first.getNext());
        first.getNext().setPrev(n);
        first.setNext(n);
        n.setPrev(first);
    }
    
    public int max(){
        int max = 0;
        Node current = first.getNext();
        while(current.getNext() != null){
            if(current == first.getNext()){
                max = current.getInfo();
            }
            else{
                if(max > current.getInfo()){
                    max = current.getInfo();
                }
            }
            current = current.getNext();
        }
        return max;
    }
    
    public void removeMax(){
        int max = max();
        Node current = first.getNext();
        while(current.getInfo() != max){
            current = current.getNext();
        }
        current.getNext().setPrev(current.getPrev());
        current.getPrev().setNext(current.getNext());
        current.setPrev(null);
        current.setNext(null);
    }
}
