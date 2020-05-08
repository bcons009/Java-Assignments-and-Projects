/*
 * File: Tester.java
 * Tester class for OrderedList.java, using input values read from a text 
 * document.
 */
package linkedlist;
import java.util.Scanner ;
import java.io.File ;
import java.io.FileNotFoundException;
import java.io.IOException ;					
import java.io.PrintWriter ;

/**
 * Test class for OrderedList class.
 * @author Bryan Consuegra
 */
public class Tester<E> { 
    
    //Create new static object of OrderedList oList.
    private static OrderedList oList = new OrderedList();
    
    /**
     * Main method for the Tester class.
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        //Initialize new Scanner to check a new File by the name "ordlist.txt"
        Scanner fileScan = new Scanner(new File("ordlist.txt"));
        //While there is still unchecked data in the file...
        while(fileScan.hasNext()){
            //Initialize String operation to the next token in the input file.
            String operation = fileScan.next();
            //Declare int infoInt and String info.
            int infoInt;
            String info;
            //If String operation is equal to "INSERT" or "DELETE", infoInt is 
            //equal to the next token in the input file, which should be an 
            //integer.
            if(operation.equals("INSERT") || operation.equals("DELETE")){
                infoInt = fileScan.nextInt();
            }
            //If String operation is not equal to "INSERT" or "DELETE", infoInt 
            //is set to zero.
            else{
                infoInt = 0;
            }
            //String message is initialized to be an empty string.
            String message = "";
            switch(operation){
                //If String operation is set to "INSERT"...
                case "INSERT":
                    //The insertAfter() method of oList is called, passing 
                    //infoInt as the parameter.
                    oList.insertAfter(infoInt);
                    break;
                //If String operation is set to "DELETE"...
                case "DELETE":
                    //Boolean result is initialized to oList's deleteAfter() 
                    //method, with the method looking for the node with a value 
                    //equal to infoInt.
                    boolean result = oList.deleteAfter(infoInt);
                    //If boolean result is false...
                    if(!result){
                        //String message is equal to the following String.
                        message = "\nERROR: Node could not be found.";
                    }
                    break;
                //If String operation is set to "CLEAR"...
                case "CLEAR":
                    //If the linked list is already empty...
                    if(oList.isEmpty()){
                        //String message is equal to the following String.
                        message = "\nERROR: List is already empty.";
                    }
                    //If the linked list is populated...
                    else{
                        //oList's clear() method is called, emptying the list.
                        oList.clear();
                    }                    
                    break;
                //If String operation is set to "REVERSE"...
                case "REVERSE":
                    //oList's reverseOrder() method is called, reversign the 
                    //sorting of the linked list.
                    oList.reverseOrder();
                    break;
            }
            //If integer infoInt is equal to zero...
            if(infoInt == 0){
                //String info is set to an empty string.
                info = "";
            }
            //If integer infoInt is not equal to zero...
            else{
                //String info is equal to integer infoInt converted to a String.
                info = Integer.toString(infoInt);
            }
            //Prints Strings operation, info, message, and the object oList.
            System.out.println(operation + " " + info + message + "\n" + 
                    oList.toString() + "\n");
        }
    }
    
}
