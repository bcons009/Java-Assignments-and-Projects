/*
 * File: Test.java
 * Reads the provided input file for every car's license number and operation,
 * calling the appropriate methods depending on the car's operation. Afterwards,
 * an output file is created. This file mirrors the input file while also adding
 * status messages for each operation.
 */
package basheminparkinggarage;
import java.util.Scanner ;
import java.io.File ;
import java.io.IOException ;					
import java.io.PrintWriter ;

/**
 * Test class for the Garage class.
 * @author Bryan Consuegra
 */
public class Test {
    //Creates new Garage object and message string.
    private static Garage garage = new Garage() ;
    private static String message ;
    
    /**Main method for test class
     * @param args 
     * @throws java.io.IOException 
     */
    public static void main(String[] args) throws IOException{
        //Scanner initialized for "garage.txt" input file.
        Scanner fileScan = new Scanner(new File("garage.txt")) ;
        //PrintWriter initialized to create and write onto "output.txt" file.
        PrintWriter outfile = new PrintWriter("output.txt") ;
        //While there is unread data in the input file...
        while(fileScan.hasNext()){
            //Scanner reads both the license number and operation
            String licenseNum = fileScan.next() ;
            String operation = fileScan.next() ;
            //If the operation is "ARRIVE"...
            if(operation.equals("ARRIVE")){
                //Call Garage's arrive method, which returns a string.
                //Have that string equal to message string.
                message = garage.arrive(licenseNum) ;
            }
            //Else if the operation is "DEPART"...
            else if(operation.equals("DEPART")){
                //Call Garage's depart method, which returns a string.
                //Have that string equal to message string.
                message = garage.depart(licenseNum) ;
            }
            //Prints output to both console and output file. Output includes
            //the car's license number, operation, and status message.
            System.out.println(licenseNum + " " + operation + " " + message) ;
            outfile.println(licenseNum + " " + operation + " " + message) ;
        }
        //Closing PrintWriter object.
        outfile.close() ;
    }
    
}
