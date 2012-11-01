
/**
 * This class plays a game with the user where it attempts to guess 
 * the animal the user is thinking of by asking a series of questions.
 * If the game doesn't win it asks for details about the animal so it 
 * can "learn".
 * 
 * @author David Firestone
 * @version 1.0
 */

import java.io.*;

public class GuesserLearner
{
    public static IOUser user1 = new JOptionUser();
    public static void main(String[] args){

        QuestionNode currentQuestionNode=null;
        ThingNode currentThingNode=null;
        DecisionTreeNode head=null;

        //Game intro
        user1.outToUser("Welcome to the guessing game!");
        //load tree from serialized file
        head = DeSerial(".ser");

        //Play the game
        do{
            //resets variables if playing multiple times
            currentQuestionNode=null;
            currentThingNode = null;
            user1.outToUser("Please think of a animal.");
            //go through the tree
            if(head instanceof QuestionNode){
                currentQuestionNode = (QuestionNode)head;
                do{
                    //Ask question
                    int TorF = user1.yesNoToUser(currentQuestionNode.getQuestion());
                    // If ans leads to thing node set current thing node
                    //to it else move current qustion node and go again
                    if(TorF==0){
                        if(currentQuestionNode.getYesLink() instanceof ThingNode){
                            currentThingNode = 
                            (ThingNode)currentQuestionNode.getYesLink();
                        }else{
                            currentQuestionNode = (QuestionNode)currentQuestionNode.getYesLink();
                        }
                    }
                    if(TorF == 1){
                        if(currentQuestionNode.getNoLink() instanceof ThingNode){
                            currentThingNode = 
                            (ThingNode)currentQuestionNode.getNoLink();
                        }else{
                            currentQuestionNode = (QuestionNode)currentQuestionNode.getNoLink();
                        }
                    }
                    //If user hits th x on input window
                    if(TorF == -1){
                        if(user1.yesNoToUser("Would you like to quit the game?(This "
                            +"round will not be saved.)")==0){
                            System.exit(1);
                        }

                    }

                } while (currentThingNode==null);
            }else{
                currentThingNode=(ThingNode)head;
            }
            //Win or Lose
            int TorF = user1.yesNoToUser("Is it a "+currentThingNode.getThing()+"?");
            if(TorF==0){
                user1.outToUser("I Win!");
            }
            if(TorF==1) {
                String newAnimal = user1.inToUser("Darn. What was your animal?");
                String newQuestion = user1.inToUser("What's your animal got that mine doesn't?\n"+
                "(Please write in the form of a question with a yes or no answer.)");
                if(currentQuestionNode!=null){
                    if(currentQuestionNode.getYesLink()==currentThingNode){
                        currentQuestionNode.setYesLink(new QuestionNode(newQuestion, 
                                currentThingNode, 
                                new ThingNode(newAnimal)));
                    }else{
                        currentQuestionNode.setNoLink(new QuestionNode(newQuestion, 
                                currentThingNode, 
                                new ThingNode(newAnimal)));
                    }
                }else{
                    head = new QuestionNode(newQuestion, currentThingNode, new ThingNode(newAnimal));
                }
            }
            if(TorF==-1){
                if(user1.yesNoToUser("Would you like to quit the game?(This "
                    +"round will not be saved.)")==0){
                    System.exit(1);
                }
            }
            //save game/serialize after every round.
            Serial(head, ".ser");
        }while(user1.yesNoToUser("Would you like to play again?")==0);
    }

    /***
     * Serializes the tree from the game so you can continue teaching
     * the system.
     * 
     * @param   DecisionTreeNode    Takes the root node of the tree
     */
    public static void Serial(DecisionTreeNode head, String extension){
        try{
                OutputStream file = new FileOutputStream("GuesserLearner"+extension);
                OutputStream buffer = new BufferedOutputStream(file);
                ObjectOutput output = new ObjectOutputStream(buffer);
                try{
                    output.writeObject(head);
                }finally{
                    output.close();
                }

            }catch(IOException ex){
                System.err.println("Unsuccessful serialization. " + ex);
            }
    }

    /***
     * DeSerializes the tree from the file so you can continue teaching
     * the system. If the file is not found it returns a root with a answer
     * and starts rebuilding a new tree. 
     * 
     * @return   DecisionTreeNode    The root of the tree
     */
    public static DecisionTreeNode DeSerial(String extension){
        DecisionTreeNode root =null;
        try{
            InputStream file = new FileInputStream("GuesserLearner"+extension);
            InputStream buffer = new BufferedInputStream(file);
            ObjectInput input = new ObjectInputStream(buffer);
            try{
                root=(DecisionTreeNode)input.readObject();
                user1.outToUser("File loaded going to continue old game.");
            }finally{
                input.close();
            }
        }catch (ClassNotFoundException ex) {
            System.err.println(
                "Unsuccessful deserialization: Class not found. " + ex);
        }catch(FileNotFoundException ex){
            user1.outToUser("No file found. Creating new file and new game.");
            root = new ThingNode("Tiger");
        }catch (IOException ex){
            System.err.println("Unsuccessful deserialization: " + ex);
        }
        return root;
    }
}
