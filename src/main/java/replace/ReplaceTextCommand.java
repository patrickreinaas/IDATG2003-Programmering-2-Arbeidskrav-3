/**
 * This class represents a command to
 * replace substrings in a text.
 *
 * file     ReplaceTextCommand.java
 * @author  Patrick Reinås
 * @version 0.0.1
 * @since   17.02.2026
 */


package replace;

import text.TextCommand;


/**
 * ReplaceTextCommand class
 */
public class ReplaceTextCommand implements TextCommand {
    protected String target;      // Substring to be replaced
    protected String replacement; // Replacement substring

    /**
     * ReplaceTextCommand constructor
     *
     * @param target      - The substring to be replaced
     * @param replacement - The substring to replace with
     *
     * @throws IllegalArgumentException if target or replacement
     * is null or blank
     */
    public ReplaceTextCommand(String target, String replacement) {
        if (target == null || target.isBlank())
            throw new
                    IllegalArgumentException("Target cannot be null or blank");
        if (replacement == null || replacement.isBlank())
            throw new
                    IllegalArgumentException("Replacement cannot be null or blank");
        this.target = target;
        this.replacement = replacement;
    }


    /**
     * Method to replace all the targeted substrings
     * with the new replacement substrings in a given text.
     *
     * @param text - The text in which the replacement is to be performed
     *
     * @return The modified string with replacements
     *
     * @throws IllegalArgumentException if the text given is null or blank
     *
     * @see #getTarget()
     * @see #getReplacement()
     */
    @Override
    public String execute(String text) {
        if (text == null || text.isBlank())
            throw new
                    IllegalArgumentException("The text cannot be null or blank");
        return text.replace(getTarget(), getReplacement());
    }

    /**
     * Method to get the target substring
     *
     * @return target - The targeted substring
     */
    public String getTarget() {
        return target;
    }

    /**
     * Method to get the replacement substring
     *
     * @return replacement - The replacement substring
     */
    public String getReplacement() {
        return replacement;
    }
}