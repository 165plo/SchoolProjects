
/**
 * IOUser is a interface that contains all the required
 * methods needed to playthe guesser game.  
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface IOUser
{
    /***
     * Prints a message out to the user
     * @param   The string that the user needs to see.
     */
    void outToUser(String message);
    /***
     * Prints a message to the user and waits for a return
     * input from the user
     * @param   The string that the user needs to see
     * @return  The users response to the viewed string
     */
    String inToUser(String message);
    /***
     * Prints a message to the user and waits for yes or no 
     * response from them.
     * @param   The string that the user needs to see
     * @return  A yes or no response from the user
     * in the form of a number
     */
    int yesNoToUser(String message);
}
