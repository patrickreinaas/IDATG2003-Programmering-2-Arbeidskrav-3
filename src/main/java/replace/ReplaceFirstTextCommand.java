/**
 * This class represents a command to replace
 * the first match of a targeted substring in
 * a text with a replacement substring.
 *
 * file     ReplaceFirstTextCommand.java
 * @author  Patrick Reinås
 * @version 0.0.1
 * @since   17.02.2026
 */


package replace;


/**
 * ReplaceFirstTextCommand class
 */
public class ReplaceFirstTextCommand extends ReplaceTextCommand {

    /**
     * ReplaceFirstTextCommand constructor
     *
     * @param target      - The substring to be replaced
     * @param replacement - The substring to replace with
     *
     * @throws IllegalArgumentException if target or replacement
     * is null or blank (see parent constructor ReplaceTextCommand)
     */
    public ReplaceFirstTextCommand(String target, String replacement) {
        super(target, replacement);
    }


    /**
     * Method to replace the first occurrence of the targeted substring
     * with the new replacement substring in a given text.
     *
     * @param text - The text in which the replacement is to be performed
     *
     * @return The modified string with the first replacement
     *
     * @throws IllegalArgumentException if the text given is null or blank,
     *
     */
    @Override
    public String execute(String text) {
        if (text == null || text.isBlank())
            throw new
                    IllegalArgumentException("The text cannot be null or blank");
        return text.replaceFirst(getTarget(), getReplacement());
    }
}
