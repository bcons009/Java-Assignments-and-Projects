package asg2_1;

public class Main {

    public Main(){
        Deque deque = new Deque();
        deque.push(1);
        deque.push(2);
        deque.push(3);
        System.out.println(deque.pop());
        System.out.println(deque.pop());
        deque.inject(4);
        deque.inject(5);
        System.out.println(deque.eject());
    }
    
    public static void main(String[] args) {
        Main main = new Main();
    }
    
}
