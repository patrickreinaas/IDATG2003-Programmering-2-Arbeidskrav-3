/**
 * This class represents a script that can
 * execute a list containing text commands.
 *
 * file     Script.java
 * @author  Patrick Reinås
 * @version 0.0.1
 * @since   17.02.2026
 */


package script;

import text.TextCommand;
import java.util.List;


/**
 * Script class
 */
public class Script implements TextCommand {
    private List<TextCommand> textCommands; // The list of text commands

    /**
     * Script constructor
     *
     * @param textCommands - The list of text commands to be executed in the script
     *
     * @throws IllegalArgumentException if the list of commands is null or empty,
     * or if a command in the list is null
     */
    public Script(List<TextCommand> textCommands) {
        this.textCommands = textCommands;
    }


    /**
     * Method to execute a list of text commands on a text
     *
     * @param text - The text on which the commands are to be executed on
     *
     * @return The text after all commands have been executed
     *
     * @throws IllegalArgumentException if the list of commands is null or empty,
     * or if a command in the list is null
     */
    public String execute(String text) {
        if (textCommands == null || textCommands.isEmpty()) {
            throw new
                    IllegalArgumentException("The list is empty or a command is null");
        }
        for (TextCommand textCommand : textCommands) {
            text = textCommand.execute(text);
        }
        return text;
    }
}