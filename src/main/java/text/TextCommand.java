/**
 * Interface for a single text command.
 * Used to execute a specific action on a string,
 * and return a string as a result.
 *
 * file     TextCommand.java
 * @author  Patrick Reinås
 * @version 0.0.2
 * @since   17.02.2026
 */


package text;


/**
 * TextCommand interface
 */
public interface TextCommand {

    /**
     * Interface method that execute an action
     * on a string, and returns a string as a result
     * (see implementing classes for details on return)
     *
     * @param text - The string
     */
    String execute(String text);
}
