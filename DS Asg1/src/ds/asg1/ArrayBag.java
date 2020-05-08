/*
 * PID: 6040474
 */
package ds.asg1;

import java.util.Arrays;

public class ArrayBag {
    
    private static final int SIZE = 10;
    private String[] bag;
    private int length;
    
    public ArrayBag(){
        bag = new String[SIZE];
        length = 0;
    }
    
    public boolean isEmpty(){
        return length == 0;
    }
    
    public void print(){
        System.out.println("Contents of bag:\n");
        for(int i = 0; i < length; i++){
            System.out.println(bag[i]);
        }
        System.out.println();
    }
    
    public void add(String s){
        if(length < SIZE){
            bag[length] = s;
            length++;
        }
        else{
            System.out.println("Error: Bag is empty!");
        }        
    }
    
    public void remove(String s){
        if(isEmpty()){
            System.out.println("Error: Bag is empty!");
        }
        else{
            boolean found = false;
            int tempLength = length;
            for(int i = 0; i < tempLength; i++){
                if(bag[i].equals(s)){
                    bag[i] = null;
                    length--;
                    found = true;
                }
            }
            for(int i = 0; i < tempLength; i++){
                if(bag[i] == null && i < tempLength - 1){
                    bag[i] = bag[i + 1];
                    bag[i + 1] = null;
                }
            }
            if(!found){
                System.out.println("Error: String was not found in bag!");
            }
        }        
    }
    
    int count(String s){
        int counter = 0;
        for(int i = 0; i < length; i++){
            if(bag[i].equals(s)){
                counter++;
            }
        }
        return counter;
    }
}
