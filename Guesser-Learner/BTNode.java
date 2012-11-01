
/**
 * This is the node for a binary tree node.
 * 
 * @author David Firestone
 */
public class BTNode<T> implements java.io.Serializable
{
   private BTNode left;
   private BTNode right;
   private T data;
   
   /***
    * This is the main constructor and defaults all
    * the variables to null
    */
   public BTNode(){
       this.left=null;
       this.right=null;
       this.data=null;
    }
    
    /***
    * This is the main constructor and defaults all
    * the variables to null
    */
   public BTNode(T data){
       this.left=null;
       this.right=null;
       this.data=data;
    }
    
    /***
     * This constructor sets the left node to the value
     * and set all other informtion to null
     * 
     * @param   left A BTNode that sould be on the 
     * left leg of this node
     */
    public BTNode(BTNode left){
        this.left=left;
        this.right=null;
        this.data=null;
    }
    
    /***
     * This constructor sets both links of this node
     * and setsthe data to null
     * 
     * @param   left and right node to be conectedto this node
     */
    public BTNode(BTNode left, BTNode right){
        this.left=left;
        this.right=right;
        this.data=null;
    }
    
    /***
     * This constructor sets both links and the data for this node
     * 
     * @param   sets both links and the data for this node
     */
    public BTNode(T data, BTNode left, BTNode right){
        this.left=left;
        this.right=right;
        this.data=data;
    }
    
    /***
     * Sets the left link to a new node
     * 
     * @param   BTNode Node to link to
     */
    public void setLeftNode(BTNode left){
        this.left=left;
    }
    
    /***
     * Sets theright link to a new node
     * 
     * @param   BTNode Node to link to
     */
    public void setRightNode(BTNode right){
        this.right=right;
    }
    
    /***
     * Sets the data value
     * 
     * @param   T Takes T type data set to to new value
     */
    public void setData(T data){
        this.data=data;
    }
    
    /***
     * Returns the current node in the link left
     * 
     * @return BTNode Node linked to the left side
     */
    public BTNode getLeftNode(){
        return this.left;
    }
    
    /***
     * Returns the current node in the link right
     * 
     * @return  BTNode Node linked to the right side
     */
    public BTNode getRightNode(){
        return this.right;
    }
    
    /***
     * Returns the current value in data
     * 
     * @return  T The value stored of data stored
     * in the Node
     */
    public T getData(){
        return data;
    }
    
    /***
     * Overrides the object to string method and shows
     * the link on the left then its data and then the
     * link on the right.
     * 
     * @return String   A String of the left link then 
     * the data then the right link
     */
    public String toString(){
        String display = "[ "+getLeftNode()+" | "+getData()+" | "+getRightNode()+" ]";
        return display;
    }
    
}
