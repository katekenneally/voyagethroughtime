//*******************************************************************
//StoryNode.java                   @author Jane Abernathy
//CS230 Final Project Voyage Through Time
//
//Represents a node in the graph of the story. Stores the name of the 
//node, descriptive text for the game user to read, point value to add
//to score, an importance boolean, and the name of an image to 
//display on the GUI.
//
//Primary Coder: Jane
//*******************************************************************

public class StoryNode{

 //Instance Variables
  public String name;
  public String description;
  public int value;
  public boolean isImportant;
  public String image;

  
  /**
   * Constructor, sets the name, description, value, isImportant boolean, and image
   * to be the given values
   */
  public StoryNode (String n,String d, int v, boolean i, String im){
    name = n;
    description = d;
    value = v;
    isImportant = i;
    image = im;
  }
  
 /**
 * Returns the name of the node, String
 * 
 * @return      name
 */
  public String getName()
  {
    return name;
  }
  
/**
 * Returns the description String
 * 
 * @return      description
 */
  public String getDescription()
  {
    return description;
  }
  
/**
 * Returns the value int
 * 
 * @return      value
 */
  public int getValue()
  {
    return value;
  }
  
/**
 * Returns the importance boolean 
 * 
 * @return      isImprtant
 */
  public boolean getImportance()
  {
    return isImportant;
  }
  
 /**
 * Returns the image String 
 * 
 * @return      image
 */
  public String getImage()
  {
    return image;
  }

 /**
 * Returns a string reresentation of the node 
 * 
 * @return      string representation
 */
  public String toString(){
    return "The node name is " + name + "\nThe node descrition is " + description +
      "\nThe value is " +value+ "\nThe node imprtance is " + isImportant +
      "\nThe node image is "+ image;
  }
  
//  public static void main(String[] args) {
//    StoryNode one = new StoryNode("Enter the building", "You walk into the saloon and see lots of stuff", 0, false, "oldWest");
//    //System.out.println(one);
//    System.out.println(one.getName());
//    System.out.println(one.getDescription());
//    System.out.println(one.getValue());
//    System.out.println(one.getImportance());
//    System.out.println(one.getImage());
//  }
}