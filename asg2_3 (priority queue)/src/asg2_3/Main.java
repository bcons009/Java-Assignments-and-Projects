package asg2_3;

public class Main {

    public Main(){
        PriorityQueue pq = new PriorityQueue();
        pq.add(10);
        pq.add(7);
        pq.add(5);
        System.out.println(pq.max());
        pq.removeMax();
        System.out.println(pq.max());
    }
    
    public static void main(String[] args) {
        Main main = new Main();        
    }    
}
