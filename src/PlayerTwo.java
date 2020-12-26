
/**
 *
 * @author Rohan
 */
public class PlayerTwo {
    
    // Instance variables
    private String buttonsClicked = "";
    private String[] winCombos = {"123", "456", "789", 
    "147", "258", "369", "159", "357"};
    
    private boolean hasWon;
    
    /**
     * Constructs player two
     * Assigns boolean variable 'hasWon' a value of false
    */
    public PlayerTwo() {
        // Initialize all variables
        this.hasWon = false;
    }
    
    /**
     * Method to check if player two has won
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
     * Access method to access if player two has won
     * @return boolean value 'hasWon' 
     */
    public boolean getWin() {
        // Return the value of has won
        return this.hasWon;
    }
}
