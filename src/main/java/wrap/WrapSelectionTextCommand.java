/**
 * This class represents a command for wrapping
 * all occurrences of a selected word in a given
 * text with a chosen opening and ending string.
 *
 * file     WrapSelectionTextCommand.java
 * @author  Patrick Reinås
 * @version 0.0.1
 * @since   17.02.2026
 */


package wrap;


/**
 * WrapSelectionTextCommand class
 */
public class WrapSelectionTextCommand extends WrapTextCommand {
    private String selection; // The selected word to be wrapped

    /**
     * WrapSelectionTextCommand constructor
     *
     * @param opening   - The string to be added before the selected word
     * @param end       - The string to be added after the selected word
     * @param selection - The word to be wrapped
     *
     * @throws IllegalArgumentException if opening, end or selection is
     * null or blank (see parent constructor WrapTextCommand)
     */
    public WrapSelectionTextCommand(String opening, String end, String selection) {
        super(opening, end);
        if (selection == null || selection.isBlank()) {
            throw new
                    IllegalArgumentException("Selection cannot be null or empty");
        }
        this.selection = selection;
    }

    /**
     * Method to wrap the selected word in a given text
     * with the chosen opening and ending strings
     *
     * @param text - The text in which the wrapping is to be performed
     *
     * @return The modified text with the selected word wrapped
     *
     * @throws IllegalArgumentException if the text given is null or blank
     *
     * @see #getSelection()
     * @see #getOpening()
     * @see #getEnd()
     */
    @Override
    public String execute(String text) {
        if (text == null || text.isBlank()) {
            throw new
                    IllegalArgumentException("The text cannot be null or blank");
        }
        return text.replace(getSelection(),
                getOpening() + getSelection() + getEnd());
    }

    /**
     * Get the word that is selected to be wrapped
     *
     * @return the selected word
     */
    public String getSelection() {
        return selection;
    }
}
