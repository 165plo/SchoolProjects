
/**
 * QuestionNode - Contains the question and links to either other question nodes
 * or to thing nodes. 
 * 
 * @author David Firestone 
 */
public class QuestionNode extends DecisionTreeNode
{
   public QuestionNode(String question, DecisionTreeNode noAnswer, DecisionTreeNode yesAnswer){
       super(question, noAnswer, yesAnswer);
    }
    
    /***
     * Gets the Question that is stored within this node
     * 
     * @return  String  The Question that is contained in the node
     */
    public String getQuestion(){
        return getString();
    }
    
    /***
     * returns a string representation of a QuestionNode. It uses the format of
     * [ leftNode | currentNodeData | rightNode ]. 
     * 
     * @return  String  A string representation of QuestionNode
     */
    public String toString(){
        String display = "[ "+getNoLink()+" | "+getQuestion()+" | "+getYesLink()+" ]";
        return display;
    }
}
