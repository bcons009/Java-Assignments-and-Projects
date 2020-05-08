/*
 * File: PascalsTriangle.java
 * Creates a 2D array of integers representing a Pascal's Triangle.
 * The number of the 2d array's "rows" and "columns" are determined by an
 * integer "rowNum", which is a parameter of the PascalsTriangle object. Also
 * included is a toString() method which formats the Pascal's Triangle into a 
 * neatly spaced String.
 */
package pascaltriangle;

import java.util.Arrays;

/**
 * Creates a portion of Pascal's Triangle and edits the object's toString()
 * method to output a neatly spaced String.
 * @author Bryan Consuegra
 */
public class PascalsTriangle {
    
    //Declares integer rowNum and 2D array of integers pT.
    private int rowNum;
    private int[][] pT;
    
    /**
     * Creates a PascalsTriangle object representing a Pascal's Triangle made of 
     * a number of rows determined by rowNum.
     * @param rowNum The number of rows the Pascal's Triangle will have.
     */
    public PascalsTriangle(int rowNum){
        this.rowNum = rowNum;
        //Declare 2D array pT as a new 2D array of integers with a "row" and
        //"column" size of rowNum.
        pT = new int[rowNum][rowNum];
        //Calls the method to fill the pT 2D array.
        createPT();
    }
    
    /**
     * Fills the pT 2D array of integers with the Pascal's Triangle of rowNum
     * rows.
     */
    private void createPT(){
        //Nested for loops which check every space in the 2D array
        for(int i = 0; i < rowNum; i++){
            for(int j = 0; j < (i + 1); j++){
                //If the space is the first or last space in the row...
                if(j == 0 || j == i){
                    //The space is set to 1.
                    pT[i][j] = 1;
                }
                //If not...
                else{
                    //The space is set to the sum of the values in the previous 
                    //row, previous column and previous row, same column.
                    pT[i][j] = pT[i - 1][j - 1] + pT[i - 1][j];
                }
            }
        }
    }
    
    @Override
    /**
     * Overrides PascalsTriangle's default toString() method, formatting the 
     * values of the 2D array pT into an evenly spaced out String displaying the
     * Pascal's Triangle as a neat triangle.
     * @return String printPT, the String representation of object 
     * PascalsTriangle.
     */
    public String toString(){
        //Initialize empty String printPT.
        String printPT = "";
        //Nested for loops which check every space in 2D array pT.
        for(int i = 0; i < rowNum; i++){
            //Initialize a new String array pt with 25 spaces filled with the 
            //String "   ".
            String pt[] = new String[25];
            Arrays.fill(pt, "   ");
            //Integer rowCount is initialized with a value of 0. This integer is
            //used as a counter to properly place Pascal's Triangle values onto
            //the String array pt.
            int rowCount = 0;
            for(int j = 0; j < i + 1; j++){
                //Set the pt array space at the index 12 - i + (2 * rowCount) to
                //the corresponding pT value, converting the int value into a 
                //String.
                pt[12 - i + (2 * rowCount)] = 
                        Integer.toString(pT[i][j]);
                //If int j is less than i...
                if(j < i){
                    //Depending on the length of integer (turned into a String)
                    //at the space in the same row and next column of the
                    //previously used Pascal's Triangle value, the spacing after
                    //the previous value will range between 3 and 5 spaces.
                    switch(Integer.toString(pT[i][j + 1]).length()){
                        case 1:
                            pt[12 - i + (2 * rowCount) + 1] = 
                                    "     ";
                            break;
                        case 2:
                            pt[12 - i + (2 * rowCount) + 1] = 
                                    "    ";
                            break;
                        case 3:
                            pt[12 - i + (2 * rowCount) + 1] = 
                                    "   ";
                            break;
                    }
                }
                //Counter rowCount is increased by 1.
                rowCount++;
            }
            //Once a full row is added to array pt, a for loop is used to 
            //transcribe the values of the array into String printPT.
            for(int k = 0; k < 25; k++){
                printPT += pt[k];
                //After addign the last pt value to String printPT...
                if (k == 24){
                    //Add a line break to pritnPT
                    printPT += "\n";
                }
            }
        }
        return printPT;
    }
}
