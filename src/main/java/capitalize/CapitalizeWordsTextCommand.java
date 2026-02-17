/**
 * This class represents a command to capitalize
 * the first letter of each word in a given text.
 *
 * file     CapitalizeWordsTextCommand.java
 * @author  Patrick Reinås
 * @version 0.0.1
 * @since   17.02.2026
 */


package capitalize;


/**
 * CapitalizeWordsTextCommand class
 */
public class CapitalizeWordsTextCommand extends CapitalizeTextCommand {

    /**
     * Method to capitalize the first letter of each word in a given text
     * by splitting the text into words, then capitalizing the first letter
     * of each word and joining them back together
     *
     * @param text - The text in which the capitalization is to be performed
     *
     * @return The text with the first letter of each word capitalized
     *
     * @throws IllegalArgumentException if the text given is null or blank
     */
    @Override
    public String execute(String text) {
        if (text == null || text.isBlank()) {
            throw new IllegalArgumentException("Text can not be null or blank");
        }
        String[] words = text.toLowerCase().split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].substring(0, 1).toUpperCase()
                    + words[i].substring(1);
        }
        return String.join(" ", words);
    }
}
