import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Rohan
 */
public class Board extends JFrame {
    
    // Instance variables 
    private JButton[] boardButtons;
    private JLabel text;
    
    private JPanel buttonPanel;
    private JPanel textPanel;
    
    private Font gameFont = new Font("Sans Serif", Font.BOLD, 25);
    
    /**
     * Constructs the main window frame for board
     * Creates the panel where buttons are stored
     * Creates the buttons user clicks
     * Set the layout of the panel 
     */
    public Board() {
        
        // Create the window frame - Creates board
        this.setTitle("Tic-Tac-Toe");
        this.setSize(400, 400);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.WHITE);
        this.setLayout(new BorderLayout());
        
        // Initialize all GUI components to be displayed on board 
        boardButtons = new JButton[9];
        buttonPanel = new JPanel();
        textPanel = new JPanel();
        text = new JLabel("Player X Turn");
        
        // Set the layout of buttons panel 
        buttonPanel.setLayout(new GridLayout(3, 3));
        
        // Call all helper methods within file
        addPanels();
        addButtons();
        addText();
    }
    
    /**
     * Adds all panels inside main window
     * Adds the buttons panel to the top of window
     */
    private void addPanels() {
        
        // Add all panels inside inside the JFrame
        this.add(buttonPanel, BorderLayout.CENTER);
        this.add(textPanel, BorderLayout.PAGE_START);
        
    }
    
    /**
     * Create all nine buttons 
     * Add each button inside the button panel 
     */
    private void addButtons() {
        
        // Loop through the buttons array 
        for(int i = 0; i < boardButtons.length; i++) {
            // Create a new button 
            boardButtons[i] = new JButton();
            
            // Design the button
            boardButtons[i].setBackground(Color.WHITE);
            boardButtons[i].setActionCommand(String.valueOf(i + 1));
            boardButtons[i].setFont(gameFont);
            //boardButtons[i].setText(String.valueOf(i + 1));
            
            // Add the button inside is corresponding panel 
            buttonPanel.add(boardButtons[i]);
        }
        
    }
    
    /**
     * Method to add a JLabel at the top of window
     */
    private void addText() {
        // Set the font of the JLabel
        text.setFont(gameFont);
        
        // Add the JLabel to its corresponding panel 
        textPanel.add(text);
    }
    
    /**
     * Access method to access the board buttons
     * @return the buttons on the board 
     */
    public JButton[] getButtons() {
        // Return all board buttons
        return boardButtons;
    }
    
    /**
     * Access method to access the JLabel
     * @return the JLabel 
     */
    public JLabel getText() {
        // Return the JLabel 
        return text;
    }

    
}
