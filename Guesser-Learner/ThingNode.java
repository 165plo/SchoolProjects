
/**
 * ThingNode - contains the final result of the tree. In this
 * case it is the animal that the game has stored. This class 
 * does not have a left or right node as it should be at the
 * trees branch.
 * 
 * @author David Firestone 
 */
public class ThingNode extends DecisionTreeNode
{
    public ThingNode(String thing){
        super(thing, null, null);
    }
    
    /***
     * Gets the Thing that is stored within this node
     * 
     * @return  String  The Thing that is contained in the node
     */
    public String getThing(){
        return getString();
    }
    
    /***
     * returns a string representation of a ThingNode. It uses the format of
     * [ leftNode | currentNodeData | rightNode ]. 
     * 
     * @return  String  A string representation of ThingNode
     */
    public String toString(){
        String display = "[ "+getNoLink()+" | "+getThing()+" | "+getYesLink()+" ]";
        return display;
    }
}
