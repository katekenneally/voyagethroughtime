//*******************************************************************
//StoryPanel.java                 @author Kate Kenneally
//CS230 Final Project Voyage Through Time
//
//Panel contained in StoryGUI's frame. Gathers information from other
//classes.
//
//Primary Coder: Kate
//*******************************************************************

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javafoundations.*;

public class StoryPanel extends JPanel {
  
  private JLabel titleLabel, mainLabel, imageLabel, tLogLabel, tLabel1, tLabel2, tLabel3, tLabel4, tLabel5;
  private JButton b1, b2, b3, b4;
  private ImageIcon image;
  private JPanel leftPanel, rightPanel, buttonPanel, logPanel;
  
  // These variables will be passed through from StoryGUI
  private JFrame frame;
  private StoryGraph<StoryNode> game;
  private Player wendy;
  private StoryNode current, q1, q2, q3;
  
  private LinkedList<String> recentActions;
  private LinkedQueue<String> overallActions;
  private LinkedList<StoryNode> options;
  
  private int numOps, score, beerCounter;
  
  private String results, finalImageURL;
  
   /**
   * Constructor
   */
  public StoryPanel(JFrame frame, StoryGraph game, Player wendy, StoryNode start, StoryNode q1, StoryNode q2, StoryNode q3) {
    
    // Set variables
    this.frame = frame;
    this.game = game;
    this.wendy = wendy;
    current = start; // Current node at the start of the game is the start node (s1) from StoryGUI
    this.q1 = q1;
    this.q2 = q2;
    this.q3 = q3;
    
    // Set the beerCounter to 0
    beerCounter = 0;
    
    // Get options from start node to use for button text
    options = game.getSuccessors(start);
    // Get recentActions from wendy (empty strings at game start) to use for travel log text
    recentActions = wendy.getRecentActions();
    
    // Our GUI uses a GridLayout: 1 column for the leftPanel, 1 column for the rightPanel
    setLayout(new GridLayout(1,2));
    
    // The leftPanel contains a buttonPanel, and the rightPanel contains a logPanel
    // All four of these panels use a BoxLayout and have a black background
    leftPanel = new JPanel();
    leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
    leftPanel.setBackground(Color.black);
    rightPanel = new JPanel();
    rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
    rightPanel.setBackground(Color.black);
    buttonPanel = new JPanel();
    buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
    buttonPanel.setBackground(Color.black);
    logPanel = new JPanel();
    logPanel.setLayout(new BoxLayout(logPanel, BoxLayout.Y_AXIS));
    logPanel.setBackground(Color.black);
    
    // The text for titleLabel will not change
    titleLabel = new JLabel("VOYAGE THROUGH TIME");
    titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    titleLabel.setFont(new Font("Courier New", Font.ITALIC, 30));
    titleLabel.setForeground(Color.white);
    
    // mainLabel contains the description from the current node
    mainLabel = new JLabel(current.getDescription());
    mainLabel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
    mainLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    mainLabel.setFont(new Font("Courier New", Font.PLAIN, 16));
    mainLabel.setForeground(Color.green);
    
    // imageLabel contains ImageIcon generated from the image string (url) from the current node
    imageLabel = new JLabel();
    imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    image = new ImageIcon(current.getImage(), "main image");
    imageLabel.setIcon(image);
    
    // The text for tLogLabel will not change
    tLogLabel = new JLabel("TRAVEL LOG");
    tLogLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    tLogLabel.setFont(new Font("Courier New", Font.PLAIN, 20));
    tLogLabel.setForeground(Color.white);
    
    // The tLabels are contained in the logPanel
    // Their text changes based on wendy's recentActions
    tLabel1 = new JLabel(recentActions.get(4));
    tLabel1.setAlignmentX(Component.CENTER_ALIGNMENT);
    tLabel1.setFont(new Font("Courier New", Font.PLAIN, 20));
    tLabel1.setForeground(Color.white);
    tLabel2 = new JLabel(recentActions.get(3));
    tLabel2.setAlignmentX(Component.CENTER_ALIGNMENT);
    tLabel2.setFont(new Font("Courier New", Font.PLAIN, 20));
    tLabel2.setForeground(Color.white);
    tLabel3 = new JLabel(recentActions.get(2));
    tLabel3.setAlignmentX(Component.CENTER_ALIGNMENT);
    tLabel3.setFont(new Font("Courier New", Font.PLAIN, 20));
    tLabel3.setForeground(Color.white);
    tLabel4 = new JLabel(recentActions.get(1));
    tLabel4.setAlignmentX(Component.CENTER_ALIGNMENT);
    tLabel4.setFont(new Font("Courier New", Font.PLAIN, 20));
    tLabel4.setForeground(Color.white);
    tLabel5 = new JLabel(recentActions.get(0));
    tLabel5.setAlignmentX(Component.CENTER_ALIGNMENT);
    tLabel5.setFont(new Font("Courier New", Font.PLAIN, 20));
    tLabel5.setForeground(Color.white);
    
    // The buttons are contained in the buttonPanel
    // Their text changes based on the current node's successors
    b1 = new JButton(options.get(0).getName());
    b1.setAlignmentX(Component.CENTER_ALIGNMENT);
    b1.setFont(new Font("Courier New", Font.PLAIN, 16));
    b1.setBackground(Color.white);
    b1.setForeground(Color.black);
    b1.addActionListener(new ButtonListener());
    b2 = new JButton(options.get(1).getName());
    b2.setAlignmentX(Component.CENTER_ALIGNMENT);
    b2.setFont(new Font("Courier New", Font.PLAIN, 16));
    b2.setBackground(Color.white);
    b2.setForeground(Color.black);
    b2.addActionListener(new ButtonListener());
    b3 = new JButton(options.get(2).getName());
    b3.setAlignmentX(Component.CENTER_ALIGNMENT);
    b3.setFont(new Font("Courier New", Font.PLAIN, 16));
    b3.setBackground(Color.white);
    b3.setForeground(Color.black);
    b3.addActionListener(new ButtonListener());
    b4 = new JButton(options.get(3).getName());
    b4.setAlignmentX(Component.CENTER_ALIGNMENT);
    b4.setFont(new Font("Courier New", Font.PLAIN, 16));
    b4.setBackground(Color.white);
    b4.setForeground(Color.black);
    b4.addActionListener(new ButtonListener());
    
    
    // Add leftPanel and rightPanel to the frame (GridLayout)
    add(leftPanel);
    add(rightPanel);
    
    // Add buttons to the buttonPanel (BoxLayout)
    buttonPanel.add(b1);
    buttonPanel.add(b2);
    buttonPanel.add(b3);
    buttonPanel.add(b4);
    
    // Add tLabels to the logPanel (BoxLayout)
    logPanel.add(tLabel1);
    logPanel.add(tLabel2);
    logPanel.add(tLabel3);
    logPanel.add(tLabel4);
    logPanel.add(tLabel5);
    
    // Add mainLabel and buttonPanel to the leftPanel with space in between (BoxLayout)
    leftPanel.add(Box.createRigidArea(new Dimension(0,75)));
    leftPanel.add(mainLabel);
    leftPanel.add(Box.createRigidArea(new Dimension(0,50)));
    leftPanel.add(buttonPanel);
    leftPanel.add(Box.createRigidArea(new Dimension(0,10)));
    
    // Add titleLabel, imageLabel, and logPanel to the rightPanel with space in between (BoxLayout)
    rightPanel.add(Box.createRigidArea(new Dimension(0,10)));
    rightPanel.add(titleLabel);
    rightPanel.add(Box.createRigidArea(new Dimension(0,10)));
    rightPanel.add(imageLabel);
    rightPanel.add(Box.createRigidArea(new Dimension(0,10)));
    rightPanel.add(tLogLabel);
    rightPanel.add(Box.createRigidArea(new Dimension(0,10)));
    rightPanel.add(logPanel);
    rightPanel.add(Box.createRigidArea(new Dimension(0,10)));
    
  }
  
  private class ButtonListener implements ActionListener {
    
    /******************************************************************
    * ButtonListener for all buttons in StoryPanel. Changes appearance
    * of panel and updates/retrieves variables as needed.
    * 
    * @param event: the button click
    ******************************************************************/
    public void actionPerformed (ActionEvent event) {  
      
      // Get the text of the button that was clicked
      String selectedAction = event.getActionCommand();
      
      // SPECIAL CASES:
      
      // QUIT (END GAME)
      if (selectedAction.equals("QUIT")) {
        // Quit the game by closing the frame
        frame.dispose();
      }
      
      // VIEW RESULTS (FINAL SCREEN)
      else if (selectedAction.equals("View Results")) {
        // Get overallActions for results screen
        overallActions = wendy.getOverallActions();
        // Change the appearance of StoryPanel to create results screen
        // Clear out right side of StoryPanel
        //remove(rightPanel);
        tLogLabel.setText("");
        tLabel1.setText("");
        tLabel2.setText("");
        tLabel3.setText("");
        tLabel4.setText("");
        tLabel5.setText("");
        if (beerCounter>=16) {
          results = ("<html>What have you done.<br><br>Beers drunk: " + beerCounter 
                       + "<br><br>Don't drink and time travel, kids.</html>");
        }
        else {
          // Define results string by looping through/dequeueing overallActions LinkedQueue until empty
          results = ("<html>Thank you for playing! Take a look at the key decisions you made " 
                       + "during your VOYAGE THROUGH TIME:<br><br>");
          while (overallActions.size()!=0) {
            results += overallActions.dequeue() + "<br><br>";
          }
          if (beerCounter>2 && beerCounter<16) results += ("Beers drunk: " + beerCounter + "<br><br>");
          results +="</html>";
        }
        // Display results
        mainLabel.setText(results);
        // b1 becomes QUIT button (action covered in above conditional)
        b1.setText("QUIT");
        // Insert imageLabel below QUIT button
        //leftPanel.add(imageLabel);
        // finalImageURL set in "Continue..." conditional below
        image = new ImageIcon(finalImageURL, "main image");
        imageLabel.setIcon(image);
        revalidate();
      }
      
      // CONTINUE (Q ENDING)
      // Because Q ENDINGS are dependent on points, they are not connected to any nodes on the graph
      // and must be traveled to manually
      else if (selectedAction.equals("Continue...")) {
        // Get wendy's final score
        score = wendy.getScore();
        // Worst ending (less than 10 points), travel to q1 node
        if (score<10) {
          current = q1;
          // Set Janeway GIF URL accordingly
          finalImageURL = "worst.gif";
        }
        // Good ending (between 10 and 40 points), travel to q2 node
        else if (score>=10 && score<40) {
          current = q2;
          finalImageURL = "notbad.gif";
        }
        // Best ending (full 40 points), travel to q3 node
        else {
          current = q3;
          finalImageURL = "best.gif";
        }
        // Update main text, button text, and image
        mainLabel.setText(current.getDescription());
        b1.setText("View Results");
        image = new ImageIcon(current.getImage(), "main image");
        imageLabel.setIcon(image);
        revalidate();
      }
      
      // NORMAL CASE:
      
      else {
        
        // Get node from the text of the clicked button, set to current
        current = StoryGraph.getNodeByName(selectedAction, options);
        
        // Update score, recentActions, overallActions
        wendy.updateScore(current);
        wendy.updateRecentActions(current);
        wendy.updateOverallActions(current);
        
        // Get recentActions (for travel log), options (for button text),
        // and numOps (for number of buttons to display)
        recentActions = wendy.getRecentActions();
        options = game.getSuccessors(current);
        numOps = options.size();
        
        // Set mainlabel text to the description of the current node
        mainLabel.setText(current.getDescription());
        
        // Update travel log with recentActions
        tLabel1.setText(recentActions.get(4));
        tLabel2.setText(recentActions.get(3));
        tLabel3.setText(recentActions.get(2));
        tLabel4.setText(recentActions.get(1));
        tLabel5.setText(recentActions.get(0));
        
        // Update image with image variable from current node
        image = new ImageIcon(current.getImage(), "main image");
        imageLabel.setIcon(image);
        
        // If this node has no successors, it is an end node
        // If the score is -1000 (no Q ENDING), a button should link directly to the View Results screen
        // (see VIEW RESULTS special case conditional above)
        if (game.isEndNode(current)) {
          if (wendy.getScore()==-1000) {
            b1.setText("View Results");
            // set finalImageURL here (since CONTINUE node will not be visited)
            finalImageURL = "worst.gif";
          }
          // If the score is not -1000, a button should link to a Q ENDING screen
          // (see CONTINUE special case conditional above)
          else b1.setText("Continue...");
          // Only b1 is needed; remove other buttons
          buttonPanel.remove(b2);
          buttonPanel.remove(b3);
          buttonPanel.remove(b4);
          revalidate();
        }
        // If the node has successors:
        else {
          if (selectedAction.equals("Drink Beer")) beerCounter++;
          // Number of buttons may vary. Remove buttons/change text as needed
          if (numOps<4) buttonPanel.remove(b4);
          else {
            buttonPanel.add(b4);
            b4.setText(options.get(3).getName());
          }
          if (numOps<3) buttonPanel.remove(b3);
          else {
            buttonPanel.add(b3);
            b3.setText(options.get(2).getName());
          }
          if (numOps<2) buttonPanel.remove(b2);
          else {
            buttonPanel.add(b2);
            b2.setText(options.get(1).getName());
          }
          b1.setText(options.get(0).getName());
          revalidate();
        }
      }
    }
  }
}