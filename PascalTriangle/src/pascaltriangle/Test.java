/*
 * File: Test.java
 * Asks the user to enter an integer, then uses that integer to generate 
 * and print a Pascal's Triangle with the number of rows determined by the
 * user-inputted integer.
 */
package pascaltriangle;
import java.util.Scanner;

/**
 * A test class for the PascalsTriangle Class.
 * @author Bryan Consuegra
 */
public class Test {

    //Declare integer rowNum and String rowStr, both used to hold values 
    //inputted by the user.
    private static int rowNum;
    private static String rowStr;
    //A Scanner s is used to read user input.
    private static Scanner s = new Scanner(System.in);
    //Booleans success and intris initialized as true. Both Booleans are used in
    //detecting whether user input is an integer.
    private static Boolean success = true;
    private static Boolean intr = true;
    
    /**
     * Main method for test class.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Ask the user for an integer
        System.out.println("Enter the number of rows you would like the Pascal"
                + "Triangle to have.");
        //Store the value as a String.
        rowStr = s.next();
        //Initialize a scanner to read String rowStr...
        Scanner s2 = new Scanner(rowStr);
        //And check if the user inputted an integer.
        if(s2.hasNextInt()){
            //If an integer was inputted, rowNum will equal the integer version 
            //of String rowStr.
            rowNum = Integer.parseInt(rowStr);
        }
        else{
            //If not, Booleans success and intr are set to false.
            success = false;
            intr = false;
        }
        //This loop checks if success if false (or if the inputted value was an
        //integer) and if the inputted integer is between 1 and 13.
        while(!success || rowNum > 13 || rowNum < 1){
            //If the user input was not an integer...
            if (!intr){
                //Print the followign error message.
                System.out.println("Error: Not an integer. Please enter"
                        + "an integer.");
            }
            //If the user input was an integer but >13 or <1...
            else if (intr && rowNum > 13 || rowNum < 1){
                //The following error message is printed.
                System.out.println("Error: Pascal Triangles generated by "
                        + "this program can only be between 1 and 13 rows."
                        + "\nEnter the number of rows you would like the "
                        + "Pascal Triangle to have.");
            }
            //User input is checked again.
            rowStr = s.next();
            //Another scanner is created to check the updated rowStr.
            Scanner s3 = new Scanner(rowStr);
            //If the new input is an integer...
            if(s3.hasNextInt()){
                //Integer rowNum is set to the integer version of String rowStr.
                rowNum = Integer.parseInt(rowStr);
                //Boolean intr is also set to true, indicating that the input
                //was an integer.
                intr = true;
            }
            //If not, intr remains false.
            else{
                intr = false;
            }
            //If the new input is an integer and is between 1 and 13...
            if (s3.hasNextInt() && rowNum <= 13 && rowNum >= 1){
                //Boolean success is set to true, exiting the loop.
                success = true;
            }
        }
        //A new PascalsTriangle object is created with rowNum rows.
        PascalsTriangle pT = new PascalsTriangle(rowNum);
        //The PascalsTriangle object is then printed.
        System.out.println(pT);
    }
    
}
