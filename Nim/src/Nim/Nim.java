/*
 * File: Nim.java
 * Creates a Nim object with method play(), which is the main conductor of the
 * game's fucntions. Also declares a winner once the pile is empty.
 */

package Nim;
import javax.swing.JOptionPane;

/**
 * Creates a Nim object which conducts a game of Nim between two players.
 * @author Bryan Consuegra
 */
public class Nim {
    
    //Declare Pile object pile, array of Player players, Booleans playerTurn and 
    //firstTime, and initialize String winner to "".
    private Pile pile;
    private Player[] players;
    private Boolean playerTurn;
    private Boolean firstTime;
    private String winner = "";
    
    /**
     * Constructor for object Nim that creates a new Pile object and initializes 
     * Booleans playerTurn and firstTime as well as array of Player players.
     * @param players Array determining the players that will compete against
     * each other in a game of Nim.
     * @param playerTurn Boolean which determines if the player goes first. If 
     * true, the player has the first move.
     * @param firstTime Boolean which determines if the player is on their first
     * turn. If true, then it is the player's first turn.
     */
    public Nim(Player[] players, Boolean playerTurn, Boolean firstTime){
        pile = new Pile();
        this.players = players;
        this.playerTurn = playerTurn;
        this.firstTime = firstTime;
    }
    
    /**
     * Method which continuously conducts the majority of game functions, 
     * including turns for both the human player and the opponent, until the
     * pile has no more marbles, at which point a winner is declared.
     */
    public void play(){
        //While no winner has been declared...
        while(winner.equals("")){
            //If it is the player's turn and it is not their first turn...
            if(playerTurn && !firstTime){
                //The number of marbles in the pile will be subtracted by the 
                //number of marbles the player wishes to remove.
                pile.setPileSize(players[0].move(pile.getPileSize()));
                //Status message showing how many marbles have been taken by 
                //whom and how many marbles remain.
                JOptionPane.showMessageDialog(null,players[0].getName() + " has"
                        + " taken " + pile.getMoveCount() + " marble(s).\n" + 
                        pile.getPileSize() + " marble(s) remain.");
                //If during the player's turn the pile becomes empty...
                if(pile.getPileSize() == 0){
                    //The opponent is declared the winner.
                    winner = players[1].getName();
                }
            }
            //If it is not the player's turn...
            else if(!playerTurn){
                //The number of marbles in the pile will be subtracted by the 
                //number of marbles the opponent's move() method determines.
                pile.setPileSize(players[1].move(pile.getPileSize()));
                //Status message showing how many marbles have been taken by 
                //whom and how many marbles remain.
                JOptionPane.showMessageDialog(null,players[1].getName() + " has"
                        + " taken " + pile.getMoveCount() + " marble(s).\n" + 
                        pile.getPileSize() + " marble(s) remain.");
                //If during the opponent's turn the pile becomes empty...
                if(pile.getPileSize() == 0){
                    //The player is declared the winner.
                    winner = players[0].getName();
                }
            }
            //If it is the player's turn and it is their first turn...
            else if(playerTurn && firstTime){
                //Message stating how many marbles are in the pile and informing
                //the payer that they have the first move.
                JOptionPane.showMessageDialog(null, "There are " + 
                        pile.getPileSize() + " marbles in the pile."
                        + "\nYou move first!");
                //The number of marbles in the pile will be subtracted by the 
                //number of marbles the player wishes to remove.
                pile.setPileSize(players[0].move(pile.getPileSize()));
                //Status message showing how many marbles have been taken by 
                //whom and how many marbles remain.
                JOptionPane.showMessageDialog(null,players[0].getName() + " has"
                        + " taken " + pile.getMoveCount() + " marble(s).\n" + 
                        pile.getPileSize() + " marble(s) remain.");
                //firstTime is set to false, since the player has just 
                //experienced their first turn.
                firstTime = false;
            }
            //playerTurn is inverted for the next turn.
            playerTurn = !playerTurn;
        }
        //A message appears declaring the winner.
        JOptionPane.showMessageDialog(null, winner + " has won!");
    }
}
