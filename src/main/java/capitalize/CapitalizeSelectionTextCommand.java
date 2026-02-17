/**
 * This class represents a command to capitalize the
 * first letter of a selected word, capitalizing all
 * occurrences of that word in a given text.
 *
 * file     CapitalizeSelectionTextCommand.java
 * @author  Patrick Reinås
 * @version 0.0.1
 * @since   17.02.2026
 */


package capitalize;


/**
 * CapitalizeSelectionTextCommand class
 */
public class CapitalizeSelectionTextCommand extends CapitalizeTextCommand {
    private String selection; // The selected word to be capitalized

    /**
     * CapitalizeSelectionTextCommand constructor
     *
     * @param selection - The word to be capitalized
     *
     * @throws IllegalArgumentException if selection is null or blank
     */
    public CapitalizeSelectionTextCommand(String selection) {
        if (selection == null || selection.isBlank()) {
                throw new
                        IllegalArgumentException("Selection cannot be null or blank");
        }
        this.selection = selection;
    }

    /**
     * Method to capitalize the first letter of all
     * occurrences of a selected word in a given text
     *
     * @param text - The text in which the capitalization is to be performed
     *
     * @return The text with the selected word capitalized
     *
     * @throws IllegalArgumentException if the text given is null or blank
     *
     * @see #getSelection()
     */
    @Override
    public String execute(String text) {
        if (text == null || text.isBlank()) {
            throw new
                    IllegalArgumentException("The text cannot be null or blank");
        }
        return text.replaceAll(getSelection().substring(0, 1),
                getSelection().substring(0, 1).toUpperCase());
    }

    /**
     * Get the word that is selected to be capitalized
     *
     * @return the selected word
     */
    public String getSelection() {
        return selection;
    }
}
