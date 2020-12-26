
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Rohan
 */
public class Game implements ActionListener {
    
    // Instance variables
    private String boardNumbers = "";
    private String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
    private String player = "";
    
    private Board gameBoard;
    private PlayerOne firstPlayer;
    private PlayerTwo secondPlayer;
    
    /**
     * Constructs the game
     * Creates the games board
     * Creates the first and second player
     */
    public Game() {
        
        // Initialize all instance variables
        this.gameBoard = new Board();
        this.firstPlayer = new PlayerOne();
        this.secondPlayer = new PlayerTwo();
        
        // Get all buttons from game board class
        JButton[] boardButtons = this.gameBoard.getButtons();
        
        // Loop through the buttons array 
        for(int i = 0; i < boardButtons.length; i++) {
            // Add action listener to all buttons 
            boardButtons[i].addActionListener(this);
        }
        
    }
   
    
    /**
     * Method performed when any of the nine buttons are clicked
     * @param e 
     */
    public void actionPerformed(ActionEvent e) {
        // Get the boolean value isTurn from player one 
        boolean playerTurn = this.firstPlayer.getTurn();
        
        // Get the text that displays whos turn it is 
        JLabel text = this.gameBoard.getText();
        
        // Get the command of button clicked as an integer
        int buttonNumber = Integer.parseInt(e.getActionCommand());
        
        // Check which players turn it is 
        if(playerTurn) {
            // Set value of player to 'x'
            player = "X";
            
            // Display to user it is player ones turn 
            text.setText("Player O turn");
            
            // Store the integer value inside string
            boardNumbers += buttonNumber;
            
            // Call method to switch turns, check for win, and place player 
            this.firstPlayer.switchTurns();
            this.firstPlayer.checkWin(buttonNumber);
            placePlayer(buttonNumber);
            
        } else if(!playerTurn) {
            // Set the value of player to 'O'
            player = "O";
            
            // Display to user it is player twos turn 
            text.setText("Player X turn");
            
            // Store the integer value inside string
            boardNumbers += buttonNumber;
            
            // Call method to switch turns, check for win, and place player
            this.firstPlayer.switchTurns();
            this.secondPlayer.checkWin(buttonNumber);
            placePlayer(buttonNumber);
        }
    }
    
    /**
     * Helper method that places the player at its position
     */
    private void placePlayer(int number) {
        
       // Get the buttons and store in variable
       JButton[] boardButtons = this.gameBoard.getButtons();
       
       // Display the player on button 
       boardButtons[number - 1].setText(player);
       
       // Check if somebody has won, or if there has been a tie
       if(this.firstPlayer.getWin()) {
           // Display to user first player has won 
           JOptionPane.showMessageDialog(gameBoard, "Player X has won!");
       } else if(this.secondPlayer.getWin()) {
           // Display to user second player has won
           JOptionPane.showMessageDialog(gameBoard, "Player O has won!");
       } else {
           // Call method to check for tie 
           checkTie();
       }
    }
    
    /**
     * Helper method to check if there is a tie 
     */
    private void checkTie() {
        // Method variables
        int count = 0;
        
        // Loop through the numbers array 
        for(int i = 0; i < numbers.length; i++) {
            // Check if string contains number
            if(boardNumbers.contains(numbers[i])) {
                // Increase value of count by one
                count += 1;
            }
        }
        
        // Check if count is at 9
        if(count == 9) {
            // Display to user it is a tie
            JOptionPane.showMessageDialog(gameBoard, "This game is a DRAW!");
        }
    }
}
