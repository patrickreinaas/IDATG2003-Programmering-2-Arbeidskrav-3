/**
 * This class represents a command to wrap each line
 * of a text with a specified opening and end string.
 *
 * file     WrapLinesTextCommand.java
 * @author  Patrick Reinås
 * @version 0.0.1
 * @since   17.02.2026
 */


package wrap;


/**
 * WrapLinesTextCommand class
 */
public class WrapLinesTextCommand extends WrapTextCommand {

    /**
     * WrapLinesTextCommand constructor
     *
     * @param opening - The string to be added before each line of the text
     * @param end     - The string to be added after each line of the text
     *
     * @throws IllegalArgumentException if opening or end is
     * null or blank (see parent constructor WrapTextCommand)
     */
    public WrapLinesTextCommand(String opening, String end) {
        super(opening, end);
    }

    /**
     * Method to wrap each line with chosen opening and end strings
     * by splitting the text by its lines, then wrapping each line
     * with the chosen opening and end string, before joining and
     * returning the now modified text
     *
     * @param text - The text in which the wrapping is to be performed
     *
     * @return The modified text with each line wrapped
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
                    IllegalArgumentException("Text can not be null or blank");
        }
        String[] lines = text.split("\n");
        for (int i = 0; i < lines.length; i++) {
            lines[i] = getOpening() + lines[i] + getEnd();
        }
        return String.join("\n", lines);
    }
}
