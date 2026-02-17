/**
 * This class represents a command to capitalize
 * the first letter in a given text.
 *
 * file     CapitalizeTextCommand.java
 * @author  Patrick Reinås
 * @version 0.0.1
 * @since   17.02.2026
 */


package capitalize;

import text.TextCommand;


/**
 * CapitalizeTextCommand class
 */
public class CapitalizeTextCommand implements TextCommand {

    /**
     * Method to capitalize the first substring in a text
     *
     * @param text - The text in which the capitalization is to be performed
     *
     * @return The text with the first letter capitalized
     *
     * @throws IllegalArgumentException if the text given is null or blank
     */
    @Override
    public String execute(String text) {
        if(text == null || text.isBlank()) {
            throw new
                    IllegalArgumentException("The text cannot be null or blank");
        }
        return text.substring(0, 1).toUpperCase() + text.substring(1);
    }
}
