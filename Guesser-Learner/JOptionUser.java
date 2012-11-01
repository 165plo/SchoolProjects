
/**
 * JOptionUser is a implemenation of IOUser. Its designed to provide a 
 * GUI to the guesser-learner game.
 * 
 * @author David Firestone
 */

import javax.swing.*;

public class JOptionUser implements IOUser
{
    /***
     * Prints a message out to the user
     * @param   The string that the user needs to see.
     */
    public void outToUser(String message){
        JOptionPane.showMessageDialog(null, message);
    }

    /***
     * Prints a message to the user and waits for a return
     * input from the user
     * @param   The string that the user needs to see
     * @return  The users response to the viewed string
     */
    public String inToUser(String message){
        return JOptionPane.showInputDialog(null, message);
    }

    /***
     * Prints a message to the user and waits for yes or no 
     * response from them.
     * @param   The string that the user needs to see
     * @return  A yes or no response from the user 
     * in the form of a number. 0 if yes; 1 if no; -1 if they hit
     * the cancel (x button at top of window) button.
     */
    public int yesNoToUser(String message){
        return JOptionPane.showConfirmDialog(null, message,
            "",JOptionPane.YES_NO_OPTION);
    }
}
