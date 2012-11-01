
/**
 * Abstract class DecisionTreeNode - Is used to control the nodes associated with the
 * making a decision. With a yes and no side this tree node class is used for stroing 
 * decisions.
 * 
 * @author David Firestone
 */
public abstract class DecisionTreeNode extends BTNode<String>
{
    public DecisionTreeNode(){
        new BTNode<String>();
    }
    
    public DecisionTreeNode(String value, DecisionTreeNode no, DecisionTreeNode yes){
        super (value, (BTNode<String>)no, (BTNode<String>)yes);
    }
  
    /***
     * Gets the DeicsionTreeNode that is associated with a no response
     * 
     * @return  Decision    returns the node on the left/no side of the 
     * current node.
     */
    public DecisionTreeNode getNoLink(){
        return (DecisionTreeNode)getLeftNode();
    }
    
    /***
     * Gets the String that is contained within the current DecisionTreeNode
     * 
     * @return  String  The value data conained within the node
     */
    public String getString(){
        return getData();
    }
    
    /***
     * Gets the DeicsionTreeNode that is associated with a yes response
     * 
     * @return  Decision    returns the node on the right/yes side of the 
     * current node.
     */
    public DecisionTreeNode getYesLink(){
        return (DecisionTreeNode)getRightNode();
    }
    
    /***
     * Sets the DecisionTreeNode left/no link to a DecisionTreeNode
     * 
     * @param   DecisionTreeNode    The node your wish to be linked to this
     * side of the current node.
     */
    public void setNoLink(DecisionTreeNode link){
        setLeftNode((BTNode<String>)link);
    }
    
    /***
     * Sets the DecisionTreeNode right/yes link to a DecisionTreeNode
     * 
     * @param   DecisionTreeNode    The node your wish to be linked to this
     * side of the current node.
     */
    public void setYesLink(DecisionTreeNode link){
        setRightNode((BTNode<String>)link);
    }
}
