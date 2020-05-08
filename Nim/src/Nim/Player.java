/*
 * File: Player.java
 * Creates interface Player with a method for determining a player's move as 
 * well as setter and getter methods for the player's name. Also created are 
 * classes HumanPlayer, StupidPlayer, and SmartPlayer, all of which implement 
 * interface Player.
 */

package Nim;
import javax.swing.JOptionPane;
import java.util.Scanner;
import java.util.Random;

/**
 * Creates interface Player with method move() to detect a player's move along 
 * with setName() and getName() used as setter and getter methods for the String
 * name, representing the player's name.
 * @author Bryan Consuegra
 */
public interface Player{
    int move(int pile);
    void setName(String name);
    String getName();
}

/**
 * Creates class HumanPlayer which implements interface Player. This class uses 
 * player input for both move() and setName (the input for setName is found in 
 * the Test class).
 * @author Bryan Consuegra
 */
class HumanPlayer implements Player{
    @Override
    /**
     * Asks the player how many marbles they wish to take from the pile.
     * @param pile Integer which tells move() how many marbles are currently in 
     * the pile.
     * @return The amount that will be subtracted from the pile, aka the 
     * player's move.
     */
    public int move(int pile){
        //Input stored into a string so that it may be checked by Scanner s.
        String moveStr = JOptionPane.showInputDialog(pile + " marble(s) "
                + "remain(s). How many marbles would you like to take?");
        Scanner s = new Scanner(moveStr);
        //Integer modulus is declared, which is 1 only if the pile has only 1
        //marble. This integer is used to ensure the player is able to take the
        //last marble.
        int modulus;
        if(pile == 1){
            modulus = 1;
        }
        else{
            modulus = 0;
        }
        //If the player input was not an integer or was an integer outside the 
        //range of 1 and half of the pile...
        if(!s.hasNextInt() || Integer.parseInt(moveStr) > ((pile / 2) + modulus)
                || Integer.parseInt(moveStr) <= 0){
            //Creates boolean success which determines whether while loop 
            //continues to run.
            Boolean success = false;
            while(!success){
                //Displays error message and prompts user to enter a new value.
                String moveStr1 = JOptionPane.showInputDialog("ERROR: This "
                        + "program only accepts integers within the range "
                        + "1-" + ((pile / 2) + modulus) + ".\nThere are "
                        + "currently " + pile + " marbles in the pile." 
                        + "\nHow many marbles would you like to take?");
                //Create a new scanner to scan the new input String.
                Scanner s1 = new Scanner(moveStr1);
                //If the input is an integer and is between 1 and half of the 
                //pile, inclusive...
                if(s1.hasNextInt() && Integer.parseInt(moveStr1) <= (pile / 2) 
                        && Integer.parseInt(moveStr1) > 0){
                    //The input is trasnferred to the prior input String, which 
                    //will be converted to an integer, and success is set to 
                    //true, ending the loop.
                    moveStr = moveStr1;
                    success = true;
                }
            }
        }
        //The input String is converted into and integer, and the method move()
        //returns the integer.
        int move = Integer.parseInt(moveStr);
        return move;
    }
    //String name is declared to store the player's name.
    String name;
    @Override
    /**
     * Sets the player's name to the String parameter name.
     * @param name The player's inputted name.
     */
    public void setName(String name){
        this.name = name;
    }
    @Override
    /**
     * Accessor method for String name.
     * @return Player's name.
     */
    public String getName(){
        return name;
    }
}

/**
 * Creates class StupidPlayer which implements interface Player. This class 
 * uses a random number generator between 1 and half the pile to determine the
 * opponent's move. getName() will always print "Stupid Computer", and setName() 
 * is unused.
 * @author Bryan Consuegra
 */
class StupidPlayer implements Player{
    @Override
    /**
     * Determines the opponent's move with a random number generator.
     * @param pile Integer which tells move() how many marbles are currently in 
     * the pile.
     * @return The amount that will be subtracted from the pile, aka the 
     * opponent's move.
     */
    public int move(int pile){
        //Initialize new randomizer r.
        Random r = new Random();
        int move;
        //If the pile has more than 1 marble...
        if(pile > 1){
            //The opponent's move is chosen between 1 and half the pile.
            move = r.nextInt(pile/2) + 1;
        }
        //If the pile has 1 marble...
        else{
            //The computer will take 1 marble.
            //This is to prevent a randomizer error where the randomizer must
            //choose a number of range 0.
            move = 1;
        }
        return move;
    }
    @Override
    /**
     * Unused method from interface Player.
     * @param name Unused parameter from interface Player.
     */
    public void setName(String name){}
    @Override
    /**
     * Accessor method for String name, which is set to "Stupid Computer".
     * @return Opponent's name.
     */
    public String getName(){
        return "Stupid Computer";
    }
}

/**
 * Creates class StupidPlayer which implements interface Player. This class 
 * uses a series of if statements to employ an optimal Nim victory strategy. 
 * getName() will always print "Smart Computer", and setName() is unused.
 * @author Bryan Consuegra
 */
class SmartPlayer implements Player{
    @Override
    /**
     * Determines the opponent's move so that the opponent employs the optimal 
     * Nim victory strategy by leaving the pile with a power of 2 minus 1, 
     * whenever possible.
     * @param pile Integer which tells move() how many marbles are currently in 
     * the pile.
     * @return The amount that will be subtracted from the pile, aka the 
     * opponent's move.
     */
    public int move(int pile){
        int move;
        //If the pile has more than 63 marbles...
        if(pile > 63){
            //Opponent removes enough marbles so that the pile has 63 marbles.
            move = pile - 63;
        }
        //If the pile has 32-63 marbles...
        else if(pile > 31 && pile <= 63){
            //If the pile has exactly 63 marbles
            if(pile == 63){
                //The opponent removes 31 marbles, the maximum amount a player
                //can remove.
                move = 31;
            }
            //If the pile has 32-62 marbles...
            else{
                //Opponent removes enough marbles so that the pile has 31 
                //marbles.
                move = pile - 31;
            }
        }
        //If the pile has 16-31 marbles...
        else if (pile > 15 && pile <= 31){
            //If the pile has exactly 31 marbles...
            if(pile == 31){
                //The opponent removes 15 marbles, the maximum amount a player
                //can remove.
                move = 15;
            }
            //If the pile has 16-30 marbles...
            else{
                //Opponent removes enough marbles so that the pile has 15 
                //marbles.
                move = pile - 15;
            }
        }
        //If the pile has 8-15 marbles...
        else if (pile > 7 && pile <= 15){
            //If the pile has exactly 15 marbles...
            if(pile == 15){
                //The opponent removes 7 marbles, the maximum amount a player
                //can remove.
                move = 7;
            }
            //If the pile has 8-14 marbles...
            else{
                //Opponent removes enough marbles so that the pile has 7 
                //marbles.
                move = pile - 7;
            }
        }
        //If the pile has 4-7 marbles...
        else if (pile > 3 && pile <= 7){
            //If the pile ahs exactly 7 marbles...
            if(pile == 7){
                //The opponent removes 3 marbles, the maximum amount a player
                //can remove.
                move = 3;
            }
            //If the pile has 4-6 marbles...
            else{
                //Opponent removes enough marbles so that the pile has 3 
                //marbles.
                move = pile - 3;
            }
        }
        //If the pile has 1-3 marbles...
        else{
            //Opponent removes 1 marbles, the maximum amount a player 
            //can remove.
            move = 1;
        }
        return move;
    }
    @Override
    /**
     * Unused method from interface Player.
     * @param name Unused parameter from interface Player.
     */
    public void setName(String name){}
    @Override
    /**
     * Accessor method for String name, which is set to "Smart Computer".
     * @return Opponent's name.
     */
    public String getName(){
        return "Smart Computer";
    }
}
