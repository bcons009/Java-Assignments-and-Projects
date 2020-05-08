/*
 * File: Test.java
 * Asks the player for their name, whether they would like to go first, and 
 * which opponent type they would like to face before calling Nim's play() 
 * method.
 */

package Nim;

import javax.swing.JOptionPane;

/**
 * Test class for the Nim class.
 * @author Bryan Consuegra
 */
public class Test {
    
    /**
     * Main method for Test class.
     * @param args 
     */
    public static void main(String[] args) {
        //Initialize array of Player players as an empty array with two spaces,
        //setting index 0 to equal a new HumanPlayer().
        Player players[] = new Player[2];
        players[0] = new HumanPlayer();
        //String winner is initialized to equal "".
        String winner = "";
        //Ask the user for their name and store their input in String playerName
        String playerName = JOptionPane.showInputDialog("What is your name?");
        //Use HumanPlayer's setter method to set the player's name.
        players[0].setName(playerName);
        //Declare booleans playerTurn and firstTime
        Boolean playerTurn;
        Boolean firstTime;
        //Ask the player if they wish to go first.
        int playerStart = JOptionPane.showConfirmDialog(null, 
                "Would you like to go first?", "", JOptionPane.YES_NO_OPTION);
        switch (playerStart) {
            //If the player says yes...
            case JOptionPane.YES_OPTION:
                //playerTurn and firstTime are set to true.
                playerTurn = true;
                firstTime = true;
                break;
            //If the player says no or exits...
            default:
                //playerTurn and firstTime are set to false.
                playerTurn = false;
                firstTime = false;
                break;
        }
        //Display a dialog box with custom button text that asks the player 
        //which opponent they would like to face.
        String[] opponentA = {"Stupid Computer", "Smart Computer"};
        int opponentI = JOptionPane.showOptionDialog(null,"Which opponent would" 
                + " you like to face?", "", JOptionPane.DEFAULT_OPTION, 
                JOptionPane.INFORMATION_MESSAGE, null, opponentA, opponentA[0]);
        switch(opponentI){
            //If player chooses "Stupid Computer"...
            case 0:
                //Index 1 of players is set to a new StupidPlayer()
                players[1] = new StupidPlayer();
                break;
            //If player does not choose "Stupid Computer"...
            case 1:
                //Index 1 of players is set to a new SmartPlayer()
                players[1] = new SmartPlayer();
                break;
        }
        //New Nim object is created taking in the values of players, playerTurn, 
        //and firstTime.
        Nim nim = new Nim(players, playerTurn, firstTime);
        //Nim's play() method is called, beginning the game.
        nim.play();
    }
    
}
