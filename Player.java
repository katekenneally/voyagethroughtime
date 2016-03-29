//*******************************************************************
//Player.java                @author Dana Hsiao
//CS230 Final Project Voyage Through Time
//
//Represents the player's data. Holds the player's score, recent
//moves, and moves taken that are important to the plot.
//
//Primary Coder: Dana
//*******************************************************************

import java.util.LinkedList;
import javafoundations.*;

public class Player{
  //Instance Variables
  private int score;
  private LinkedList<String> recentActions;
  private LinkedQueue<String> overallActions;
  
  /**
   * Constructor, sets inital score to 0, recentActions to be a new Linked List,
   * and overallActions to be a new LinkedQueue; adds empty strings to recentActions
   */
  public Player(){
    score = 0;
    recentActions = new LinkedList<String>();
    overallActions = new LinkedQueue<String>();
    recentActions.add("");
    recentActions.add("");
    recentActions.add("");
    recentActions.add("");
    recentActions.add("");
  }
  

 /**
 * Returns the integer score 
 * 
 * @return      score
 */
  public int getScore(){
    return score;
  }
 
  /**
 * Returns the LinkedList recentActions 
 * 
 * @return      recentActions
 */
  public LinkedList<String> getRecentActions(){
    return recentActions;
  }
 
  /**
 * Returns the LinkedQueue overallActions 
 * 
 * @return      overallActions
 */
  public LinkedQueue<String> getOverallActions(){
    return overallActions;
  }
  
 /**
 * Updates the score based on the amount of points in the given node
 * 
 * @param  node, the StoryNode the that the user is on
 */
  public void updateScore(StoryNode node){
    score += node.getValue();
  }
  
 /**
 * Adds the name of the given node to recentActions and keeps the length of recentActions
 * at 5 or less
 * 
 * @param  node, the StoryNode the that the user is on
 */
  public void updateRecentActions(StoryNode node){
    //If the size is 5, removes the oldest move from the list
    if (recentActions.size() == 5){
      recentActions.remove();
    }
    recentActions.add(node.getName()); //Adds the name of the node for user-friendly read out
  }
  

 /**
 * Adds the name of the given node to overallActions if the isImportant booleean for the
 * given node is true
 * 
 * @param  node, the StoryNode the that the user is on
 */
  public void updateOverallActions(StoryNode node){
    if (node.getImportance()){
      overallActions.enqueue(node.getName()); //Adds the name of the node f0r user-friendly read out
    }
  }
  
  //Testing Code
//  public static void main(String[] args){
//    Player wendy = new Player();
//    StoryNode one = new StoryNode("Enter the building", "You walk into the saloon and see lots of stuff", 0, false, "oldWest");
//    StoryNode two = new StoryNode("Talk to bar tender", "He tells you important information", 0, true, "oldWest");
//    StoryNode three = new StoryNode("Drink beer", "You drink beer, the world tilts a little", -2, false,"oldWest");
//    StoryNode four = new StoryNode("Go to Police Station", "You enter the station and see Outlaw", 0, false, "oldWest");
//    StoryNode five = new StoryNode("Interrogate Outlaw", "He spills everything", 0, true,"oldWest");
//    StoryNode six = new StoryNode("Save Deputy", "You untie your deputy from the tracks", 10, true,"oldWest");
//    
//    wendy.updateScore(one);
//    wendy.updateRecentActions(one);
//    wendy.updateOverallActions(one);
//    System.out.println("Score: " + wendy.getScore());
//    System.out.println("Recent Actions:");
//    System.out.println(wendy.getRecentActions().toString());
//    System.out.println("Overall Actions:");
//    System.out.println(wendy.getOverallActions().toString());
//    System.out.println("~~~~");
//    
//    wendy.updateScore(two);
//    wendy.updateRecentActions(two);
//    wendy.updateOverallActions(two);
//    System.out.println("Score: " + wendy.getScore());
//    System.out.println("Recent Actions:");
//    System.out.println(wendy.getRecentActions().toString());
//    System.out.println("Overall Actions:");
//    System.out.println(wendy.getOverallActions().toString());
//    System.out.println("~~~~");
//    
//    wendy.updateScore(three);
//    wendy.updateRecentActions(three);
//    wendy.updateOverallActions(three);
//    System.out.println("Score: " + wendy.getScore());
//    System.out.println("Recent Actions:");
//    System.out.println(wendy.getRecentActions().toString());
//    System.out.println("Overall Actions:");
//    System.out.println(wendy.getOverallActions().toString());
//    System.out.println("~~~~");
//    
//    wendy.updateScore(four);
//    wendy.updateRecentActions(four);
//    wendy.updateOverallActions(four);
//    System.out.println("Score: " + wendy.getScore());
//    System.out.println("Recent Actions:");
//    System.out.println(wendy.getRecentActions().toString());
//    System.out.println("Overall Actions:");
//    System.out.println(wendy.getOverallActions().toString());
//    System.out.println("~~~~");
//    
//    wendy.updateScore(five);
//    wendy.updateRecentActions(five);
//    wendy.updateOverallActions(five);
//    System.out.println("Score: " + wendy.getScore());
//    System.out.println("Recent Actions:");
//    System.out.println(wendy.getRecentActions().toString());
//    System.out.println("Overall Actions:");
//    System.out.println(wendy.getOverallActions().toString());
//    System.out.println("~~~~");
//    
//    wendy.updateScore(six);
//    wendy.updateRecentActions(six);
//    wendy.updateOverallActions(six);
//    System.out.println("Score: " + wendy.getScore());
//    System.out.println("Recent Actions:");
//    System.out.println(wendy.getRecentActions().toString());
//    System.out.println("Overall Actions:");
//    System.out.println(wendy.getOverallActions().toString());
//    System.out.println("~~~~");
//  }

}