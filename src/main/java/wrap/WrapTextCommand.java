/**
 * This class implements a command to wrap a given text
 * with specified opening and ending strings.
 *
 * file     WrapTextCommand.java
 * @author  Patrick Reinås
 * @version 0.0.1
 * @since   17.02.2026
 */


package wrap;

import text.TextCommand;


/**
 * WrapTextCommand class
 */
public class WrapTextCommand implements TextCommand {
    protected String opening; // The string to be added before the text
    protected String end;     // The string to be added after the text

    /**
     * WrapTextCommand constructor
     *
     * @param opening - The string to be added before the text
     * @param end     - The string to be added after the text
     *
     * @throws IllegalArgumentException if opening or end is null or blank
     */
    public WrapTextCommand(String opening, String end) {
        if (opening == null || opening.isBlank()) {
            throw new
                    IllegalArgumentException("Opening cannot be null or empty");
        }
        if (end == null || end.isBlank()) {
            throw new
                    IllegalArgumentException("End cannot be null or empty");
        }
        this.opening = opening;
        this.end = end;
    }


    /**
     * Method to wrap the given text with the opening and ending strings
     *
     * @param text - The text to be wrapped
     *
     * @return The modified string with the opening and ending added
     *
     * @throws IllegalArgumentException if the text given is null or blank
     *
     * @see #getOpening()
     * @see #getEnd()
     */
    @Override
    public String execute(String text) {
        if (text == null || text.isBlank()) {
            throw new
                    IllegalArgumentException("The text cannot be null or blank");
        }
        return getOpening() + text + getEnd();
    }

    /**
     * Get the string that is added before the text
     *
     * @return the opening string
     */
    public String getOpening() {
        return opening;
    }

    /**
     * Get the string that is added after the text
     *
     * @return the ending string
     */
    public String getEnd() {
        return end;
    }
}
