package asg2_1;

public class Deque {
    
    private final int SIZE;
    private int[] list;
    int front, rear, count;
    
    public Deque(){
        SIZE = 10;
        
        front = 0;
        rear = SIZE - 1;
        count = 0;
        
        list = new int[SIZE];
    }
    
    public Deque(int s){
        SIZE = s;
        
        front = 0;
        rear = SIZE - 1;
        count = 0;
        
        list = new int[SIZE];
    }
    
    public boolean isEmpty(){
        return count == 0;
    }
    
    public void push(int x){
        if(count < SIZE){
            if(front == 0){
                front = SIZE - 1;
            }
            else{
                front = (front - 1) % SIZE;
            }            
            list[front] = x;
            count++;
        }
        else{
            System.out.println("Error: Queue is full!");
        }
    }
    
    public int pop(){
        int re = 0;
        if(!isEmpty()){
            re = list[front];
            front = (front + 1) % SIZE;
            --count;
        }
        else{
            System.out.println("Error: Queue is empty!");
        }
        return re;
    }
    
    public void inject(int x){
        if(count < SIZE){
            rear = (rear + 1) % SIZE;
            list[rear] = x;
            count++;
        }
        else{
            System.out.println("Error: Queue is full!");
        }
    }
    
    public int eject(){
        int re = 0;
        if(!isEmpty()){
            re = list[rear];
            if(rear == 0){
                rear = SIZE - 1;
            }
            else{
                rear = (rear - 1) % SIZE;
            }            
            --count;
        }
        else{
            System.out.println("Error: Queue is empty!");
        }
        return re;
    }
    
    public int getFront(){
        return list[front];
    }
    
    public int getRear(){
        return list[rear];
    }
}
