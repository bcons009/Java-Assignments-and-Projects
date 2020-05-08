/*
 * File: Pile.java
 * Creates a Pile object which holds an integer pileSize which counts the amount 
 * of marbles in the pile. Also includes an integer moveCount to count how many 
 * marbles were removed in the previous turn, as well as accessor methods for 
 * pileSize and moveCount. 
 */

package Nim;
import java.util.Random;

/**
 * Creates object Pile with integer pileSize that counts the number of marbles
 * in the pile, as well as integer moveCount which stores the number of marbles
 * taken in their previous move.
 * @author Bryan Consuegra
 */
public class Pile {
    
    //Initialize randomizer r and declare integers pileSize and moveCount.
    private Random r = new Random();
    private int pileSize;
    private int moveCount;
    
    /**
     * Constructor which initializes pileSize as a random integer between
     * 10 and 100.
     */
    public Pile(){
        pileSize = r.nextInt(91) + 10;
    }
    
    /**
     * Sets the moveCoutn to the player's move and subtracts the pile size by
     * the player's move.
     * @param move The player's move.
     */
    public void setPileSize(int move){
        moveCount = move;
        pileSize -= move;
    }
    
    /**
     * Accessor method for integer pileSize.
     * @return pileSize, the amount of marbles in the pile.
     */
    public int getPileSize(){
        return pileSize;
    }
    
    /**
     * Accessor method for integer moveCount
     * @return moveCount, the player's move.
     */
    public int getMoveCount(){
        return moveCount;
    }
}
