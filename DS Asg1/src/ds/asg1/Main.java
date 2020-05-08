/*
 * PID: 6040474
 */
package ds.asg1;
import java.util.Random;

public class Main {
    
    public Main(){}
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayBag bag = new ArrayBag();
        Random r = new Random();
        for(int i = 0; i < 10; i++){
            int lengthOfString = 1 + r.nextInt(19);
            StringBuilder str = new StringBuilder(lengthOfString);
            for(int j = 0; j < lengthOfString; j++){
                //Lines 25 and 26 taken from Professor Hernandez's 
                //Prog15_01.java file's lines 37 and 38.
                int x = 32 + (int) (Math.random() * 95);
                str.append((char) x);
            }
            bag.add(str.toString());
            bag.print();
            if(i > 8){
                System.out.println("Number of occurences of \"" + str.toString() 
                        + "\": " + bag.count(str.toString()));
                System.out.println("Removing all occurences of \"" + 
                        str.toString() + "\" in the bag...");
                bag.remove(str.toString());
                System.out.println("New number of occurences of \"" + 
                        str.toString() + "\": " + bag.count(str.toString()));
                System.out.println("Removing all occurences of \"" + 
                        str.toString() + "\" in the bag...");
                bag.remove(str.toString());
            }
        }        
    }    
}
