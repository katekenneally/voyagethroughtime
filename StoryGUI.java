//*******************************************************************
//StoryGUI.java                 @author Kate Kenneally
//CS230 Final Project Voyage Through Time
//
//Graphical User Interface for the game. Gathers information from other
//classes.
//
//Primary Coder: Kate
//*******************************************************************

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StoryGUI {
  
  public static void main(String[] args) {
    
    // Create JFrame
    JFrame frame = new JFrame("VOYAGE THROUGH TIME");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    // Create new Player object and StoryGraph object
    Player wendy = new Player();
    StoryGraph<StoryNode> game = new StoryGraph<StoryNode>();
    
    // NODES (Creating StoryNodes and adding vertices to StoryGraph)
    
    StoryNode s1 = new StoryNode("Start", "<HTML>You are Captain Janeway of the USS Voyager. You are on a totally normal routine mission in the Delta Quadrant." +
                                 "<br><br>\"Captain! There is a giant space-time anomaly fifteen degrees of starboard!\"<br><br>\"On screen,\" you command. On the viewscreen, there is a giant wormhole."+
                                 "<br><br>\"Captain, we are caught within its gravitational grasp! What should we do?\"</HTML>", 0, true, "voyager.jpg");
    
    game.addVertex(s1);
    
    StoryNode s2 = new StoryNode("Fly into anomaly", "<HTML>\"Set course for the anomaly,\" you calmly command.<br><br>\"Captain?\"<br><br>"+
                                 "\"We are within its event horizon - there's no way that we'll be able to avoid getting sucked in. We might as well make sure that "+
                                 "our ship isn't unduly damaged when we get to the other side.\"<br><br>\"Right away, Captain.\" As you get closer and closer to the anomaly, "+
                                 "things get weirder and weirder until you are not quite sure if you are awake or dreaming and then-<br><br>Black.</HTML>", 0, true, "voyager.jpg");
    
    game.addVertex(s2);
    
    StoryNode s3 = new StoryNode("Turn around and eject warp cores", "<HTML>\"Turn us around right now!\" Your pilot hastens to comply. Stress "+
                                 "cracks appear in ship around you and the klaxons start ringing.<br><br>You press a button. \"Janeway to Engineering.\"<br><br>\"Yes, Captain?\"<br><br>"+
                                 "\"Eject the warp cores.\"<br><br>\"Are you sure, captain?\"<br><br>\"The resulting explosion should be enough to push us out of the anomaly.\"<br><br>"+
                                 "Everyone stares at you incredulously.<br><br>\"Hey, if it worked for Kirk, it could work for us. Just do it!\"<br><br>\"Yes, Captain!\"<br><br>"+
                                 "\"Eject the cores!\" you command. However, you must have miscalculated. The resulting explosion does not push you to safety. Instead, "+
                                 "it rips through your ship - and all you know is the silence of space.<br><br>----<br><br>Congratulations, you have killed yourself and " +
                                 "everyone on your ship.</HTML>", -1000, true, "voyager.jpg");
    
    game.addVertex(s3);
    
    StoryNode s4 = new StoryNode("Turn around and get the heck out of there", "<HTML>\"Turn us around right now!\" Your pilot hastens to comply.<br><br>"+
                                 "\"Maximum warp. Get us out of here.\" Stress cracks appear in the ship around you and the klaxons start ringing. Even with your ship straining "+
                                 "with everything she has, it is still not enough. Little by little, your ship gets dragged towards the anomaly. As you get closer and closer "+
                                 "to the anomaly, things get weirder and weirder until you are not quite sure if you are awake or dreaming and then-<br><br>Black.</HTML>", 0, true, "voyager.jpg");
    
    game.addVertex(s4);
    
    StoryNode s5 = new StoryNode("Panic","<HTML>It might be embarrassing to admit, but you are frozen. Your mind is blank. You can't possibly think of a way "+
                                 "out of this situation. Stress cracks appear in the ship around you and the klaxons start ringing. You should be doing something. Anything. But you "+
                                 "are doing nothing. As you get closer and closer to the anomaly, things get weirder and weirder until you are not quite sure if you are awake "+
                                 "or dreaming and then-<br><br>Black.</HTML>",-5,true, "voyager.jpg");
    
    game.addVertex(s5);
    
    StoryNode w1 = new StoryNode("Continue","<HTML>You are Sheriff Janeway of the small town of Voyager, set in the wild, wild west. You are currently in a "+
                                 "small interrogation room in your police station.<br><br>In front of you shackled to the table is the infamous outlaw, Romeo Outlaw. He sure lived up to his name.</HTML>",
                                 0,false, "west.jpg");
    
    game.addVertex(w1);
    
    StoryNode w2 = new StoryNode("Continue","<HTML>You are Sheriff Janeway of the small town of Voyager, set in the wild, wild west. You are currently standing "+
                                 "in the main street of your town. There are a couple people milling about. There is a railroad station at the end of the road.<br><br>On the nearby bulletin "+
                                 "board, you see a flyer advertising a duel between some guys named Hamilton and Burr. You feel as though you should know who they are, but it escapes "+
                                 "you. You really want to go and get a drink, but you should probably be interrogating your prisoner.</HTML>", 0, false, "west.jpg");
    
    
    game.addVertex(w2);
    
    StoryNode w3 = new StoryNode("Continue", "<HTML>You are Sheriff Janeway of the small town of Voyager, set in the wild, wild west. You are currently in your "+
                                 "town's saloon, drinking beer after beer. For some reason you feel like you've just narrowly avoided death. You are just a little bit tipsy.</HTML>",0,false,"west.jpg");
    
    
    game.addVertex(w3);
    
    StoryNode wPMS1 = new StoryNode("Go to Main Street", "<HTML>You are currently standing in the main street of your town. There are a couple people milling about."+
                                    " There is a railroad station at the end of the road.<br><br>On the nearby bulletin board, you see a flyer advertising a duel between"+
                                    " some guys named Hamilton and Burr. You feel as though you should know who they are, but it escapes you.<br><br>The world sways around you.",0,false,"west.jpg");
    
    game.addVertex(wPMS1);
    
    StoryNode wPBar1 = new StoryNode("Talk to Bartender", "<HTML>\"Hey Sheriff, how are things?\"<br><br>You say that things could be worse. Somehow, you really, really believe it."+
                                     " He agrees. The world dulls then brightens.</HMTL>", 0, true, "west.jpg");
    
    game.addVertex(wPBar1);
    
    StoryNode wPDB1 = new StoryNode("Drink Beer", "<HTML>You ask the Bartender for a beer. He looks at you a bit weirdly.<br><br>\"Are you sure you should be be drinking?\"<br><br>"+
                                    "You tell him to give you your beer. He hands it over. It tastes great. The world wavers.</HTML>", -2, false, "west.jpg");
    
    game.addVertex(wPDB1);
    
    StoryNode wPS1 = new StoryNode("Go to Saloon", "<HTML>You are in the saloon. It is dark and dingy. There is a low murmur of chatter. The world tilts a little.</HTML>",0,false,"west.jpg");
    
    StoryNode wPPS1 = new StoryNode("Go to Police Station", "<HTML>You are in a small interrogation room in your police station.<br><br>In front of you shackled to the table is the infamous outlaw, Romeo Outlaw."+
                                    " He sure lived up to his name. The room tilts.</HTML>", 0, false, "west.jpg");
    
    game.addVertex(wPPS1);
    
    StoryNode wPRR1 = new StoryNode("Go to Railroad", "<HTML>The tracks seem to strech endlessly in both directions. There is nothing else here."+
                                    " The world seems to elongate and then snaps back.</HTML>",0,false,"west.jpg");
    
    game.addVertex(wPRR1);
    
    StoryNode wPBar2 = new StoryNode("Talk to Bartender", "<HTML>\"Have you heard about the upcoming duel between Hamilton and Burr? Apparently they used to be friends.\"<br><br>"+
                                     "You nod in apparent interest.</HTML>",0,true,"west.jpg");
    
    game.addVertex(wPBar2);
    
    StoryNode wPMS2 = new StoryNode("Go to Main Street", "<HTML>You are currently standing in the main street of your town. There are a couple people milling about."+
                                    " There is a railroad station at the end of the road.<br><br>On the nearby bulletin board, you see a flyer advertising a duel between some guys named Hamilton and Burr."+
                                    " You feel as though you should know who they are, but it escapes you.<br><br>The world sways around you.</HTML>", 0, false, "west.jpg");
    
    game.addVertex(wPMS2);
    
    StoryNode wPDB2 = new StoryNode("Drink Beer", "<HTML>You ask the Bartender for a beer. He looks at you a bit weirdly.<br><br>\"Are you sure you should be be drinking?\"<br><br>"+
                                    "You tell him to give you your beer. He hands it over. It tastes great. The world wavers.</HTML>", -2, false, "west.jpg");
    
    game.addVertex(wPDB2);
    
    StoryNode wPIO1a = new StoryNode("Interrogate Outlaw", "<HTML>He sneers at you but talks.<br><br>\"My lovely wife Juliet has captured your Deputy, Chakotay, and is planning on tying"+
                                     " him up on the railroad tracks to get run over!\"</HTML>", 0, true, "west.jpg");
    
    game.addVertex(wPIO1a);
    
    StoryNode wPIO1b = new StoryNode("Interrogate Outlaw", "<HTML>He sneers at you.<br><br>\"I have nothing more to say.\"</HTML>", 0, false, "west.jpg");
    
    game.addVertex(wPIO1b);
    
    StoryNode wPMS3 = new StoryNode("Go to Main Street", "<HTML>You are currently standing in the main street of your town. There are a couple people milling about."+
                                    " There is a railroad station at the end of the road.<br><br>On the nearby bulletin board, you see a flyer advertising a duel between some guys named Hamilton and Burr."+
                                    " You feel as though you should know who they are, but it escapes you.<br><br>The world sways around you.</HTML>", 0, false, "west.jpg");
    
    game.addVertex(wPMS3);
    
    StoryNode wPPS2 = new StoryNode("Go to Police Station", "<HTML>You are in a small interrogation room in your police station.<br><br>In front of you shackled to the table is the infamous outlaw, Romeo Outlaw."+
                                    " He sure lived up to his name. The room tilts.</HTML>", 0, false, "west.jpg");
    
    game.addVertex(wPPS2);
    
    StoryNode wPS2 = new StoryNode("Go to Saloon", "<HTML>You are in the saloon. It is dark and dingy. There is a low murmur of chatter. The world tilts a little.</HTML>",0,false,"west.jpg");
    
    game.addVertex(wPS2);
    
    StoryNode wPRR2 = new StoryNode("Go to Railroad", "<HTML>The tracks seem to strech endlessly in both directions. There is nothing else here."+
                                    " The world seems to elongate and then snaps back.</HTML>",0,false,"west.jpg");
    
    game.addVertex(wPRR2);
    
    StoryNode wPMS4 = new StoryNode("Go to Main Street", "<HTML>You are currently standing in the main street of your town. There are a couple people milling about."+
                                    " There is a railroad station at the end of the road.<br><br>On the nearby bulletin board, you see a flyer advertising a duel between some guys named Hamilton and Burr."+
                                    " You feel as though you should know who they are but it escapes you.<br><br>You hear the sound of screeching in the direction of the railroad.<br><br>"+
                                    "The world spins around you and you fall to the ground. You end up hitting your head on a hitching post, and all you know is- <br><br>Black.</HTML>", 0, true, "west.jpg");
    
    game.addVertex(wPMS4);
    
    StoryNode wPDB3 = new StoryNode("Drink Beer", "<HTML>You ask the Bartender for a beer. He looks at you a bit weirdly.<br><br>\"Are you sure you should be be drinking?\"<br><br>"+
                                    "You tell him to give you your beer. He hands it over. It tastes great. The world wavers.</HTML>", -2, false, "west.jpg");
    
    game.addVertex(wPDB3);
    
    StoryNode wPBar3 = new StoryNode("Talk to Bartender", "<HTML>\"You know Sheriff, I've heard that Juliet Outlaw is in town. Something about avenging her husband-\"<br><br>"+
                                     "Faintly, you hear a high-pitched screeching noise.<br><br>\"That didn't sound good. You should probably check it out.\"<br><br>"+
                                     "You nod and make to stand up, but the world spins and you manage to bash your head against the edge of the bar. All you can see is-<br><br>"+
                                     "Black.</HTML>", 0, true, "west.jpg");
    
    game.addVertex(wPBar3);
    
    StoryNode wPRR3 = new StoryNode("Go to Railroad", "<HTML>The tracks seem to strech endlessly in both directions. Your deputy is tied to the tracks. In the distance, there is a train approaching."+
                                    " Juliet is there, laughing at Chakotay. The world seems to elongate and then snaps back.</HTML>", 0, true, "west.jpg");
    
    game.addVertex(wPRR3);
    
    StoryNode wPPS3 = new StoryNode("Go to Police Station", "<HTML>You are in a small interrogation room in your police station.<br><br>In front of you shackled to the table is the infamous outlaw, Romeo Outlaw."+
                                    " He sure lived up to his name. The room tilts.</HTML>", 0, false, "west.jpg");
    
    game.addVertex(wPPS3);
    
    StoryNode wPS3 = new StoryNode("Go to Saloon", "<HTML>You are in the saloon. It is dark and dingy. There is a low murmur of chatter. The Bartender isn't there. The world tilts a little.</HTML>", 0, false, "west.jpg");
    
    game.addVertex(wPS3);
    
    StoryNode wPDB4 = new StoryNode("Drink Beer", "<HTML>You go behind the bar and help yourself to a beer. Surely, the bartender won't mind. The world tilts.</HTML>", -2, false, "west.jpg");
    
    game.addVertex(wPDB4);
    
    StoryNode wPSC1 = new StoryNode("Save Chakotay", "<HTML>You stagger towards him. Juliet takes this wonderful opportunity to run away.<br><br>You fumble with the ropes tying him to the tracks."+
                                    " Somehow, you untie him and roll him out of the way.<br><br>You manage to walk off the tracks yourself, but the world spins, you fall down, and all you know is-<br><br>"+
                                    "Black.</HTML>", 10, true, "west.jpg");
    
    game.addVertex(wPSC1);
    
    StoryNode wPAJ1 = new StoryNode("Arrest Juliet", "<HTML>You stagger towards her. She throws a punch at you and tries to get away.<br><br>In a stunning example of the Drunken Fist, you lean around "+
                                    "her punch and deck her. You handcuff her, and then feetcuff her for good measure.<br><br>There is a train approaching.</HTML>", 10, true, "west.jpg");
    
    game.addVertex(wPAJ1);
    
    StoryNode wPSC2 = new StoryNode("Save Chakotay", "<HTML>You stagger torwards him.<br><br>You fumble with the ropes tying him to the tracks. Eventually you are able to move him. "+
                                    "You haul him and yourself off the tracks in the nick of time, but the train clips you and sends you flying.<br><br>You hit the ground hard, and all you can see is-<br><br>"+
                                    "Black.</HTML>", 10, true, "west.jpg");
    
    game.addVertex(wPSC2);
    
    StoryNode wPTJ1 = new StoryNode("Throw Juliet in Jail", "<HTML>Ignoring the guy on the tracks, you haul Juliet onto your shoulder and stagger back to town."+
                                    " She would look good in a cell next to her husband, you think.<br><br>Behind you, you faintly hear a high-pitched screeching noise.<br><br>"+
                                    "You over-estimated your strength at this point, however, and the world spins around you as you fall down. You manage to bash heads with Juliet, and all you know is-"+
                                    "<br><br>Black.</HTML>", 0, false, "west.jpg");
    
    game.addVertex(wPTJ1);
    
    StoryNode wPIO2a = new StoryNode("Interrogate Outlaw", "<HTML>He sneers at you but talks.<br><br>\"My lovely wife Juliet has captured your Deputy, Chakotay, and is planning on tying"+
                                     " him up on the railroad tracks to get run over!\"</HTML>", 0, true, "west.jpg");
    
    game.addVertex(wPIO2a);
    
    StoryNode wPIO2b = new StoryNode("Interrogate Outlaw", "<HTML>He sneers at you.<br><br>\"I have nothing more to say.\"</HTML>", 0, false, "west.jpg");
    
    game.addVertex(wPIO2b);
    
    StoryNode wPMS5 = new StoryNode("Go to Main Street", "<HTML>You are currently standing in the main street of your town. There are a couple people milling about."+
                                    " There is a railroad station at the end of the road.<br><br> On the nearby bulletin board, you see a flyer advertising a duel between"+
                                    " some guys named Hamilton and Burr. You feel as though you should know who they are, but it escapes you.<br><br>The world sways around you.",0,false,"west.jpg");
    
    game.addVertex(wPMS5);
    
    StoryNode wPPS4 = new StoryNode("Go to Police Station", "<HTML>You are in a small interrogation room in your police station.<br><br>In front of you shackled to the table is the infamous outlaw, Romeo Outlaw."+
                                    " He sure lived up to his name. The room tilts.</HTML>", 0, false, "west.jpg");
    
    game.addVertex(wPPS4);
    
    StoryNode wPRR4 = new StoryNode("Go to Railroad", "<HTML>The tracks seem to strech endlessly in both directions. Your deputy is tied to the tracks. There is a train approaching."+
                                    " Juliet is nowhere to be seen. The world seems to elongate and then snaps back.</HTML>", 0, true, "west.jpg");
    
    game.addVertex(wPRR4);
    
    StoryNode wPS4 = new StoryNode("Go to Saloon", "<HTML>You are in the saloon. It is dark and dingy. There is a low murmur of chatter. Juliet is sitting there.<br><br>She laughs at you. "+
                                   "\"If you arrest me now, you won't have time to save your dear deputy.\"<br><br>The world tilts a little.</HTML>",0,false, "west.jpg");
    
    game.addVertex(wPS4);
    
    StoryNode wPDN1 = new StoryNode("Do Nothing", "<HTML>You freeze. There is a terrible screech of brakes and a muffled thump. You idly observe that there is a lot of blood."+
                                    " Juliet must have gotten away by now.<br><br>The world spins around you and you fall down and there is only-<br><br>Black.</HTML>", 0, true, "west.jpg");
    
    game.addVertex(wPDN1);
    
    StoryNode wPSC3 = new StoryNode("Save Chakotay", "<HTML>You staggar towards him.<br><br>You fumble with the ropes tying him to the tracks."+
                                    " Eventually you get him free, but the train is fast approaching. You shove him out of the way. The world spins and you fall in the process."+
                                    " Before you can get up, all you can hear is the screech of brakes and everything goes-<br><br>Black.</HTML>", 10, true, "west.jpg");
    
    game.addVertex(wPSC3);
    
    StoryNode wPAJ2 = new StoryNode("Arrest Juliet", "<HTML>You stagger towards her.<br><br>\"You're under arrest,\" you tell her. She darts around you, but one of the other people in the saloon stops her for you."+
                                    "<br><br>Suddenly, there is a screech of brakes outside. You get a bad feeling. The world spins and everything goes-<br><br>Black.</HTML>", 10, true, "west.jpg");
    
    game.addVertex(wPAJ2);
    
    StoryNode wIO1a = new StoryNode("Interrogate Outlaw", "<HTML>Cowering in front of your mighty presence, he talks.<br><br>\"My lovely wife Juliet has captured your Deputy, Chakotay, and is planning on tying"+
                                    " him up on the railroad tracks to get run over!\"</HTML>", 0, true, "west.jpg");
    
    game.addVertex(wIO1a);
    
    StoryNode wMS1 = new StoryNode("Go to Main Street", "<HTML>You are standing in the main street of your town. There are a couple people milling about. There is a railroad station at the end of the road.<br><br>"+
                                   "On the nearby bulletin board, you see a flyer advertising a duel between some guys named Hamilton and Burr."+
                                   " You feel as though you should know who they are, but it escapes you.</HTML>", 0, false, "west.jpg");
    
    game.addVertex(wMS1);
    
    StoryNode wPolS1 = new StoryNode("Go to Police Station", "<HTML>You are in a small interrogation room in your police station.<br><br>In front of you shackled to the table is the infamous outlaw, Romeo Outlaw."+
                                     " He sure lived up to his name.</HTML>",0, false, "west.jpg");
    
    game.addVertex(wPolS1);
    
    StoryNode wRR1 = new StoryNode("Go to Railroad", "<HTML>The tracks seem to strech endlessly in both directions. There is nothing else here.</HTML>",0,false,"west.jpg");
    
    game.addVertex(wRR1);
    
    StoryNode wS1 = new StoryNode("Go to Saloon", "<HTML>You are in the saloon. It is dark and dingy. There is a low murmur of chatter.</HTML>", 0, false, "west.jpg");
    
    game.addVertex(wS1);
    
    StoryNode wIO1b = new StoryNode("Interrogate Outlaw", "<HTML>He cowers in front of you.<br><br>\"I have nothing else, I swear!\"</HTML>",0,false,"west.jpg");
    
    game.addVertex(wIO1b);
    
    StoryNode wMS2 = new StoryNode("Go to Main Street", "<HTML>You are standing in the main street of your town. There are a couple people milling about. There is a railroad station at the end of the road.<br><br>"+
                                   "On the nearby bulletin board, you see a flyer advertising a duel between some guys named Hamilton and Burr."+
                                   " You feel as though you should know who they are, but it escapes you.</HTML>", 0, false, "west.jpg");
    
    game.addVertex(wMS2);
    
    StoryNode wPolS2 = new StoryNode("Go to Police Station", "<HTML>You are in a small interrogation room in your police station.<br><br>In front of you shackled to the table is the infamous outlaw, Romeo Outlaw."+
                                     " He sure lived up to his name.</HTML>",0, false, "west.jpg");
    
    game.addVertex(wPolS2);
    
    StoryNode wS2 = new StoryNode("Go to Saloon", "<HTML>You are in the saloon. It is dark and dingy. There is a low murmur of chatter. The Bartender isn't there.</HTML>", 0, false, "west.jpg");
    
    game.addVertex(wS2);
    
    StoryNode wRR2 = new StoryNode("Go to Railroad", "<HTML>The tracks seem to strech endlessly in both directions. Juliet Outlaw is in the process of tying Chakotay to the tracks.</HTML>", 0, true, "west.jpg");
    
    game.addVertex(wRR2);
    
    StoryNode wSC1 = new StoryNode("Save Chakotay", "<HTML>You make your way to Chakotay. With expert hands, you deftly untie the knots binding him to the tracks."+
                                   " After pulling him out of the way, you stand up and notice that Juliet is nowhere to be seen. It seems as through she took advantage of the diversion and ran.<br><br>"+
                                   "The world wavers around you and then starts to melt away, leaving only-<br><br>Black.</HTML>",10,true,"west.jpg");
    
    game.addVertex(wSC1);
    
    StoryNode wAJ1 = new StoryNode("Arrest Juliet", "<HTML>You make your way torwards Juliet. She tries to run for it, but you manage to overtake her and tackle her to the ground."+
                                   " You handcuff her, and feet-cuff her too for good measure.</HTML>", 10, true, "west.jpg");
    
    game.addVertex(wAJ1);
    
    StoryNode wSC2 = new StoryNode("Save Chakotay", "<HTML>You make your way to Chakotay. With expert hands, you deftly untie the knots binding him to the tracks. You haul him away from the tracks.<br><br>"+
                                   "The world wavers around you and then starts to melt away, leaving only-<br><br>Black.</HTML>",10,true,"west.jpg");
    
    game.addVertex(wSC2);
    
    StoryNode wBar1 = new StoryNode("Talk to Bartender", "<HTML>\"Hey Sheriff, how are things?\"<br><br>You say that things could be worse. He agrees.</HTML>", 0, true, "west.jpg");
    
    game.addVertex(wBar1);
    
    StoryNode wMS3 = new StoryNode("Go to Main Street", "<HTML>You are standing in the main street of your town. There are a couple people milling about. There is a railroad station at the end of the road.<br><br>"+
                                   "On the nearby bulletin board, you see a flyer advertising a duel between some guys named Hamilton and Burr."+
                                   " You feel as though you should know who they are, but it escapes you.</HTML>", 0, false, "west.jpg");
    
    game.addVertex(wMS3);
    
    StoryNode wBar2 = new StoryNode("Talk to Bartender", "<HTML>\"Have you heard about the upcoming duel between Hamilton and Burr? Apparently they used to be friends.\"<br><br>"+
                                    "You nod in apparent interest.</HTML>", 0, true, "west.jpg");
    
    game.addVertex(wBar2);
    
    StoryNode wRR3 = new StoryNode("Go to Railroad", "<HTML>The tracks seem to strech endlessly in both directions. There is nothing else here.</HTML>",0,false,"west.jpg");
    
    game.addVertex(wRR3);
    
    StoryNode wPolS3 = new StoryNode("Go to Police Station", "<HTML>You are in a small interrogation room in your police station.<br><br>In front of you shackled to the table is the infamous outlaw, Romeo Outlaw."+
                                     " He sure lived up to his name.</HTML>",0, false, "west.jpg");
    
    game.addVertex(wPolS3);
    
    StoryNode wS3 = new StoryNode("Go to Saloon", "<HTML>You are in the saloon. It is dark and dingy. There is a low murmur of chatter.</HTML>", 0, false, "west.jpg");
    
    game.addVertex(wS3);
    
    StoryNode wIO2a = new StoryNode("Interrogate Outlaw", "<HTML>Cowering infront of your mighty presence, he talks.<br><br>\"My lovely wife Juliet has captured your Deputy, Chakotay, and is planning on tying"+
                                    " him up on the railroad tracks to get run over!\"</HTML>", 0, true, "west.jpg");
    
    game.addVertex(wIO2a);
    
    StoryNode wIO2b = new StoryNode("Interrogate Outlaw", "<HTML>He cowers in front of you.<br><br>\"I have nothing else, I swear!\"</HTML>",0,false,"west.jpg");
    
    game.addVertex(wIO2b);
    
    StoryNode wMS4 = new StoryNode("Go to Main Street", "<HTML>You are standing in the main street of your town. There are a couple people milling about. There is a railroad station at the end of the road.<br><br>"+
                                   "On the nearby bulletin board, you see a flyer advertising a duel between some guys named Hamilton and Burr."+
                                   " You feel as though you should know who they are, but it escapes you.</HTML>", 0, false, "west.jpg");
    
    game.addVertex(wMS4);
    
    StoryNode wPolS4 = new StoryNode("Go to Police Station", "<HTML>You are in a small interrogation room in your police station.<br><br>In front of you shackled to the table is the infamous outlaw, Romeo Outlaw."+
                                     " He sure lived up to his name.</HTML>",0, false, "west.jpg");
    
    game.addVertex(wPolS4);
    
    StoryNode wRR4 = new StoryNode("Go to Railroad", "<HTML>The tracks seem to strech endlessly in both directions. Your deputy is tied to the tracks. In the distance, there is a train approaching."+
                                   " Juliet is there, laughing at Chakotay.</HTML>",0,true,"west.jpg");
    game.addVertex(wRR4);
    
    StoryNode wS4 = new StoryNode("Go to Saloon", "<HTML>You are in the saloon. It is dark and dingy. There is a low murmur of chatter.</HTML>", 0, false, "west.jpg");
    
    game.addVertex(wS4);
    
    StoryNode wAJ2 = new StoryNode("Arrest Juliet", "<HTML>You make your way torwards Juliet. She tries to run for it, but you manage to overtake her and tackle her to the ground."+
                                   " You handcuff her, and feet-cuff her too for good measure.<br><br>Distantly, a train approaches.</HTML>",10,true,"west.jpg");
    
    game.addVertex(wAJ2);
    
    StoryNode wDB1 = new StoryNode("Drink Beer", "<HTML>You ask the Bartender for a beer. He looks at you a bit weirdly.<br><br>\"Are you sure you should be drinking?\"<br><br>You tell him to give you your beer."+
                                   " He hands it over. It tastes great. The world wavers.</HTML>",-2, false, "west.jpg");
    
    game.addVertex(wDB1);
    
    StoryNode wBar3 = new StoryNode("Talk to Bartender", "<HTML>\"You know, Sheriff, I heard that Juliet Outlaw is in town. Something about avenging her husband? There was a bit of a commontion earlier."+
                                    " I think she was dragging something torwards the railroad.\"<br><br>You thank him. Someone walks into the bar.</HTML>",0,true,"west.jpg");
    
    game.addVertex(wBar3);
    
    StoryNode wMS5 = new StoryNode("Go to Main Street", "<HTML>You are standing in the main street of your town. There are a couple people milling about. There is a railroad station at the end of the road.<br><br>"+
                                   "On the nearby bulletin board, you see a flyer advertising a duel between some guys named Hamilton and Burr."+
                                   " You feel as though you should know who they are, but it escapes you.</HTML>", 0, false, "west.jpg");
    
    game.addVertex(wMS5);
    
    StoryNode wMS6 = new StoryNode("Go to Main Street", "<HTML>You are standing in the main street of your town. There are a couple people milling about. There is a railroad station at the end of the road.<br><br>"+
                                   "On the nearby bulletin board, you see a flyer advertising a duel between some guys named Hamilton and Burr."+
                                   " You feel as though you should know who they are, but it escapes you.</HTML>", 0, false, "west.jpg");
    
    game.addVertex(wMS6);
    
    StoryNode wRR5 = new StoryNode("Go to Railroad", "<HTML>The tracks seem to strech endlessly in both directions. Your deputy is tied to the tracks. There is a train approaching."+
                                   " Juliet is nowhere to be seen.</HTML>", 0, true, "west.jpg");
    
    game.addVertex(wRR5);
    
    StoryNode wS5 = new StoryNode("Go to Saloon", "<HTML>You are in the saloon. It is dark and dingy. There is a low murmur of chatter. Juliet is sitting there.<br><br>She laughs at you. "+
                                  "\"If you arrest me now, you won't have time to save your dear deputy.\"</HTML>",0,true,"west.jpg");
    
    game.addVertex(wS5);
    
    StoryNode wSC3 = new StoryNode("Save Chakotay", "<HTML>You make your way to Chakotay. With expert hands, you deftly untie the knots binding him to the tracks and haul him away."+
                                   " The train rushes by you, whipping your hair around. Juliet must have escaped by now.<br><br>The world wavers around you and then starts to melt away, leaving only-<br><br>"+
                                   "Black.</HTML>", 10, true, "west.jpg");
    
    game.addVertex(wSC3);
    
    StoryNode wAJ3 = new StoryNode("Arrest Juliet", "<HTML>\"You're under arrest,\" you tell her. She tries to dart around you, but you are too quick and catch her.<br><br>"+
                                   " Suddenly, there is a screech of brakes outside. You get a bad feeling. The world wavers around you and then starts to melt away, leaving only-<br><br>Black.</HTML>",10,true,"west.jpg");
    
    game.addVertex(wAJ3);
    
    StoryNode wS6 = new StoryNode("Go to Saloon", "<HTML>You are in the saloon. It is dark and dingy. There is a low murmur of chatter.</HTML>", 0, false, "west.jpg");
    
    game.addVertex(wS6);
    
    StoryNode wRR6 = new StoryNode("Go to Railroad", "<HTML>The tracks seem to strech endlessly in both directions. There is nothing else here.</HTML>",0,false,"west.jpg");
    
    game.addVertex(wRR6);
    
    StoryNode wPolS5 = new StoryNode("Go to Police Station", "<HTML>You are in a small interrogation room in your police station.<br><br>In front of you shackled to the table is the infamous outlaw, Romeo Outlaw."+
                                     " He sure lived up to his name.</HTML>",0, false, "west.jpg");
    
    game.addVertex(wPolS5);
    
    StoryNode wIO3a = new StoryNode("Interrogate Outlaw", "<HTML>Cowering infront of your mighty presence, he talks.<br><br>\"My lovely wife Juliet has captured your Deputy, Chakotay, and is planning on tying"+
                                    " him up on the railroad tracks to get run over!\"</HTML>", 0, true, "west.jpg");
    
    game.addVertex(wIO3a);
    
    StoryNode wIO3b = new StoryNode("Interrogate Outlaw", "<HTML>He cowers in front of you.<br><br>\"I have nothing else, I swear!\"</HTML>",0,false,"west.jpg");
    
    game.addVertex(wIO3b);
    
    StoryNode wMS7 = new StoryNode("Go to Main Street", "<HTML>You are standing in the main street of your town. There are a couple people milling about. There is a railroad station at the end of the road.<br><br>"+
                                   "On the nearby bulletin board, you see a flyer advertising a duel between some guys named Hamilton and Burr."+
                                   " You feel as though you should know who they are, but it escapes you.</HTML>", 0, false, "west.jpg");
    
    game.addVertex(wMS7);
    
    
    StoryNode wRR7 = new StoryNode("Go to Railroad", "<HTML>The tracks seem to strech endlessly in both directions. Your deputy is tied to the tracks. There is a train fast approaching."+
                                   " Juliet is nowhere to be seen.</HTML>", 0, true, "west.jpg");
    
    game.addVertex(wRR7);
    
    StoryNode wSC4 = new StoryNode("Save Chakotay", "<HTML>You make your way to Chakotay. With expert hands, you deftly untie the knots binding him to the tracks and haul him away."+
                                   " The train rushes by you, just clipping you, and sends you flying. Juliet must have escaped by now.<br><br>You hit your head hard, and the world crashes around you, leaving only-"+
                                   "<br><br>Black.</HTML>",10,true,"west.jpg");
    
    game.addVertex(wSC4);
    
    StoryNode m1 = new StoryNode("Continue", "<HTML>You are Princess Janeway of Castle Voyager. You have been awakened quite "+
                                 "rudely by some sort of loud crashing and roaring coming from outside the castle. Honestly, don't "+
                                 "they know you're trying to sleep?</HTML>", 0, false, "castle.jpg");
    game.addVertex(m1);
    
    StoryNode ms1 = new StoryNode("Go back to sleep", "<HTML>Groaning, you pull your pillow over your head and try to go "+
                                  "back to sleep. You just know that this is going to be a bad day. The annoying crashing "+
                                  "and roaring sounds don't stop.</HTML>", 0, false, "castle.jpg");
    game.addVertex(ms1);
    
    StoryNode ms2 = new StoryNode("Look out of the window", "<HTML>You get up and make your way over to the small arrow "+
                                  "slit in the wall that is your window. Obviously, a larger window would just be a security "+
                                  "risk, but you can't help but wish for a moment that your window was a bit larger so you "+
                                  "could see a bit more.<br><br>The noises are a little louder here, and you can clearly hear, if "+
                                  "not see, that there is some sort of battle going on.</HTML>", 0, false, "castle.jpg");
    game.addVertex(ms2);
    
    StoryNode mex1 = new StoryNode("Explore the castle", "<HTML>You walk into your council room. Tuvok is there, looking as "+
                                   "stoic as ever.</HTML>", 0, false, "castle.jpg");
    game.addVertex(mex1);
    
    StoryNode mex2 = new StoryNode("Explore the castle", "<HTML>You enter the armory. B'Elanna Torres is there, checking over "+
                                   "the various equipment, deep frown lines marking her brow.</HTML>", 0, false, "castle.jpg");
    game.addVertex(mex2);
    
    StoryNode mex3 = new StoryNode("Explore the castle", "<HTML>You enter the kitchens. Neelix is there, starting to cook "+
                                   "breakfast.</HTML>", 0, false, "castle.jpg");
    game.addVertex(mex3);
    
    StoryNode mex4 = new StoryNode("Explore the castle", "<HTML>You walk into the tunnel system under your castle. There is "+
                                   "an old man here. In front of him lie two items. One is a long bow with a large black arrow. "+
                                   "The other item is a medallion, with an inscription of a dragon on it. The old man smiles at "+
                                   "you.<br><br>\"Princess, what you see here is a bow and arrow that will fell the largest and "+
                                   "fiercest of dragons in just one shot. This medallion will allow you and all who are near "+
                                   "you to understand the speech of dragons. You can only take one. Choose wisely.\"</HTML>",
                                   0, true, "castle.jpg");
    game.addVertex(mex4);
    
    StoryNode mt1 = new StoryNode("Talk to Tuvok", "<HTML>\"Princess Janeway. It appears that there is a fight currently "+
                                  "taking place outside of the castle.\"<br><br>You look at him increduously. The master of "+
                                  "understatement right here.<br><br>\"Precisely. What do you think we should do about "+
                                  "it?\"<br><br>\"Undoubtedly, we should do nothing. According to the laws of Convention, a "+
                                  "princess contained within a castle with a dragon outside must wait for a prince or knight "+
                                  "to save her from it.\"</HTML>",0, false, "castle.jpg");
    game.addVertex(mt1);
    
    StoryNode mt2 = new StoryNode("Talk to Torres", "<HTML>\"Hello, Princess, how can I help you?\"<br><br>\"Ah, hello, Lieutenant. "+
                                  "What can you tell me about what's going on outside?\"<br><br>\"Oh, that. It seems like some idiot "+
                                  "knight jumped to conclusions as usual. As you know, the dragon's migration path after their "+
                                  "children hatch passes by here this time of year... Princess, may I speak freely?\"<br><br>\"Go "+
                                  "ahead.\"<br><br>\"You should leave that idiot to his fate. We've had a pretty good relationship "+
                                  "with the dragons - and who challenges a mother dragon?\"<br><br>\"Duly noted, Lieutenant. Thank "+
                                  "you for the input.\"</HTML>",0, false, "castle.jpg");
    game.addVertex(mt2);
    
    StoryNode mt3 = new StoryNode("Talk to Neelix", "<HTML>\"Hello, Princess. I'm making your favorite today! Why don't you "+
                                  "sit down, and I'll get you something to drink.\"<br><br>You sit down at one of the counters, "+
                                  "and Neelix hands you a glass.<br><br>\"There is a fight between a knight and a dragon going on "+
                                  "outside, and I'm not quite sure what I should do about it,\" you tell him, looking down at "+
                                  "your drink.<br><br>He snorts. \"If that guy challenged a dragon this time of year, he deserves "+
                                  "what he gets. Let the dragon take care of it.\"<br><br>You scowl at the drink, swirling it around "+
                                  "a bit.<br><br>\"Yeah, but I don't really want to just leave him to get roasted by a dragon.\"<br><br>\"Then "+
                                  "kill the dragon for him or somthing. No sweat off my back. Just don't get yourself killed in "+
                                  "the process, okay, Princess?\"</HTML>",0, false, "castle.jpg");
    game.addVertex(mt3);
    
    StoryNode ml1 = new StoryNode("Leave Castle", "<HTML>You walk outside your castle. Beyond the moat, there is a knight, "+
                                  "a big dragon, and a small dragon. The knight and the big dragon are duking it out. The baby "+
                                  "dragon watches from the side.<br><br>As it happens, the knight sees you emerge from the "+
                                  "castle.<br><br>\"Fair princess!\" He shouts. \"I will defeat this evil dragon and save you from "+
                                  "your unjust imprisonment!\"<br><br>You have no idea what he is talking about. However, in his "+
                                  "attempt to impress you, the knight lets his concentration waver, and the dragon guts him "+
                                  "without further ado. The dragon roars at the crumpled form of the knight and walks off. "+
                                  "The baby dragon follows.<br><br>For some odd reason, you are falling through a hole that has "+
                                  "just appeared under you, and all you know is- <br><br>Black.</HTML>",10, true, "castle.jpg");
    game.addVertex(ml1);
    
    StoryNode ml2 = new StoryNode("Leave Castle", "<HTML>You walk outside your castle. Beyond the moat, there is a knight, "+
                                  "a big dragon, and a small dragon. The knight and the big dragon are duking it out. The "+
                                  "baby dragon watches from the side.<br><br>As it happens, your emergence from the castle goes "+
                                  "unnoticed. The tail of the dragon is swinging towards the knight. The knight, occupied "+
                                  "by the dragon's head, doesn't seem to have noticed.</HTML>",0, true, "castle.jpg");
    game.addVertex(ml2);
    
    StoryNode ml3 = new StoryNode("Leave Castle", "<HTML>You walk outside your castle. Beyond the moat, there is a knight, "+
                                  "a big dragon, and a small dragon. The knight and the big dragon are duking it out. The "+
                                  "baby dragon watchs from the side.<br><br>As it happens, the dragon notices you emerging "+
                                  "from the castle.<br><br>This moment of lapsed concentration leaves an opening for the knight "+
                                  "to get in a lucky shot through the roof of the dragon's mouth, straight into its brain. "+
                                  "The dragon comes crashing down. The baby dragon lets out a keening wail and nudges the big "+
                                  "dragon. She doesn't move. The knight straightens up and approaches the baby dragon "+
                                  "from behind, sword raised. The baby dragon, occupied with its dead mother, doesn't "+
                                  "notice.</HTML>",0, true, "castle.jpg");
    game.addVertex(ml3);
    
    StoryNode ml4 = new StoryNode("Take the medallion", "<HTML>You grab the medallion and slip it over your head.<br><br>\"Thank "+
                                  "you,\" you say to the old man. Turning, you make to leave the castle.<br><br>You walk outside "+
                                  "your castle. Beyond the moat, there is a knight, a big dragon, and a small dragon. The "+
                                  "knight and the big dragon are duking it out. The baby dragon watchs from the side.<br><br>As "+
                                  "it happens, your emergence from the castle goes unnoticed.</HTML>",0, true, "castle.jpg");
    game.addVertex(ml4);
    
    StoryNode ml5 = new StoryNode("Take the bow", "<HTML>You grab the bow and arrow.<br><br>\"Thank you,\" you say to the "+
                                  "old man. Turning, you make to leave the castle.<br><br>You walk outside your castle. Beyond "+
                                  "the moat, there is a knight, a big dragon, and a small dragon. The knight and the big "+
                                  "dragon are duking it out. The baby dragon watchs from the side.<br><br>As it happens, your "+
                                  "emergence from the castle goes unnoticed.</HTML>",0, true, "castle.jpg");
    game.addVertex(ml5);
    
    StoryNode ml2d1 = new StoryNode("Call out", "<HTML>\"WATCH OUT!\" You scream desperately.<br><br>Startled, the knight turns "+
                                    "towards you, just in time to be devoured by the dragon's flames and catch the tail to the "+
                                    "back of his head. He goes flying and lands in a heap. He doesn't get up.<br><br>The dragon "+
                                    "turns in your direction and stares at for you for a long moment. Eventually, she snorts "+
                                    "a bit of fire in your direction and stomps off, the baby dragon following behind.<br><br>For "+
                                    "some odd reason, you are falling through a hole that has just appeared under you, and "+
                                    "all you know is- <br><br>Black.</HTML>",10, true, "castle.jpg");
    game.addVertex(ml2d1);
    
    StoryNode ml2d2 = new StoryNode("Do nothing", "<HTML>Feeling oddly cold, you say nothing. The knight, however, ducks "+
                                    "under the tail. You breathe a small sigh of relief. The knight and the dragon continue "+
                                    "to fight. It is clear, however, that the dragon has the upper hand. You watch, frozen. "+
                                    "Your legs have weights attached - your voice is doused.<br><br>The knight trips, and the "+
                                    "dragon blows white-hot fire over him, then stomps on him for good measure. You "+
                                    "can hear the crunch from where you are standing.<br><br>The dragon sniffs at the knight for "+
                                    "a couple of moments, and then, seemingly satsified by his condition, turns and "+
                                    "walks away, the baby dragon following behind.<br><br>For some odd reason, you are falling through "+
                                    "a hole that has just appeared under you, and all you know is- <br><br>Black.</HTML>",10, true, "castle.jpg");
    game.addVertex(ml2d2);
    
    StoryNode ml3d1 = new StoryNode("Save the baby dragon", "<HTML>\"WAIT!\" you cry. \"DON'T KILL IT!\"<br><br>The knight, "+
                                    "surprised by your sudden outburst, freezes in place. The baby dragon, surprised as well, "+
                                    "looks up to see the looming figure that killed its mother above it, squeaks, and runs "+
                                    "towards you, hiding behind you.<br><br>\"Princess,\" the knight says grimly, walking torwards "+
                                    "you, \"Please step away from the dragon. Such a beast shouldn't survive, especially since "+
                                    "that larger one was keeping you captive here.\"<br><br>You open your mouth to answer him, "+
                                    "but before you can, you are falling through a hole that has just appeared under you, "+
                                    "and all you know is- <br><br>Black.</HTML>",10, true, "castle.jpg");
    game.addVertex(ml3d1);
    
    StoryNode ml3d2 = new StoryNode("Do nothing", "<HTML>Feeling oddly cold, you say nothing. The sword descends and you "+
                                    "close your eyes. You can still hear the thunk of the baby dragon's head hitting the "+
                                    "ground. You open your eyes in time to see the body slump to the ground.<br><br>The knight "+
                                    "turns and notices you standing there. He beams.<br><br>\"Fair Princess! I have saved you "+
                                    "from the dragon's oppressive reign over this castle! Please, let us proceed inside so "+
                                    "we can hold a feast in my honor and discuss our upcoming nuptials!\"<br><br>You stare at him "+
                                    "incredulously, but before you can answer him, you are falling through a hole that has just "+
                                    "appeared under you, and all you know is- <br><br>Black.</HTML>",-5, true, "castle.jpg");
    game.addVertex(ml3d2);
    
    StoryNode ml4d1 = new StoryNode("Stop the fight", "<HTML>Running torwards the fight, you shout, \"Stop it! Stop fighting! "+
                                    "Please, there must be a way to resolve this peacefully!\"<br><br>Surpirsed, both the dragon "+
                                    "and the knight stop and turn towards you.<br><br>\"But my fair princess,\" the knight "+
                                    "protests, recovering, \"this evil dragon has been keeping you captive, and yet you still "+
                                    "wish for it to live?\"<br><br>\"It is out of respect for your people,\" the dragon intones, "+
                                    "ignoring the knight, in a deep but feminine voice, \"that I do not use this opportunity "+
                                    "to stike down this ignorant knave, regardless of the fact that you are in the way, for this "+
                                    "human has attacked us unjustly and unprovoked, thus endangering my child.\"</HTML>", 20, true, "castle.jpg");
    game.addVertex(ml4d1);
    
    StoryNode ml4d1b = new StoryNode("Continue", "<HTML>\"It can talk!\" shrieks the knight.<br><br>\"Just because you are so vacuous as not to understand my "+
                                    "language does not mean that my kind cannot communicate!\" roars the dragon. \"My kind has "+
                                    "been using this path to travel from our nesting grounds to the hunting grounds for thousands "+
                                    "of years, and when this castle was built, we came to an accord so that we could still "+
                                    "use it!\" The knight gapes at the dragon. Snorting out a bit of fire, the mother dragon "+
                                    "turns to you. \"Princess Janeway of Castle Voyager, I leave this fool to you. However, "+
                                    "know that ignorance will not be tolerated in the future, and should this simpleton "+
                                    "threaten me or mine again, and I will not hesitate to kill him where he stands.\"<br><br>You curtsy "+
                                    "to the dragon. \"Understood.\" The dragon nods, and turns to leave, calling for her child "+
                                    "to follow her.<br><br>For some odd reason, you are falling through a hole that has just appeared "+
                                    "under you, and all you know is- <br><br>Black.</HTML>", 0, false, "castle.jpg");
    game.addVertex(ml4d1b);
    
    StoryNode ml4d2 = new StoryNode("Do nothing", "<HTML>Feeling oddly cold, you say nothing. It is clear, however, that the "+
                                    "dragon has the upper hand. You watch, frozen. Your legs have weights attached - your voice "+
                                    "is doused.<br><br>The knight trips, and the dragon blows white-hot fire over him, then "+
                                    "stomps on him for good measure. You can hear the crunch from where you are standing.<br><br>The "+
                                    "dragon sniffs at the knight for a couple of moments, and then, seemingly satsified by "+
                                    "his condition, turns and walks away, the baby dragon following behind.<br><br>For some odd reason, "+
                                    "you are falling through a hole that has just appeared under you, and all you know "+
                                    "is- <br><br>Black.</HTML>",10, true, "castle.jpg");
    game.addVertex(ml4d2);
    
    StoryNode ml5d1 = new StoryNode("Kill the knight", "<HTML>You nock the arrow, draw the bow, and aim for the knight. You "+
                                    "take a deep breath, then let go. Such is the power of this bow and arrow that the arrow "+
                                    "punches through the knight's armor as if it wasn't even there and flies clean through "+
                                    "the knight.<br><br>The knight collaspes.<br><br>The dragon sniffs at the knight for a couple "+
                                    "of moments, and then, seemingly satsified by his condition, turns to look at you. "+
                                    "After a long moment, she nods at you and walks away, the baby dragon following behind.<br><br>For "+
                                    "some odd reason, you are falling through a hole that has just appeared under you, and "+
                                    "all you know is- <br><br>Black.</HTML>",10, true, "castle.jpg");
    game.addVertex(ml5d1);
    
    StoryNode ml5d2 = new StoryNode("Kill the dragon", "<HTML>You nock the arrow, draw the bow, and aim for the dragon. You "+
                                    "take a deep breath, then let go. Your arrow flies true, and buries itself in the dragon's "+
                                    "eye.<br><br>The dragon collapses.<br><br>The baby dragon lets out a keening wail and nudges the "+
                                    "big dragon. She doesn't move. The knight straightens up and approaches the baby dragon "+
                                    "from behind, sword raised. The baby dragon, occupied with its dead mother, doesn't "+
                                    "notice.</HTML>",10, true, "castle.jpg");
    game.addVertex(ml5d2);
    
    StoryNode ml5d3 = new StoryNode("Kill the baby dragon", "<HTML>You nock the arrow, draw the bow, and aim for the baby "+
                                    "dragon. You take a deep breath, then let go. Your arrow flies true and buries itself "+
                                    "in the baby dragon's head.<br><br>The baby dragon collaspes.<br><br>The dragon roars, furious. "+
                                    "It quickly becomes apparent that the dragon had been trying to reduce damage to the "+
                                    "surroundings, because she immediately stops holding back. With an earth-shattering stomp, "+
                                    "the knight is flattened, and the castle shakes and starts crumbling. In the face of a "+
                                    "dragon's wrath, the castle stands no chance.<br><br>The dragon stomps over to you and roars "+
                                    "in your face. Then with a deep breath, she breathes fire all over you.<br><br>Has anyone ever told "+
                                    "you that fire is not a good way to go?<br><br>Beyond the fire and the pain, and oh, the "+
                                    "pain, darkness starts encroaching on your vision and all you know is- <br><br>Black.</HTML>",
                                    -20, true, "castle.jpg");
    game.addVertex(ml5d3);
    
    StoryNode mx1 = new StoryNode("Stop the knight", "<HTML>\"WAIT!\" you cry. \"DON'T KILL IT!\"<br><br>The knight, surprised "+
                                  "by your sudden outburst, freezes in place. The baby dragon, surprised as well, looks up "+
                                  "to see the knight looming overhead, poised to strike. It squeaks and books it out of "+
                                  "there.<br><br>The knight turns to you, but before he can say anything, you are falling through "+
                                  "a hole that has just appeared under you, and all you know is- <br><br>Black.</HTML>", 10, true, "castle.jpg");
    game.addVertex(mx1);
    
    StoryNode mx2 = new StoryNode("Do nothing", "<HTML>Feeling oddly cold, you say nothing. The sword descends and you close "+
                                  "your eyes. You can still hear the thunk of the baby dragon's head hitting the ground. You "+
                                  "open your eyes in time to see the body slump to the ground.<br><br>The knight turns and notices "+
                                  "you standing there. He beams.<br><br>\"Fair Princess! I have saved you from the dragon's "+
                                  "oppressive reign over this castle! Please, let us proceed inside so we can hold a feast "+
                                  "in my honor and discuss our upcoming nuptials!\"<br><br>You stare at him incredulously, but "+
                                  "before you can answer him, you are falling through a hole that has just appeared under you, "+
                                  "and all you know is- <br><br>Black.</HTML>", -5, true, "castle.jpg");
    game.addVertex(mx2);
    
    StoryNode qend = new StoryNode("Return to Voyager", "<HTML><font size=\"4\">You jerk in your chair. Chakotay looks over at you, concerned.<br><br>"+
                                   "\"Captain, are you alright?\"<br><br>You shake your head. \"Yes, yes, I'm fine. What about the "+
                                   "crew, the ship? What is our condition after that wormhole?\"<br><br>\"Captain, I am quite unsure "+
                                   "of what you mean by a wormhole. There is no wormhole. I am certain that our sensors would have "+
                                   "picked up on such a wormhole already,\" replied Tuvok.<br><br>You shake your head and lean back in your "+
                                   "seat. There is a sudden shimmering in front of the viewscreen, and a man steps out.<br><br>\"Hello, "+
                                   "Voyager!\" he says, smiling. Turning to you, he continues. \"And you must be Captain Janeway. "+
                                   "I am Q!\" The bridge collectively groans. \"Now don't be like that! I'm just here to see Ms. "+
                                   "Janeway for myself! I want to know why some mortal bipedal female was named godmother of Q's "+
                                   "son and has Q's favor.\"<br><br>He grins at you. \"That's right, it was me. To wrap your mortal "+
                                   "mind around what I have done, imagine that I put you in one of your holodeck programs. I "+
                                   "wanted to test you.\"<br><br>\"Get off my ship,\" you growl at him. He looks at you as if you "+
                                   "are a little puppy who has just tried to look intimidating. In a word, amused.<br><br>\"What, "+
                                   "don't you want to know how you did? Let me just check the Linked <i>Queue</i> and see!\"</HTML>", 0, false, "voyager.jpg");
    game.addVertex(qend);
    
    StoryNode q1 = new StoryNode("Continue...", "<HTML><font size=\"4\">\"You know what, I don't blame you for not wanting to know. After all, "+
                                 "you did horribly! I am shocked that your Starfleet would employ one such as yourself to be a "+
                                 "captain. You are certainly not worthy of being Q's godmother. In fact, I think I'll do them "+
                                 "all a favor and get rid this little ship.\"<br><br>Someone gasps. \"You can't!\" Several "+
                                 "others bring out their phasers and shoot at him, but he snaps his fingers and all "+
                                 "of the weapons disappear.<br><br>\"Why not? It's no skin off my nose, and the universe won't "+
                                 "miss one lost ship full of bipedal humanoids.\"<br><br>With that, he snaps his fingers again.<br><br>\"Your "+
                                 "warp core is destabilizing and is going to explode imminently. Ta!\" He snaps his fingers "+
                                 "one final time and disappears in a shimmer of light.<br><br>The explosion rips through your ship, and all "+
                                 "you know is the silence of space.<br><br>----<br><br>Congratulations, you have killed yourself and "+
                                 "everyone on your ship.</HTML>", 0, false, "voyager.jpg");
    game.addVertex(q1);
    
    StoryNode q2 = new StoryNode("Continue...", "<HTML>\"Eh, you did well enough. I guess I can let you guys go. I'll let Q know "+
                                 "you're looking forward to a visit from him and his son!\"<br><br>He snaps his fingers and "+
                                 "disappears in a shimmer of light.<br><br>\"So, Captain, what was that all about?\" You can't "+
                                 "quite stop the noise of exasperation that escapes you. They're all laughing at you, you "+
                                 "just know it.<br><br>\"Lieutenant Paris,\" you bite out, ignoring the question entirely, \"please "+
                                 "proceed on our course back to the Alpha Quadrant. Warp 6.\"<br><br>\"Right away, Captain.\" Was "+
                                 "that laughter in his voice? You scowl at the back of his head. The nerve of these people! "+
                                 "But as you lean back in your chair, you think that it is good to be back in your ship, "+
                                 "Voyager, as Captain.</HTML>", 0, false, "voyager.jpg");
    game.addVertex(q2);
    
    StoryNode q3 = new StoryNode("Continue...", "<HTML>\"Actually, I'm quite impressed! You did everything perfectly, and achieved "+
                                 "all of the objectives! Great job. You know what? I'll think I'll do you all a favor, eh? Give you a "+
                                 "reward.\"<br><br>He snaps his fingers. A bright light fills your vision. When it fades, all you "+
                                 "can do is stare in shock. The view on the screen is unmistakable.<br><br>\"It- it's Earth!\" Someone "+
                                 "gasps.<br><br>\"It really is!\" confirms your helmsman, staring at the coordinates on his "+
                                 "console.<br><br>\"Captain! Starfleet is hailing us!\"<br><br>You look around for the Q, and you see "+
                                 "him wink at you before snapping his fingers and disappearing in a shimmer of light.<br><br>And as "+
                                 "you tell your comms officer to put Starfleet on screen, and prepare yourself to explain to "+
                                 "the admirals just how you've managed to return from the Delta Quadrant, you think to yourself that the "+
                                 "Q aren't so bad after all.</HTML>", 0, false, "voyager.jpg");
    game.addVertex(q3);   
    
    // LINKS (Setting links between vertices in StoryGraph)
    
    game.setLinks(s1, s2, s3, s4, s5);
    game.setLinks(s2,w1,null,null,null);
    game.setLinks(s4,w2,null,null,null);
    game.setLinks(s5,w3,null,null,null);
    game.setLinks(w2,wPolS1, wS1, wRR1, null);
    game.setLinks(w3,wPMS1,wPBar1,wPDB1,null);
    game.setLinks(wPDB1,wPDB1,wPBar1,wPMS1,null);
    game.setLinks(wPS1,wPMS1,wPBar1,wPDB1,null);
    game.setLinks(wPMS1,wPS1,wPPS1,wPRR1,null);
    game.setLinks(wPRR1,wPMS1,null,null,null);
    game.setLinks(wPDB2, wPDB2, wPBar2, wPMS2, null);
    game.setLinks(wPBar1, wPBar2, wPMS2, wPDB2, null);
    game.setLinks(wPPS1, wPIO1a, wPMS1, null, null);
    game.setLinks(wPIO1a, wPIO1b, wPMS3, null, null);
    game.setLinks(wPIO1b, wPIO1b, wPMS3, null, null);
    game.setLinks(wPS2, wPMS2, wPDB2, wPBar2, null);
    game.setLinks(wPRR2, wPMS2, null, null, null);
    game.setLinks(wPMS2, wPPS2, wPS2, wPRR2, null);
    game.setLinks(wPMS4, m1, null, null, null);
    game.setLinks(wPBar3, m1, null, null, null);
    game.setLinks(wPDB3, wPMS4, wPBar3, null, null);
    game.setLinks(wPBar2, wPDB3, wPBar3, wPMS4, null);
    game.setLinks(wPPS3, wPIO1b, wPMS3, null, null);
    game.setLinks(wPMS3, wPRR3, wPPS3, wPS3, null);
    game.setLinks(wPS3, wPMS3, wPDB4, null, null);
    game.setLinks(wPSC1, m1, null, null, null);
    game.setLinks(wPSC2, m1, null, null, null);
    game.setLinks(wPTJ1, m1, null, null, null);
    game.setLinks(wPAJ1, wPSC2, wPTJ1, null, null);
    game.setLinks(wPPS2, wPIO2a, wPMS2, null, null);
    game.setLinks(wPDB4, wPMS5, null, null, null);
    game.setLinks(wPIO2a, wPIO2b, wPMS5, null, null);
    game.setLinks(wPIO2b, wPIO2b, wPMS5, null, null);
    game.setLinks(wPPS4, wPIO2b, wPMS5, null, null);
    game.setLinks(wPMS5, wPPS4, wPRR4, wPS4, null);
    game.setLinks(wPDN1, m1, null, null, null);
    game.setLinks(wPRR3, wPMS3, wPSC1, wPAJ1, wPDN1);
    game.setLinks(wPSC3, m1, null, null, null);
    game.setLinks(wPRR4, wPMS5, wPDN1, wPSC3, null);
    game.setLinks(wPAJ2, m1, null, null, null);
    game.setLinks(wPS4, wPAJ2, null, null, null);
    game.setLinks(w1, wIO1a, wMS1, null, null);
    game.setLinks(wPolS1, wIO1a, wMS1, null, null);
    game.setLinks(wRR1, wMS1, null, null, null);
    game.setLinks(wMS1, wPolS1, wS1, wRR1, null);
    game.setLinks(wIO1a, wIO1b, wMS2, null, null);
    game.setLinks(wIO1b, wIO1b, wMS2, null, null);
    game.setLinks(wPolS2, wMS2, wIO1b, null, null);
    game.setLinks(wS2, wMS2, wPDB4, null, null);
    game.setLinks(wMS2, wPolS2, wRR2, wS2, null);
    game.setLinks(wSC1, m1, null, null, null);
    game.setLinks(wRR2, wSC1, wAJ1, null, null);
    game.setLinks(wSC2, m1, null, null, null);
    game.setLinks(wAJ1, wSC2, null, null, null);
    game.setLinks(wS1, wPDB1, wBar1, wMS1, null);
    game.setLinks(wBar1, wPDB2, wBar2, wMS3, null);
    game.setLinks(wRR3, wMS3, null, null, null);
    game.setLinks(wS3, wMS3, wBar2, wPDB2, null);
    game.setLinks(wMS3, wRR3, wPolS3, wS3, null);
    game.setLinks(wPolS3, wIO2a, wMS3, null, null);
    game.setLinks(wIO2a, wIO2b, wMS4, null, null);
    game.setLinks(wIO2b, wIO2b, wMS4, null, null);
    game.setLinks(wPolS4, wMS4, wIO2b, null, null);
    game.setLinks(wMS4, wPolS4, wRR4, wS4, null);
    game.setLinks(wAJ2, wSC2, null, null, null);
    game.setLinks(wRR4, wMS4, wSC1, wAJ2, null);
    game.setLinks(wS4, wDB1, wBar2, wMS4, null);
    game.setLinks(wDB1, wPMS5, wDB1, null, null);
    game.setLinks(wBar2, wPDB3, wBar3, wMS5, null);
    game.setLinks(wBar3, wMS6, null, null, null);
    game.setLinks(wMS6, wRR5, wS5, null, null);
    game.setLinks(wMS6, wRR5, wS5, null, null);
    game.setLinks(wRR5, wSC3, wMS6, null, null);
    game.setLinks(wAJ3, m1, null, null, null);
    game.setLinks(wS5, wAJ3, wMS6, null, null);
    game.setLinks(wS6, wMS5, wBar3, null, null);
    game.setLinks(wRR6, wMS5, null, null, null);
    game.setLinks(wMS5, wS6, wRR6, wPolS5, null);
    game.setLinks(wPolS5, wMS5, wIO3a, null, null);
    game.setLinks(wIO3a, wIO3b, wMS7, null, null);
    game.setLinks(wIO3b, wIO3b, wMS7, null, null);
    game.setLinks(wMS7, wRR7, null, null, null);
    game.setLinks(wRR7, wSC4, null, null, null);
    game.setLinks(wSC4, m1, null, null, null);  
    game.setLinks(m1, ms1, ms2, mex1, null);
    game.setLinks(ms1, ms2, mex1, null, null);
    game.setLinks(ms2, mex1, null, null, null);
    game.setLinks(mex1, mt1, mex2, ml1, null);
    game.setLinks(mt1, mex2, ml1, null, null);
    game.setLinks(mex2, mt2, mex3, ml2, null);
    game.setLinks(mt2, mex3, ml2, null, null);
    game.setLinks(mex3, mt3, mex4, ml3, null);
    game.setLinks(mt3, mex4, ml3, null, null);  
    game.setLinks(mex4, ml4, ml5, null, null);  
    game.setLinks(ml1, qend, null, null, null); 
    game.setLinks(ml2, ml2d1, ml2d2, null, null); 
    game.setLinks(ml3, ml3d1, ml3d2, null, null);
    game.setLinks(ml4, ml4d1, ml4d2, null, null); 
    game.setLinks(ml5, ml4d2, ml5d1, ml5d2, ml5d3); 
    game.setLinks(ml2d1, qend, null, null, null);
    game.setLinks(ml2d2, qend, null, null, null);
    game.setLinks(ml3d1, qend, null, null, null); 
    game.setLinks(ml3d2, qend, null, null, null);
    game.setLinks(ml4d1, ml4d1b, null, null, null);
    game.setLinks(ml4d1b, qend, null, null, null);
    game.setLinks(ml4d2, qend, null, null, null);
    game.setLinks(ml5d1, qend, null, null, null);
    game.setLinks(ml5d2, mx1, mx2, null, null);
    game.setLinks(ml5d3, qend, null, null, null);
    game.setLinks(mx1, qend, null, null, null);  
    game.setLinks(mx2, qend, null, null, null);                               
    
    // Create StoryPanel object (passing through necessary variables) and add to frame
    StoryPanel panel = new StoryPanel(frame, game, wendy, s1, q1, q2, q3);
    frame.getContentPane().add(panel);
    
    frame.setPreferredSize(new Dimension(1200,700));
    
    frame.pack();
    frame.setVisible(true);
    
  }
}