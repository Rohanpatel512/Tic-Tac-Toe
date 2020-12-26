/**
 *
 * @author Rohan
 */
public class PlayerOne {
    
    // Instance variables
    private String buttonsClicked = "";
    private String[] winCombos = {"123", "456", "789", 
    "147", "258", "369", "159", "357"};

    private boolean hasWon;
    private boolean isTurn;
    
    /**
     * Constructs the first player
     * Assigns 'hasWon' boolean variable a value of false
     * Assigns 'isTurn' a boolean value of true
    */
    public PlayerOne() {
        // Initialize variables
        this.hasWon = false;
        this.isTurn = true;
    }
    
    /**
     * Method to check if user has won 
     * @param buttons action command as an integer 
     */
    public void checkWin(int buttonNumber) {
        
        // Method variables
        int count = 0;
        
        // Store the value of button inside string 
        buttonsClicked += buttonNumber;  
        
        // Loop through the win combos array 
        for(int i = 0; i < winCombos.length; i++) {
            // Turn each string into array and store in variable
            String[] combo = winCombos[i].split("");
            
            // Loop through the combo array 
            for(int j = 0; j < combo.length; j++) {
                // Check if string contains a number in combo
                if(buttonsClicked.contains(combo[j])) {
                    count += 1;
                } else {
                    count = 0;
                    break;
                }
            }
            
            // If count is 3, break out of outer loop
            if(count == 3) {
                break;
            }
        }
        
        /* Make sure count is three, 
        then set boolean value to true*/
        if(count == 3) {
            this.hasWon = true;
        }
    }
    
    /**
     * Method to switch turns 
     */
    public void switchTurns() {
        // Flip the boolean value of 'isTurn' 
        this.isTurn = !this.isTurn;
    }

    /**
     * Access method to access if player has won
     * @return if player has won 
     */
    public boolean getWin() {
        // Return hasWon boolean variable value
        return this.hasWon;
    }
    
    /**
     * Access method to access if it is player one's turn
     * @return if it is player one's turn
     */
    public boolean getTurn() {
        // Return isTurn boolean variable value
        return this.isTurn;
    }
   
}
