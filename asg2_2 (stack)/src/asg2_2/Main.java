package asg2_2;

public class Main {

    public Main(){
        Stack stack = new Stack();
        stack.push(1);
        //stack.push(2);
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
    }
    
    public static void main(String[] args) {
        Main main = new Main();
    }
    
}
