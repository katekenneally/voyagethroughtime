//*******************************************************************
//StoryGraph.java                 @author Jane Abernathy
//CS230 Final Project Voyage Through Time
//
//Extends AdjmatGraph has methods to check if a node is the end of the 
//story, to find a node given its name, and to assign multiple deccendants 
//at once
//
//Primary Coder: Jane
//*******************************************************************
import java.util.LinkedList;

public class StoryGraph<T> extends AdjMatGraph<T> implements Graph<T> {
  
   /**
   * Constructor, uses the constructor from AdjMatGraph
   */
  public StoryGraph() {
    super();
  }

  /******************************************************************
    * Checks if the given node (vertex) is the end of the story (points 
    * to no other vertex)
    * 
    * @param vertex: the potential end node
    * @return true if the node is an end, false if it is not.
    * @throws IllegalArgumentException if given vertex is not in graph
    ******************************************************************/
  public boolean isEndNode(T vertex) throws IllegalArgumentException{
    //as long as the index is within the apropriate range
    if(indexIsValid(getIndex(vertex))){
      //check if vertex has successors, will return true if no successors
      return getSuccessors(vertex).isEmpty();
    }else{
      throw new IllegalArgumentException();
    }
  }
  
    /******************************************************************
    * Checks if the given String (string) is the name of any of the nodes
    * in the given linked list (options)
    * 
    * @param string: the name of a vertex you are looking for
    * @param options: a linkedList of StoryNodes to look through
    * @return the node if found, null if not found
    ******************************************************************/
  public static StoryNode getNodeByName(String string, LinkedList<StoryNode> options){
    //loops through options
    for (int i = 0 ;i<options.size();i++){
      //if the option name is the same as the string
      if (options.get(i).getName().equals(string)){
        //return the node
        return options.get(i);
      }
    }
    //if no node is found return null
    return null;
  }
  
  
  /******************************************************************
    * Adds arcs from the origin node to four other given nodes
    * 
    * @param origin: the node for which you would like to set decendants
    * @param node1: a node to be a decendant
    * @param node2: a node to be a decendant
    * @param node3: a node to be a decendant
    * @param node4: a node to be a decendant
    ******************************************************************/  
  public void setLinks(T origin, T node1, T node2, T node3, T node4){
    addArc(origin, node1);
    addArc(origin, node2);
    addArc(origin, node3);
    addArc(origin, node4);
  }


//    public static void main(String[] args) {
//      StoryNode one = new StoryNode("Enter the building", "You walk into the saloon and see lots of stuff", 0, false, "oldWest");
//      StoryNode two = new StoryNode("Talk to bar tender", "He tells you important information", 0, false, "oldWest");
//      StoryNode three = new StoryNode("Drink beer", "You drink beer, the world tilts a little", 0, false,"oldWest");
//      StoryGraph<StoryNode> game = new StoryGraph<StoryNode>();
//      
//      game.addVertex(one);
//      game.addVertex(two);
//      game.addVertex(three);
//      game.setLinks(one,two, three,null,null);
//      
//      
//      System.out.println(game.isEndNode(two));
//      System.out.println(game.getSuccessors(one));
//      
//      System.out.println(game.getNodeByName("Talk to bar tender", game.getSuccessors(one)));
//    }
}
