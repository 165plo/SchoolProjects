
/**
 * Abstract class DecisionTreeNode - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class DecisionTreeNode extends BTNode<String>
{
    public DecisionTreeNode(){
        new BTNode<String>();
    }
    
    public DecisionTreeNode(String value, DecisionTreeNode no, DecisionTreeNode yes){
        new BTNode<String>(value, (BTNode<String>)no, (BTNode<String>)yes);
    }
  
    public DecisionTreeNode getNoLink(){
        return (DecisionTreeNode)getLeftNode();
    }
    
    public String getString(){
        return getData();
    }
    
    public DecisionTreeNode getYesLink(){
        return (DecisionTreeNode)getRightNode();
    }
    
    public void setNoLink(DecisionTreeNode link){
        setLeftNode((BTNode<String>)link);
    }
    
    public void setYesLink(DecisionTreeNode link){
        setRightNode((BTNode<String>)link);
    }
}
